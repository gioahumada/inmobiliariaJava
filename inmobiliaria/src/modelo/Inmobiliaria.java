package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Clases en carpetas */

public class Inmobiliaria {
    private ArrayList<Comuna> comunas;

    public Inmobiliaria() {
        this.comunas = new ArrayList<>();
    }

    /* Metodos */

    public void agregarComuna(Comuna comuna) {
        comunas.add(comuna);
    }

    public void eliminarComuna(Comuna comuna) {
        comunas.remove(comuna);
    }

    public ArrayList<Comuna> getComunas() {
        return comunas;
    }



}
