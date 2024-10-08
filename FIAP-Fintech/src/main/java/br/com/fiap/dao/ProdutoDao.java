package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private Connection conexao;
    public ProdutoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    public void cadastrar(Produto produto) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_produto (cd_produto, nm_produto, ds_produto, vl_produto, nr_estoque) VALUES (seq_produto.nextval, ?, ?, ?, ?)");
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getDescricao());
        stm.setDouble(3, produto.getValor());
        stm.setInt(4, produto.getEstoque());
        stm.executeUpdate();
    }
    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    public Produto pesquisar(long codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_produto WHERE cd_produto = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Produto não encontrado");
        return parseProduto(result);
    }
    public List<Produto> listar() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_produto");
        ResultSet result = stm.executeQuery();
        List<Produto> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseProduto(result));
        }
        return lista;
    }

    private Produto parseProduto (ResultSet result) throws SQLException{
        Long id = result.getLong("cd_produto");
        String nome = result.getString("nm_produto");
        String descricao = result.getString("ds_produto");
        double valor = result.getDouble("vl_produto");
        int estoque = result.getInt("nr_estoque");

        return new Produto(id, nome, descricao, valor, estoque);

    }
}