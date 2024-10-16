package br.com.fiap.model;

public class Investment{
    private long idInv;
    private long fkUsuario;
    private long fkInstFinanceira;
    private Double vlInvest;
    private Double profitableRate;

    public Investment(long idInv, long fkUsuario, long fkInstFinanceira, Double vlInvest, Double profitableRate) {
        this.idInv = idInv;
        this.fkUsuario = fkUsuario;
        this.fkInstFinanceira = fkInstFinanceira;
        this.vlInvest = vlInvest;
        this.profitableRate = profitableRate;
    }

    public Investment(long fkUsuario, long fkInstFinanceira, Double vlInvest, Double profitableRate) {
        this.fkUsuario = fkUsuario;
        this.fkInstFinanceira = fkInstFinanceira;
        this.vlInvest = vlInvest;
        this.profitableRate = profitableRate;
    }

    public long getIdInv() {
        return idInv;
    }

    public void setIdInv(long idInv) {
        this.idInv = idInv;
    }

    public long getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(long fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public long getFkInstFinanceira() {
        return fkInstFinanceira;
    }

    public void setFkInstFinanceira(long fkInstFinanceira) {
        this.fkInstFinanceira = fkInstFinanceira;
    }

    public double getVlInvest() {
        return vlInvest;
    }

    public void setVlInvest(double vlInvest) {
        this.vlInvest = vlInvest;
    }

    public double getProfitableRate() {
        return profitableRate;
    }

    public void setProfitableRate(double profitableRate) {
        this.profitableRate = profitableRate;
    }

}
