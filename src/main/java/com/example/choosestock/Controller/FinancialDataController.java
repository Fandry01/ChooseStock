package com.example.choosestock.Controller;

import com.example.choosestock.Model.*;
import com.example.choosestock.Service.AlphaAdvantageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/finance")
public class FinancialDataController {
    private final AlphaAdvantageService alphaAdvantageService;

    public FinancialDataController(AlphaAdvantageService alphaAdvantageService) {
        this.alphaAdvantageService = alphaAdvantageService;
    }

    @GetMapping("/income-statement/{symbol}")
    public Mono<IncomeStatementResponse> getIncomeStatement(@PathVariable String symbol){
        String apiKey = "VJZOP72DUZVBIXH2";
        return alphaAdvantageService.getIncomeStatement(symbol,apiKey);
    }

    @GetMapping("/balance-sheet/{symbol}")
    public Mono<BalanceSheetResponse> getBalanceSheet(@PathVariable String symbol){
        String apiKey = "VJZOP72DUZVBIXH2";
        return alphaAdvantageService.getBalanceSheet(symbol,apiKey);
    }
    @GetMapping("/cash-flow/{symbol}")
    public Mono<CashFlowResponse> getCashFlow(@PathVariable String symbol){
        String apiKey ="VJZOP72DUZVBIXH2";
        return alphaAdvantageService.getCashFlow(symbol,apiKey);
    }

    @GetMapping("/financial-data/{symbol}")
    public Mono<FinancialDataForAI> getFinancialData(@PathVariable String symbol){
        return alphaAdvantageService.getFinancialData(symbol);
    }

    @GetMapping("/company-summary/{symbol}")
    public Mono<Company> getCompanySummary(@PathVariable String symbol){
        String apiKey ="VJZOP72DUZVBIXH2";
        return alphaAdvantageService.getCompanySummary(symbol,apiKey);
    }

}
