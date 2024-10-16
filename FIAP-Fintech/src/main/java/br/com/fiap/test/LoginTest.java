package br.com.fiap.test;

import br.com.fiap.dao.impl.LoginDaoImpl;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.Login;

import java.sql.SQLException;
import java.util.List;

public class LoginTest {
    public static void main(String[] args) {
        addNew();
        getAll();
    }

    //*Neste teste eu tenho uma constraint que nao posso ter mais de uma autentificaçao por usuário. Por isso, nao irei atender o item do exercicio de cadastrar 5 autentificacoes.
    public static void addNew() {
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        try {
            Login Login1 = new Login(1, "guilherme@gbbdesign.com.br", "Gui12345", "Y", sqlDate);
            DaoFactory.getLoginDao().insert(Login1);
            System.out.println("Login cadastrado!");
            DaoFactory.getLoginDao().fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            LoginDaoImpl dao = new LoginDaoImpl();
            List<Login> logins = dao.getAll();

            for (Login login : logins) {
                System.out.println(login.getIdLogin() + ", " + login.getFkUsuario() + ", " + login.getEmail() + ", " + login.getPassword() + ", " + login.getStatusAutentification() + ", " + login.getDtRegistration());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
