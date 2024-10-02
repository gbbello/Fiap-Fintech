package br.com.fiap.fintech.model;

public class Login {
    //Atributos do objeto
    private String userName;
    private String password;

    //Construtores
    public Login(){

    }


    public Login(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public void doLogin(){
        System.out.println("Realizando login para o usuário: " + userName );
    }
}
