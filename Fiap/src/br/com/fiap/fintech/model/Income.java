package br.com.fiap.fintech.model;

public class Income extends Transactions{
    private String incomeFrom;
    private int frequency; // Número de dias

    public Income(String incomeFrom, int frequency) {
        this.incomeFrom = incomeFrom;
        this.frequency = frequency;
    }

    public Income(Integer type, Double value, String date, String description, String incomeFrom, int frequency) {
        super(type, value, date, description);
        this.incomeFrom = incomeFrom;
        this.frequency = frequency;
    }


    public String getIncomeFrom() {
        return incomeFrom;
    }

    public void setIncomeFrom(String incomeFrom) {
        this.incomeFrom = incomeFrom;
    }
}
