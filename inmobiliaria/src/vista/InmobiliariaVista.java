// InmobiliariaVista.java
package vista;

import controlador.InmobiliariaController;
import modelo.Casa;
import modelo.Comuna;

import java.util.Scanner;

public class InmobiliariaVista {
    private InmobiliariaController controller;
    private Scanner scanner;

    public InmobiliariaVista(InmobiliariaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("1. Agregar Comuna");
            System.out.println("2. Ver Comuna");
            System.out.println("3. Actualizar Comuna");
            System.out.println("4. Eliminar Comuna");
            System.out.println("5. Agregar Casa a Comuna");
            System.out.println("6. Eliminar Casa de Comuna");
            System.out.println("7. Mostrar Todas las Comunas");
            System.out.println("8. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    agregarComuna();
                    break;
                case 2:
                    verComuna();
                    break;
                case 3:
                    actualizarComuna();
                    break;
                case 4:
                    eliminarComuna();
                    break;
                case 5:
                    agregarCasaAComuna();
                    break;
                case 6:
                    eliminarCasaDeComuna();
                    break;
                case 7:
                    mostrarTodasLasComunas();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void agregarComuna() {
        System.out.println("Ingrese ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese Clase:");
        String clase = scanner.nextLine();
        controller.agregarComuna(id, nombre, clase);
    }

    private void verComuna() {
        System.out.println("Ingrese ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Comuna comuna = controller.obtenerComuna(id);
        if (comuna != null) {
            System.out.println("ID: " + comuna.getId());
            System.out.println("Nombre: " + comuna.getNombre());
            System.out.println("Clase: " + comuna.getClase());
        } else {
            System.out.println("Comuna no encontrada");
        }
    }

    private void actualizarComuna() {
        System.out.println("Ingrese ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese Nuevo Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese Nueva Clase:");
        String clase = scanner.nextLine();
        controller.actualizarComuna(id, nombre, clase);
    }

    private void eliminarComuna() {
        System.out.println("Ingrese ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        controller.eliminarComuna(id);
    }

    private void agregarCasaAComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese ID de la Casa:");
        int idCasa = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese Precio:");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese Dirección:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese Clase de Zona:");
        String claseDeZona = scanner.nextLine();
        System.out.println("Ingrese Número de Habitaciones:");
        int numHabitaciones = scanner.nextInt();
        System.out.println("Ingrese Número de Baños:");
        int numBanios = scanner.nextInt();
        System.out.println("Ingrese Número de Estacionamientos:");
        int numEstacionamiento = scanner.nextInt();
        System.out.println("¿Tiene Patio? (true/false):");
        boolean tienePatio = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        Casa casa = new Casa(idCasa, precio, direccion, mts2, claseDeZona, numHabitaciones, numBanios, numEstacionamiento, tienePatio);
        controller.agregarCasaAComuna(idComuna, casa);
    }

    private void eliminarCasaDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese ID de la Casa:");
        int idCasa = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            for (Casa casa : comuna.getCasas()) {
                if (casa.getId() == idCasa) {
                    controller.eliminarCasaDeComuna(idComuna, casa);
                    break;
                }
            }
        } else {
            System.out.println("Comuna no encontrada");
        }
    }

    private void mostrarTodasLasComunas() {
        for (Comuna comuna : controller.obtenerTodasLasComunas()) {
            System.out.println(comuna);
        }
    }
}