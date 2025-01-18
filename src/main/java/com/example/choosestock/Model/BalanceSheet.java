package com.example.choosestock.Model;

public class BalanceSheet {
    private String fiscalDateEnding;
    private String totalAssests;
    private String totalLiabilities;

    public String getFiscalDateEnding() {
        return fiscalDateEnding;
    }

    public void setFiscalDateEnding(String fiscalDateEnding) {
        this.fiscalDateEnding = fiscalDateEnding;
    }

    public String getTotalAssests() {
        return totalAssests;
    }

    public void setTotalAssests(String totalAssests) {
        this.totalAssests = totalAssests;
    }

    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }
}
