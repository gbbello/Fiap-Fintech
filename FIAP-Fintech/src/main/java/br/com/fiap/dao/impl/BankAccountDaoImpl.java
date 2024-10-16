package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDaoImpl implements Dao<BankAccount> {

    private Connection conexao;

    public BankAccountDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public BankAccount getById(long id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_inst_financeira WHERE id_ins = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) throw new EntidadeNaoEcontradaException("Instituicao financeira nao encontrada");

        return parseBankAccount(result);
    }

    @Override
    public List<BankAccount> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_inst_financeira");
        ResultSet result = stm.executeQuery();
        List<BankAccount> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseBankAccount(result));
        }
        return lista;
    }

    @Override
    public void insert(BankAccount bankAccount) throws SQLException {

        String sql = "INSERT INTO t_fin_inst_financeira (id_ins, nr_inst, nr_ag, nr_cc)" +
                " VALUES (sq_t_fin_inst_financeira.nextval,?, ?, ?)";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, bankAccount.getBankCode());
        stm.setInt(2, bankAccount.getAg());
        stm.setInt(3, bankAccount.getCc());
        stm.executeUpdate();
    }

    @Override
    public void update(BankAccount bankAccount, String[] params) throws SQLException {

    }

    @Override
    public void delete(BankAccount bankAccount) throws SQLException {

    }

    private BankAccount parseBankAccount(ResultSet result) throws SQLException {
        int idInst = result.getInt("id_ins");
        int bankCode = result.getInt("nr_inst");
        int ag = result.getInt("nr_ag");
        int cc = result.getInt("nr_cc");

        return new BankAccount(idInst, bankCode, ag, cc);

    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

}
