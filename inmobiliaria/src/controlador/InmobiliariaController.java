// InmobiliariaController.java
package controlador;

import modelo.Casa;
import modelo.Comuna;
import modelo.Inmobiliaria;

import java.util.List;

public class InmobiliariaController {
    private Inmobiliaria inmobiliaria;

    public InmobiliariaController(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    public void agregarComuna(int id, String nombre, String clase) {
        Comuna comuna = new Comuna(id, nombre, clase);
        inmobiliaria.agregarComuna(comuna);
    }

    public Comuna obtenerComuna(int id) {
        for (Comuna comuna : inmobiliaria.getComunas()) {
            if (comuna.getId() == id) {
                return comuna;
            }
        }
        return null;
    }

    public void actualizarComuna(int id, String nombre, String clase) {
        Comuna comuna = obtenerComuna(id);
        if (comuna != null) {
            comuna.setNombre(nombre);
            comuna.setClase(clase);
        }
    }

    public void eliminarComuna(int id) {
        Comuna comuna = obtenerComuna(id);
        if (comuna != null) {
            inmobiliaria.eliminarComuna(comuna);
        }
    }

    public void agregarCasaAComuna(int idComuna, Casa casa) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            comuna.agregarCasa(casa);
        }
    }

    public void eliminarCasaDeComuna(int idComuna, Casa casa) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            comuna.eliminarCasa(casa);
        }
    }

    public List<Comuna> obtenerTodasLasComunas() {
        return inmobiliaria.getComunas();
    }
}