package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Investment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestmentDaoImpl implements Dao<Investment> {
    private Connection conexao;

    public InvestmentDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    @Override
    public Investment getById(long id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_investimento WHERE id_not = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) throw new EntidadeNaoEcontradaException("Notificação não encontrada");

        return parseInvestment(result);
    }

    @Override
    public List<Investment> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_investimento");
        ResultSet result = stm.executeQuery();
        List<Investment> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseInvestment(result));
        }
        return lista;
    }

    @Override
    public void insert(Investment investment) throws SQLException {
        String sql = "INSERT INTO t_fin_investimento (id_inv, fk_usuario, fk_inst_financeira, vl_invest, tx_retabilidade_ano)" +
                " VALUES (sq_t_fin_investimento.nextval,?, ?, ?, ?)";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setLong(1, investment.getFkUsuario());
        stm.setLong(2, investment.getFkInstFinanceira());
        stm.setDouble(3, investment.getVlInvest());
        stm.setDouble(4, investment.getProfitableRate());

        stm.executeUpdate();
    }

    @Override
    public void update(Investment investment, String[] params) throws SQLException {

    }

    @Override
    public void delete(Investment investment) throws SQLException {

    }

    private Investment parseInvestment(ResultSet result) throws SQLException {

        long idInvestment= result.getLong("id_inv");
        long fkUsuario= result.getLong("fk_usuario");
        long fkInstFinanceira = result.getLong("fk_inst_financeira");
        Double vlInvest= result.getDouble("vl_invest");
        Double profitableRate = result.getDouble("tx_retabilidade_ano");

        return new Investment(idInvestment, fkUsuario, fkInstFinanceira, vlInvest, profitableRate);

    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
