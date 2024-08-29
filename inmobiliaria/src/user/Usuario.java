package user;

public class Usuario {
    private String nombreUsuario;
    private String hashContraseña;
    private boolean esAdministrador;

    /* Constructures */

    public Usuario(String nombreUsuario, String hashContraseña, boolean esAdministrador) {
        this.nombreUsuario = nombreUsuario;
        this.hashContraseña = hashContraseña;
        this.esAdministrador = esAdministrador;
    }

    /* Getters & Setters */

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

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    /* Metodos */

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", esAdministrador=" + esAdministrador +
                '}';
    }

    public boolean verificarContraseña(String contraseña) {
        return hashContraseña.equals(contraseña);
    }
}