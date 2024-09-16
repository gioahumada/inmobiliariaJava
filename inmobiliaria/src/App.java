import modelo.Inmobiliaria;
import vista.InmobiliariaVista;
import java.io.IOException;

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
        
        vista.mostrarMenu(); // Mostrar menú sin necesidad de controller intermedio
    }
}
