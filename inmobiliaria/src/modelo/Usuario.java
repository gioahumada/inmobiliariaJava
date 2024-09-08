package modelo;

public class Usuario {
    private String nombreUsuario;
    private String hashContraseña;
    private boolean esAdministrador;

    public Usuario(String nombreUsuario, String hashContraseña, boolean esAdministrador) {
        this.nombreUsuario = nombreUsuario;
        this.hashContraseña = hashContraseña;
        this.esAdministrador = esAdministrador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getHashContraseña() {
        return hashContraseña;
    }

    public void setHashContraseña(String hashContraseña) {
        this.hashContraseña = hashContraseña;
    }

    public boolean isEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    @Override

    public String toString() {
        // Solo muestra el nombre de usuario
        return "Usuario: " + nombreUsuario;
    }

    public String toString(boolean incluirInfoAdicional) {
        // Muestra la información adicional si se solicita
        if (incluirInfoAdicional) {
            return "Usuario: " + nombreUsuario + "\n" +
                    "Contraseña: " + hashContraseña + "\n" +
                    "Es Administrador: " + esAdministrador + "\n";
        } else {
            return toString();
            // Llama al método básico si no se desea la info adicional
        }
    }
}