package modelo;

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
        double multiplicador = 1.0;

        if (this.isTieneServicioAgua()) {
            multiplicador += 0.2;
        }

        if (this.isTieneServicioLuz()) {
            multiplicador += 0.2;
        }

        if (this.isTieneServicioGas()) {
            multiplicador += 0.2;
        }

        return multiplicador;
    }

    public double calcPrecioTerreno(double factorAjuste) {
        double multiplicador = calcPrecioTerreno();
        return multiplicador * factorAjuste;
    }

    @Override
    public String toString() {
        // Información básica que siempre se mostrará
        return "Terreno\n" +
                "ID : " + this.getId() + "\n" +
                "Precio: " + getPrecioFormat() +  "\n" +
                "Dirección: " + this.getDireccion() + "\n" +
                "------------------------";
    }
    
    public String toString(boolean incluirInfoAdicional) {
        if (incluirInfoAdicional) {
            // Mostrar toda la información si se desea información adicional
            return "Terreno\n" +
                    "ID : " + this.getId() + "\n" +
                    "Precio: " + getPrecioFormat() +  "\n" +
                    "Dirección: " + this.getDireccion() + "\n" +
                    "Metros Cuadrados: "+ this.getMts2() + "\n" +
                    "Tiene Agua: " + this.isTieneServicioAgua() + "\n" +
                    "Tiene Luz: " + this.isTieneServicioLuz() + "\n" +
                    "Tiene Gas: " + this.isTieneServicioGas() + "\n" +
                    "------------------------";
        } else {
            // Mostrar solo el ID, la dirección y el precio si no se desea información adicional
            return toString();
        }
    }
}