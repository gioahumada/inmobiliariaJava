package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inmobiliaria {
    private String nombre;
    private ArrayList<Comuna> comunas;
    private HashMap<String, Usuario> usuarios;

    /* Constructor */

    public Inmobiliaria() {
        this.nombre = "InmobiliariaJava";
        this.comunas = new ArrayList<>();
        this.usuarios = new HashMap<>();
    }

    /* Setters & Getters */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Comuna> getComunas() {
        return comunas;
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    /* Metodos */

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombreUsuario(), usuario);
    }

    public Usuario obtenerUsuario(String nombreUsuario) {
        return usuarios.get(nombreUsuario);
    }

    public boolean esUsuarioAdministrador(String nombreUsuario) {
        Usuario usuario = obtenerUsuario(nombreUsuario);
        return usuario != null && usuario.isEsAdministrador();
    }

    public void agregarComuna(Comuna comuna) {
        comunas.add(comuna);
        try {
            guardarComunasCSV("comunas.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarComuna(Comuna comuna) {
        comunas.remove(comuna);
    }

    /* Persistencia de Datos */

    public void guardarUsuariosCSV(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            for (Usuario usuario : usuarios.values()) {
                String[] record = {usuario.getNombreUsuario(), usuario.getHashContraseña(), String.valueOf(usuario.isEsAdministrador())};
                writer.writeNext(record);
            }
        }
    }

    public void cargarUsuariosCSV(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String nombreUsuario = nextLine[0];
                String hashContraseña = nextLine[1];
                boolean esAdministrador = Boolean.parseBoolean(nextLine[2]);
                Usuario usuario = new Usuario(nombreUsuario, hashContraseña, esAdministrador);
                agregarUsuario(usuario);
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }

    // Métodos para guardar y cargar comunas
    public void guardarComunasCSV(String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (Comuna comuna : comunas) {
                String[] record = {String.valueOf(comuna.getId()), comuna.getNombre(), comuna.getClase()};
                writer.writeNext(record);
            }
        }
    }

    public void cargarComunasCSV(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String nombre = nextLine[1];
                String clase = nextLine[2];
                Comuna comuna = new Comuna(id, nombre, clase);
                agregarComuna(comuna);
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}