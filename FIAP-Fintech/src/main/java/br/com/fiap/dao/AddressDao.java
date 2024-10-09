package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {

    private Connection conexao;
    public AddressDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    public void cadastrar(Address address) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO t_fin_address (id_end, fk_usuario, nm_lougradouro, nm_bairro, nm_uf, nr_lougradouro, ds_complemento) VALUES (sq_t_fin_endereco.nextval,1, ?, ?, ?, ?, ?)");
        stm.setString(1, address.getLogradouro());
        stm.setString(3, address.getBairro());
        stm.setString(4, address.getEstado());
        stm.setInt(2, address.getNumero());
        stm.setString(5, address.getComplemento());
        stm.executeUpdate();
    }
    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    public Address pesquisar(int id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_endereco WHERE id_end = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Address não encontrado");
        return parseAddress(result);
    }
    public List<Address> listar() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_endereco");
        ResultSet result = stm.executeQuery();
        List<Address> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseAddress(result));
        }
        return lista;
    }

    private Address parseAddress (ResultSet result) throws SQLException{
        int idEnd = result.getInt("id_end");
        int fkUsuario = result.getInt("fk_usuario");
        String nomeLogradouro = result.getString("nm_lougradouro");
        String rua = result.getString("nm_rua");
        int numero = result.getInt("nr_lougradouro");
        String complemento = result.getString("ds_complemento");
        String bairro = result.getString("nm_bairro");
        String estado=result.getString("nm_uf");

        return new Address(idEnd, fkUsuario, nomeLogradouro, rua, numero,complemento,bairro, estado);

    }
}