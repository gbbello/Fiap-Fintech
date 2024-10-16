package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.FintechAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FintechAccountDaoImpl implements Dao<FintechAccount> {

    private Connection conexao;
    public FintechAccountDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    @Override
    public FintechAccount get(long id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_usuario WHERE id_usu = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) throw new EntidadeNaoEcontradaException("Conta nao encontrada");

        return parseFinTechAccount(result);
    }

    @Override
    public List<FintechAccount> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_usuario");
        ResultSet result = stm.executeQuery();
        List<FintechAccount> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseFinTechAccount(result));
        }
        return lista;
    }

    @Override
    public void save(FintechAccount fintechAccount) throws SQLException {
        String sql = "INSERT INTO t_fin_usuario (id_usu, nm_completo, nr_rg, nr_cpf, dt_nascimento, tp_sexo, tp_escolaridade, tp_estado_civil)" +
                " VALUES (sq_t_fin_usuario.nextval,?, ?, ?, ?, ?, ?,?)";


        PreparedStatement stm = conexao.prepareStatement(sql);

        stm.setString(1, fintechAccount.getName());
        stm.setString(2, fintechAccount.getRg());
        stm.setString(3, fintechAccount.getCpf());
        stm.setDate(4, fintechAccount.getBirthdate());
        stm.setString(5, fintechAccount.getSex());
        stm.setString(6, fintechAccount.getEducationLevel());
        stm.setString(7, fintechAccount.getMartilStatus());
        stm.executeUpdate();
    }

    @Override
    public void update(FintechAccount fintechAccount, String[] params) throws SQLException {

    }

    @Override
    public void delete(FintechAccount fintechAccount) throws SQLException {

    }


    private FintechAccount parseFinTechAccount(ResultSet result) throws SQLException {

        long idUsuario = result.getLong("ID_USU");
        String name = result.getString("nm_completo");
        String rg = result.getString("nr_rg");
        String cpf = result.getString("nr_cpf");
        Date birthdate= result.getDate("dt_nascimento");
        String sex = result.getString("tp_sexo");
        String eMail = result.getString("tp_escolaridade");
        String martilStatus = result.getString("tp_estado_civil");

        return new FintechAccount(idUsuario, name, rg, cpf, sex, birthdate, eMail, martilStatus);

    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
