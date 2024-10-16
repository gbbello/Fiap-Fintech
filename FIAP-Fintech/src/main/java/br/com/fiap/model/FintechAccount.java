package br.com.fiap.model;
import java.sql.Date;

public class FintechAccount extends Profile {

    public FintechAccount( String name, String rg, String cpf, String sex, Date birthdate, String educationLevel, String martilStatus) {
        super(name, rg, cpf, sex, birthdate, educationLevel, martilStatus);
    }
    public FintechAccount(long idUsuario, String name, String rg, String cpf, String sex, Date birthdate, String educationLevel, String martilStatus) {
        super(idUsuario, name, rg, cpf, sex, birthdate, educationLevel, martilStatus);
    }
}
