package modelo;

import java.text.NumberFormat;
import java.util.Locale;

public class Inmueble {
    /* Atributos */
    private int id;
    private int precio;
    private String direccion;
    private double mts2;

    /* Constructor */
    public Inmueble(int id, int precio, String direccion, double mts2) {
        this.id = id;
        this.precio = precio;
        this.direccion = direccion;
        this.mts2 = mts2;
    }

    public Inmueble() {
        this.id = 0;
        this.precio = 0;
        this.direccion = "";
        this.mts2 = 0;
    }

    /* Getter & Setter */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPrecio(double precio) {
        this.precio = (int) precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getMts2() {
        return mts2;
    }

    public void setMts2(double mts2) {
        this.mts2 = mts2;
    }

    /* Metodos */

    public int precioMetroCuadrado() {
        return (int) this.getMts2() * 110282;  /*Valor mt2 2024 */
    }

    public String getPrecioFormat() {
        /* Coloca los precios en pesos chilenos */
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
        return currencyFormat.format(this.getPrecio());
    }

    @Override
    public String toString() {
        return id + "," + precio + "," + direccion + "," + mts2;
    }

    public String toString(String formato) {
        switch (formato.toLowerCase()) {
            case "breve":
                return "ID: " + id + ", Precio: " + getPrecioFormat();
            case "direccion":
                return "Dirección: " + direccion + " (" + mts2 + " m²)";
            case "precio":
                return "Precio: " + getPrecioFormat() + " (" + mts2 + " mts²)";
            default:
                return toString();
        }
    }
}