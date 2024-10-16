package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Income;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDaoImpl implements Dao<Income> {

    private Connection conexao;

    public IncomeDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public Income getById(long id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_recebimento WHERE id_rec = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) throw new EntidadeNaoEcontradaException("Recebimento nao encontrado");

        return parseIncome(result);
    }

    @Override
    public List<Income> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_recebimento");
        ResultSet result = stm.executeQuery();
        List<Income> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseIncome(result));
        }
        return lista;
    }

    public void insert(Income income) throws SQLException {

        String sql = "INSERT INTO t_fin_recebimento (id_rec, fk_usuario, fk_inst_financeira, vl_receb, tipo_receb, dt_receb,  ds_receb)" +
                " VALUES (sq_t_fin_recebimento.nextval,?, ?, ?, ?, ?, ?)";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, income.getFkUsuario());
        stm.setInt(2, income.getFkInstFinanceira());
        stm.setDouble(3, income.getValue());
        stm.setString(4, income.getType());
        stm.setDate(5, income.getDate());
        stm.setString(6, income.getDescription());
        stm.executeUpdate();
    }


    @Override
    public void update(Income income, String[] params) throws SQLException {

    }

    @Override
    public void delete(Income income) throws SQLException {

    }

    private Income parseIncome(ResultSet result) throws SQLException {
        int idRecebimento = result.getInt("id_rec");
        int fkUsuario = result.getInt("fk_usuario");
        int fkInsFinanceira = result.getInt("fk_inst_financeira");
        Double value = result.getDouble("vl_receb");
        String type = result.getString("tipo_receb");
        Date date = result.getDate("dt_receb");
        String description = result.getString("ds_receb");

        return new Income(idRecebimento, fkUsuario, fkInsFinanceira, value, date, type, description);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

}
