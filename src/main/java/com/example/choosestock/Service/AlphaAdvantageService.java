package com.example.choosestock.Service;

import com.example.choosestock.Model.FinancialDataResponse;
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

    public Mono<FinancialDataResponse> getIncomeStatement (String symbol, String apiKey){
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
                .bodyToMono(FinancialDataResponse.class);
    }
}
