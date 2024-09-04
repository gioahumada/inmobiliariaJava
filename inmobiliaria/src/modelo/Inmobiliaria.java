package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Inmobiliaria {
    private String nombre;
    private ArrayList<Comuna> comunas;
    private HashMap<String, Usuario> usuarios;

    /* Constructor */

    public Inmobiliaria() {
        this.nombre = "InmobiliariaJava";
        this.comunas = new ArrayList<>();
        this.usuarios = new HashMap<>();
    }

    /* Setters & Getters */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Comuna> getComunas() {
        return comunas;
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    /* Metodos */

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombreUsuario(), usuario);
    }

    public Usuario obtenerUsuario(String nombreUsuario) {
        return usuarios.get(nombreUsuario);
    }

    public boolean esUsuarioAdministrador(String nombreUsuario) {
        Usuario usuario = obtenerUsuario(nombreUsuario);
        return usuario != null && usuario.isEsAdministrador();
    }

    public void agregarComuna(Comuna comuna) {
        comunas.add(comuna);
    }

    public void eliminarComuna(Comuna comuna) {
        comunas.remove(comuna);
    }

    /* Inicializador casos de prueba */

    public void inicializarDatosDePrueba() {
        // Crear algunas comunas de prueba
        Comuna comuna1 = new Comuna(1, "Las Condes", "A");
        Comuna comuna2 = new Comuna(2, "Quilpué", "B");
        Comuna comuna3 = new Comuna(3, "Providencia", "A");
        Comuna comuna4 = new Comuna(4, "Viña del Mar", "A");
        Comuna comuna5 = new Comuna(5, "Santiago Centro", "A");

        // Agregar comunas a la lista
        agregarComuna(comuna1);
        agregarComuna(comuna2);
        agregarComuna(comuna3);
        agregarComuna(comuna4);
        agregarComuna(comuna5);

        // Crear algunas casas de prueba
        Casa casa1 = new Casa(1, 130000000, "Av. Las Condes 12345", 100, 3, 2, 1, 80, true);
        Casa casa2 = new Casa(2, 102000000, "Camino El Alba 54321", 120, 4, 3, 2, 100, false);
        Casa casa3 = new Casa(3, 160000000, "Av. Providencia 6789", 150, 5, 4, 2, 120, true);
        Casa casa4 = new Casa(4, 109000000, "Los Leones 1234", 110, 3, 2, 1, 90, false);
        Casa casa5 = new Casa(5, 194000000, "Av. Libertador Bernardo O'Higgins 123", 200, 6, 4, 3, 150, true);

        // Agregar casas a las comunas
        comuna1.agregarCasa(casa1);
        comuna1.agregarCasa(casa2);
        comuna3.agregarCasa(casa3);
        comuna3.agregarCasa(casa4);
        comuna5.agregarCasa(casa5);

        // Crear algunos departamentos de prueba
        Departamento depto1 = new Departamento(6, 104000000, "Av. Los Carrera 4567", 80, 2, 1, 5, true, true);
        Departamento depto2 = new Departamento(7, 96000000, "Av. Quilpué 9876", 90, 3, 2, 10, false, true);
        Departamento depto3 = new Departamento(8, 78000000, "Calle Valparaíso 123", 70, 2, 1, 8, true, false);
        Departamento depto4 = new Departamento(9, 11000000, "Calle Libertad 456", 85, 3, 2, 12, false, true);
        Departamento depto5 = new Departamento(10,13900000,"Calle Estado 789", 95, 3, 2, 15, true, false);

        // Agregar departamentos a las comunas
        comuna2.agregarDepartamento(depto1);
        comuna2.agregarDepartamento(depto2);
        comuna4.agregarDepartamento(depto3);
        comuna4.agregarDepartamento(depto4);
        comuna5.agregarDepartamento(depto5);

        // Crear algunos terrenos de prueba
        Terreno terreno1 = new Terreno(11, 35000000, "Camino La Viña 1234", 500, true, false, false);
        Terreno terreno2 = new Terreno(12, 4700000, "Calle Villanelo 5678", 600, false, false, false);
        Terreno terreno3 = new Terreno(13, 2100000, "Av. Matta 910", 550, true, true, false);
        Terreno terreno4 = new Terreno(14, 3400000, "Calle Vicuña Mackenna 1234", 700, false, true, false);
        Terreno terreno5 = new Terreno(15, 54000000, "Av. Recoleta 4321", 800, true, false, true);

        // Agregar terrenos a las comunas
        comuna1.agregarTerreno(terreno1);
        comuna2.agregarTerreno(terreno2);
        comuna3.agregarTerreno(terreno3);
        comuna4.agregarTerreno(terreno4);
        comuna5.agregarTerreno(terreno5);

        /* Agregar Usuario */

        this.agregarUsuario(new Usuario("admin", "admin", true));
        this.agregarUsuario(new Usuario("invitado", "invitado", false));
        this.agregarUsuario(new Usuario("bastiivc", "bizcocho121", true));
        this.agregarUsuario(new Usuario("gioahumada", "bizcocho121", true));
        this.agregarUsuario(new Usuario("pytricio", "bizcocho121", true));
        this.agregarUsuario(new Usuario("21.368.487-6", "bizcocho121", true));
        this.agregarUsuario(new Usuario("123", "123", false));
        this.agregarUsuario(new Usuario("RafaelMellado", "HWKW17", true));
        this.agregarUsuario(new Usuario("IvanMercado", "SOPRAVAL", true));
        this.agregarUsuario(new Usuario("ClaudioCubillos", "JSXY60", true));
        this.agregarUsuario(new Usuario("Nachetao", "SKIBIDI", false));
        this.agregarUsuario(new Usuario("SimonVera", "hashish", false));
    }
}