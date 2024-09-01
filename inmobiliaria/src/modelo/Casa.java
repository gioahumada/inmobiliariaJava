package modelo;

public class Casa extends Inmueble {
    private int numHabitaciones;
    private int numBanios;
    private int numEstacionamiento;
    private int mts2Construidos;
    private boolean tienePatio;

    // Constructor con parámetros
    public Casa(int id, double precio, String direccion, double mts2, int numHabitaciones, int numBanios, int numEstacionamiento, int mts2Construidos, boolean tienePatio) {
        super(id, precio, direccion, mts2);
        this.numHabitaciones = numHabitaciones;
        this.numBanios = numBanios;
        this.numEstacionamiento = numEstacionamiento;
        this.mts2Construidos = mts2Construidos;
        this.tienePatio = tienePatio;
    }

    // Constructor por defecto
    public Casa() {
        super();
        this.numHabitaciones = 0;
        this.numBanios = 0;
        this.numEstacionamiento = 0;
        this.mts2Construidos = 0;
        this.tienePatio = false;
    }

    // Getters y Setters
    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }

    public int getNumEstacionamiento() {
        return numEstacionamiento;
    }

    public void setNumEstacionamiento(int numEstacionamiento) {
        this.numEstacionamiento = numEstacionamiento;
    }

    public int getMts2Construidos() {
        return mts2Construidos;
    }

    public void setMts2Construidos(int mts2Construidos) {
        this.mts2Construidos = mts2Construidos;
    }

    public boolean isTienePatio() {
        return tienePatio;
    }

    public void setTienePatio(boolean tienePatio) {
        this.tienePatio = tienePatio;
    }

    // Método para representar la casa como una cadena de texto
    @Override
    public String toString() {
        return "Casa{" +
                "numHabitaciones=" + numHabitaciones +
                ", numBanios=" + numBanios +
                ", numEstacionamiento=" + numEstacionamiento +
                ", mts2Construidos=" + mts2Construidos +
                ", tienePatio=" + tienePatio +
                "} " + super.toString();
    }
}
