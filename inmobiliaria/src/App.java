import java.io.IOException;

public class App {
        public static void main(String[] args) throws IOException {
        PropiedadCSV propiedadCSV = new PropiedadCSV();

        int maxId = propiedadCSV.obtenerMaxId();

        if (maxId == 0) {
            Propiedad.setUltimoId(0); // Inicializa ultimoId a 0 si no hay propiedades
        } else {
            Propiedad.setUltimoId(maxId + 1); // Inicializa ultimoId al siguiente ID disponible
        }

        MenuVista menuVista = new MenuVista();
        MenuControl menuController = new MenuControl(propiedadCSV, menuVista);
        
        menuController.iniciar();
    }
}