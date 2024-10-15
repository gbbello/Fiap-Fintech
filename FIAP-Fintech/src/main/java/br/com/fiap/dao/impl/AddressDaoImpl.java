package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressDaoImpl implements Dao<Address> {

    private Connection conexao;

    public AddressDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void save(Address address) throws SQLException {

        String sql = "INSERT INTO t_fin_endereco (id_end, fk_usuario, nm_lougradouro, nm_rua, nm_bairro, nm_uf, nr_lougradouro, ds_complemento)" +
                " VALUES (sq_t_fin_endereco.nextval,1, ?, ?, ?, ?, ?,?)";

        PreparedStatement stm = conexao.prepareStatement(sql);

        stm.setString(1, address.getLogradouro());
        stm.setString(2, address.getRua());
        stm.setString(3, address.getBairro());
        stm.setString(4, address.getEstado());
        stm.setInt(5, address.getNumero());
        stm.setString(6, address.getComplemento());
        stm.executeUpdate();
    }

    @Override
    public void update(Address address, String[] params) throws SQLException {

    }

    @Override
    public void delete(Address address) throws SQLException {

    }

    @Override
    public Optional<Address> get(long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Address> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_endereco");
        ResultSet result = stm.executeQuery();
        List<Address> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseAddress(result));
        }
        return lista;
    }

    private Address parseAddress(ResultSet result) throws SQLException {
        int idEnd = result.getInt("id_end");
        int fkUsuario = result.getInt("fk_usuario");
        String nomeLogradouro = result.getString("nm_lougradouro");
        int numero = result.getInt("nr_lougradouro");
        String bairro = result.getString("nm_bairro");
        String estado = result.getString("nm_uf");
        String rua = result.getString("nm_rua");
        String complemento = result.getString("ds_complemento");

        return new Address(idEnd, fkUsuario, nomeLogradouro, rua, numero, complemento, bairro, estado);

    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}