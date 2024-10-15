package br.com.fiap.model;

public class Address {
    private int idEnd;
    private int fkUsuario;
    private String nomeLogradouro;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String estado;

    public Address(int idEnd, int fkUsuario, String nomeLogradouro, String rua, int numero, String complemento, String bairro,   String estado) {
        this.idEnd = idEnd;
        this.fkUsuario= fkUsuario;
        this.nomeLogradouro = nomeLogradouro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
    }


    public Address( int fkUsuario, String nomeLogradouro,  int numero, String complemento, String rua, String bairro, String estado) {
        this.nomeLogradouro = nomeLogradouro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
    }

    //Getter and Setter
    public int getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(int idEnd) {
        this.idEnd = idEnd;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public String getLogradouro() {
        return nomeLogradouro;
    }

    public void setLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }


// Metodo
    public String getCompleteAddress() {
        return this.nomeLogradouro + ","
                + this.numero + ","
                + this.complemento + ","
                + this.estado;
    }

}
