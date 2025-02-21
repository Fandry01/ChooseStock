package com.example.choosestock.Service;

import com.example.choosestock.Assistant.CompetitorTool;
import com.example.choosestock.Assistant.StockAnalysisTool;

import com.example.choosestock.Model.Company;
import com.example.choosestock.Model.StockAnalysisResponse;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class AIAnalysisService {
    private final AlphaAdvantageService alphaAdvantageService;
    private final StockAnalysisTool stockAnalysisTool;
    private final CompetitorTool competitorTool;

    public AIAnalysisService(AlphaAdvantageService alphaAdvantageService, StockAnalysisTool stockAnalysisTool, CompetitorTool competitorTool) {
        this.alphaAdvantageService = alphaAdvantageService;
        this.stockAnalysisTool = stockAnalysisTool;
        this.competitorTool = competitorTool;
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
                    Company summary = financialData.getCompanySummary();

                    return Mono.just(stockAnalysisTool.analyzeStock(symbol,revenue,profitMargin,netIncome,totalAssets,totalLiabilities,summary));
                });
    }

    public String getCompetitors(String ticker){
        return competitorTool.findCompetitors(ticker);
    }
}
