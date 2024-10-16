package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.OutCome;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OutComeDaoImpl implements Dao<OutCome> {

    private Connection conexao;

    public OutComeDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public OutCome getById(long id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_despesa WHERE id_despesa = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) throw new EntidadeNaoEcontradaException("Despesa nao Encontrada");

        return parseOutCome(result);
    }


    public List<OutCome> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_despesa");
        ResultSet result = stm.executeQuery();
        List<OutCome> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseOutCome(result));
        }
        return lista;
    }
    @Override
    public void insert(OutCome outCome) throws SQLException {

        String sql = "INSERT INTO t_fin_despesa (id_despesa, fk_usuario, fk_inst_financeira, vl_despesa, nr_parcela, dt_despesas, tipo_despesa, ds_despesa)" +
                " VALUES (sq_t_fin_despesa.nextval,?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, outCome.getFkUsuario());
        stm.setInt(2, outCome.getFkInstFinanceira());
        stm.setDouble(3, outCome.getValue());
        stm.setDouble(4, outCome.getFrequency());
        stm.setDate(5, outCome.getDate());
        stm.setString(6, outCome.getType());
        stm.setString(7, outCome.getDescription());
        stm.executeUpdate();
    }

    @Override
    public void update(OutCome outCome, String[] params) throws SQLException {

    }

    @Override
    public void delete(OutCome outCome) throws SQLException {

    }

    private OutCome parseOutCome(ResultSet result) throws SQLException {
        int idDespesa = result.getInt("id_despesa");
        int fkUsuario = result.getInt("fk_usuario");
        int fkInsFinanceira = result.getInt("fk_inst_financeira");
        Double value = result.getDouble("vl_despesa");
        Double frequency = result.getDouble("nr_parcela");
        Date date = result.getDate("dt_despesas");
        String type = result.getString("tipo_despesa");
        String description = result.getString("ds_despesa");

        return new OutCome(idDespesa, fkUsuario, fkInsFinanceira, value, frequency, date, type, description);

    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

}
