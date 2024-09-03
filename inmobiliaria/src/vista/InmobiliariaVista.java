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
            System.out.println("1. Menú Comuna");
            System.out.println("2. Menú Propiedades");
            System.out.println("3. Menú Actualización de Datos");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opción:");
            System.out.println();

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    mostrarMenuComuna();
                    break;
                case 2:
                    mostrarMenuPropiedades();
                    break;
                case 3:
                    mostrarMenuActualizacion();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenuComuna() {
        while (true) {
            System.out.println();
            System.out.println("1. Mostrar Todas las Comunas");
            System.out.println("2. Ver Comuna");
            System.out.println("3. Crear Comuna");
            System.out.println("4. Eliminar Comuna");
            System.out.println("5. Volver al menú principal");
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
                    eliminarComuna();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenuPropiedades() {
        while (true) {
            System.out.println();
            System.out.println("1. Añadir Propiedad a Comuna");
            System.out.println("2. Quitar Propiedad de Comuna");
            System.out.println("3. Volver al menú principal");
            System.out.println("Ingrese una opción:");
            System.out.println();

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
    }

    private void mostrarMenuActualizacion() {
        while (true) {
            System.out.println();
            System.out.println("1. Actualizar Comuna");
            System.out.println("2. Actualizar Casa");
            System.out.println("3. Actualizar Departamento");
            System.out.println("4. Actualizar Terreno");
            System.out.println("5. Volver al menú principal");
            System.out.println("Ingrese una opción:");
            System.out.println();

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
                    System.out.println();
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
        scanner.nextLine();
        System.out.println("Ingrese Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese Clase:");
        String clase = scanner.nextLine();
        controller.agregarComuna(id, nombre, clase);
    }

    private void añadirAComuna() {
        System.out.println("1. Añadir Casa a Comuna");
        System.out.println("2. Añadir Departamento a Comuna");
        System.out.println("3. Añadir Terreno a Comuna");
        int opcion = scanner.nextInt();
        scanner.nextLine();

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
        scanner.nextLine();

        System.out.println("Ingrese ID de la Casa:");
        int idCasa = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese Dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine();

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
        scanner.nextLine();

        Casa casa = new Casa(idCasa, 0, direccion, mts2, numHabitaciones, numBanios, numEstacionamiento, mts2Construidos, tienePatio);
        controller.agregarCasaAComuna(idComuna, casa);

        System.out.println("Casa añadida con éxito a la comuna.");
        System.out.println("Precio asignado: " + (int) casa.getPrecio());
        System.out.println("¿Desea aceptar el precio? (sí/no):");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("no")) {
            System.out.println("Ingrese el nuevo precio:");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            casa.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado: " + casa.getPrecio());
        }
    }

    private void añadirDepartamentoAComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID del Departamento:");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese Dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese Número de Habitaciones:");
        int numHabitaciones = scanner.nextInt();

        System.out.println("Ingrese Número de Baños:");
        int numBanos = scanner.nextInt();

        System.out.println("Ingrese Piso:");
        int piso = scanner.nextInt();
        scanner.nextLine();

        System.out.println("¿Tiene Estacionamiento? (Sí/No):");
        String estacionamientoInput = scanner.nextLine().trim().toLowerCase();
        boolean tieneEstacionamiento = estacionamientoInput.equals("sí") || estacionamientoInput.equals("si");

        System.out.println("¿Tiene Bodega? (Sí/No):");
        String bodegaInput = scanner.nextLine().trim().toLowerCase();
        boolean tieneBodega = bodegaInput.equals("sí") || bodegaInput.equals("si");

        Departamento departamento = new Departamento(idDepartamento, direccion, 0, mts2, numHabitaciones, numBanos, piso, tieneEstacionamiento, tieneBodega);
        controller.agregarDepartamentoAComuna(idComuna, departamento);

        System.out.println("Departamento añadido con éxito a la comuna.");
        System.out.println("Precio asignado: " + departamento.getPrecio());
        System.out.println("¿Desea aceptar el precio? (sí/no):");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("no")) {
            System.out.println("Ingrese el nuevo precio:");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            departamento.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado: " + departamento.getPrecio());
        }
    }


    private void añadirTerrenoAComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID del Terreno:");
        int idTerreno = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese Dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("¿Tiene Servicio de Agua? (true/false):");
        boolean agua = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("¿Tiene Servicio de Luz? (true/false):");
        boolean luz = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("¿Tiene Servicio de Gas? (true/false):");
        boolean gas = scanner.nextBoolean();
        scanner.nextLine();

        Terreno terreno = new Terreno(idTerreno, 0, direccion, mts2, agua, luz, gas);
        controller.agregarTerrenoAComuna(idComuna, terreno);

        System.out.println("Terreno añadido con éxito a la comuna.");
        System.out.println("Precio asignado: " + terreno.getPrecio());
        System.out.println("¿Desea aceptar el precio? (sí/no):");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("no")) {
            System.out.println("Ingrese el nuevo precio:");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            terreno.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado: " + terreno.getPrecio());
        }
    }

    private void quitarDeComuna() {
        System.out.println("1. Quitar Casa de Comuna");
        System.out.println("2. Quitar Departamento de Comuna");
        System.out.println("3. Quitar Terreno de Comuna");
        int opcion = scanner.nextInt();
        scanner.nextLine();

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
        scanner.nextLine();

        System.out.println("Ingrese ID de la Casa:");
        int idCasa = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            Casa casa = comuna.obtenerCasa(idCasa);
            if (casa != null) {
                controller.eliminarCasaDeComuna(idComuna, casa);
                System.out.println("Casa eliminada de la comuna.");
            } else {
                System.out.println("Casa no encontrada en la comuna.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void quitarDepartamentoDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID del Departamento:");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            Departamento departamento = comuna.obtenerDepartamento(idDepartamento);
            if (departamento != null) {
                controller.eliminarDepartamentoDeComuna(idComuna, departamento);
                System.out.println("Departamento eliminado de la comuna.");
            } else {
                System.out.println("Departamento no encontrado en la comuna.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void quitarTerrenoDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID del Terreno:");
        int idTerreno = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            Terreno terreno = comuna.obtenerTerreno(idTerreno);
            if (terreno != null) {
                controller.eliminarTerrenoDeComuna(idComuna, terreno);
                System.out.println("Terreno eliminado de la comuna.");
            } else {
                System.out.println("Terreno no encontrado en la comuna.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void eliminarComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.eliminarComuna(id);
    }

    private void actualizarComuna() {
        System.out.println("Ingrese ID de la Comuna a actualizar:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nuevo Nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese nueva Clase:");
        String clase = scanner.nextLine();

        controller.actualizarComuna(idComuna, nombre, clase);
        System.out.println("Comuna actualizada con éxito.");
    }

    private void actualizarCasa() {
        System.out.println("Ingrese ID de la Comuna de la Casa:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID de la Casa a actualizar:");
        int idCasa = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nueva Dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese nuevos Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese nuevo Número de Habitaciones:");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nuevo Número de Baños:");
        int numBanios = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nuevo Número de Estacionamientos:");
        int numEstacionamiento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nuevos Metros Cuadrados Construidos:");
        int mts2Construidos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("¿Tiene Patio? (true/false):");
        boolean tienePatio = scanner.nextBoolean();
        scanner.nextLine();

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            boolean actualizado = comuna.actualizarCasa(idCasa, direccion, mts2, numHabitaciones, numBanios, numEstacionamiento, mts2Construidos, tienePatio);
            if (actualizado) {
                System.out.println("Casa actualizada con éxito.");
            } else {
                System.out.println("Error al actualizar la casa.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void actualizarDepartamento() {
        System.out.println("Ingrese ID de la Comuna del Departamento:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID del Departamento a actualizar:");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nueva Dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese nuevos Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese nuevo Número de Habitaciones:");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nuevo Número de Baños:");
        int numBanios = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nuevo Piso:");
        int piso = scanner.nextInt();
        scanner.nextLine();

        System.out.println("¿Tiene Estacionamiento? (true/false):");
        boolean tieneEstacionamiento = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("¿Tiene Bodega? (true/false):");
        boolean tieneBodega = scanner.nextBoolean();
        scanner.nextLine();

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            boolean actualizado = comuna.actualizarDepartamento(idDepartamento, direccion, mts2, numHabitaciones, numBanios, piso, tieneEstacionamiento, tieneBodega);
            if (actualizado) {
                System.out.println("Departamento actualizado con éxito.");
            } else {
                System.out.println("Error al actualizar el departamento.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void actualizarTerreno() {
        System.out.println("Ingrese ID de la Comuna del Terreno:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID del Terreno a actualizar:");
        int idTerreno = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nueva Dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese nuevos Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("¿Tiene servicio de Agua? (true/false):");
        boolean agua = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("¿Tiene servicio de Luz? (true/false):");
        boolean luz = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("¿Tiene servicio de Gas? (true/false):");
        boolean gas = scanner.nextBoolean();
        scanner.nextLine();

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            boolean actualizado = comuna.actualizarTerreno(idTerreno, direccion, mts2, agua, luz, gas);
            if (actualizado) {
                System.out.println("Terreno actualizado con éxito.");
            } else {
                System.out.println("Error al actualizar el terreno.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }
}