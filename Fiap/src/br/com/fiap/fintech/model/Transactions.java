package br.com.fiap.fintech.model;

public abstract class Transactions {
    //Atributos do objeto
    private Double value;
    private String date;
    private String description;

    //Construtores
    public Transactions(){

    }

    public Transactions(Integer type, Double value, String date, String description) {
        this.value = value;
        this.date = date;
        this.description = description;
    }

    //Metodos
    //Deleto transacao
    public void delete(boolean confirmation){
        if(confirmation){
            System.out.println("Deleçao realizada com sucesso," +this.description + "no valor de:" + this.value );
        }else{
            System.out.println("Deleçao cancelada," + this.value  );
        }
    }
    //Edito transacao
    public void edit( String attribute, String newValue ){
        System.out.println("O campo:" + attribute + " foi atualizado com sucesso" );
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
