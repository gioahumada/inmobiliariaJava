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

    /* Metodos */

    public boolean hasRegisteredUsers() {
        return !usuarios.isEmpty();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombreUsuario(), usuario);
        try {
            guardarUsuariosCSV("db/usuarios.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        guardarCambiosComunas();
    }

    public void eliminarComuna(Comuna comuna) {
        comunas.remove(comuna);
        guardarCambiosComunas();
    }

    public void actualizarComuna(Comuna comunaActualizada) throws NoEncontrado {
        for (Comuna comuna : comunas) {
            if (comuna.getId() == comunaActualizada.getId()) {
                comuna.setNombre(comunaActualizada.getNombre());
                comuna.setClase(comunaActualizada.getClase());

                // Guardar los cambios en el archivo CSV después de la actualización
                try {
                    guardarComunasCSV("db/comunas.csv");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Comuna actualizada con éxito.");
                return;
            }
        }
        throw new NoEncontrado("No se encontró la comuna con ID: " + comunaActualizada.getId());
    }

    public List<Comuna> obtenerTodasLasComunas() {
        return new ArrayList<>(comunas);
    }

    /* InmobiliariaController */

    public Comuna buscarComunaPorId(int id) throws NoEncontrado {
        for (Comuna comuna : comunas) {
            if (comuna.getId() == id) {
                return comuna; // Devuelve la comuna si encuentra coincidencia de ID
            }
        }
        throw new NoEncontrado("Comuna con ID " + id + " no encontrada."); // Lanza la excepción si no se encuentra la comuna
    }


    public boolean existeComunaConId(int id) throws NoEncontrado {
        boolean exists = comunas.stream().anyMatch(comuna -> comuna.getId() == id);
        if (!exists) {
            throw new NoEncontrado("Comuna con ID " + id + " no encontrada.");
        }
        return exists;
    }


    public void agregarComuna(int id, String nombre, String clase) {
        try {
            if (existeComunaConId(id)) {
                return;
            }
        } catch (NoEncontrado e) {
            // If the exception is thrown, it means the comuna does not exist, so we can proceed to add it
        }
        Comuna comuna = new Comuna(id, nombre, clase);
        agregarComuna(comuna); // Llama al método ya existente para agregar una comuna
    }

    public boolean eliminarComunaPorId(int id) {
        try {
            Comuna comuna = buscarComunaPorId(id);
            comunas.remove(comuna);
            guardarCambiosComunas(); // Ya existente

            // Eliminar el archivo CSV de propiedades asociado a la comuna
            String propiedadesFilePath = "db/comuna_" + id + "_propiedades.csv";
            File archivoPropiedades = new File(propiedadesFilePath);

            if (archivoPropiedades.exists()) {
                if (archivoPropiedades.delete()) {
                    System.out.println("Archivo de propiedades eliminado");
                    return true;
                } else {
                    System.out.println("No se pudo eliminar el archivo de propiedades");
                    return false;
                }
            } else {
                System.out.println("El archivo de propiedades no existe");
                return false;
            }
        } catch (NoEncontrado e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


    public void actualizarComuna(int id, String nombre, String clase) {
        try {
            Comuna comuna = buscarComunaPorId(id);
            comuna.setNombre(nombre);
            comuna.setClase(clase);
            guardarCambiosComunas(); // Ya existente
        } catch (NoEncontrado e) {
            System.out.println("Error: " + e.getMessage());
        }
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
                if (nextLine.length < 3) {
                    System.err.println("Invalid line format: " + String.join(",", nextLine));
                    continue;
                }
                try {
                    String nombreUsuario = nextLine[0];
                    String hashContraseña = nextLine[1];
                    boolean esAdministrador = Boolean.parseBoolean(nextLine[2]);
                    Usuario usuario = new Usuario(nombreUsuario, hashContraseña, esAdministrador, true); // Pass true to indicate the password is already hashed
                    usuarios.put(nombreUsuario, usuario);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                    System.err.println("Error parsing line: " + String.join(",", nextLine));
                    e.printStackTrace();
                }
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

                // Cargar propiedades asociadas a la comuna desde sus CSV
                String propiedadesPath = "db/comuna_" + id + "_propiedades.csv";
                comuna.cargarPropiedadesCSV(propiedadesPath); // Cargar las propiedades de cada comuna
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }

    private void guardarCambiosComunas() {
        try {
            guardarComunasCSV("db/comunas.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Inmobiliaria.java
    public void eliminarUsuario(String nombreUsuario) throws NoEncontrado {
        if (usuarios.containsKey(nombreUsuario)) {
            usuarios.remove(nombreUsuario);
            try {
                guardarUsuariosCSV("db/usuarios.csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new NoEncontrado("Usuario no encontrado.");
        }
    }
}