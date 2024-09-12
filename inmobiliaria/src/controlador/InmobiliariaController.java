package controlador;

import modelo.*;

import java.io.IOException;
import java.util.List;

public class InmobiliariaController {
    private Inmobiliaria inmobiliaria;

    public InmobiliariaController(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    /* Persistencia */

    public void guardarTodasLasPropiedadesCSV(String directorio) throws IOException {
        for (Comuna comuna : inmobiliaria.getComunas()) {
            String filePath = directorio + "/comuna_" + comuna.getId() + "_propiedades.csv";
            comuna.guardarPropiedadesCSV(filePath);  // Guardar todas las propiedades de la comuna
        }
    }    

    public void cargarTodasLasPropiedadesCSV(String directorio) throws IOException {
        for (Comuna comuna : inmobiliaria.getComunas()) {
            String filePath = directorio + "/comuna_" + comuna.getId() + "_propiedades.csv";
            comuna.cargarPropiedadesCSV(filePath);  // Cargar todas las propiedades de la comuna
        }
    }
    

    // Comuna

    public List<Comuna> obtenerTodasLasComunas() {
        return inmobiliaria.getComunas();
    }

    /* CRUD */

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

    public List<Object> obtenerTodasLasPropiedadesDeComuna(int idComuna) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            return comuna.obtenerTodasLasPropiedades();
        }
        return null;
    }

    /* Casa */

    public void agregarCasaAComuna(int idComuna, Casa casa) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            casa.setPrecio(precioFinalCasa(comuna,casa));
            System.out.println("El precio para la casa seleccionado por nuestro sistema fue: " + casa.getPrecio());
            comuna.agregarCasa(casa);
        }
    }

    public void eliminarCasaDeComuna(int idComuna, Casa casa) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            comuna.eliminarCasa(casa);
        }
    }

    public int precioFinalCasa(Comuna comuna, Casa casa) {
        double multSector = comuna.calcPrecioAgregadoSector();
        double multCasa = casa.calcPrecioCasa();
        int precioBase = casa.precioMetroCuadrado();

        precioBase += (int) casa.precioMetroCuadradoConstruido(); // Se agrega el precio por metro cuadrado construido

        double factorTotal = 1.0 + multSector + multCasa;

        return (int) (precioBase * factorTotal);
    }

    /* Departamento */

    public void agregarDepartamentoAComuna(int idComuna, Departamento departamento) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            departamento.setPrecio(precioFinalDepartamento(comuna, departamento));
            comuna.agregarDepartamento(departamento);
            System.out.println("Departamento añadido a la comuna con ID " + idComuna);
        } else {
            System.out.println("No se encontró la comuna con ID " + idComuna);
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

    public int precioFinalDepartamento(Comuna comuna, Departamento departamento) {
        double multSector = comuna.calcPrecioAgregadoSector();
        double multDepto = departamento.calcPrecioDepartamento();
        int precioBase = departamento.precioMetroCuadrado() * 4;

        double factorTotal = 1.0 + multSector + multDepto;

        return (int) (precioBase * factorTotal);
    }

    /* Terreno */

    public int precioFinalTerreno(Comuna comuna, Terreno terreno) {
        double multSector = comuna.calcPrecioAgregadoSector();
        double multTerreno = terreno.calcPrecioTerreno();
        int precioBase = terreno.precioMetroCuadrado();

        double factorTotal = 1.0 + multSector + multTerreno;

        return (int)(precioBase * factorTotal);
    }

    public void agregarTerrenoAComuna(int idComuna, Terreno terreno) {
        Comuna comuna = obtenerComuna(idComuna);
        if (comuna != null) {
            terreno.setPrecio(precioFinalTerreno(comuna, terreno));
            comuna.agregarTerreno(terreno);
            System.out.println("Terreno añadido a la comuna con ID " + idComuna);
        } else {
            System.out.println("No se encontró la comuna con ID " + idComuna);
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

    /* Usuario */

    public Usuario obtenerUsuario(String nombreUsuario) {
        return inmobiliaria.obtenerUsuario(nombreUsuario);
    }

}