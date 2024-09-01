// InmobiliariaVista.java
package vista;

import controlador.InmobiliariaController;
import modelo.Casa;
import modelo.Comuna;
import modelo.Departamento;
import modelo.Terreno;

import java.util.List;
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
            System.out.println("8. Mostrar Todas las Propiedades de una Comuna");
            System.out.println("9. Salir");
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
                    mostrarTodasLasPropiedadesDeComuna();
                    break;
                case 9:
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
        System.out.println("Ingrese Número de Habitaciones:");
        int numHabitaciones = scanner.nextInt();
        System.out.println("Ingrese Número de Baños:");
        int numBanios = scanner.nextInt();
        System.out.println("Ingrese Número de Estacionamientos:");
        int numEstacionamiento = scanner.nextInt();
        System.out.println("¿Tiene Patio? (true/false):");
        boolean tienePatio = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        Casa casa = new Casa(idCasa, precio, direccion, mts2, numHabitaciones, numBanios, numEstacionamiento, tienePatio);
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
            System.out.println("Nombre Comuna: " + comuna.getNombre());
            System.out.println("ID Comuna: " + comuna.getId());
            System.out.println("Clase de zona: " + comuna.getClase());
            System.out.println();
        }
    }

    private void mostrarTodasLasPropiedadesDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            List<Object> propiedades = comuna.obtenerTodasLasPropiedades();
            for (Object propiedad : propiedades) {
                if (propiedad instanceof Casa) {
                    Casa casa = (Casa) propiedad;
                    System.out.println("Tipo: Casa");
                    System.out.println("ID: " + casa.getId());
                    System.out.println("Precio: " + casa.getPrecio());
                    System.out.println("Direccion: " + casa.getDireccion());
                    System.out.println("Metros Cuadrados: " + casa.getMts2());
                    System.out.println("Comuna: " + comuna.getNombre());
                } else if (propiedad instanceof Departamento) {
                    Departamento departamento = (Departamento) propiedad;
                    System.out.println("Tipo: Departamento");
                    System.out.println("ID: " + departamento.getId());
                    System.out.println("Precio: " + departamento.getPrecio());
                    System.out.println("Direccion: " + departamento.getDireccion());
                    System.out.println("Metros Cuadrados: " + departamento.getMts2());
                    System.out.println("Comuna: " + comuna.getNombre());
                } else if (propiedad instanceof Terreno) {
                    Terreno terreno = (Terreno) propiedad;
                    System.out.println("Tipo: Terreno");
                    System.out.println("ID: " + terreno.getId());
                    System.out.println("Precio: " + terreno.getPrecio());
                    System.out.println("Direccion: " + terreno.getDireccion());
                    System.out.println("Metros Cuadrados: " + terreno.getMts2());
                    System.out.println("Comuna: " + comuna.getNombre());
                }
                System.out.println(); // Add a blank line between properties
            }
        } else {
            System.out.println("Comuna no encontrada");
        }
    }
}