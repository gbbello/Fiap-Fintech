package br.com.fiap.model;

import java.sql.Date;

public class Notification {
    private long idNot;
    private long fkUsuario;
    private Date dtNotificacao;
    private String dsMensagem;
    private String status;

    public Notification(long idNot, long fkUsuario, Date dtNotificacao, String dsMensagem, String status) {
        this.idNot = idNot;
        this.fkUsuario = fkUsuario;
        this.dtNotificacao = dtNotificacao;
        this.dsMensagem = dsMensagem;
        this.status = status;
    }

    public Notification(long fkUsuario, Date dtNotificacao, String dsMensagem, String status) {
        this.fkUsuario = fkUsuario;
        this.dtNotificacao = dtNotificacao;
        this.dsMensagem = dsMensagem;
        this.status = status;
    }

    public long getIdNot() {
        return idNot;
    }

    public void setIdNot(long idNot) {
        this.idNot = idNot;
    }

    public long getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(long fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Date getDtNotificacao() {
        return dtNotificacao;
    }

    public void setDtNotificacao(Date dtNotificacao) {
        this.dtNotificacao = dtNotificacao;
    }

    public String getDsMensagem() {
        return dsMensagem;
    }

    public void setDsMensagem(String dsMensagem) {
        this.dsMensagem = dsMensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
