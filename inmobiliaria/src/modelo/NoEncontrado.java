package modelo;

public class NoEncontrado extends Exception {
    // constructor
    public NoEncontrado() {
        super("No encontrado");
    }

    // Constructor con mensaje personalizado
    public NoEncontrado(String mensaje) {
        super(mensaje);
    }

    // toString para imprimir el mensaje
    @Override
    public String toString() {
        return "No Encontrado: " + getMessage();
    }
}