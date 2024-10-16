package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEcontradaException;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T get(long id) throws SQLException, EntidadeNaoEcontradaException;

    List<T> getAll() throws SQLException;

    void save(T t) throws SQLException;

    void update(T t, String[] params) throws SQLException;

    void delete(T t) throws SQLException;
}