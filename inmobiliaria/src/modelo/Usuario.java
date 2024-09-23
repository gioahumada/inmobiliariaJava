package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Usuario {
    private String nombreUsuario;
    private String hashContraseña;
    private boolean esAdministrador;

    public Usuario(String nombreUsuario, String contraseña, boolean esAdministrador, boolean isHashed) {
        this.nombreUsuario = nombreUsuario;
        this.hashContraseña = isHashed ? contraseña : hashPassword(contraseña);
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

    public void setHashContraseña(String contraseña) {
        this.hashContraseña = hashPassword(contraseña);
    }

    public boolean isEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario;
    }

    public String toString(boolean incluirInfoAdicional) {
        if (incluirInfoAdicional) {
            return "Usuario: " + nombreUsuario + "\n" +
                    "Contraseña: " + hashContraseña + "\n" +
                    "Es Administrador: " + esAdministrador + "\n";
        } else {
            return toString();
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificarContraseña(String contraseña) {
        return hashContraseña.equals(hashPassword(contraseña));
    }
}