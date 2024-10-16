package br.com.fiap.test;

import br.com.fiap.dao.impl.NotificationDaoImpl;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.Notification;

import java.sql.SQLException;
import java.util.List;

public class NotificationTest {

    public static void main(String[] args) {
        addNew();
        getAll();
    }

    public static void addNew() {
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        try {
            for (int i = 1; i <= 5; i++) {
                Notification Notification1 = new Notification(1, sqlDate, "Mensagem da notificacao" + i, "r");
                DaoFactory.getNotificationDao().insert(Notification1);
                System.out.println("Notification cadastrado!");
            }
            DaoFactory.getNotificationDao().fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll() {
        try {
            NotificationDaoImpl dao = new NotificationDaoImpl();
            List<Notification> notifications = dao.getAll();

            for (Notification notification : notifications) {
                System.out.println(notification.getIdNot() + ", " +notification.getFkUsuario() + ", " + notification.getDtNotificacao() + ", " + notification.getDsMensagem()+", " + notification.getStatus());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
