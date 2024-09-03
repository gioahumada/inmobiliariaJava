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
        System.out.println("Bienvenido a la InmobiliariaJava");
        while (true) {
            System.out.println();
            System.out.println("1. Mostrar Todas las Comunas");
            System.out.println("2. Ver Comuna");
            System.out.println("3. Crear Comuna");
            System.out.println("4. Añadir a Comuna");
            System.out.println("5. Eliminar Comuna");
            System.out.println("6. Quitar a Comuna");
            System.out.println("7. Actualizar Datos");
            System.out.println("8. Salir");
            System.out.println("Ingrese una opción:");
            System.out.println();

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    mostrarTodasLasComunas();
                    break;
                case 2:
                    limpiarPantalla();
                    verComuna();
                    
                    break;
                case 3:
                    limpiarPantalla();
                    crearComuna();
                    break;
                case 4:
                    limpiarPantalla();
                    añadirAComuna();
                    break;
                case 5:
                    limpiarPantalla();
                    eliminarComuna();
                    break;
                case 6:
                    limpiarPantalla();
                    quitarDeComuna();
                    break;
                case 7:
                    limpiarPantalla();
                    actualizarDatos();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void limpiarPantalla() {
        for (int i = 0; i < 8; i++) {
            System.out.println();
        }
    }

    private void mostrarTodasLasComunas() {
        List<Comuna> comunas = controller.obtenerTodasLasComunas();
    
        if (comunas.isEmpty()) {
            System.out.println("No hay comunas que mostrar");
        } else {
            for (Comuna comuna : comunas) {
                System.out.println(comuna.toString());
            }
        }
    }

    private void verComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();
    
        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            // Mostrar detalles de la comuna
            System.out.println(comuna.toString());
    
            // Mostrar todas las propiedades de la comuna
            List<Object> propiedades = comuna.obtenerTodasLasPropiedades();
            if (!propiedades.isEmpty()) {
                System.out.println("Propiedades en la Comuna:");
                for (Object propiedad : propiedades) {
                    if (propiedad instanceof Casa) {
                        Casa casa = (Casa) propiedad;
                        System.out.println(casa.toString());
                    } else if (propiedad instanceof Departamento) {
                        Departamento departamento = (Departamento) propiedad;
                        System.out.println(departamento.toString());
                    } else if (propiedad instanceof Terreno) {
                        Terreno terreno = (Terreno) propiedad;
                        System.out.println(terreno.toString());
                    }
                    System.out.println(); // Añadir una línea en blanco entre propiedades
                }
            } else {
                System.out.println("No hay propiedades en esta comuna.");
            }
        } else {
            System.out.println("Comuna no encontrada");
        }
    }   

    private void crearComuna() {
        System.out.println("Ingrese ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese Clase:");
        String clase = scanner.nextLine();
        controller.agregarComuna(id, nombre, clase);
    }

    private void añadirAComuna() {
        System.out.println("1- Añadir Casa a Comuna");
        System.out.println("2- Añadir Departamento a Comuna");
        System.out.println("3- Añadir Terreno a Comuna");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (opcion) {
            case 1:
                añadirCasaAComuna();
                break;
            case 2:
                añadirDepartamentoAComuna();
                break;
            case 3:
                añadirTerrenoAComuna();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void añadirCasaAComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese ID de la Casa:");
        int idCasa = scanner.nextInt();
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
    
        System.out.println("Ingrese Metros Cuadrados Construidos:");
        int mts2Construidos = scanner.nextInt();
    
        System.out.println("¿Tiene Patio? (true/false):");
        boolean tienePatio = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
    
        Casa casa = new Casa(idCasa, 0, direccion, mts2, numHabitaciones, numBanios, numEstacionamiento, mts2Construidos, tienePatio);
        controller.agregarCasaAComuna(idComuna, casa);
    
        System.out.println("Casa añadida con éxito a la comuna.");
    }    
    
    private void añadirDepartamentoAComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese ID del Departamento:");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese Dirección:");
        String direccion = scanner.nextLine();
    
        System.out.println("Ingrese Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese Número de Habitaciones:");
        int numHabitaciones = scanner.nextInt();
    
        System.out.println("Ingrese Número de Baños:");
        int numBanos = scanner.nextInt();
    
        System.out.println("Ingrese Piso:");
        int piso = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("¿Tiene Estacionamiento? (Sí/No):");
        String estacionamientoInput = scanner.nextLine().trim().toLowerCase();
        boolean tieneEstacionamiento = estacionamientoInput.equals("sí") || estacionamientoInput.equals("si");
    
        System.out.println("¿Tiene Bodega? (Sí/No):");
        String bodegaInput = scanner.nextLine().trim().toLowerCase();
        boolean tieneBodega = bodegaInput.equals("sí") || bodegaInput.equals("si");
    
        Departamento departamento = new Departamento(idDepartamento, direccion, 0, mts2, numHabitaciones, numBanos, piso, tieneEstacionamiento, tieneBodega);
        controller.agregarDepartamentoAComuna(idComuna, departamento);
    
        System.out.println("Departamento añadido con éxito a la comuna.");
    }

    private void añadirTerrenoAComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Ingrese ID del Terreno:");
        int idTerreno = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Ingrese Dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("¿Tiene Servicio de Agua? (Sí/No):");
        String aguaInput = scanner.nextLine().trim().toLowerCase();
        boolean tieneServicioAgua = aguaInput.equals("sí") || aguaInput.equals("si");

        System.out.println("¿Tiene Servicio de Luz? (Sí/No):");
        String luzInput = scanner.nextLine().trim().toLowerCase();
        boolean tieneServicioLuz = luzInput.equals("sí") || luzInput.equals("si");

        System.out.println("¿Tiene Servicio de Gas? (Sí/No):");
        String gasInput = scanner.nextLine().trim().toLowerCase();
        boolean tieneServicioGas = gasInput.equals("sí") || gasInput.equals("si");

        // Creación del objeto Terreno con los parámetros correctos
        Terreno terreno = new Terreno(idTerreno, 0, direccion, mts2, tieneServicioAgua, tieneServicioLuz, tieneServicioGas);

        // Agregar el terreno a la comuna
        controller.agregarTerrenoAComuna(idComuna, terreno);

        System.out.println("Terreno añadido con éxito a la comuna.");
    }

    private void eliminarComuna() {
        System.out.println("Ingrese ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.eliminarComuna(id);
    }

    private void quitarDeComuna() {
        System.out.println("1- Eliminar Casa de Comuna");
        System.out.println("2- Eliminar Departamento de Comuna");
        System.out.println("3- Eliminar Terreno de Comuna");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        switch (opcion) {
            case 1:
                eliminarCasaDeComuna();
                break;
            case 2:
                eliminarDepartamentoDeComuna();
                break;
            case 3:
                eliminarTerrenoDeComuna();
                break;
            default:
                System.out.println("Opción no válida");
        }
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
                    System.out.println("Casa eliminada con éxito.");
                    return;
                }
            }
            System.out.println("Casa no encontrada en la comuna.");
        } else {
            System.out.println("Comuna no encontrada");
        }
    }
    
    private void eliminarDepartamentoDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese ID del Departamento:");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            for (Departamento departamento : comuna.getDepartamentos()) { // Suponiendo que Comuna tiene un método getDepartamentos
                if (departamento.getId() == idDepartamento) {
                    controller.eliminarDepartamentoDeComuna(idComuna, departamento);
                    System.out.println("Departamento eliminado con éxito.");
                    return;
                }
            }
            System.out.println("Departamento no encontrado en la comuna.");
        } else {
            System.out.println("Comuna no encontrada");
        }
    }
    
    private void eliminarTerrenoDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Ingrese ID del Terreno:");
        int idTerreno = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            for (Terreno terreno : comuna.getTerrenos()) { // Suponiendo que Comuna tiene un método getTerrenos
                if (terreno.getId() == idTerreno) {
                    controller.eliminarTerrenoDeComuna(idComuna, terreno);
                    System.out.println("Terreno eliminado con éxito.");
                    return;
                }
            }
            System.out.println("Terreno no encontrado en la comuna.");
        } else {
            System.out.println("Comuna no encontrada");
        }
    }    

    private void actualizarDatos() {
        System.out.println("1- Actualizar Comuna");
        System.out.println("2- Actualizar Casa");
        System.out.println("3- Actualizar Departamento");
        System.out.println("4- Actualizar Terreno");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        switch (opcion) {
            case 1:
                actualizarComuna();
                break;
            case 2:
                actualizarCasa();
                break;
            case 3:
                actualizarDepartamento();
                break;
            case 4:
                actualizarTerreno();
                break;
            default:
                System.out.println("Opción no válida");
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
    
    private void actualizarCasa() {
        System.out.println("Funcionalidad de actualizar casa aún no implementada.");
    }
    
    private void actualizarDepartamento() {
        System.out.println("Funcionalidad de actualizar departamento aún no implementada.");
    }
    
    private void actualizarTerreno() {
        System.out.println("Funcionalidad de actualizar terreno aún no implementada.");
    }    
}