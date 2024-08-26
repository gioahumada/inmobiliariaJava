import java.util.*;
import java.io.*;

public class Menu {
    private final PropiedadCSV propiedadCSV;
    private final Scanner scanner;

    /* Constantes Colores  */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m"; /* Solo errores */
    public static final String ANSI_BOLD = "\u001B[1m"; /* Negrita */

    /* Constructor */

    public Menu() {
        propiedadCSV = new PropiedadCSV();
        scanner = new Scanner(System.in);
    }

    /* Métodos */

    public void mostrarMenu() {
        while (true) {
            cls();
            System.out.printf(ANSI_GREEN + ANSI_BOLD);
            System.out.println("→ Sistema de Gestión de Propiedades\n");
            System.out.printf(ANSI_RESET + ANSI_YELLOW);
            System.out.println("[1] Agregar Propiedad");
            System.out.println("[2] Leer Propiedades");
            System.out.println("[3] Actualizar Propiedad");
            System.out.println("[4] Eliminar Propiedad");
            System.out.println("[5] Salir");
            System.out.printf(ANSI_RESET);
            System.out.print("\nSeleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            try { /* En caso de errores */
                switch (opcion) {
                    case 1:
                        cls();
                        agregarPropiedad();
                        cls();
                        break;
                    case 2:
                        cls();
                        leerPropiedades();
                        cls();
                        break;
                    case 3:
                        cls();
                        actualizarPropiedad();
                        cls();
                        break;
                    case 4:
                        cls();
                        eliminarPropiedad();
                        cls();
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (IOException e) {
                System.out.printf(ANSI_RED);
                System.out.println("Ocurrió un error: " + e.getMessage());
                System.out.printf(ANSI_RESET);
            }
        }
    }

    /* Limpiar Pantalla */
    private void cls() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private void pause() {
        System.out.println("\nPresione Enter para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Operaciones CRUD DESDE MENU */

    private void agregarPropiedad() throws IOException {
        System.out.printf(ANSI_YELLOW);
        System.out.print("Ingrese ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea /* NO QUITAR */

        System.out.print("Ingrese Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea /* NO QUITAR */

        Propiedad nuevaPropiedad = new Propiedad(id, direccion, precio);
        propiedadCSV.agregarPropiedad(nuevaPropiedad);
        System.out.printf(ANSI_RESET);

        System.out.println("\nPropiedad agregada exitosamente.");
        pause();
    }

    private void leerPropiedades() throws IOException
    {
        List<Propiedad> propiedades = propiedadCSV.leerPropiedades();

        System.out.printf(ANSI_YELLOW);

        for (Propiedad p : propiedades) {
            System.out.println(p.mostrarFormateado() + "\n");

        }

        System.out.printf(ANSI_RESET);
        pause();
    }

    private void actualizarPropiedad() throws IOException {
        System.out.print("Ingrese ID de la propiedad a actualizar: ");
        int idActualizar = scanner.nextInt();

        System.out.print("Ingrese nueva Dirección: ");
        String nuevaDireccion = scanner.nextLine();

        System.out.print("Ingrese nuevo Precio: ");
        double nuevoPrecio = scanner.nextDouble();

        Propiedad propiedadActualizada = new Propiedad(idActualizar, nuevaDireccion, nuevoPrecio);
        propiedadCSV.actualizarPropiedad(propiedadActualizada);

        System.out.println("Propiedad actualizada exitosamente.");
        pause();
    }

    private void eliminarPropiedad() throws IOException {
        System.out.print("Ingrese ID de la propiedad a eliminar: ");
        int idEliminar = scanner.nextInt();

        propiedadCSV.eliminarPropiedad(idEliminar);
        System.out.println("Propiedad eliminada exitosamente.");
        pause();
    }
}