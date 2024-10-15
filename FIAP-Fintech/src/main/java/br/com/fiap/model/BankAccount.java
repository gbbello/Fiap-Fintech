package br.com.fiap.model;

public  class  BankAccount {

    //Atributos do objeto
    private int idIns;
    private int bankCode;
    private int ag;
    private int cc;

    //Construtores

    public BankAccount(int bankCode, int ag, int cc) {
        this.bankCode = bankCode;
        this.ag = ag;
        this.cc = cc;
    }

    public BankAccount(int idIns,int bankCode, int ag, int cc) {
        this.idIns = idIns;
        this.bankCode = bankCode;
        this.ag = ag;
        this.cc = cc;
    }

    //Get and Setter
    public int getIdIns() {
        return idIns;
    }

    public void setIdIns(int idIns) {
        this.idIns = idIns;
    }
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


}
