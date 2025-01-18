package com.example.choosestock.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BalanceSheetResponse {
    @JsonProperty("symbol")
    private String Symbol;
    @JsonProperty("annualReports")
    private List<BalanceSheet> annualBalanceReports;
    @JsonProperty("quarterlyReports")
    private List<BalanceSheet> quarterlyBalanceReports;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public List<BalanceSheet> getAnnualBalanceReports() {
        return annualBalanceReports;
    }

    public void setAnnualBalanceReports(List<BalanceSheet> annualBalanceReports) {
        this.annualBalanceReports = annualBalanceReports;
    }

    public List<BalanceSheet> getQuarterlyBalanceReports() {
        return quarterlyBalanceReports;
    }

    public void setQuarterlyBalanceReports(List<BalanceSheet> quarterlyBalanceReports) {
        this.quarterlyBalanceReports = quarterlyBalanceReports;
    }
}
