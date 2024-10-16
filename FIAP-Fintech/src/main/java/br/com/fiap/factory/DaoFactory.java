package br.com.fiap.factory;

import br.com.fiap.dao.impl.*;

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

    public static FintechAccountDaoImpl getFintechAccountDao() throws SQLException {
        return new FintechAccountDaoImpl();
    }

    public static LoginDaoImpl getLoginDao() throws SQLException {
        return new LoginDaoImpl();
    }
}
