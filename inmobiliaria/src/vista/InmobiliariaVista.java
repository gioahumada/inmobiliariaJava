package vista;

import controlador.InmobiliariaController;
import modelo.*;

import java.util.List;
import java.util.Scanner;

public class InmobiliariaVista {
    private InmobiliariaController controller;
    private Scanner scanner;

    /* Colores para la consola -> Constantes */
    private static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String WHITE = "\u001B[37m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String ORANGE = "\u001B[38;5;214m";
    public static final String ORANGEBG = "\u001B[48;5;214m";

    public InmobiliariaVista(InmobiliariaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        mostrarMenuLogin(); // Llamar al método de login antes de mostrar el menú principal
    }

    private void mostrarMenuLogin() {
        limpiarPantalla();

        /* Muestra el logo */
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(BOLD + "  ___                _    _ _ _          _           _               \n" +
                " |_ _|_ _  _ __  ___| |__(_) (_)__ _ _ _(_)__ _   _ | |__ ___ ____ _ \n" +
                "  | || ' \\| '  \\/ _ \\ '_ \\ | | / _` | '_| / _` | | || / _` \\ V / _` |\n" +
                " |___|_||_|_|_|_\\___/_.__/_|_|_\\__,_|_| |_\\__,_|  \\__/\\__,_|\\_/\\__,_|\n" +
                "                                                                     " + RESET);
        System.out.println("--------------------------------------------------------- v.0.1b ------\n");
        pause();
        limpiarPantalla();

        System.out.println(GREEN_BG + "=== Sistema de Inicio de Sesión ===" + RESET + "\n");
        System.out.println("¿Desea iniciar sesión o continuar como invitado?");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Continuar como invitado");
        System.out.println(ORANGE + "\nIngrese una opción:" + RESET);
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        if (opcion == 1) {
            limpiarPantalla();
            System.out.println(ORANGEBG + WHITE + "=== Inicio de Sesión ===" + RESET + "\n");
            System.out.println();
            System.out.println("Ingrese su nombre de usuario:");
            String nombreUsuario = scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contraseña = scanner.nextLine();

            Usuario usuario = controller.obtenerUsuario(nombreUsuario);
            if (usuario != null && usuario.getHashContraseña().equals(contraseña)) {
                if (usuario.isEsAdministrador()) {
                    limpiarPantalla();
                    System.out.println(GREEN + "Bienvenido Administrador " + RESET + BOLD + nombreUsuario + RESET);
                    pause();
                    mostrarMenuAdministrador(); // Mostrar menú existente para administradores
                } else {
                    limpiarPantalla();
                    System.out.println(GREEN + "Bienvenido Invitado " + RESET + BOLD + nombreUsuario + RESET);
                    pause();
                    mostrarMenuInvitado(); // Mostrar menú limitado para invitados
                }
            } else {
                System.out.println(RED + "Usuario o contraseña incorrectos. \n" + RESET);
                System.out.println(YELLOW + "(ℹ) Las credenciales están en el archivo Inmobiliaria.java" + RESET);
                pause();
                System.exit(0); // Salir del sistema si las credenciales son incorrectas
            }
        } else if (opcion == 2) {
            limpiarPantalla();
            System.out.println(GREEN + "Continuando como invitado..." + RESET );
            pause();
            mostrarMenuInvitado(); // Mostrar menú limitado para invitados
        } else {
            limpiarPantalla();
            System.out.println(RED + "Opción no válida" + RESET);
            pause();
            System.exit(0); // Salir del sistema si la opción es inválida
        }
    }

    private void mostrarMenuInvitado() {
        while (true) {
            System.out.println();
            System.out.println(GREEN_BG + "=== InmobiliariaJava - Invitado ===" + RESET + "\n");
            System.out.println("1. Mostrar Todas las Comunas");
            System.out.println("2. Ver Comuna");
            System.out.println("3. Salir");
            System.out.println(ORANGE + "\nIngrese una opción:" + RESET);
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
                    return;
                default:
                    System.out.println(RED + "Opción no válida" + RESET);
            }
        }
    }

