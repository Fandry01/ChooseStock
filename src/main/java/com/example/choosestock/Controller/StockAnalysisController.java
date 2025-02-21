package com.example.choosestock.Controller;

import com.example.choosestock.Assistant.CompetitorTool;
import com.example.choosestock.Assistant.FinancialAdvisorAsisstant;
import com.example.choosestock.Model.StockAnalysisResponse;
import com.example.choosestock.Service.AIAnalysisService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class StockAnalysisController {
    private final AIAnalysisService aiAnalysisService;
    private final FinancialAdvisorAsisstant financialAsisstant;
    private final CompetitorTool competitorTool;

    public StockAnalysisController(AIAnalysisService aiAnalysisService, FinancialAdvisorAsisstant financialAsisstant, CompetitorTool competitorTool) {
        this.aiAnalysisService = aiAnalysisService;
        this.financialAsisstant = financialAsisstant;
        this.competitorTool = competitorTool;
    }

    @GetMapping("api/analyze/{symbol}")
    public Mono<StockAnalysisResponse> handleStockAnalysisRequest(@PathVariable String symbol) {
        return aiAnalysisService.analyzeStockData(symbol)
                .doOnSuccess(response -> System.out.println("Analysis Response: "+response))
                .doOnError(error -> System.out.println("Analysis Error: "+error.getMessage()));
    }

    @GetMapping("api/competitors/{symbol}")
    public String getCompetitors(@PathVariable String symbol) {
        return competitorTool.findCompetitors(symbol);
    }

}
