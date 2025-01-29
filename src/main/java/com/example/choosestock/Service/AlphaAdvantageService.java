package com.example.choosestock.Service;

import com.example.choosestock.Model.*;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AlphaAdvantageService {
    private final WebClient webClient;

    public AlphaAdvantageService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<IncomeStatementResponse> getIncomeStatement (String symbol, String apiKey){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function","INCOME_STATEMENT")
                        .queryParam("symbol", symbol)
                        .queryParam("apikey",apiKey)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response ->
                        response.bodyToMono(String.class)
                                .flatMap(errorBody ->
                                        Mono.error(new RuntimeException("Error: " + errorBody))))
                .bodyToMono(IncomeStatementResponse.class);
    }


    public Mono<BalanceSheetResponse> getBalanceSheet(String symbol, String apiKey){
        return webClient.get().uri(uriBuilder ->  uriBuilder
                .path("/query")
                .queryParam("function","BALANCE_SHEET")
                        .queryParam("symbol", symbol)
                .queryParam("apikey",apiKey)
                .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,response -> response
                        .bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new RuntimeException("error : "+ errorBody))))
                .bodyToMono(BalanceSheetResponse.class);
    }
    public Mono<CashFlowResponse> getCashFlow(String symbol, String apiKey){
        return webClient.get().uri(uriBuilder ->  uriBuilder
                        .path("/query")
                        .queryParam("function","CASH_FLOW")
                        .queryParam("symbol",symbol)
                        .queryParam("apikey",apiKey)
                        .build()).retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,response -> response
                        .bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new RuntimeException("error : "+ errorBody))))
                .bodyToMono(CashFlowResponse.class);
    }




    public Mono<FinancialDataForAI> getFinancialData(String symbol){
        String apiKey = "VJZOP72DUZVBIXH2";
        Mono<IncomeStatementResponse> incomeStatementResponse = getIncomeStatement(symbol,apiKey);
        Mono<BalanceSheetResponse>  balanceSheetResponse = getBalanceSheet(symbol,apiKey);
        Mono<CashFlowResponse> cashFlowResponse = getCashFlow(symbol,apiKey);

        return Mono.zip(incomeStatementResponse, balanceSheetResponse,cashFlowResponse).map(tuple ->{
             IncomeStatementResponse incomeStatement = tuple.getT1();
             BalanceSheetResponse balanceSheet = tuple.getT2();
             CashFlowResponse cashFlow = tuple.getT3();

             return new FinancialDataForAI(
                     symbol,
                     incomeStatement.getAnnualIncomeStatements(),
                     balanceSheet.getAnnualBalanceReports(),
                     cashFlow.getAnnualCashFlowReports()
             );
        });

    }
}
