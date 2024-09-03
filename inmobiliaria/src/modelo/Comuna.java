package modelo;

import java.util.ArrayList;
import java.util.List;

public class Comuna {
    private int id;
    private String nombre;
    private String clase;
    private ArrayList<Departamento> departamentos;
    private ArrayList<Terreno> terrenos;
    private ArrayList<Casa> casas;

    public Comuna(int id, String nombre, String clase) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.departamentos = new ArrayList<>();
        this.terrenos = new ArrayList<>();
        this.casas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    /* Metodos */

    // Departamento

    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void eliminarDepartamento(Departamento departamento) {
        departamentos.remove(departamento);
    }

    public Departamento obtenerDepartamento(int idDepartamento) {
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == idDepartamento) {
                return departamento;
            }
        }
        return null;
    }

    public boolean actualizarDepartamento(int idDepartamento, String direccion, double mts2, int numHabitaciones, int numBanios, int piso, boolean tieneEstacionamiento, boolean tieneBodega) {
        Departamento departamento = obtenerDepartamento(idDepartamento);
        if (departamento != null) {
            departamento.setDireccion(direccion);
            departamento.setMts2(mts2);
            departamento.setNumHabitaciones(numHabitaciones);
            departamento.setNumBanos(numBanios);
            departamento.setPiso(piso);
            departamento.setTieneEstacionamiento(tieneEstacionamiento);
            departamento.setTieneBodega(tieneBodega);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    // Terreno

    public void agregarTerreno(Terreno terreno) {
        terrenos.add(terreno);
    }

    public void eliminarTerreno(Terreno terreno) {
        terrenos.remove(terreno);
    }

    public Terreno obtenerTerreno(int idTerreno) {
        for (Terreno terreno : terrenos) {
            if (terreno.getId() == idTerreno) {
                return terreno;
            }
        }
        return null;
    }

    public boolean actualizarTerreno(int idTerreno, String direccion, double mts2, boolean agua, boolean luz, boolean gas) {
        Terreno terreno = obtenerTerreno(idTerreno);
        if (terreno != null) {
            terreno.setDireccion(direccion);
            terreno.setMts2(mts2);
            terreno.setTieneServicioAgua(agua);
            terreno.setTieneServicioLuz(luz);
            terreno.setTieneServicioGas(gas);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Terreno> getTerrenos() {
        return terrenos;
    }

    // Casa

    public void agregarCasa(Casa casa) {
        casas.add(casa);
    }

    public void eliminarCasa(Casa casa) {
        casas.remove(casa);
    }

    public Casa obtenerCasa(int idCasa) {
        for (Casa casa : casas) {
            if (casa.getId() == idCasa) {
                return casa;
            }
        }
        return null;
    }

    public boolean actualizarCasa(int idCasa, String direccion, double mts2, int numHabitaciones, int numBanios, int numEstacionamiento, int mts2Construidos, boolean tienePatio) {
        Casa casa = obtenerCasa(idCasa);
        if (casa != null) {
            casa.setDireccion(direccion);
            casa.setMts2(mts2);
            casa.setNumHabitaciones(numHabitaciones);
            casa.setNumBanios(numBanios);
            casa.setNumEstacionamiento(numEstacionamiento);
            casa.setMts2Construidos(mts2Construidos);
            casa.setTienePatio(tienePatio);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    // Mostrar todos las listas

    public List<Object> obtenerTodasLasPropiedades() {
        List<Object> propiedades = new ArrayList<>();
        propiedades.addAll(casas);
        propiedades.addAll(departamentos);
        propiedades.addAll(terrenos);
        return propiedades;
    }

    public double calcPrecioAgregadoSector() {
        String charClase = this.getClase();

        return switch (charClase) {
            case "A" -> 2.0;  // Clase alta, gran impacto
            case "B" -> 1.5;
            case "C" -> 1.2;
            case "D" -> 1.0;
            case "E" -> 0.8;
            case "F" -> 0.5;  // Clase baja, menor impacto
            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + "\n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Clase: " + this.getClase() + "\n" +
                "Total Inmuebles: " + (departamentos.size() + casas.size() + terrenos.size()) + "\n" +
                "------------------------";
    }
}