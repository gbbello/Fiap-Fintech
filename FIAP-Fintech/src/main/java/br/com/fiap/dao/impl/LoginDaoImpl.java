package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements Dao<Login> {

    private Connection conexao;

    public LoginDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public Login get(long id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_autentificacao WHERE id_aut = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) throw new EntidadeNaoEcontradaException("Login nao encontrado");

        return parseLogin(result);
    }

    @Override
    public List<Login> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_autentificacao");
        ResultSet result = stm.executeQuery();
        List<Login> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseLogin(result));
        }
        return lista;
    }

    @Override
    public void save(Login login) throws SQLException {

        String sql = "INSERT INTO t_fin_autentificacao (id_aut, fk_usuario, email, senha, st_autenticacao, dt_cadastro)" +
                " VALUES (sq_t_fin_autentificacao.nextval,?, ?, ?, ?, ?)";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setLong(1, login.getFkUsuario());
        stm.setString(2, login.getEmail());
        stm.setString(3, login.getPassword());
        stm.setString(4, login.getStatusAutentification());
        stm.setDate(5, login.getDtRegistration());
        stm.executeUpdate();
    }

    @Override
    public void update(Login login, String[] params) throws SQLException {

    }

    @Override
    public void delete(Login login) throws SQLException {

    }

    private Login parseLogin(ResultSet result) throws SQLException {

         long idLogin= result.getLong("id_aut");
         long fkUsuario= result.getLong("fk_usuario");
         String email= result.getString("email");
         String password= result.getString("senha");
         String statusAutentification= result.getString("st_autentificacao");
         Date dtRegistration= result.getDate("dtCadastro");

        return new Login(idLogin, fkUsuario, email, password, statusAutentification, dtRegistration);

    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

}
