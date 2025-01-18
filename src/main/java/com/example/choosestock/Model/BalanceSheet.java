package com.example.choosestock.Model;

public class BalanceSheet {
    private String fiscalDateEnding;
    private String totalAssets;
    private String totalLiabilities;

    public String getFiscalDateEnding() {
        return fiscalDateEnding;
    }

    public void setFiscalDateEnding(String fiscalDateEnding) {
        this.fiscalDateEnding = fiscalDateEnding;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }
}
