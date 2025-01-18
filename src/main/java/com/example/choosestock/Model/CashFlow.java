package com.example.choosestock.Model;

public class CashFlow {
    private String operatingCashflow;
    private String cashflowFromInvestment;
    private String cashflowFromFinancing;

    public String getOperatingCashflow() {
        return operatingCashflow;
    }

    public void setOperatingCashflow(String operatingCashFlow) {
        this.operatingCashflow = operatingCashFlow;
    }

    public String getCashflowFromInvestment() {
        return cashflowFromInvestment;
    }

    public void setCashflowFromInvestment(String cashflowFromInvestment) {
        this.cashflowFromInvestment = cashflowFromInvestment;
    }

    public String getCashflowFromFinancing() {
        return cashflowFromFinancing;
    }

    public void setCashflowFromFinancing(String cashflowFromFinancing) {
        this.cashflowFromFinancing = cashflowFromFinancing;
    }
}
