package br.com.fiap.model;

public abstract class  BankAccount {

    //Atributos do objeto
    private int bankCode;
    private int ag;
    private int cc;
    private double balance;

    //Construtores
    public BankAccount() {

    }

    public BankAccount(int bankCode, int ag, int cc) {
        this.bankCode = bankCode;
        this.ag = ag;
        this.cc = cc;
    }

    public BankAccount(int bankCode, int ag, int cc, double balance) {
        this.bankCode = bankCode;
        this.ag = ag;
        this.cc = cc;
        this.balance = balance;
    }


    //Get and Setter
    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public int getAg() {
        return ag;
    }

    public void setAg(int ag) {
        this.ag = ag;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
