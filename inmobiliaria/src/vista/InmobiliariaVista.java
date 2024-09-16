package vista;

import modelo.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InmobiliariaVista {
    private Inmobiliaria inmobiliaria; // Ahora usamos directamente Inmobiliaria
    private Scanner scanner;

    public InmobiliariaVista(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        mostrarMenuLogin();
    }

    private void mostrarMenuLogin() {
        limpiarPantalla();
        System.out.println("=== Sistema de Inicio de Sesión ===");
        System.out.println("¿Desea iniciar sesión o continuar como invitado?");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Continuar como invitado");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        if (opcion == 1) {
            iniciarSesion();
        } else if (opcion == 2) {
            mostrarMenuInvitado();
        } else {
            System.out.println("Opción no válida");
            System.exit(0);
        }
    }

    private void iniciarSesion() {
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();

        Usuario usuario = inmobiliaria.obtenerUsuario(nombreUsuario);
        if (usuario != null && usuario.verificarContraseña(contraseña)) {
            if (usuario.isEsAdministrador()) {
                mostrarMenuAdministrador();
            } else {
                mostrarMenuInvitado();
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
            System.exit(0);
        }
    }

    private void mostrarMenuInvitado() {
        while (true) {
            System.out.println("=== Inmobiliaria - Invitado ===");
            System.out.println("1. Mostrar Todas las Comunas");
            System.out.println("2. Ver Comuna");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    mostrarTodasLasComunas();
                    break;
                case 2:
                    verComuna();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public void mostrarMenuAdministrador() {
        while (true) {
            System.out.println("=== Inmobiliaria - Administrador ===");
            System.out.println("1. Menú Comuna");
            System.out.println("2. Menú Propiedades");
            System.out.println("3. Menú Actualización de Datos");
            System.out.println("4. Salir");
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
            System.out.println("=== Menú Comuna ===");
            System.out.println("1. Mostrar Todas las Comunas");
            System.out.println("2. Ver Comuna");
            System.out.println("3. Crear Comuna");
            System.out.println("4. Eliminar Comuna");
            System.out.println("5. Volver al menú principal");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    mostrarTodasLasComunas();
                    break;
                case 2:
                    verComuna();
                    break;
                case 3:
                    crearComuna();
                    break;
                case 4:
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
            System.out.println("=== Menú Propiedades ===");
            System.out.println("1. Añadir Propiedad a Comuna");
            System.out.println("2. Quitar Propiedad de Comuna");
            System.out.println("3. Volver al menú principal");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    addAComuna();
                    break;
                case 2:
                    quitarDeComuna();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void addAComuna() {
        System.out.println("1. Añadir Casa a Comuna");
        System.out.println("2. Añadir Departamento a Comuna");
        System.out.println("3. Añadir Terreno a Comuna");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = inmobiliaria.buscarComunaPorId(idComuna);

        if (comuna != null) {
            switch (opcion) {
                case 1:
                    agregarCasaAComuna(comuna);
                    break;
                case 2:
                    agregarDepartamentoAComuna(comuna);
                    break;
                case 3:
                    agregarTerrenoAComuna(comuna);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void quitarDeComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = inmobiliaria.buscarComunaPorId(idComuna);

        if (comuna != null) {
            System.out.println("Seleccione el tipo de propiedad a quitar:");
            System.out.println("1. Casa");
            System.out.println("2. Departamento");
            System.out.println("3. Terreno");
            int tipoPropiedad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese ID de la propiedad:");
            int idPropiedad = scanner.nextInt();
            scanner.nextLine();

            switch (tipoPropiedad) {
                case 1:
                    comuna.eliminarCasa(idPropiedad);
                    System.out.println("Casa quitada de la comuna.");
                    break;
                case 2:
                    comuna.eliminarDepartamento(idPropiedad);
                    System.out.println("Departamento quitado de la comuna.");
                    break;
                case 3:
                    comuna.eliminarTerreno(idPropiedad);
                    System.out.println("Terreno quitado de la comuna.");
                    break;
                default:
                    System.out.println("Tipo de propiedad no válido.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void mostrarMenuActualizacion() {
        while (true) {
            System.out.println("=== Menú Actualización de Datos ===");
            System.out.println("1. Actualizar Comuna");
            System.out.println("2. Actualizar Casa");
            System.out.println("3. Actualizar Departamento");
            System.out.println("4. Actualizar Terreno");
            System.out.println("5. Volver al menú principal");
            int opcion = scanner.nextInt();
            scanner.nextLine();

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
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarTodasLasComunas() {
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();
        for (Comuna comuna : comunas) {
            System.out.println(comuna.toString());
        }
    }

    private void verComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = inmobiliaria.buscarComunaPorId(idComuna);
        if (comuna != null) {
            System.out.println(comuna.toString());
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
        inmobiliaria.agregarComuna(id, nombre, clase);
    }

    private void eliminarComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int id = scanner.nextInt();
        scanner.nextLine();
        inmobiliaria.eliminarComunaPorId(id);
    }

    private void limpiarPantalla() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    /* Agregar */

    private void agregarCasaAComuna(Comuna comuna) {
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

        Casa casa = new Casa(idCasa, 0, direccion, mts2, numHabitaciones, numBanios, numEstacionamiento, mts2Construidos, tienePatio);
        long precio = comuna.precioFinalCasa(comuna, casa); // Calcula el precio automáticamente
        casa.setPrecio(precio);
        comuna.agregarCasa(casa);


        System.out.println("Casa añadida a la comuna.");
    }

    private void agregarDepartamentoAComuna(Comuna comuna) {
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
        int numBanios = scanner.nextInt();

        System.out.println("Ingrese Piso:");
        int piso = scanner.nextInt();

        System.out.println("¿Tiene Estacionamiento? (true/false):");
        boolean tieneEstacionamiento = scanner.nextBoolean();

        System.out.println("¿Tiene Bodega? (true/false):");
        boolean tieneBodega = scanner.nextBoolean();

        Departamento departamento = new Departamento(idDepartamento, 0, direccion, mts2, numHabitaciones, numBanios, piso, tieneEstacionamiento, tieneBodega);
        int precio = comuna.precioFinalDepartamento(comuna, departamento); // Calcula el precio automáticamente
        departamento.setPrecio(precio);
        comuna.agregarDepartamento(departamento);
        System.out.println("Departamento añadido a la comuna.");
    }

    private void agregarTerrenoAComuna(Comuna comuna) {
        System.out.println("Ingrese ID del Terreno:");
        int idTerreno = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese Dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese Metros Cuadrados:");
        double mts2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("¿Tiene Agua? (true/false):");
        boolean tieneAgua = scanner.nextBoolean();

        System.out.println("¿Tiene Luz? (true/false):");
        boolean tieneLuz = scanner.nextBoolean();

        System.out.println("¿Tiene Gas? (true/false):");
        boolean tieneGas = scanner.nextBoolean();

        Terreno terreno = new Terreno(idTerreno, 0, direccion, mts2, tieneAgua, tieneLuz, tieneGas);
        int precio = comuna.precioFinalTerreno(comuna, terreno); // Calcula el precio automáticamente
        terreno.setPrecio(precio);
        comuna.agregarTerreno(terreno);
        System.out.println("Terreno añadido a la comuna.");
    }

    /* Actualizar */

    private void actualizarComuna() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = inmobiliaria.buscarComunaPorId(idComuna);
        if (comuna != null) {
            System.out.println("Ingrese nuevo Nombre de la Comuna:");
            String nuevoNombre = scanner.nextLine();
            comuna.setNombre(nuevoNombre);

            System.out.println("Ingrese nueva Clase de la Comuna:");
            String nuevaClase = scanner.nextLine();
            comuna.setClase(nuevaClase);

            System.out.println("Comuna actualizada correctamente.");
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void actualizarCasa() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = inmobiliaria.buscarComunaPorId(idComuna);
        if (comuna != null) {
            System.out.println("Ingrese ID de la Casa:");
            int idCasa = scanner.nextInt();
            scanner.nextLine();

            Casa casa = comuna.obtenerCasa(idCasa);
            if (casa != null) {
                System.out.println("Ingrese nueva Dirección:");
                String direccion = scanner.nextLine();
                casa.setDireccion(direccion);

                System.out.println("Ingrese nuevos Metros Cuadrados:");
                double mts2 = scanner.nextDouble();
                scanner.nextLine();
                casa.setMts2(mts2);

                System.out.println("Ingrese nuevo Número de Habitaciones:");
                int numHabitaciones = scanner.nextInt();
                casa.setNumHabitaciones(numHabitaciones);

                System.out.println("Ingrese nuevo Número de Baños:");
                int numBanios = scanner.nextInt();
                casa.setNumBanios(numBanios);

                System.out.println("Ingrese nuevo Número de Estacionamientos:");
                int numEstacionamiento = scanner.nextInt();
                casa.setNumEstacionamiento(numEstacionamiento);

                System.out.println("Ingrese nuevos Metros Cuadrados Construidos:");
                int mts2Construidos = scanner.nextInt();
                casa.setMts2Construidos(mts2Construidos);

                System.out.println("¿Tiene Patio? (true/false):");
                boolean tienePatio = scanner.nextBoolean();
                casa.setTienePatio(tienePatio);

                System.out.println("Casa actualizada correctamente.");
            } else {
                System.out.println("Casa no encontrada.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void actualizarDepartamento() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = inmobiliaria.buscarComunaPorId(idComuna);
        if (comuna != null) {
            System.out.println("Ingrese ID del Departamento:");
            int idDepartamento = scanner.nextInt();
            scanner.nextLine();

            Departamento departamento = comuna.obtenerDepartamento(idDepartamento);
            if (departamento != null) {
                System.out.println("Ingrese nueva Dirección:");
                String direccion = scanner.nextLine();
                departamento.setDireccion(direccion);

                System.out.println("Ingrese nuevos Metros Cuadrados:");
                double mts2 = scanner.nextDouble();
                scanner.nextLine();
                departamento.setMts2(mts2);

                System.out.println("Ingrese nuevo Número de Habitaciones:");
                int numHabitaciones = scanner.nextInt();
                departamento.setNumHabitaciones(numHabitaciones);

                System.out.println("Ingrese nuevo Número de Baños:");
                int numBanios = scanner.nextInt();
                departamento.setNumBanos(numBanios);

                System.out.println("Ingrese nuevo Piso:");
                int piso = scanner.nextInt();
                departamento.setPiso(piso);

                System.out.println("¿Tiene Estacionamiento? (true/false):");
                boolean tieneEstacionamiento = scanner.nextBoolean();
                departamento.setTieneEstacionamiento(tieneEstacionamiento);

                System.out.println("¿Tiene Bodega? (true/false):");
                boolean tieneBodega = scanner.nextBoolean();
                departamento.setTieneBodega(tieneBodega);

                System.out.println("Departamento actualizado correctamente.");
            } else {
                System.out.println("Departamento no encontrado.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    private void actualizarTerreno() {
        System.out.println("Ingrese ID de la Comuna:");
        int idComuna = scanner.nextInt();
        scanner.nextLine();

        Comuna comuna = inmobiliaria.buscarComunaPorId(idComuna);
        if (comuna != null) {
            System.out.println("Ingrese ID del Terreno:");
            int idTerreno = scanner.nextInt();
            scanner.nextLine();

            Terreno terreno = comuna.obtenerTerreno(idTerreno);
            if (terreno != null) {
                System.out.println("Ingrese nueva Dirección:");
                String direccion = scanner.nextLine();
                terreno.setDireccion(direccion);

                System.out.println("Ingrese nuevos Metros Cuadrados:");
                double mts2 = scanner.nextDouble();
                scanner.nextLine();
                terreno.setMts2(mts2);

                System.out.println("¿Tiene Agua? (true/false):");
                boolean tieneAgua = scanner.nextBoolean();
                terreno.setTieneServicioAgua(tieneAgua);

                System.out.println("¿Tiene Luz? (true/false):");
                boolean tieneLuz = scanner.nextBoolean();
                terreno.setTieneServicioLuz(tieneLuz);

                System.out.println("¿Tiene Gas? (true/false):");
                boolean tieneGas = scanner.nextBoolean();
                terreno.setTieneServicioGas(tieneGas);

                System.out.println("Terreno actualizado correctamente.");
            } else {
                System.out.println("Terreno no encontrado.");
            }
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

}
