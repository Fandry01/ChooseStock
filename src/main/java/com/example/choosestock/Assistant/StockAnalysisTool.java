package com.example.choosestock.Assistant;

import com.example.choosestock.Model.Company;
import com.example.choosestock.Model.Competitor;
import com.example.choosestock.Model.CompetitorsResponse;
import com.example.choosestock.Model.StockAnalysisResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
public class StockAnalysisTool {

    private final ChatLanguageModel model;

    public StockAnalysisTool(@Value("${OPENAI_API_KEY}") String openAIApiKey) {
        this.model = OpenAiChatModel.builder()
                .apiKey(openAIApiKey)
                .modelName("gpt-4o-mini")
                .temperature(0.7)
                .build();
    }

    @Tool("Find Competitors Finds competitors for a given stock ticker with details")
    public List<Competitor> findCompetitors(@P("Stock ticker symbol")String stockTicker) {
        String prompt = """ 
                Search for three competitors of the company with ticker "%s".
                Provide the result in **valid JSON format** with the following structure:
                {
                "competitors": [
                 {
                "name": "Competitor Name",
                "marketShare": 10,
                "explanation": "Short explanation of why this company is a competitor."
                }
             ]
             }
             Ensure the response is **valid JSON only**, without additional text.
           """.formatted(stockTicker);
        String jsonResponse = model.generate(prompt);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CompetitorsResponse response = objectMapper.readValue(jsonResponse, CompetitorsResponse.class);
            return response.getCompetitors();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON response: " + jsonResponse, e);
        }
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
        String explanation =  generateStockExplanation(symbol, decision, revenue,roundedProfitMargin, roundedNetIncome, totalAssets, totalLiabilities);
        List<Competitor> competitors = findCompetitors(symbol);

        return  new StockAnalysisResponse(symbol,decision,"AI-Based analysis",explanation,summary,competitors, Map.ofEntries(
                Map.entry("profitMargin",roundedProfitMargin),
                Map.entry("TotalAssets",totalAssets),
                Map.entry("TotalLiabilities",totalLiabilities),
                Map.entry("TotalRevenue",revenue ),
                Map.entry("netIncome",roundedNetIncome)
        ));
    }

    @Tool("Generate a detailed explanation for Stock Recommendation")
    public String generateStockExplanation(
            @P("Stock ticker symbol") String symbol,
            @P("Investment decision") String decision,
            @P("Total revenue in billion USD") double revenue,
            @P("Profit margin in percentage") double roundedProfitMargin,
            @P("Net income in billion USD") double roundedNetIncome,
            @P("Total assets in billion USD") double totalAssets,
            @P("Total liabilities in billion USD") double totalLiabilities

    ) { return "Based on the given financial data, the stock " + symbol + " is recommended as a " + decision +
            " because it has a profit margin of " + roundedProfitMargin + "% and a net income of " + roundedNetIncome + " billion USD.";

    }

}
