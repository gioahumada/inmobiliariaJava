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
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", esAdministrador=" + esAdministrador +
                '}';
    }
}