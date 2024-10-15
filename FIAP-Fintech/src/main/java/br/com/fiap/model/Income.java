package br.com.fiap.model;

import java.sql.Date;

public class Income extends Transactions {
    private int idRecebimento;
    private int fkUsuario;
    private int fkInstFinanceira;
    private String incomeFrom;


    public Income(int fkUsuario, int fkInstFinanceira,Double value, Date date, String type, String description) {
        super(value, date, type, description);
        this.fkUsuario = fkUsuario;
        this.fkInstFinanceira = fkInstFinanceira;
    }

    public Income(int idRecebimento, int fkUsuario, int fkInstFinanceira, Double value, Date date, String type, String description) {
        super(value, date, type, description);
        this.idRecebimento = idRecebimento;
        this.fkUsuario = fkUsuario;
        this.fkInstFinanceira = fkInstFinanceira;
    }

    public int getIdRecebimento() {
        return idRecebimento;
    }

    public void setIdRecebimento(int idRecebimento) {
        this.idRecebimento = idRecebimento;
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
        return incomeFrom;
    }

    public void setIncomeFrom(String incomeFrom) {
        this.incomeFrom = incomeFrom;
    }
}
