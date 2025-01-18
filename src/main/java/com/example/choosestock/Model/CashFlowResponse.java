package com.example.choosestock.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CashFlowResponse {
    private String symbol;
    @JsonProperty("annualReports")
    private List<CashFlow> annualCashFlowReports;
    @JsonProperty("quarterlyReports")
    private List<CashFlow> quarterlyCashFlowReports;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<CashFlow> getAnnualCashFlowReports() {
        return annualCashFlowReports;
    }

    public void setAnnualCashFlowReports(List<CashFlow> annualCashFlowReports) {
        this.annualCashFlowReports = annualCashFlowReports;
    }

    public List<CashFlow> getQuarterlyCashFlowReports() {
        return quarterlyCashFlowReports;
    }

    public void setQuarterlyCashFlowReports(List<CashFlow> quarterlyCashFlowReports) {
        this.quarterlyCashFlowReports = quarterlyCashFlowReports;
    }
}
