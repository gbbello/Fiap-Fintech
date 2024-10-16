package br.com.fiap.test;

import br.com.fiap.dao.impl.FintechAccountDaoImpl;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.FintechAccount;

import java.sql.SQLException;
import java.util.List;

public class FintechAccountTest {
    public static void main(String[] args) {
      cadastro();
     getAll();
//       pesquisar(1);

    }

    public static void cadastro() {
        try {
            java.sql.Date sqlDate = new java.sql.Date(1986, 4, 16);
            FintechAccount FintechAccount1 = new FintechAccount("Guilhreme Brenner Bello", "09319340", "01293243010", "M", sqlDate, "Ensino Médio", "União estável");
            DaoFactory.getFintechAccountDao().save(FintechAccount1);
            DaoFactory.getFintechAccountDao().fecharConexao();
            System.out.println("Conta cadastrada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            FintechAccountDaoImpl dao = new FintechAccountDaoImpl();
            List<FintechAccount> fintechAccountes = dao.getAll();

            for (FintechAccount fintechAccount : fintechAccountes) {
                System.out.println(fintechAccount.getIdUsuario() + " " + fintechAccount.getRg() + ", " + fintechAccount.getCpf() + ", " + fintechAccount.getSex() + ", " + fintechAccount.getBirthdate() + ", " + fintechAccount.getEducationLevel() + ", " + fintechAccount.getMartilStatus());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void pesquisar(long id) {
        try {
            FintechAccountDaoImpl doa = new FintechAccountDaoImpl();
            FintechAccount fintechAccount = doa.get(id);
            System.out.println(fintechAccount.getIdUsuario() + " " + fintechAccount.getRg() + ", " + fintechAccount.getCpf() + ", " + fintechAccount.getSex() + ", " + fintechAccount.getBirthdate() + ", " + fintechAccount.getEducationLevel() + ", " + fintechAccount.getMartilStatus());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Identificação nao existe na tabela");
        }
    }
}
