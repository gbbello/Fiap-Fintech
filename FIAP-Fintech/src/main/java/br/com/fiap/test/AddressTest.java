package br.com.fiap.test;

import br.com.fiap.dao.impl.AddressDaoImpl;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.factory.DaoFactory;
import br.com.fiap.model.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressTest {
    public static void main(String[] args) {
        //addNew();
        getAll();
        //pesquisar(1);
    }

    public static void addNew(){
        try {
            for (int i=1; i <= 5; i++) {
                Address Address= new Address(1, "Casa"+i, 170+i, "A", "Rua Odilon Martins de Andrades", "Recreio dos Bandeirantes", "RJ");
                DaoFactory.getAddressDao().insert(Address);
                System.out.println("Endereço cadastrado!");
            }

            DaoFactory.getAddressDao().fecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAll(){
        try {
            AddressDaoImpl dao = new AddressDaoImpl();
            List<Address> addresses = dao.getAll();

            for (Address address : addresses){
                System.out.println(address.getIdEnd()+ " " + address.getFkUsuario() + ", " + address.getLogradouro());
                System.out.println(address.getRua()+ " " + address.getNumero() + ", " + address.getComplemento() + ", " + address.getBairro() + ", " + address.getEstado()  );
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void pesquisar(long id){
        try {
            AddressDaoImpl doa = new AddressDaoImpl();
            Address address =  doa.getById(id);
            System.out.println(address.getIdEnd()+ " " + address.getFkUsuario() + ", " + address.getLogradouro());
            System.out.println(address.getRua()+ " " + address.getNumero() + ", " + address.getComplemento() + ", " + address.getBairro() + ", " + address.getEstado()  );
        }catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Identificação nao existe na tabela");
        }
    }
}
