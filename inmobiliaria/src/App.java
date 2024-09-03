import controlador.InmobiliariaController;
import modelo.Inmobiliaria;
import vista.InmobiliariaVista;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        InmobiliariaController controller = new InmobiliariaController(inmobiliaria);
        InmobiliariaVista vista = new InmobiliariaVista(controller);

        inmobiliaria.inicializarDatosDePrueba();
        vista.mostrarMenu();
    }
}