package modelo;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Comuna {
    private int id;
    private String nombre;
    private String clase;
    private ArrayList<Departamento> departamentos;
    private ArrayList<Terreno> terrenos;
    private ArrayList<Casa> casas;

    /* Constructor */

    public Comuna(int id, String nombre, String clase) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.departamentos = new ArrayList<>();
        this.terrenos = new ArrayList<>();
        this.casas = new ArrayList<>();
    }

    /* Getter & Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    /* Metodos */

    public boolean idExisteCasa(int id) throws NoEncontrado {
        // Verificar si el ID existe en la lista de casas
        for (Casa casa : casas) {
            if (casa.getId() == id) {
                return true;  // El ID ya existe
            }
        }
        throw new NoEncontrado("El ID de casa no existe: " + id);  // El ID no existe en ninguna lista
    }

    // Verificar si el ID existe en la lista de departamentos
    public boolean idExisteDepartamento(int id) throws NoEncontrado {
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == id) {
                return true;  // El ID ya existe
            }
        }
        throw new NoEncontrado("El ID de departamento no existe: " + id);  // El ID no existe en ninguna lista
    }

    // Verificar si el ID existe en la lista de terrenos
    public boolean idExisteTerreno(int id) throws NoEncontrado {
        for (Terreno terreno : terrenos) {
            if (terreno.getId() == id) {
                return true;  // El ID ya existe
            }
        }
        throw new NoEncontrado("El ID de terreno no existe: " + id);  // El ID no existe en ninguna lista
    }






    // Departamento

    public void agregarDepartamento(Departamento departamento)
    {
        try {
            if (!idExisteDepartamento(departamento.getId()))
            {
                // Si el ID no existe, se añade el departamento a la lista
                departamentos.add(departamento);
                guardarCambios();
            }
        }catch(NoEncontrado e){
            e.printStackTrace();
        }

    }

    public void eliminarDepartamento(Departamento departamento) {
        departamentos.remove(departamento);
        guardarCambios();
    }

    public void eliminarDepartamento(int idDepartamento) {
        Departamento departamento = obtenerDepartamento(idDepartamento);
        if (departamento != null) {
            departamentos.remove(departamento);
            guardarCambios();
        }
    }

    public Departamento obtenerDepartamento(int idDepartamento) {
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == idDepartamento) {
                return departamento;
            }
        }
        return null;
    }

    public boolean actualizarDepartamento(int idDepartamento, String direccion, double mts2, int numHabitaciones, int numBanios, int piso, boolean tieneEstacionamiento, boolean tieneBodega) {
        Departamento departamento = obtenerDepartamento(idDepartamento);
        if (departamento != null) {
            departamento.setDireccion(direccion);
            departamento.setMts2(mts2);
            departamento.setNumHabitaciones(numHabitaciones);
            departamento.setNumBanos(numBanios);
            departamento.setPiso(piso);
            departamento.setTieneEstacionamiento(tieneEstacionamiento);
            departamento.setTieneBodega(tieneBodega);
            guardarCambios();
            return true;
        } else {
            return false;
        }
    }

    public int precioFinalDepartamento(Comuna comuna, Departamento departamento) {
        double multSector = comuna.calcPrecioAgregadoSector();
        double multDepto = departamento.calcPrecioDepartamento();
        long precioBase = departamento.precioMetroCuadrado() * 4;

        double factorTotal = 1.0 + multSector + multDepto;

        return (int) (precioBase * factorTotal);
    }

    // Terreno

    public void agregarTerreno(Terreno terreno) {
        try{
            if (!idExisteTerreno(terreno.getId()))
            {
                terrenos.add(terreno);
                guardarCambios();
            }
        }catch(NoEncontrado e)
        {
            e.printStackTrace();
        }
    }

    public void eliminarTerreno(Terreno terreno) {
        terrenos.remove(terreno);
        guardarCambios();
    }

    public void eliminarTerreno(int idTerreno) {
        Terreno terreno = obtenerTerreno(idTerreno);
        if (terreno != null) {
            terrenos.remove(terreno);
            guardarCambios();
        }
    }

    public Terreno obtenerTerreno(int idTerreno) {
        for (Terreno terreno : terrenos) {
            if (terreno.getId() == idTerreno) {
                return terreno;
            }
        }
        return null;
    }

    public boolean actualizarTerreno(int idTerreno, String direccion, double mts2, boolean agua, boolean luz, boolean gas) {
        Terreno terreno = obtenerTerreno(idTerreno);
        if (terreno != null) {
            terreno.setDireccion(direccion);
            terreno.setMts2(mts2);
            terreno.setTieneServicioAgua(agua);
            terreno.setTieneServicioLuz(luz);
            terreno.setTieneServicioGas(gas);
            guardarCambios();
            return true;
        } else {
            return false;
        }
    }

    public int precioFinalTerreno(Comuna comuna, Terreno terreno) {
        double multSector = comuna.calcPrecioAgregadoSector();
        double multTerreno = terreno.calcPrecioTerreno();
        long precioBase = terreno.precioMetroCuadrado();

        double factorTotal = 1.0 + multSector + multTerreno;

        return (int)(precioBase * factorTotal);
    }

    // Casa

    public void agregarCasa(Casa casa) {
        try{
            if (!idExisteCasa(casa.getId())) {
                // Si el ID no existe, se añade la casa a la lista
                casas.add(casa);
                guardarCambios();
            }
        }catch(NoEncontrado e){
            e.printStackTrace();
        }
    }

    public void eliminarCasa(Casa casa) {
        casas.remove(casa);
        guardarCambios();
    }

    public void eliminarCasa(int idCasa) {
        Casa casa = obtenerCasa(idCasa);
        if (casa != null) {
            casas.remove(casa);
            guardarCambios();
        }
    }

    public Casa obtenerCasa(int idCasa) {
        for (Casa casa : casas) {
            if (casa.getId() == idCasa) {
                return casa;
            }
        }
        return null;
    }

    public boolean actualizarCasa(int idCasa, String direccion, double mts2, int numHabitaciones, int numBanios, int numEstacionamiento, int mts2Construidos, boolean tienePatio) {
        Casa casa = obtenerCasa(idCasa);
        if (casa != null) {
            casa.setDireccion(direccion);
            casa.setMts2(mts2);
            casa.setNumHabitaciones(numHabitaciones);
            casa.setNumBanios(numBanios);
            casa.setNumEstacionamiento(numEstacionamiento);
            casa.setMts2Construidos(mts2Construidos);
            casa.setTienePatio(tienePatio);
            guardarCambios();
            return true;
        }
        return false;
    }

    public long precioFinalCasa(Comuna comuna, Casa casa) {
        double multSector = comuna.calcPrecioAgregadoSector();  // Factor de la comuna
        double precioCasa = casa.calcPrecioCasa();  // Precio calculado de la casa

        // Precio de los metros no construidos (calculado desde Inmueble)
        long precioNoConstruido = casa.precioMetroCuadrado();

        // Precio de los metros construidos
        long precioConstruido = casa.precioMetroCuadradoConstruido();

        // Suma de precios de metros construidos y no construidos
        long precioTotalBase = precioNoConstruido + precioConstruido;

        // Cálculo final: suma los precios de metros construidos y no construidos, y aplica el factor sectorial
        double precioFinal = precioTotalBase * multSector;

        return (long) (precioFinal + precioCasa);  // Suma el precio total ajustado con el valor de la casa
    }



    // Mostrar todos las listas

    public List<Object> obtenerTodasLasPropiedades() {
        List<Object> propiedades = new ArrayList<>();
        propiedades.addAll(casas);
        propiedades.addAll(departamentos);
        propiedades.addAll(terrenos);
        return propiedades;
    }

    public double calcPrecioAgregadoSector() {
        String charClase = this.getClase();

        /* Mas demanda MAS precio */

        return switch (charClase) { /*entre mas alta la demanda de comuna mas alta la clase de zona*/
            case "A" -> 2.0;  // Clase alta, gran impacto
            case "B" -> 1.5;
            case "C" -> 1.2;
            case "D" -> 1.0;
            case "E" -> 0.8;
            case "F" -> 0.5;  // Clase baja, menor impacto
            default -> 0.0;
        };
    }

    /* Persistencia de Datos */

    public void guardarCambios() {
        try {
            guardarPropiedadesCSV("db/comuna_" + this.id + "_propiedades.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarPropiedadesCSV(String filePath) throws IOException {
        File file = new File(filePath);
        File directory = file.getParentFile(); // Obtiene el directorio donde se guardará el archivo

        // Verificar si el directorio existe, si no, lo crea
        if (directory != null && !directory.exists()) {
            directory.mkdirs(); // Crear el directorio si no existe
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Guardar las casas
            for (Casa casa : casas) {
                String[] record = {"Casa", String.valueOf(casa.getId()), casa.getDireccion(), String.valueOf(casa.getPrecio()), // Cambiado a long
                        String.valueOf(casa.getMts2()), String.valueOf(casa.getNumHabitaciones()),
                        String.valueOf(casa.getNumBanios()), String.valueOf(casa.getNumEstacionamiento()),
                        String.valueOf(casa.getMts2Construidos()), String.valueOf(casa.isTienePatio())};
                writer.writeNext(record);
            }

            // Guardar los departamentos
            for (Departamento departamento : departamentos) {
                String[] record = {"Departamento", String.valueOf(departamento.getId()), departamento.getDireccion(),
                        String.valueOf(departamento.getPrecio()), // Cambiado a long
                        String.valueOf(departamento.getMts2()), String.valueOf(departamento.getNumHabitaciones()),
                        String.valueOf(departamento.getNumBanos()), String.valueOf(departamento.getPiso()),
                        String.valueOf(departamento.isTieneEstacionamiento()), String.valueOf(departamento.isTieneBodega())};
                writer.writeNext(record);
            }

            // Guardar los terrenos
            for (Terreno terreno : terrenos) {
                String[] record = {"Terreno", String.valueOf(terreno.getId()), terreno.getDireccion(),
                        String.valueOf(terreno.getPrecio()), // Cambiado a long
                        String.valueOf(terreno.getMts2()), String.valueOf(terreno.isTieneServicioAgua()),
                        String.valueOf(terreno.isTieneServicioLuz()), String.valueOf(terreno.isTieneServicioGas())};
                writer.writeNext(record);
            }
        }
    }


    public void cargarPropiedadesCSV(String filePath) throws IOException {
        File file = new File(filePath);

        // Verificar si el archivo existe, si no, lo crea vacío
        if (!file.exists()) {
            System.out.println("El archivo " + filePath + " no existe, creando un archivo nuevo...");
            file.createNewFile(); // Crear el archivo si no existe
            return; // No hay nada que cargar si el archivo es nuevo
        }

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String tipo = nextLine[0];
                int id = Integer.parseInt(nextLine[1]);
                String direccion = nextLine[2];
                long precio = Long.parseLong(nextLine[3]); // Leer como long
                double mts2 = Double.parseDouble(nextLine[4]);

                switch (tipo) {
                    case "Casa":
                        int numHabitaciones = Integer.parseInt(nextLine[5]);
                        int numBanios = Integer.parseInt(nextLine[6]);
                        int numEstacionamiento = Integer.parseInt(nextLine[7]);
                        int mts2Construidos = Integer.parseInt(nextLine[8]);
                        boolean tienePatio = Boolean.parseBoolean(nextLine[9]);
                        casas.add(new Casa(id, precio, direccion, mts2, numHabitaciones, numBanios, numEstacionamiento, mts2Construidos, tienePatio));
                        break;
                    case "Departamento":
                        int numHabitacionesDep = Integer.parseInt(nextLine[5]);
                        int numBaniosDep = Integer.parseInt(nextLine[6]);
                        int piso = Integer.parseInt(nextLine[7]);
                        boolean tieneEstacionamiento = Boolean.parseBoolean(nextLine[8]);
                        boolean tieneBodega = Boolean.parseBoolean(nextLine[9]);
                        departamentos.add(new Departamento(id, precio, direccion, mts2, numHabitacionesDep, numBaniosDep, piso, tieneEstacionamiento, tieneBodega));
                        break;
                    case "Terreno":
                        boolean tieneAgua = Boolean.parseBoolean(nextLine[5]);
                        boolean tieneLuz = Boolean.parseBoolean(nextLine[6]);
                        boolean tieneGas = Boolean.parseBoolean(nextLine[7]);
                        terrenos.add(new Terreno(id, precio, direccion, mts2, tieneAgua, tieneLuz, tieneGas));
                        break;
                }
            }
        } catch (CsvValidationException e) {
            throw new IOException("Error al validar el archivo CSV", e);
        }
    }

    public Casa obtenerCasaPorId(int idCasa) {
        for (Casa casa : this.casas) {
            if (casa.getId() == idCasa) {
                return casa;
            }
        }
        return null;
    }

    public List<Integer> obtenerIdsCasas() {
        return casas.stream().map(Casa::getId).collect(Collectors.toList());
    }

    public List<Departamento> obtenerTodosLosDepartamentos() {
        return new ArrayList<>(departamentos);
    }

    public List<Terreno> obtenerTodosLosTerrenos() {
        return new ArrayList<>(this.terrenos);
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + "\n" +
                "Nombre: " + this.getNombre() + "\n" +
                "Clase: " + this.getClase() + "\n" +
                "Total Inmuebles: " + (departamentos.size() + casas.size() + terrenos.size()) + "\n";
    }

    public String toString(boolean incluirInfoAdicional) {
        if (incluirInfoAdicional) {
            return toString() + "\n" +
                    "Departamentos: " + departamentos.size() + "\n" +
                    "Casas: " + casas.size() + "\n" +
                    "Terrenos: " + terrenos.size() + "\n";
        } else {
            return toString();
        }
    }


}