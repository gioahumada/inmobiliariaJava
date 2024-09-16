package modelo;

public class Casa extends Inmueble {
    private int numHabitaciones;
    private int numBanios;
    private int numEstacionamiento;
    private int mts2Construidos;
    private boolean tienePatio;

    // Constructor con parámetros
    public Casa(int id, long precio, String direccion, double mts2, int numHabitaciones, int numBanios, int numEstacionamiento, int mts2Construidos, boolean tienePatio) {
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

    /* Metodos */

    /* $$$$ */

    public long calcPrecioCasa() {
        long valorAgregado = 0;

        if (this.getNumHabitaciones() > 2) {
            valorAgregado += (this.getNumHabitaciones() - 2) * 200; // Cambiado a long
        }

        if (this.getNumBanios() > 1) {
            valorAgregado += (this.getNumBanios() - 1) * 300; // Cambiado a long
        }

        if (this.getNumEstacionamiento() > 1) {
            valorAgregado += (this.getNumEstacionamiento() - 1) * 20000; // Cambiado a long
        }

        if (this.isTienePatio()) {
            valorAgregado += 50000; // Cambiado a long
        }

        return valorAgregado;
    }

    public long precioMetroCuadradoConstruido() {
        return (long) this.getMts2Construidos() * 500000; // Devuelve long
    }


    @Override
    public String toString() {
        // Información básica que siempre se mostrará
        return "Casa\n" +
                "ID : " + this.getId() + "\n" +
                "Precio: " + getPrecioFormat() +  "\n" +
                "Direccion: " + this.getDireccion() + "\n" +
                "------------------------";
    }

    public String toString(boolean incluirInfoAdicional) {
        if (incluirInfoAdicional) {
            // Mostrar toda la información si se desea información adicional
            return "Casa\n" +
                    "ID : " + this.getId() + "\n" +
                    "Precio: " + getPrecioFormat() +  "\n" +
                    "Direccion: " + this.getDireccion() + "\n" +
                    "Metros Cuadrados: " + this.getMts2() + "\n" +
                    "Cant. Baños: " + this.getNumBanios() + "\n" +
                    "Cant. Habitaciones: " + this.getNumHabitaciones() + "\n" +
                    "Cant. Estacionamientos: " + this.getNumEstacionamiento() + "\n" +
                    "Metros Cuadrados Construidos: " + this.getMts2Construidos() + "\n" +
                    "Tiene Patio: " + this.isTienePatio() + "\n" +
                    "------------------------";
        } else {
            // Mostrar solo el ID, la dirección y el precio si no se desea información adicional
            return toString();
        }
    }


}