import modelo.Inmobiliaria;
import vista.InmobiliariaVista;
import java.io.IOException;
import vista.Login;

public class App {
    public static void main(String[] args) {
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        InmobiliariaVista vista = new InmobiliariaVista(inmobiliaria);

        try {
            inmobiliaria.cargarUsuariosCSV("usuarios.csv");
            inmobiliaria.cargarComunasCSV("comunas.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Login login = new Login(inmobiliaria);
        login.setVisible(true);
    }
}
