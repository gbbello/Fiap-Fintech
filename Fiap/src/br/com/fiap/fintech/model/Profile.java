package br.com.fiap.fintech.model;

public abstract class Profile {
    //Atributos do objeto
    private String name;
    private String lastName;
    private String rg;
    private String cpf;
    private String sex;
    private String birthdate;
    private String eMail;
    private Address address;

    //Construtores
    public Profile(){
    }

    public Profile(String name, String lastName, String rg, String cpf, String sex, String birthdate, String eMail, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.rg = rg;
        this.cpf = cpf;
        this.sex = sex;
        this.birthdate = birthdate;
        this.eMail = eMail;
        this.address = address;
    }



    //Edito o profile
    public void edit(String attribute, String newValue ){
        System.out.println("O campo:" + attribute + " foi atualizado com sucesso" );
    }

    //Get and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Address getAddress() {
        return address;
    }

    public void setEndereco(Address address) {
        this.address = address;
    }
}
