package com.example.choosestock.Model;

public class CashFlow {
    private String operatingCashFlow;
    private String cashflowFromInvestments;
    private String cashflowFromFinancing;

    public String getOperatingCashFlow() {
        return operatingCashFlow;
    }

    public void setOperatingCashFlow(String operatingCashFlow) {
        this.operatingCashFlow = operatingCashFlow;
    }

    public String getCashflowFromInvestments() {
        return cashflowFromInvestments;
    }

    public void setCashflowFromInvestments(String cashflowFromInvestments) {
        this.cashflowFromInvestments = cashflowFromInvestments;
    }

    public String getCashflowFromFinancing() {
        return cashflowFromFinancing;
    }

    public void setCashflowFromFinancing(String cashflowFromFinancing) {
        this.cashflowFromFinancing = cashflowFromFinancing;
    }
}
