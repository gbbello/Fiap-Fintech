package br.com.fiap.dao.impl;

import br.com.fiap.dao.Dao;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Notification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDaoImpl implements Dao<Notification> {
    private Connection conexao;

    public NotificationDaoImpl() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    @Override
    public Notification getById(long id) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_notificacao WHERE id_not = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next()) throw new EntidadeNaoEcontradaException("Notificação não encontrada");

        return parseNotification(result);
    }

    @Override
    public List<Notification> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_fin_notificacao");
        ResultSet result = stm.executeQuery();
        List<Notification> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseNotification(result));
        }
        return lista;
    }

    @Override
    public void insert(Notification notification) throws SQLException {
        String sql = "INSERT INTO t_fin_notificacao (id_not, fk_usuario, dt_notificacao, ds_mensagem, status)" +
                " VALUES (sq_t_fin_notificacao.nextval,?, ?, ?, ?)";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setLong(1, notification.getFkUsuario());
        stm.setDate(2, notification.getDtNotificacao());
        stm.setString(3, notification.getDsMensagem());
        stm.setString(4, notification.getStatus());
        stm.executeUpdate();
    }

    @Override
    public void update(Notification notification, String[] params) throws SQLException {

    }

    @Override
    public void delete(Notification notification) throws SQLException {

    }

    private Notification parseNotification(ResultSet result) throws SQLException {

        long idNotification= result.getLong("id_not");
        long fkUsuario= result.getLong("fk_usuario");
        Date dtNotification= result.getDate("dt_notificacao");
        String dsMensagem= result.getString("ds_mensagem");
        String status= result.getString("status");

        return new Notification(idNotification, fkUsuario, dtNotification, dsMensagem, status);

    }
    
    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
