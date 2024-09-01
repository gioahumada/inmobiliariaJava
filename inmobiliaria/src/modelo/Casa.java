package modelo;

public class Casa extends Inmueble {
    private int numHabitaciones;
    private int numBanios;
    private int numEstacionamiento;
    private int mts2Construidos;
    private boolean tienePatio;

    public Casa(int id, double precio, String direccion, double mts2, int numHabitaciones, int numBanios, int numEstacionamiento, boolean tienePatio) {
        super(id, precio, direccion, mts2);
        this.numHabitaciones = numHabitaciones;
        this.numBanios = numBanios;
        this.numEstacionamiento = numEstacionamiento;
        this.tienePatio = tienePatio;
    }

    public Casa() {
        this.numHabitaciones = 0;
        this.numBanios = 0;
        this.numEstacionamiento = 0;
        this.tienePatio = false;
    }
}


