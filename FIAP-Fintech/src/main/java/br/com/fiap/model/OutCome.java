package br.com.fiap.model;

import java.sql.Date;

public class OutCome extends Transactions {
    private int idDespesa;
    private int fkUsuario;
    private int fkInstFinanceira;
    private String outComeFrom;
    private Double frequency; // Número de dias

    public OutCome(int fkUsuario, int fkInstFinanceira, Double value, Double frequency, Date date, String type, String description) {
        super(value, date, type, description);
        this.fkUsuario = fkUsuario;
        this.fkInstFinanceira = fkInstFinanceira;
        this.frequency = frequency;
    }

    public OutCome(int idDespesa, int fkUsuario, int fkInstFinanceira, Double value, Double frequency, Date date, String type, String description) {
        super(value, date, type, description);
        this.idDespesa = idDespesa;
        this.fkUsuario = fkUsuario;
        this.fkInstFinanceira = fkInstFinanceira;
        this.frequency = frequency;
    }

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkInstFinanceira() {
        return fkInstFinanceira;
    }

    public void setFkInstFinanceira(int fkInstFinanceira) {
        this.fkInstFinanceira = fkInstFinanceira;
    }

    public String getIncomeFrom() {
        return outComeFrom;
    }

    public void setIncomeFrom(String outComeFrom) {
        this.outComeFrom = outComeFrom;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }
}

