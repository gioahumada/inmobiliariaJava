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
            System.out.println("Seleccione una opción:");
            System.out.println("1. Gestionar Comunas");
            System.out.println("2. Gestionar Propiedades");
            System.out.println("3. Actualizar Datos");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opción:");
            System.out.println();

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    menuGestionComunas();
                    break;
                case 2:
                    menuGestionPropiedades();
                    break;
                case 3:
                    menuActualizarDatos();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void menuGestionComunas() {
        System.out.println("=== Gestión de Comunas ===");
        System.out.println("1. Mostrar Todas las Comunas");
        System.out.println("2. Ver Comuna");
        System.out.println("3. Crear Comuna");
        System.out.println("4. Eliminar Comuna");
        System.out.println("5. Volver al Menú Principal");
        System.out.println("Ingrese una opción:");

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
                eliminarComuna();
                break;
            case 5:
                return;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void menuGestionPropiedades() {
        System.out.println("=== Gestión de Propiedades ===");
        System.out.println("1. Añadir Propiedad a Comuna");
        System.out.println("2. Quitar Propiedad de Comuna");
        System.out.println("3. Volver al Menú Principal");
        System.out.println("Ingrese una opción:");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        switch (opcion) {
            case 1:
                limpiarPantalla();
                añadirAComuna();
                break;
            case 2:
                limpiarPantalla();
                quitarDeComuna();
                break;
            case 3:
                return;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void menuActualizarDatos() {
        System.out.println("=== Actualización de Datos ===");
        System.out.println("1. Actualizar Comuna");
        System.out.println("2. Actualizar Casa");
        System.out.println("3. Actualizar Departamento");
        System.out.println("4. Actualizar Terreno");
        System.out.println("5. Volver al Menú Principal");
        System.out.println("Ingrese una opción:");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        switch (opcion) {
            case 1:
                limpiarPantalla();
                actualizarComuna();
                break;
            case 2:
                limpiarPantalla();
                actualizarCasa();
                break;
            case 3:
                limpiarPantalla();
                actualizarDepartamento();
                break;
            case 4:
                limpiarPantalla();
                actualizarTerreno();
                break;
            case 5:
                return;
            default:
                System.out.println("Opción no válida");
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
            System.out.println(comuna.toString());
    
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
    
        Departamento departamento = new Departamento(idDepartamento, 0, direccion, mts2, numHabitaciones, numBanos, piso, tieneEstacionamiento, tieneBodega);
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
    
        System.out.println("Ingrese Valor Fiscal:");
        double valorFiscal = scanner.nextDouble();
    
        Terreno terreno = new Terreno(idTerreno, 0, direccion, mts2, valorFiscal);
        controller.agregarTerrenoAComuna(idComuna, terreno);
    
        System.out.println("Terreno añadido con éxito a la comuna.");
    }

    private void quitarDeComuna() {
        System.out.println("1- Quitar Casa de Comuna");
        System.out.println("2- Quitar Departamento de Comuna");
        System.out.println("3- Quitar Terreno de Comuna");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (opcion) {
            case 1:
                quitarCasaDeComuna();
                break;
            case 2:
                quitarDepartamentoDeComuna();
                break;
            case 3:
                quitarTerrenoDeComuna();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void quitarCasaDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese ID de la Casa:");
        int idCasa = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        controller.eliminarCasaDeComuna(idComuna, idCasa);
    
        System.out.println("Casa eliminada con éxito de la comuna.");
    }
    
    private void quitarDepartamentoDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese ID del Departamento:");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        controller.eliminarDepartamentoDeComuna(idComuna, idDepartamento);
    
        System.out.println("Departamento eliminado con éxito de la comuna.");
    }
    
    private void quitarTerrenoDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese ID del Terreno:");
        int idTerreno = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        controller.eliminarTerrenoDeComuna(idComuna, idTerreno);
    
        System.out.println("Terreno eliminado con éxito de la comuna.");
    }

    private void actualizarComuna() {
        System.out.println("Ingrese ID de la Comuna a Actualizar:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna == null) {
            System.out.println("Comuna no encontrada");
            return;
        }
    
        System.out.println("Ingrese Nuevo Nombre:");
        String nuevoNombre = scanner.nextLine();
    
        System.out.println("Ingrese Nueva Clase:");
        String nuevaClase = scanner.nextLine();
    
        comuna.setNombre(nuevoNombre);
        comuna.setClase(nuevaClase);
    
        System.out.println("Comuna actualizada con éxito.");
    }
    
    private void actualizarCasa() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese ID de la Casa a Actualizar:");
        int idCasa = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        Casa casa = controller.obtenerCasaDeComuna(idComuna, idCasa);
        if (casa == null) {
            System.out.println("Casa no encontrada");
            return;
        }
    
        System.out.println("Ingrese Nueva Dirección:");
        String nuevaDireccion = scanner.nextLine();
    
        System.out.println("Ingrese Nuevos Metros Cuadrados:");
        double nuevosMts2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese Nuevo Número de Habitaciones:");
        int nuevoNumHabitaciones = scanner.nextInt();
    
        System.out.println("Ingrese Nuevo Número de Baños:");
        int nuevoNumBanios = scanner.nextInt();
    
        System.out.println("Ingrese Nuevo Número de Estacionamientos:");
        int nuevoNumEstacionamiento = scanner.nextInt();
    
        System.out.println("Ingrese Nuevos Metros Cuadrados Construidos:");
        int nuevosMts2Construidos = scanner.nextInt();
    
        System.out.println("¿Tiene Patio? (true/false):");
        boolean nuevoTienePatio = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
    
        casa.setDireccion(nuevaDireccion);
        casa.setMts2(nuevosMts2);
        casa.setNumHabitaciones(nuevoNumHabitaciones);
        casa.setNumBanios(nuevoNumBanios);
        casa.setNumEstacionamiento(nuevoNumEstacionamiento);
        casa.setMts2Construidos(nuevosMts2Construidos);
        casa.setTienePatio(nuevoTienePatio);
    
        System.out.println("Casa actualizada con éxito.");
    }
    
    private void actualizarDepartamento() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese ID del Departamento a Actualizar:");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        Departamento departamento = controller.obtenerDepartamentoDeComuna(idComuna, idDepartamento);
        if (departamento == null) {
            System.out.println("Departamento no encontrado");
            return;
        }
    
        System.out.println("Ingrese Nueva Dirección:");
        String nuevaDireccion = scanner.nextLine();
    
        System.out.println("Ingrese Nuevos Metros Cuadrados:");
        double nuevosMts2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese Nuevo Número de Habitaciones:");
        int nuevoNumHabitaciones = scanner.nextInt();
    
        System.out.println("Ingrese Nuevo Número de Baños:");
        int nuevoNumBanios = scanner.nextInt();
    
        System.out.println("Ingrese Nuevo Piso:");
        int nuevoPiso = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("¿Tiene Estacionamiento? (true/false):");
        boolean nuevoTieneEstacionamiento = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
    
        System.out.println("¿Tiene Bodega? (true/false):");
        boolean nuevoTieneBodega = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
    
        departamento.setDireccion(nuevaDireccion);
        departamento.setMts2(nuevosMts2);
        departamento.setNumHabitaciones(nuevoNumHabitaciones);
        departamento.setNumBanios(nuevoNumBanios);
        departamento.setPiso(nuevoPiso);
        departamento.setTieneEstacionamiento(nuevoTieneEstacionamiento);
        departamento.setTieneBodega(nuevoTieneBodega);
    
        System.out.println("Departamento actualizado con éxito.");
    }
    
    private void actualizarTerreno() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese ID del Terreno a Actualizar:");
        int idTerreno = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        Terreno terreno = controller.obtenerTerrenoDeComuna(idComuna, idTerreno);
        if (terreno == null) {
            System.out.println("Terreno no encontrado");
            return;
        }
    
        System.out.println("Ingrese Nueva Dirección:");
        String nuevaDireccion = scanner.nextLine();
    
        System.out.println("Ingrese Nuevos Metros Cuadrados:");
        double nuevosMts2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
    
        System.out.println("Ingrese Nuevo Valor Fiscal:");
        double nuevoValorFiscal = scanner.nextDouble();
    
        terreno.setDireccion(nuevaDireccion);
        terreno.setMts2(nuevosMts2);
        terreno.setValorFiscal(nuevoValorFiscal);
    
        System.out.println("Terreno actualizado con éxito.");
    }

    private void eliminarComuna() {
        System.out.println("Ingrese ID de la Comuna a Eliminar:");
        int id = scanner.nextInt();
        controller.eliminarComuna(id);
    }
}
