import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class PropiedadCSV {
    private static final String FILE_PATH = "propiedades.csv";

    public List<Propiedad> leerPropiedades() throws IOException {
        List<Propiedad> propiedades = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Propiedad propiedad = new Propiedad();
                Field[] fields = Propiedad.class.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    try {
                        if (fields[i].getType() == int.class) {
                            fields[i].setInt(propiedad, Integer.parseInt(data[i]));
                        } else if (fields[i].getType() == double.class) {
                            fields[i].setDouble(propiedad, Double.parseDouble(data[i]));
                        } else {
                            fields[i].set(propiedad, data[i]);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
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
}