package br.com.fiap.view;
import br.com.fiap.dao.AddressDao;
import br.com.fiap.model.Address;
import java.sql.SQLException;
import java.util.List;

public class GetAllAddressTest {
    public static void main(String[] args) {
        try {
            AddressDao dao = new AddressDao();
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
}