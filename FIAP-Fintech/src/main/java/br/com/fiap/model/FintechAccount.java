package br.com.fiap.model;
import java.util.ArrayList;

public class FintechAccount extends Profile {
    //Atributos do objeto
    private String userName;
    private int accountType;
    private ArrayList<Investment> investments =  new ArrayList<>();
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<OutCome> outComes = new ArrayList<>();
    private double balance;


    public FintechAccount() {
        super();
    }


    public FintechAccount(String name, String lastName, String rg, String cpf, String sex, String birthdate, String eMail, Address address, String userName, int accountType, ArrayList<Investment> investments, ArrayList<OutCome> outComes, ArrayList<Income> incomes) {
        super(name, lastName, rg, cpf, sex, birthdate, eMail, address);
        this.userName = userName;
        this.accountType = accountType;
        this.investments = investments;
        this.incomes = incomes;
        this.outComes = outComes;
    }

    public void addInvestmentAccount(Investment obj){
        this.investments.add(obj);
    }

    public void addIncome(Income obj){

       this.incomes.add(obj);
    }

    public void addOutCome(OutCome obj){
        this.outComes.add(obj);
    }

    public void calcBalance(){
        this.balance = 0;

            for ( Income income : incomes) {
                this.balance += income.getValue();
            }

            for (OutCome outCome : getOutComes()) {
                this.balance -= outCome.getValue();
            }
    }


    //Getter and Setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public ArrayList<Investment> getInvestmentAccount() {
        return investments;
    }

    public void setInvestmentAccount(ArrayList<Investment> investments) {
        this.investments = investments;
    }

    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(ArrayList<Income> incomes) {
        this.incomes = incomes;
    }

    public ArrayList<OutCome> getOutComes() {
        return outComes;
    }

    public void setOutComes(ArrayList<OutCome> outComes) {
        this.outComes = outComes;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance =  balance;
    }
}
