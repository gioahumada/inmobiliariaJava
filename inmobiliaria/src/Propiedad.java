public class Propiedad {
    /* Atributos */
    private static int ultimoId = 0; /* Contador para asignar ID */

    private int id;
    private String direccion;
    private double precio;

    // Constructor sin argumentos
    public Propiedad() {}

    // Constructor con argumentos ID AUTOMATICO
    public Propiedad(String direccion, double precio) {
        this.id = ultimoId++; /* Le suma uno, para autoasignarlo. */
        this.direccion = direccion;
        this.precio = precio;
    }

    public Propiedad(int id, String direccion, double precio) {
        this.id = id; /* Le suma uno, para autoasignarlo. */
        this.direccion = direccion;
        this.precio = precio;
    }

    // Getters & Setters

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Propiedad.ultimoId = ultimoId; /* Es diferente porque es static */
    }

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

    // Metodos
    @Override
    public String toString() {
        return id + "," + direccion + "," + precio;
    }

    public String mostrarFormateado() {
        return "ID: " + id + "\nDirección: " + direccion + "\nPrecio: $" + precio + "\n";
    }
}