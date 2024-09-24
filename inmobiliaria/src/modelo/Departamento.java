package modelo;

public class Departamento extends Inmueble {
    private int numHabitaciones;
    private int numBanos;
    private int piso;
    private boolean tieneEstacionamiento;
    private boolean tieneBodega;


    // Constructor con parámetros
    public Departamento(int id, long precio, String direccion, double mts2, int numHabitaciones, int numBanos, int piso, boolean tieneEstacionamiento, boolean tieneBodega) {
        super(id, precio, direccion, mts2);
        this.numHabitaciones = numHabitaciones;
        this.numBanos = numBanos;
        this.piso = piso;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.tieneBodega = tieneBodega;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
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

    /* Metodos */

    /* $$$$ */

    public double calcPrecioDepartamento() {
        double multiplicador = 0;

        if (this.getNumHabitaciones() > 1 ) {
            multiplicador += (this.getNumHabitaciones() - 1 ) * 0.02;
        }

        if (this.getNumBanos() > 1) {
            multiplicador += (this.getNumBanos() - 1) * 0.03;
        }

        multiplicador += this.getPiso() * 0.002;

        if(this.isTieneBodega()) {
            multiplicador += 0.1;
        }

        if (this.isTieneEstacionamiento()) {
            multiplicador += 0.5;
        }

        return multiplicador;
    }

    // Método para representar el departamento como una cadena de texto
    @Override
    public String toString() {
        // Información básica que siempre se mostrará
        return  "ID : " + this.getId() + " | " +
                "Precio: " + this.getPrecioFormat() +  " | " +
                "Direccion: " + this.getDireccion() + "\n";
    }

    public String toString(boolean incluirInfoAdicional) {
        if (incluirInfoAdicional) {
            // Mostrar toda la información si se desea información adicional
            return "Departamento\n" +
                    "ID : " + this.getId() + "\n" +
                    "Precio: " + this.getPrecioFormat() +  "\n" +
                    "Direccion: " + this.getDireccion() + "\n" +
                    "Metros Cuadrados: " + this.getMts2() + "\n" +
                    "Cant. Baños: " + this.getNumBanos() + "\n" +
                    "Cant. Habitaciones: " + this.getNumHabitaciones() + "\n" +
                    "Cant. Estacionamientos: " + this.isTieneEstacionamiento() + "\n" +
                    "Piso: " + getPiso() + "\n" +
                    "Tiene estacionamiento: " + isTieneEstacionamiento() + "\n" +
                    "Tiene bodega: " + isTieneBodega() + "\n";
        } else {
            // Mostrar solo el ID, la dirección y el precio si no se desea información adicional
            return toString();
        }
    }
}