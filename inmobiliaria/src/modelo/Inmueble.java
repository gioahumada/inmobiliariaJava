package modelo;

import java.text.NumberFormat;
import java.util.Locale;

public class Inmueble {
    /* Atributos */
    private int id;
    private long precio;
    private String direccion;
    private double mts2;

    /* Constructor */
    public Inmueble(int id, long precio, String direccion, double mts2) {
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

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
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

    public long precioMetroCuadrado() {
        double metrosNoConstruidos = this.getMts2();  // Asumimos que `getMts2()` está en `Inmueble`

        if (this instanceof Casa) {
            // En una casa, se restan los metros construidos de los no construidos para calcularlos por separado.
            Casa casa = (Casa) this;
            metrosNoConstruidos -= casa.getMts2Construidos();  // Restamos los metros construidos si es una Casa
        }
        else if (this instanceof Departamento) {
            // En un departamento, todos los metros son útiles, no hay metros "no construidos"
            metrosNoConstruidos = this.getMts2();  // Usamos el total de metros del departamento
        }

        // Calcular el precio de los metros
        return (long) (metrosNoConstruidos * 110282);  // Precio por metro cuadrado
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