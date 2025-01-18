package com.example.choosestock.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IncomeStatementResponse {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("annualReports")
    private List<IncomeStatement> annualIncomeStatements;
    @JsonProperty("quarterlyReports")
    private List<IncomeStatement> quarterlyIncomeStatements;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<IncomeStatement> getAnnualIncomeStatements() {
        return annualIncomeStatements;
    }

    public void setAnnualIncomeStatements(List<IncomeStatement> annualIncomeStatements) {
        this.annualIncomeStatements = annualIncomeStatements;
    }

    public List<IncomeStatement> getQuarterlyIncomeStatements() {
        return quarterlyIncomeStatements;
    }

    public void setQuarterlyIncomeStatements(List<IncomeStatement> quarterlyIncomeStatements) {
        this.quarterlyIncomeStatements = quarterlyIncomeStatements;
    }
}
