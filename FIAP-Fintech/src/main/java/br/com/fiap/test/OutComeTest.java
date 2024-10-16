package br.com.fiap.test;

import br.com.fiap.dao.impl.OutComeDaoImpl;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.OutCome;

import java.sql.SQLException;
import java.util.List;

public class OutComeTest {
    public static void main(String[] args) {
        addNew();
        getAll();
    }


    public static void addNew() {
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        try {
            for (int i = 1; i <= 5; i++) {
                OutCome OutCome = new OutCome(1, 1, 1000.00 * i, 30.00, sqlDate, "1", "Descrição" + i);
                DaoFactory.getOutComeDao().insert(OutCome);
                System.out.println("Despesa cadastrada!");
            }
            DaoFactory.getOutComeDao().fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            OutComeDaoImpl dao = new OutComeDaoImpl();
            List<OutCome> outComes = dao.getAll();

            for (OutCome outCome : outComes) {
                System.out.println(outCome.getIdDespesa() + ", " + outCome.getFkUsuario() + ", " + outCome.getFkInstFinanceira() + ", " + outCome.getValue() + ", " + outCome.getType() + ", " + outCome.getDate());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getById(long id) {
        try {
            OutComeDaoImpl doa = new OutComeDaoImpl();
            OutCome outCome = doa.getById(id);
            System.out.println(outCome.getIdDespesa() + ", " + outCome.getFkUsuario() + ", " + outCome.getFkInstFinanceira() + ", " + outCome.getValue() + ", " + outCome.getType() + ", " + outCome.getDate());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Identificação nao existe na tabela");
        }
    }
}
