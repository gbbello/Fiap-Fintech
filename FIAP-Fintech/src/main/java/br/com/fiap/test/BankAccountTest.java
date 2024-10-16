package br.com.fiap.test;

import br.com.fiap.dao.impl.BankAccountDaoImpl;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.BankAccount;

import java.sql.SQLException;
import java.util.List;

public class BankAccountTest {
    public static void main(String[] args) {
        addNew();
        getAll();

    }

    public static void addNew() {
        try {
            for (int i = 1; i <= 5; i++) {
                BankAccount BankAccount = new BankAccount(270 + i, 3423 + i, 213456 + i);
                DaoFactory.getBankAccountDao().insert(BankAccount);
                System.out.println("Instituição Financeira cadastrada!");
            }
            DaoFactory.getBankAccountDao().fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            BankAccountDaoImpl dao = new BankAccountDaoImpl();
            List<BankAccount> bankAccounts = dao.getAll();

            for (BankAccount bankAccount : bankAccounts) {
                System.out.println(bankAccount.getIdIns() + " " + bankAccount.getAg() + ", " + bankAccount.getCc());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
