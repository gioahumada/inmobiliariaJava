import controlador.InmobiliariaController;
import modelo.Inmobiliaria;
import vista.InmobiliariaVista;
import java.io.IOException; // Import added

public class App {
    public static void main(String[] args) {
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        InmobiliariaController controller = new InmobiliariaController(inmobiliaria);
        InmobiliariaVista vista = new InmobiliariaVista(controller);

        try {
            inmobiliaria.cargarUsuariosCSV("usuarios.csv");
            inmobiliaria.cargarComunasCSV("comunas.csv");
            controller.cargarTodasLasPropiedadesCSV("db");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        vista.mostrarMenu();
    }
}