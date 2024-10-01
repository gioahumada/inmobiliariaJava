package modelo;

public class YaExiste extends RuntimeException {
    // Default constructor
    public YaExiste() {
        super("Ya existe");
    }

    // Constructor with custom message
    public YaExiste(String message) {
        super(message);
    }

    // Override toString method
    @Override
    public String toString() {
        return "Ya Existe: " + getMessage();
    }
}