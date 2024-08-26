public class Propiedad {
    private int id;
    private String direccion;
    private double precio;

    // Constructor
    public Propiedad(int id, String direccion, double precio) {
        this.id = id;
        this.direccion = direccion;
        this.precio = precio;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Methods 

    @Override
    public String toString() {
        return id + "," + direccion + "," + precio;
    }

    public String mostrarFormateado() {
        return "ID: " + id + "\nDirección: " + direccion + "\nPrecio: " + precio;
    }

}