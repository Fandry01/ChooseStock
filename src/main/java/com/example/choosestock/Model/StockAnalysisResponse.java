package com.example.choosestock.Model;

import java.util.List;
import java.util.Map;

public class StockAnalysisResponse {
    private String symbol;
    private String decision;
    private String reason;
    private String explanation;
    private Company summary;
    private List<Competitor> competitors;
    private Map<String,Double> keyMetrics;


    public StockAnalysisResponse(String symbol, String decision, String reason,String explanation,Company summary,List<Competitor> competitors, Map<String, Double> keyMetrics) {
        this.symbol = symbol;
        this.decision = decision;
        this.reason = reason;
        this.keyMetrics = keyMetrics;
        this.explanation = explanation;
        this.competitors = competitors;
        this.summary = summary;
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

    public Map<String, Double> getKeyMetrics() {
        return keyMetrics;
    }

    public void setKeyMetrics(Map<String, Double> keyMetrics) {
        this.keyMetrics = keyMetrics;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Company getSummary() {
        return summary;
    }

    public void setSummary(Company summary) {
        this.summary = summary;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public String toString() {
        return "StockAnalysisResponse{" +
                "symbol='" + symbol + '\'' +
                ", decision='" + decision + '\'' +
                ", reason='" + reason + '\'' +
                ", analysisDetails=" + keyMetrics +
                ", explanation='" + explanation + '\'' +
                ", summary='" + summary + '\'' +
                ", competitors='" + competitors + '\'' +
                '}';
    }
}
