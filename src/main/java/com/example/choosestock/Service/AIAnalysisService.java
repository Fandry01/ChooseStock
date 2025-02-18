package com.example.choosestock.Service;

import com.example.choosestock.Assistant.StockAnalysisTool;

import com.example.choosestock.Model.StockAnalysisResponse;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class AIAnalysisService {
    private final AlphaAdvantageService alphaAdvantageService;
    private final StockAnalysisTool stockAnalysisTool;

    public AIAnalysisService(AlphaAdvantageService alphaAdvantageService, StockAnalysisTool stockAnalysisTool) {
        this.alphaAdvantageService = alphaAdvantageService;
        this.stockAnalysisTool = stockAnalysisTool;
    }


    public Mono<StockAnalysisResponse> analyzeStockData(String symbol){

        return alphaAdvantageService.getFinancialData(symbol)
                .flatMap(financialData ->{
                    double revenue = financialData.getIncomeStatements().stream()
                            .mapToDouble(statement -> Double.parseDouble(statement.getTotalRevenue()))
                            .sum();
                    double netIncome = financialData.getIncomeStatements().stream()
                            .mapToDouble(statement -> Double.parseDouble(statement.getNetIncome()))
                            .sum();
                    double totalAssets = financialData.getBalanceSheets().stream()
                            .mapToDouble(balance -> Double.parseDouble(balance.getTotalAssets()))
                            .sum();
                    double totalLiabilities = financialData.getBalanceSheets().stream()
                            .mapToDouble(balance -> Double.parseDouble(balance.getTotalLiabilities())).sum();
                    double profitMargin = (revenue != 0) ? (netIncome / revenue) * 100 : 0;

                    return Mono.just(stockAnalysisTool.analyzeStock(symbol,revenue,profitMargin,netIncome,totalAssets,totalLiabilities));
                });
    }
}
