package com.example.choosestock.Model;

import java.util.List;

public class FinancialDataForAI {
    private String symbol;
    private List<IncomeStatement> incomeStatements;
    private List<BalanceSheet> balanceSheets;
    private Company companySummary;

    public FinancialDataForAI(String symbol, List<IncomeStatement> incomeStatements, List<BalanceSheet> balanceSheets, Company companySummary) {
        this.symbol = symbol;
        this.incomeStatements = incomeStatements;
        this.balanceSheets = balanceSheets;
        this.companySummary = companySummary;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<IncomeStatement> getIncomeStatements() {
        return incomeStatements;
    }

    public void setIncomeStatements(List<IncomeStatement> incomeStatements) {
        this.incomeStatements = incomeStatements;
    }

    public List<BalanceSheet> getBalanceSheets() {
        return balanceSheets;
    }

    public void setBalanceSheets(List<BalanceSheet> balanceSheets) {
        this.balanceSheets = balanceSheets;
    }

    public Company getCompanySummary() {
        return companySummary;
    }

    public void setCompanySummary(Company companySummary) {
        this.companySummary = companySummary;
    }
}
