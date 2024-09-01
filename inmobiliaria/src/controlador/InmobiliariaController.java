// InmobiliariaController.java
package controlador;

import modelo.Casa;
import modelo.Comuna;
import modelo.Departamento;
import modelo.Inmobiliaria;
import modelo.Terreno;

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

    public void eliminarDepartamentoDeComuna(int idComuna, Departamento departamento) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            comuna.getDepartamentos().remove(departamento);
            System.out.println("Departamento eliminado de la comuna con éxito.");
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    public void eliminarTerrenoDeComuna(int idComuna, Terreno terreno) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            comuna.getTerrenos().remove(terreno);
            System.out.println("Terreno eliminado de la comuna con éxito.");
        } else {
            System.out.println("Comuna no encontrada.");
        }
    }

    public List<Comuna> obtenerTodasLasComunas() {
        return inmobiliaria.getComunas();
    }

    public List<Object> obtenerTodasLasPropiedadesDeComuna(int idComuna) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            return comuna.obtenerTodasLasPropiedades();
        }
        return null;
    }

    public void agregarDepartamentoAComuna(int idComuna, Departamento departamento) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            comuna.agregarDepartamento(departamento);
            System.out.println("Departamento añadido a la comuna con ID " + idComuna);
        } else {
            System.out.println("No se encontró la comuna con ID " + idComuna);
        }
    }    

    public void agregarTerrenoAComuna(int idComuna, Terreno terreno) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            comuna.agregarTerreno(terreno);
            System.out.println("Terreno añadido a la comuna con ID " + idComuna);
        } else {
            System.out.println("No se encontró la comuna con ID " + idComuna);
        }
    }
}