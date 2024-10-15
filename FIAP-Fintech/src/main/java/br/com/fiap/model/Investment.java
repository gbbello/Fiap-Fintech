package br.com.fiap.model;

public class Investment extends BankAccount{
    private double tax;// taxa de manutençao da conta
    private double returnRate;// taxa de rendimento


    public Investment(int bankCode, int ag, int cc, double balance, double tax, double returnRate) {
        super(bankCode, ag, cc);
        this.tax = tax;
        this.returnRate = returnRate;
    }

    public Investment(int idIns, int bankCode, int ag, int cc, double tax, double returnRate) {
        super(idIns,bankCode, ag, cc);
        this.tax = tax;
        this.returnRate = returnRate;
    }
//Getter and Setter
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(double returnRate) {
        this.returnRate = returnRate;
    }
}
