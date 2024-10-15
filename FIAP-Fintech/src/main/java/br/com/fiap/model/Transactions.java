package br.com.fiap.model;

import java.sql.Date;

public abstract class Transactions {
    //Atributos do objeto
    private Double value;
    private Date date;
    private String type;
    private String description;


    //Construtores
    public Transactions(){

    }

    public Transactions(Double value, Date date, String type, String description) {
        this.value = value;
        this.date = date;
        this.type = type;
        this.description = description;
    }



    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
