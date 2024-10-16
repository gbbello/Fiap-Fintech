package br.com.fiap.model;

import java.sql.Date;

public abstract class Profile {
    //Atributos do objeto
    private long idUsuario;
    private String name;
    private String rg;
    private String cpf;
    private String sex;
    private Date birthdate;
    private String educationLevel;
    private String martilStatus;

    public Profile(String name, String rg, String cpf, String sex, Date birthdate, String educationLevel, String martilStatus) {
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.sex = sex;
        this.birthdate = birthdate;
        this.educationLevel = educationLevel;
        this.martilStatus = martilStatus;
    }

    public Profile(long idUsuario, String name, String rg, String cpf, String sex, Date birthdate, String educationLevel, String martilStatus) {
        this.idUsuario = idUsuario;
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.sex = sex;
        this.birthdate = birthdate;
        this.educationLevel = educationLevel;
        this.martilStatus = martilStatus;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getMartilStatus() {
        return martilStatus;
    }

    public void setMartilStatus(String martilStatus) {
        this.martilStatus = martilStatus;
    }
}
