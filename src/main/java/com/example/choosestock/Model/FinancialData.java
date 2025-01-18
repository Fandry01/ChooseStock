package com.example.choosestock.Model;

import java.util.Map;

public class FinancialData {
    private String symbol;
    private Map<String,Object> reports;

    public FinancialData(String symbol, Map<String,Object> reports){
        this.symbol = symbol;
        this.reports = reports;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Map<String, Object> getReports() {
        return reports;
    }

    public void setReports(Map<String, Object> reports) {
        this.reports = reports;
    }
}
