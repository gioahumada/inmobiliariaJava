package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Clases en carpetas */

public class Inmobiliaria {
    private String nombre;
    private ArrayList<Comuna> comunas;

    /* Constructor */

    public Inmobiliaria() {
        this.nombre = "InmobiliariaJava";
        this.comunas = new ArrayList<>();
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


    /* Metodos */

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

        // Agregar comunas a la lista
        agregarComuna(comuna1);
        agregarComuna(comuna2);

        // Crear algunas casas de prueba
        Casa casa1 = new Casa(1, 1, "Dirección 1", 100, 3, 2, 1, 80, true);
        Casa casa2 = new Casa(2, 1, "Dirección 2", 120, 4, 3, 2, 100, false);

        // Agregar casas a las comunas
        comuna1.agregarCasa(casa1);
        comuna1.agregarCasa(casa2);

        // Crear algunos departamentos de prueba
        Departamento depto1 = new Departamento(3, "Dirección 3", 200, 80, 2, 1, 5, true, true);
        Departamento depto2 = new Departamento(4, "Dirección 4", 250, 90, 3, 2, 10, false, true);

        // Agregar departamentos a las comunas
        comuna2.agregarDepartamento(depto1);
        comuna2.agregarDepartamento(depto2);

        // Crear algunos terrenos de prueba
        Terreno terreno1 = new Terreno(5, 300, "Dirección 5", 500, true, false, false);
        Terreno terreno2 = new Terreno(6, 350,"Dirección 6", 600, false, false, false);

        // Agregar terrenos a las comunas
        comuna1.agregarTerreno(terreno1);
        comuna2.agregarTerreno(terreno2);
    }
}
