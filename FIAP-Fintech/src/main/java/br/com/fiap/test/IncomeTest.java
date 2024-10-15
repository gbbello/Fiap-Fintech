package br.com.fiap.test;

import br.com.fiap.dao.impl.IncomeDaoImpl;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.Income;

import java.sql.SQLException;
import java.util.List;

public class IncomeTest {
    public static void main(String[] args) {
        cadastro();
        getAll();
    }


    public static void cadastro() {
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        try {
            Income Income1 = new Income(1, 1, 1000.00, sqlDate, "1", "Descrição 1");
            DaoFactory.getIncomeDao().save(Income1);
            Income Income2 = new Income(1, 1, 1000.00, sqlDate, "1", "Descrição 2");
            DaoFactory.getIncomeDao().save(Income2);

            DaoFactory.getIncomeDao().fecharConexao();
            System.out.println("Recebimento cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            IncomeDaoImpl dao = new IncomeDaoImpl();
            List<Income> incomes = dao.getAll();

            for (Income income : incomes) {
                System.out.println(income.getIdRecebimento() + ", " +income.getFkUsuario() + ", " + income.getFkInstFinanceira() + ", " + income.getValue()+", " + income.getType()+", " + income.getDate());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
