package modelo;

import java.util.ArrayList;

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

    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void eliminarDepartamento(Departamento departamento) {
        departamentos.remove(departamento);
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void agregarTerreno(Terreno terreno) {
        terrenos.add(terreno);
    }

    public void eliminarTerreno(Terreno terreno) {
        terrenos.remove(terreno);
    }

    public ArrayList<Terreno> getTerrenos() {
        return terrenos;
    }

    public void agregarCasa(Casa casa) {
        casas.add(casa);
    }

    public void eliminarCasa(Casa casa) {
        casas.remove(casa);
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    @Override
    public String toString() {
        return "Comuna{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                '}';
    }
}
