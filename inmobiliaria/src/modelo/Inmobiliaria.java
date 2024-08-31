import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Clases en carpetas */
import modelo.Inmueble;
import modelo.Usuario;

public class Inmobiliaria {
    private ArrayList<Inmueble> inmuebles;
    private Map<String, Usuario> usuarios;

    public Inmobiliaria() {
        inmuebles = new ArrayList<>();
        usuarios = new HashMap<>();
    }

    // Métodos para gestionar inmuebles
    public void agregarInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
    }

    public void eliminarInmueble(Inmueble inmueble) {
        inmuebles.remove(inmueble);
    }

    public ArrayList<Inmueble> listarInmuebles() {
        return inmuebles;
    }

    // Métodos para gestionar usuarios
    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombreUsuario(), usuario);
    }

    public Usuario autenticarUsuario(String nombreUsuario, String contraseña) {
        Usuario usuario = usuarios.get(nombreUsuario);
        if (usuario != null && usuario.verificarContraseña(contraseña)) { /* Agregar Funcion a User */
            return usuario;
        }
        return null;
    }
}
