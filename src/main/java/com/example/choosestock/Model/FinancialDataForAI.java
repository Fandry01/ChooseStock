package com.example.choosestock.Model;

import java.util.List;

public class FinancialDataForAI {
    private String symbol;
    private List<IncomeStatement> incomeStatements;
    private List<BalanceSheet> balanceSheets;
    private List<CashFlow> cashFlows;

    public FinancialDataForAI(String symbol, List<IncomeStatement> incomeStatements, List<BalanceSheet> balanceSheets, List<CashFlow> cashFlows) {
        this.symbol = symbol;
        this.incomeStatements = incomeStatements;
        this.balanceSheets = balanceSheets;
        this.cashFlows = cashFlows;
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

    public List<CashFlow> getCashFlows() {
        return cashFlows;
    }

    public void setCashFlows(List<CashFlow> cashFlows) {
        this.cashFlows = cashFlows;
    }
}
