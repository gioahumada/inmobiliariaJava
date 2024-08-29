import java.util.*;
import java.io.*;

public class MenuVista {
    private final Scanner scanner = new Scanner(System.in);

    /* CONSTANTES COLORES */
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BOLD = "\u001B[1m";

    public void mostrarMenu() {
        limpiarPantalla();
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
    }

    public int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            mostrarMensajeError("Entrada no válida. Por favor, ingrese un número.");
            scanner.next(); // QUEMA UNA LINEA /* NO QUITAR */
            System.out.print("\nSeleccione una opción: ");
        }
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMensajeExito(String mensaje) {
        System.out.printf(ANSI_GREEN);
        System.out.println(mensaje);
        System.out.printf(ANSI_RESET);
    }

    public void mostrarMensajeError(String mensaje) {
        System.out.printf(ANSI_RED);
        System.out.println(mensaje);
        System.out.printf(ANSI_RESET);
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void pausar() {
        System.out.println("\nPresione Enter para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int obtenerId() {
        System.out.print("Ingrese ID: ");
        while (!scanner.hasNextInt()) {
            mostrarMensajeError("Entrada no válida. Por favor, ingrese un número.");
            scanner.next(); // QUEMA UNA LINEA /* NO QUITAR */
            System.out.print("Ingrese ID: ");
        }
        return scanner.nextInt();
    }

    public String obtenerDireccion() {
        System.out.print("Ingrese Dirección: ");
        scanner.nextLine(); // QUEMA UNA LINEA /* NO QUITAR */
        return scanner.nextLine();
    }

    public double obtenerPrecio() {
        System.out.print("Ingrese Precio: ");
        while (!scanner.hasNextDouble()) {
            mostrarMensajeError("Entrada no válida. Por favor, ingrese un número.");
            scanner.next(); // QUEMA UNA LINEA /* NO QUITAR */
            System.out.print("Ingrese Precio: ");
        }
        return scanner.nextDouble();
    }
}