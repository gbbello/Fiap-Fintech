package br.com.fiap.test;

import br.com.fiap.dao.impl.InvestmentDaoImpl;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.Investment;

import java.sql.SQLException;
import java.util.List;

public class InvestmentTest {
    public static void main(String[] args) {
        addNew();
        getAll();
    }

    public static void addNew() {
        try {
            for (int i = 1; i <= 5; i++) {
                Investment Investment = new Investment(1, 1, 20000.00 * i, 0.10 + i);
                DaoFactory.getInvestmentDao().insert(Investment);
                System.out.println("Investment cadastrado!");
            }
            DaoFactory.getInvestmentDao().fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            InvestmentDaoImpl dao = new InvestmentDaoImpl();
            List<Investment> investments = dao.getAll();

            for (Investment investment : investments) {
                System.out.println(investment.getIdInv() + ", " + investment.getFkUsuario() + ", " + investment.getFkInstFinanceira() + ", " + investment.getVlInvest() + ", " + investment.getProfitableRate());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
