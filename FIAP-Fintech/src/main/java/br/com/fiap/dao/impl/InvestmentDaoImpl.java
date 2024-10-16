package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.model.Investment;

import java.sql.SQLException;
import java.util.List;

public class InvestmentDaoImpl implements Dao<Investment> {
    @Override
    public Investment get(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Investment> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void save(Investment investment) throws SQLException {

    }

    @Override
    public void update(Investment investment, String[] params) throws SQLException {

    }

    @Override
    public void delete(Investment investment) throws SQLException {

    }
}
