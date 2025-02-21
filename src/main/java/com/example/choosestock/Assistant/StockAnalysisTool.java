package com.example.choosestock.Assistant;

import com.example.choosestock.Model.Company;
import com.example.choosestock.Model.StockAnalysisResponse;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class StockAnalysisTool {

    private final ChatLanguageModel model;

    public StockAnalysisTool(@Value("${langchain4j.open-ai.chat-model.api-key}") String openAIApiKey) {
        this.model = OpenAiChatModel.builder()
                .apiKey(openAIApiKey)
                .modelName("gpt-4o-mini")
                .temperature(0.7)
                .build();
    }

    @Tool("Find Competitors Finds competitors for a given stock ticker with details")
    public String findCompetitors(@P("Stock ticker symbol")String stockTicker) {
        String prompt = """ 
                search for three competitors of the company with ticker "%s".
               Provide:
               - Name of the competitor
               - Market share percentage
               - A short explanation (50 words) why this is a competitor.
              """.formatted(stockTicker);
        return model.generate(prompt);
    }

    @Tool("Analyze Financial stock data and return a recommendation")
    public StockAnalysisResponse analyzeStock(
            @P("Stock ticker symbol(e.g.APPL,TSLA)") String symbol,
            @P("Total revenue in billion USD") double revenue,
            @P("Profit margin as percentage") double profitMargin,
            @P("Net income in billion USD") double netIncome,
            @P("Total assets in billion USD") double totalAssets,
            @P("Total liabilities in billion USD") double totalLiabilities,
            @P("Summary of the company") Company summary
    ){
        double roundedProfitMargin = Math.round(profitMargin * 100.0) / 100.0;  // afronden op 2 decimalen
        double roundedNetIncome = Math.round(netIncome * 100.0) / 100.0;  // afronden op 2 decimalen

        String decision;
        if(roundedProfitMargin > 15 && roundedNetIncome > 5){
            decision = "Strong Buy";
        } else if(profitMargin > 10){
            decision = "Buy";
        } else if(profitMargin > 5){
            decision = "Hold";
        }else {
            decision = "Sell/dont Buy";
        }
        String explanation =  generateStockExplanation(symbol, decision, revenue, profitMargin, netIncome, totalAssets, totalLiabilities);
        String competitors = findCompetitors(symbol);

        return  new StockAnalysisResponse(symbol,decision,"AI-Based analysis",explanation,summary,competitors, Map.ofEntries(
                Map.entry("profitMargin",roundedProfitMargin + "%"),
                Map.entry("TotalAssets",totalAssets + "B"),
                Map.entry("TotalLiabilities",totalLiabilities + "B"),
                Map.entry("TotalRevenue",revenue +"B"),
                Map.entry("netIncome",roundedNetIncome+ "B")
        ));
    }

    @Tool("Generate a detailed explanation for Stock Recommendation")
    public String generateStockExplanation(
            @P("Stock ticker symbol") String symbol,
            @P("Investment decision") String decision,
            @P("Total revenue in billion USD") double revenue,
            @P("Profit margin in percentage") double profitMargin,
            @P("Net income in billion USD") double netIncome,
            @P("Total assets in billion USD") double totalAssets,
            @P("Total liabilities in billion USD") double totalLiabilities
    ) {
        return "Based on the given financial data, the stock " + symbol + " is recommended as a " + decision +
                " because it has a profit margin of " + profitMargin + "% and a net income of " + netIncome + " billion USD.";
    }

}
