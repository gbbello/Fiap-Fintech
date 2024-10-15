package br.com.fiap.test;

import br.com.fiap.dao.impl.BankAccountDaoImpl;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.BankAccount;

import java.sql.SQLException;
import java.util.List;

public class BankAccountTest {
    public static void main(String[] args) {
        cadastro();
        getAll();

    }

    public static void cadastro(){
        try {
            BankAccount BankAccount = new BankAccount(270,3423,213456);
            DaoFactory.getBankAccountDao().save(BankAccount);
            DaoFactory.getBankAccountDao().fecharConexao();
            System.out.println("Instituição Financeira cadastrada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void getAll(){
        try {
            BankAccountDaoImpl dao = new BankAccountDaoImpl();
            List<BankAccount> bankAccounts = dao.getAll();

            for (BankAccount bankAccount : bankAccounts){
                System.out.println(bankAccount.getIdIns()+ " " + bankAccount.getAg() + ", " + bankAccount.getCc());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
