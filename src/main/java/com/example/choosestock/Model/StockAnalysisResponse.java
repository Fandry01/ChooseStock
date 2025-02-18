package com.example.choosestock.Model;

import java.util.Map;

public class StockAnalysisResponse {
    private String symbol;
    private String decision;
    private String reason;
    private String explanation;
    private Map<String,String> keyMetrics;

    public StockAnalysisResponse(String symbol, String decision, String reason,String explanation, Map<String, String> keyMetrics) {
        this.symbol = symbol;
        this.decision = decision;
        this.reason = reason;
        this.keyMetrics = keyMetrics;
        this.explanation = explanation;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Map<String, String> getKeyMetrics() {
        return keyMetrics;
    }

    public void setKeyMetrics(Map<String, String> keyMetrics) {
        this.keyMetrics = keyMetrics;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String toString() {
        return "StockAnalysisResponse{" +
                "symbol='" + symbol + '\'' +
                ", decision='" + decision + '\'' +
                ", reason='" + reason + '\'' +
                ", analysisDetails=" + keyMetrics +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
