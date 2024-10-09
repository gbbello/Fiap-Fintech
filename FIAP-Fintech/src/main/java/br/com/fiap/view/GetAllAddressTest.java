package br.com.fiap.view;
import br.com.fiap.dao.AddressDao;
import br.com.fiap.model.Address;
import java.sql.SQLException;
public class GetAllAddressTest {
    public static void main(String[] args) {
        try {
            AddressDao dao = new AddressDao();
            Address Address = new Address(1,"Casa2", 170, "A","Rua Odilon Martins de Andrades", "Recreio dos Bandeirantes","RJ");
            dao.cadastrar(Address);
            dao.fecharConexao();
            System.out.println("Produto cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}