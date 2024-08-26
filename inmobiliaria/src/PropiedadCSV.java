import java.io.*;
import java.util.*;

public class PropiedadCSV {
    private static final String FILE_PATH = "propiedades.csv";

    public void agregarPropiedad(Propiedad propiedad) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(propiedad.toString());
            writer.newLine();
        }
    }

    public List<Propiedad> leerPropiedades() throws IOException {
        List<Propiedad> propiedades = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Propiedad propiedad = new Propiedad(
                    Integer.parseInt(data[0]),
                    data[1],
                    Double.parseDouble(data[2])
                );
                propiedades.add(propiedad);
            }
        }
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
}