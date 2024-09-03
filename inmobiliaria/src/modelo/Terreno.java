package modelo;

import java.text.NumberFormat;
import java.util.Locale;

public class Terreno extends Inmueble{
    private boolean tieneServicioAgua;
    private boolean tieneServicioLuz;
    private boolean tieneServicioGas;

    public Terreno(int id, int precio, String direccion, double mts2, boolean tieneServicioAgua, boolean tieneServicioLuz, boolean tieneServicioGas) {
        super(id, precio, direccion, mts2);
        this.tieneServicioAgua = tieneServicioAgua;
        this.tieneServicioLuz = tieneServicioLuz;
        this.tieneServicioGas = tieneServicioGas;
    }

    /* Getter & Setter */

    public boolean isTieneServicioAgua() {
        return tieneServicioAgua;
    }

    public void setTieneServicioAgua(boolean tieneServicioAgua) {
        this.tieneServicioAgua = tieneServicioAgua;
    }

    public boolean isTieneServicioLuz() {
        return tieneServicioLuz;
    }

    public void setTieneServicioLuz(boolean tieneServicioLuz) {
        this.tieneServicioLuz = tieneServicioLuz;
    }

    public boolean isTieneServicioGas() {
        return tieneServicioGas;
    }

    public void setTieneServicioGas(boolean tieneServicioGas) {
        this.tieneServicioGas = tieneServicioGas;
    }


    /* Metodos */

    public double calcPrecioTerreno() {
        double multiplicador = 0;

        if (this.isTieneServicioAgua()) {
            multiplicador += 0.5;
        }

        if (this.isTieneServicioLuz()) {
            multiplicador += 0.5;
        }

        if (this.isTieneServicioGas()) {
            multiplicador += 0.5;
        }

        return multiplicador;
    }

    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
        return "ID : " + this.getId() + "\n" +
                "Precio: " + currencyFormat.format(this.getPrecio()) +  "\n" +
                "Dirección: " + this.getDireccion() + "\n" +
                "Metros Cuadrados: "+ this.getMts2() + "\n" +
                "Tiene Agua: " + this.isTieneServicioAgua() + "\n" +
                "Tiene Luz: " + this.isTieneServicioLuz() + "\n" +
                "Tiene Gas: " + this.isTieneServicioGas() + "\n" +
                "------------------------";
    }

}
