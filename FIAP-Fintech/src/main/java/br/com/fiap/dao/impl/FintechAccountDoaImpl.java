package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.model.FintechAccount;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FintechAccountDoaImpl implements Dao<FintechAccount> {
    @Override
    public Optional<FintechAccount> get(long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<FintechAccount> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void save(FintechAccount fintechAccount) throws SQLException {

    }

    @Override
    public void update(FintechAccount fintechAccount, String[] params) throws SQLException {

    }

    @Override
    public void delete(FintechAccount fintechAccount) throws SQLException {

    }
}
