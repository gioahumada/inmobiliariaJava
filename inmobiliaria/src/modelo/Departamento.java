package propiedades;

public class Departamento extends Inmueble {
    private int numHabitaciones;
    private int numBanos;
    private int piso;
    private boolean tieneEstacionamiento;
    private boolean tieneBodega;


    // Constructor con parámetros
    public Departamento(int id, String direccion, double precio, double mts2, String ClaseDeZona, int numHabitaciones, int numBanos, int piso, boolean tieneEstacionamiento, boolean tieneBodega) {
        super(id, precio, direccion, mts2, ClaseDeZona);
        this.numHabitaciones = numHabitaciones;
        this.numBanos = numBanos;
        this.piso = piso;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.tieneBodega = tieneBodega;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isTieneEstacionamiento() {
        return tieneEstacionamiento;
    }

    public void setTieneEstacionamiento(boolean tieneEstacionamiento) {
        this.tieneEstacionamiento = tieneEstacionamiento;
    }

    public boolean isTieneBodega() {
        return tieneBodega;
    }

    public void setTieneBodega(boolean tieneBodega) {
        this.tieneBodega = tieneBodega;
    }

    // Método para representar el departamento como una cadena de texto
    @Override
    public String toString() {
        return "Departamento{" +
                "numHabitaciones=" + numHabitaciones +
                ", numBanos=" + numBanos +
                ", piso=" + piso +
                ", tieneEstacionamiento=" + tieneEstacionamiento +
                ", tieneBodega=" + tieneBodega +
                '}';
    }
}
