package br.com.fiap.test;

import br.com.fiap.dao.impl.IncomeDaoImpl;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.Income;

import java.sql.SQLException;
import java.util.List;

public class IncomeTest {
    public static void main(String[] args) {
        addNew();
        getAll();
    }


    public static void addNew() {
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        try {
            for (int i = 1; i <= 5; i++) {
                Income Income = new Income(1, 1, 1000.00 * i, sqlDate, "1", "Descrição 1" + i);
                DaoFactory.getIncomeDao().insert(Income);
                System.out.println("Recebimento cadastrado!");
            }
            DaoFactory.getIncomeDao().fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            IncomeDaoImpl dao = new IncomeDaoImpl();
            List<Income> incomes = dao.getAll();

            for (Income income : incomes) {
                System.out.println(income.getIdRecebimento() + ", " + income.getFkUsuario() + ", " + income.getFkInstFinanceira() + ", " + income.getValue() + ", " + income.getType() + ", " + income.getDate());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