    public void mostrarMenuAdministrador() {
        while (true) {
            limpiarPantalla();
            System.out.println();
            System.out.println(GREEN_BG + "=== InmobiliariaJava - Administrador ===" + RESET + "\n");
            System.out.println("1. Menú Comuna");
            System.out.println("2. Menú Propiedades");
            System.out.println("3. Menú Actualización de Datos");
            System.out.println("4. Salir");
            System.out.println(ORANGE + "\nIngrese una opción:" + RESET);
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
            limpiarPantalla();
            System.out.println(ORANGEBG + WHITE + "=== Menú Comuna ===" + RESET + "\n");
            System.out.println("1. Mostrar Todas las Comunas");
            System.out.println("2. Ver Comuna");
            System.out.println("3. Crear Comuna");
            System.out.println("4. Eliminar Comuna");
            System.out.println("5. Volver al menú principal");
            System.out.println(ORANGE + "\nIngrese una opción:" + RESET);
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
            limpiarPantalla();
            System.out.println(ORANGEBG + WHITE + "=== Menú Propiedades ===" + RESET + "\n");
            System.out.println("1. Añadir Propiedad a Comuna");
            System.out.println("2. Quitar Propiedad de Comuna");
            System.out.println("3. Volver al menú principal");
            System.out.println(ORANGE + "\nIngrese una opción:" + RESET);
            System.out.println();

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    addAComuna();
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
            limpiarPantalla();
            System.out.println(ORANGEBG + WHITE + "=== Menú Actualización de Datos ===" + RESET + "\n");
            System.out.println("1. Actualizar Comuna");
            System.out.println("2. Actualizar Casa");
            System.out.println("3. Actualizar Departamento");
            System.out.println("4. Actualizar Terreno");
            System.out.println("5. Volver al menú principal");
            System.out.println(ORANGE + "\nIngrese una opción:" + RESET);
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
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    /* Gracias a StackOverFlow */
    public void pause() {
        System.out.println(GREEN + "\nPresione Enter para continuar..." + RESET);
        scanner.nextLine();
        limpiarPantalla();
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
        pause();
    }

    private void verComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = controller.obtenerComuna(idComuna);
        if (comuna != null) {
            System.out.println(comuna.toString());

            System.out.println();

            List<Object> propiedades = comuna.obtenerTodasLasPropiedades();
            if (!propiedades.isEmpty()) {
                System.out.println(GREEN + "Propiedades en la Comuna: " + RESET + "\n");
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
        pause();
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
        pause();
    }

    private void addAComuna() {
        System.out.println("1. Añadir Casa a Comuna");
        System.out.println("2. Añadir Departamento a Comuna");
        System.out.println("3. Añadir Terreno a Comuna");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                addCasaAComuna();
                break;
            case 2:
                addDepartamentoAComuna();
                break;
            case 3:
                addTerrenoAComuna();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void addCasaAComuna() {
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
        System.out.println("Precio asignado: " + casa.getPrecioFormat());
        System.out.println("¿Desea aceptar el precio? (sí/no):");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("no")) {
            System.out.println("Ingrese el nuevo precio:");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            casa.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado: " + casa.getPrecioFormat());
        }

        pause();
    }

    private void addDepartamentoAComuna() {
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

        Departamento departamento = new Departamento(idDepartamento, 0, direccion, mts2, numHabitaciones, numBanos, piso, tieneEstacionamiento, tieneBodega);
        controller.agregarDepartamentoAComuna(idComuna, departamento);

        System.out.println("Departamento añadido con éxito a la comuna.");
        System.out.println("Precio asignado: " + departamento.getPrecioFormat());
        System.out.println("¿Desea aceptar el precio? (sí/no):");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("no")) {
            System.out.println("Ingrese el nuevo precio:");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            departamento.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado: " + departamento.getPrecioFormat());
        }
        pause();
    }


    private void addTerrenoAComuna() {
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
        System.out.println("Precio asignado: " + terreno.getPrecioFormat());
        System.out.println("¿Desea aceptar el precio? (sí/no):");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("no")) {
            System.out.println("Ingrese el nuevo precio:");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            terreno.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado: " + terreno.getPrecioFormat());
        }

        pause();
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
        pause();
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

        pause();
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

        pause();
    }

    private void eliminarComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int id = scanner.nextInt();
        scanner.nextLine();
        controller.eliminarComuna(id);
        pause();
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

        pause();
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

        pause();
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

        pause();
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
        pause();
    }
}