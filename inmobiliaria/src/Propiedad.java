public class Propiedad {
    private int id;
    private String direccion;
    private double precio;

    // Constructor sin argumentos
    public Propiedad() {}

    // Constructor con argumentos
    public Propiedad(int id, String direccion, double precio) {
        this.id = id;
        this.direccion = direccion;
        this.precio = precio;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    // Methods
    @Override
    public String toString() {
        return id + "," + direccion + "," + precio;
    }

    public String mostrarFormateado() {
        return "ID: " + id + "\nDirección: " + direccion + "\nPrecio: " + precio;
    }
}