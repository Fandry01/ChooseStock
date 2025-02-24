package com.example.choosestock.Model;

public class Competitor {
    private String name;
    private Double marketShare;
    private String explanation;

    public Competitor() {}



    public Competitor(String name, Double marketShare, String explanation) {
        this.name = name;
        this.marketShare = marketShare;
        this.explanation = explanation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarketShare() {
        return marketShare;
    }

    public void setMarketShare(Double marketShare) {
        this.marketShare = marketShare;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
