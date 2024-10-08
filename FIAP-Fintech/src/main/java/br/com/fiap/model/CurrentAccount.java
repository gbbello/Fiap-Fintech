package br.com.fiap.model;

public class CurrentAccount extends BankAccount{
    private double tax;// taxa de manutençao da conta


    public CurrentAccount(double tax) {
        this.tax = tax;
    }

    public CurrentAccount(int bankCode, int ag, int cc, double tax) {
        super(bankCode, ag, cc);
        this.tax = tax;
    }

    public CurrentAccount(int bankCode, int ag, int cc, double balance, double tax) {
        super(bankCode, ag, cc, balance);
        this.tax = tax;
    }

//Getter and Setter
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
