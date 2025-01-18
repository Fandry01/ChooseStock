package com.example.choosestock.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinancialDataResponse {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("annualReports")
    private List<IncomeStatement> annualIncomeStatements;
    @JsonProperty("quarterlyReports")
    private List<IncomeStatement> quarterlyIncomeStatements;

    private List<CashFlow> annualCashFlowReports;

    private List<CashFlow> quarterlyCashFlowReports;

    private List<BalanceSheet> annualBalanceReports;

    private List<BalanceSheet> quarterlyBalanceReports;

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
