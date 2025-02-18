package com.example.choosestock.Controller;

import com.example.choosestock.Assistant.FinancialAdvisorAsisstant;
import com.example.choosestock.Service.AIAnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockAnalysisController {
    private final AIAnalysisService aiAnalysisService;
    private final FinancialAdvisorAsisstant financialAsisstant;

    public StockAnalysisController(AIAnalysisService aiAnalysisService, FinancialAdvisorAsisstant financialAsisstant) {
        this.aiAnalysisService = aiAnalysisService;
        this.financialAsisstant = financialAsisstant;
    }

    @GetMapping("api/analyze/{symbol}")
    public void handleStockAnalysisRequest(@PathVariable String symbol) {
        aiAnalysisService.analyzeStockData(symbol).doOnSuccess(response ->{
            System.out.println("Analysis Response: "+response);
        }).doOnError(error ->{
            System.out.println("Analysis Error: "+error.getMessage());
        })
                .subscribe();
    }

    @GetMapping("api/chat")
    public String chat(String userMessage){
        return financialAsisstant.chat(userMessage);
    }
}
