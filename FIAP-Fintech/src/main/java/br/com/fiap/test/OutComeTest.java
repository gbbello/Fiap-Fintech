package br.com.fiap.test;

import br.com.fiap.dao.impl.OutComeDaoImpl;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.OutCome;

import java.sql.SQLException;
import java.util.List;

public class OutComeTest {
    public static void main(String[] args) {
        cadastro();
        pesquisar(6);
        getAll();
    }


    public static void cadastro() {
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        try {
            OutCome OutCome1 = new OutCome(1, 1, 1000.00, 30.00, sqlDate, "1", "Descrição 1");
            DaoFactory.getOutComeDao().save(OutCome1);
            OutCome OutCome2 = new OutCome(1, 1, 1000.00, 30.00, sqlDate, "1", "Descrição 2");
            DaoFactory.getOutComeDao().save(OutCome2);

            DaoFactory.getOutComeDao().fecharConexao();
            System.out.println("Despesa cadastrada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            OutComeDaoImpl dao = new OutComeDaoImpl();
            List<OutCome> outComes = dao.getAll();

            for (OutCome outCome : outComes) {
                System.out.println(outCome.getIdDespesa() + ", " +outCome.getFkUsuario() + ", " + outCome.getFkInstFinanceira() + ", " + outCome.getValue()+", " + outCome.getType()+", " + outCome.getDate());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void pesquisar(long id){
        try {
            OutComeDaoImpl doa = new OutComeDaoImpl();
            OutCome outCome =  doa.get(id);
            System.out.println(outCome.getIdDespesa() + ", " +outCome.getFkUsuario() + ", " + outCome.getFkInstFinanceira() + ", " + outCome.getValue()+", " + outCome.getType()+", " + outCome.getDate());
        }catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Identificação nao existe na tabela");
        }
    }
}
