package modelo;

/* Transformar precios */
import java.text.NumberFormat;
import java.util.Locale;

public class Casa extends Inmueble {
    private int numHabitaciones;
    private int numBanios;
    private int numEstacionamiento;
    private int mts2Construidos;
    private boolean tienePatio;

    // Constructor con parámetros
    public Casa(int id, int precio, String direccion, double mts2, int numHabitaciones, int numBanios, int numEstacionamiento, int mts2Construidos, boolean tienePatio) {
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

    public double calcPrecioCasa() {
        double valorAgregado = 0;

        /*Num Habitaciones */

        if (this.getNumHabitaciones() > 2) {
            valorAgregado += (getNumHabitaciones() - 2) * 0.02;
        }

        if (this.getNumHabitaciones() < 0) {
            valorAgregado -= 2.0;
        }

        /* Baños */

        if (this.getNumBanios() > 1) {
            valorAgregado += (getNumBanios() - 1) * 0.03;
        }

        if (this.getNumBanios() < 0) {
            valorAgregado -= 2.0;
        }

        /* Estacionamiento */

        if (this.getNumEstacionamiento() > 1) {
            valorAgregado += (getNumEstacionamiento() - 1) * 0.2;
        }

        if (this.getNumBanios() < 0) {
            valorAgregado -= 2.0;
        }

        if (this.isTienePatio()) {
            valorAgregado += 0.5;
        }

        return valorAgregado;
    }

    public double precioMetroCuadradoConstruido() {
        return this.getMts2Construidos() * 500000; /*Valor mt2 construido aprox 2024 */
    }

    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
        return "ID : " + this.getId() + "\n" +
                "Precio: " + currencyFormat.format(this.getPrecio()) +  "\n" + /* Formatea a peso chileno y agrega $*/
                "Direccion: " + this.getDireccion() + "\n" +
                "Metros Cuadrados: " + this.getMts2() + "\n" +
                "Cant. Baños: " + this.getNumBanios() + "\n" +
                "Cant. Habitaciones: " + this.getNumHabitaciones() + "\n" +
                "Cant. Estacionamientos: " + this.getNumEstacionamiento() + "\n" +
                "Metros Cuadrados Construidos: " + this.getMts2Construidos() + "\n" +
                "Tiene Patio: " + this.isTienePatio() + "\n" +
                "------------------------";
    }
}
