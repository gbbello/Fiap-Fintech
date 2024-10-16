package br.com.fiap.model;

import java.sql.Date;

public class Login {

    private long idLogin;
    private long fkUsuario;
    private String email;
    private String password;
    private String statusAutentification;
    private Date dtRegistration;


    public Login(long id_login, long fk_usuario, String email, String password, String autentification, Date dt_registration) {
        this.idLogin = id_login;
        this.fkUsuario = fk_usuario;
        this.email = email;
        this.password = password;
        this.statusAutentification = autentification;
        this.dtRegistration = dt_registration;
    }

    public Login(long fk_usuario, String email, String password, String autentification, Date dt_registration) {
        this.fkUsuario = fk_usuario;
        this.email = email;
        this.password = password;
        this.statusAutentification = autentification;
        this.dtRegistration = dt_registration;
    }

    public long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(long idLogin) {
        this.idLogin = idLogin;
    }

    public long getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(long fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatusAutentification() {
        return statusAutentification;
    }

    public void setStatusAutentification(String statusAutentification) {
        this.statusAutentification = statusAutentification;
    }

    public Date getDtRegistration() {
        return dtRegistration;
    }

    public void setDtRegistration(Date dtRegistration) {
        this.dtRegistration = dtRegistration;
    }
}
