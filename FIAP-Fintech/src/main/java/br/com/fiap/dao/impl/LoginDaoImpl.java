package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.model.Login;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LoginDaoImpl implements Dao<Login> {

    @Override
    public Optional<Login> get(long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Login> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void save(Login login) throws SQLException {

    }

    @Override
    public void update(Login login, String[] params) throws SQLException {

    }

    @Override
    public void delete(Login login) throws SQLException {

    }
}
