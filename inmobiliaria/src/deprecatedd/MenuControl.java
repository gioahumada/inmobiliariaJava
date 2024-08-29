package deprecatedd;

import java.util.*;
import java.io.*;

public class MenuControl {

    /* Atributos */
    private final PropiedadCSV propiedadCSV;
    private final MenuVista menuVista;

    
    /* Constructor */
    public MenuControl(PropiedadCSV propiedadCSV, MenuVista menuView) {
        this.propiedadCSV = propiedadCSV;
        this.menuVista = menuView;
    }

    /* Métodos */

    public void iniciar() {
        while (true) {
            menuVista.mostrarMenu();

            try {
                int opcion = menuVista.obtenerOpcion();
                menuVista.limpiarPantalla();

                switch (opcion) {
                    case 1:
                        agregarPropiedad();
                        break;
                    case 2:
                        leerPropiedades();
                        break;
                    case 3:
                        actualizarPropiedad();
                        break;
                    case 4:
                        eliminarPropiedad();
                        break;
                    case 5:
                        menuVista.mostrarMensaje("Saliendo del sistema...");
                        return;
                    default:
                        menuVista.mostrarMensaje("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                menuVista.mostrarMensajeError("Entrada no válida. Por favor, ingrese un número.");
            } catch (IOException e) {
                menuVista.mostrarMensajeError("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private void agregarPropiedad() throws IOException {
        String direccion = menuVista.obtenerDireccion();
        double precio = menuVista.obtenerPrecio();

        Propiedad nuevaPropiedad = new Propiedad(direccion, precio);
        propiedadCSV.agregarPropiedad(nuevaPropiedad);

        menuVista.mostrarMensajeExito("Propiedad agregada exitosamente.");
        menuVista.pausar();
    }

    private void leerPropiedades() throws IOException {
        List<Propiedad> propiedades = propiedadCSV.leerPropiedades(); /* ArrayList */

        for (Propiedad p : propiedades) {
            menuVista.mostrarMensaje(p.mostrarFormateado());
        }

        menuVista.pausar();
    }

    private void actualizarPropiedad() throws IOException {
        int id = menuVista.obtenerId();
        String direccion = menuVista.obtenerDireccion();
        double precio = menuVista.obtenerPrecio();

        Propiedad propiedadActualizada = new Propiedad(id, direccion, precio);
        propiedadCSV.actualizarPropiedad(propiedadActualizada);

        menuVista.mostrarMensajeExito("Propiedad actualizada exitosamente.");
        menuVista.pausar();
    }

    private void eliminarPropiedad() throws IOException {
        int id = menuVista.obtenerId();
        propiedadCSV.eliminarPropiedad(id);

        menuVista.mostrarMensajeExito("Propiedad eliminada exitosamente.");
        menuVista.pausar();
    }
}