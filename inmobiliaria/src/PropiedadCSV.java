import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class PropiedadCSV {
    private static final String FILE_PATH = "propiedades.csv";

    public List<Propiedad> leerPropiedades() throws IOException {
        List<Propiedad> propiedades = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            try {
                int id = Integer.parseInt(values[0].trim());
                String direccion = values[1].trim();
                double precio = Double.parseDouble(values[2].trim());
                propiedades.add(new Propiedad(id, direccion, precio));
            } catch (NumberFormatException e) {
                System.err.println("Error al parsear la línea: " + line);
                e.printStackTrace();
            }
        }
        br.close();
        return propiedades;
    }

    public void actualizarPropiedad(Propiedad propiedad) throws IOException {
        List<Propiedad> propiedades = leerPropiedades();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Propiedad p : propiedades) {
                if (p.getId() == propiedad.getId()) {
                    writer.write(propiedad.toString());
                } else {
                    writer.write(p.toString());
                }
                writer.newLine();
            }
        }
    }

    public void eliminarPropiedad(int id) throws IOException {
        List<Propiedad> propiedades = leerPropiedades();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Propiedad p : propiedades) {
                if (p.getId() != id) {
                    writer.write(p.toString());
                    writer.newLine();
                }
            }
        }
    }

    public void agregarPropiedad(Propiedad propiedad) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(propiedad.toString());
            writer.newLine();
        }
    }

    public int obtenerMaxId() throws IOException {
        int maxId = 0;
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            try {
                int id = Integer.parseInt(values[0].trim());
                if (id > maxId) {
                    maxId = id;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error al parsear la línea: " + line);
                e.printStackTrace();
            }
        }
        br.close();
        return maxId;
    }
}