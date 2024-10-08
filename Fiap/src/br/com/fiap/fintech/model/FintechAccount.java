package br.com.fiap.fintech.model;
import java.util.ArrayList;

public class FintechAccount extends Profile {
    //Atributos do objeto
    private String userName;
    private int accountType;
    private ArrayList<InvestmentAccount> investmentAccounts =  new ArrayList<>();
    private ArrayList<CurrentAccount> currentAccounts =  new ArrayList<>();
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<OutCome> outComes = new ArrayList<>();
    private double balance;


    public FintechAccount() {
        super();
    }


    public FintechAccount(String name, String lastName, String rg, String cpf, String sex, String birthdate, String eMail, Address address, String userName, int accountType, ArrayList<InvestmentAccount> investmentAccounts, ArrayList<CurrentAccount> currentAccounts, ArrayList<OutCome> outComes,  ArrayList<Income> incomes) {
        super(name, lastName, rg, cpf, sex, birthdate, eMail, address);
        this.userName = userName;
        this.accountType = accountType;
        this.investmentAccounts = investmentAccounts;
        this.currentAccounts = currentAccounts;
        this.incomes = incomes;
        this.outComes = outComes;
    }

    public void addCurrentAccount(CurrentAccount obj){
        this.currentAccounts.add(obj);
    }
    public void addInvestmentAccount(InvestmentAccount obj){
        this.investmentAccounts.add(obj);
    }

    public void addIncome(Income obj){

       this.incomes.add(obj);
    }

    public void addOutCome(OutCome obj){
        this.outComes.add(obj);
    }

    public void calcBalance(){
        this.balance = 0;
            for (var curAccount: currentAccounts) {
                this.balance += curAccount.getBalance();
            }

            for (var invAccount: investmentAccounts) {
                this.balance += invAccount.getBalance();
            }

            for (var income : incomes) {
                this.balance += income.getValue();
            }

            for (var outCome : getOutComes()) {
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

    public ArrayList<InvestmentAccount> getInvestmentAccount() {
        return investmentAccounts;
    }

    public void setInvestmentAccount(ArrayList<InvestmentAccount> investmentAccounts) {
        this.investmentAccounts = investmentAccounts;
    }

    public ArrayList<CurrentAccount> getCurrentAccount() {
        return currentAccounts;
    }

    public void setCurrentAccount(ArrayList<CurrentAccount> currentAccounts) {
        this.currentAccounts = currentAccounts;
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
