package modelo;

public class Terreno extends Inmueble{
    private String direccion;
    private double precio;
    private boolean disponibilidadServiciosBasicos;

    // Constructor con parámetros
    public Terreno(int id, String direccion, double precio, double mts2, String claseDeZona, boolean disponibilidadServiciosBasicos) {
        super(id, precio, direccion, mts2);
        this.direccion = direccion;
        this.precio = precio;
        this.disponibilidadServiciosBasicos = disponibilidadServiciosBasicos;
    }
    // Getters y Setters

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidadServiciosBasicos() {
        return disponibilidadServiciosBasicos;
    }

    public void setDisponibilidadServiciosBasicos(boolean disponibilidadServiciosBasicos) {
        this.disponibilidadServiciosBasicos = disponibilidadServiciosBasicos;
    }

    // Método para representar el terreno como una cadena de texto
    @Override
    public String toString() {
        return "Terreno{" +
                "direccion='" + direccion + '\'' +
                ", precio=" + precio +
                ", disponibilidadServiciosBasicos=" + disponibilidadServiciosBasicos +
                '}';
    }

    // Método para mostrar la información del terreno

    public String mostrarFormateado() {
        return "Terreno{" +
                "id=" + getId() +
                ", direccion='" + direccion + '\'' +
                ", precio=" + precio +
                ", mts2=" + getMts2() +
                '\'' +
                ", disponibilidadServiciosBasicos=" + disponibilidadServiciosBasicos +
                '}';
    }
}
