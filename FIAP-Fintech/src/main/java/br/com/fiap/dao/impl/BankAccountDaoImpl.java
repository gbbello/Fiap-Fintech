package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankAccountDaoImpl implements Dao<BankAccount> {

    private Connection conexao;

    public BankAccountDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void save(BankAccount bankAccount) throws SQLException {

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

    @Override
    public Optional<BankAccount> get(long id) throws SQLException {
        return Optional.empty();
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
