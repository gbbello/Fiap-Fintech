package br.com.fiap.factory;

import br.com.fiap.dao.impl.AddressDaoImpl;
import br.com.fiap.dao.impl.BankAccountDaoImpl;
import br.com.fiap.dao.impl.IncomeDaoImpl;
import br.com.fiap.dao.impl.OutComeDaoImpl;

import java.sql.SQLException;

public class DaoFactory {
    public static AddressDaoImpl getAddressDao() throws SQLException {
        return new AddressDaoImpl();
    }
    public static BankAccountDaoImpl getBankAccountDao() throws SQLException{
        return new BankAccountDaoImpl();
    }
    public static IncomeDaoImpl getIncomeDao() throws SQLException{
        return new IncomeDaoImpl();
    }
    public static OutComeDaoImpl getOutComeDao() throws SQLException{
        return new OutComeDaoImpl();
    }
}
