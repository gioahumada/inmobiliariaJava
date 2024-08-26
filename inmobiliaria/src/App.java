import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        PropiedadCSV propiedadCSV = new PropiedadCSV();
        Scanner scanner = new Scanner(System.in);

        
        while (true) {
            System.out.println("Sistema de Gestión de Propiedades");
            System.out.println("1. Agregar Propiedad");
            System.out.println("2. Leer Propiedades");
            System.out.println("3. Actualizar Propiedad");
            System.out.println("4. Eliminar Propiedad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        System.out.print("Ingrese Dirección: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Ingrese Precio: ");
                        double precio = scanner.nextDouble();
                        Propiedad nuevaPropiedad = new Propiedad(id, direccion, precio);
                        propiedadCSV.agregarPropiedad(nuevaPropiedad);
                        System.out.println("Propiedad agregada exitosamente.");
                        break;
                    case 2:
                        List<Propiedad> propiedades = propiedadCSV.leerPropiedades();
                        for (Propiedad p : propiedades) {
                            System.out.println(p.mostrarFormateado());
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese ID de la propiedad a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        System.out.print("Ingrese nueva Dirección: ");
                        String nuevaDireccion = scanner.nextLine();
                        System.out.print("Ingrese nuevo Precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        Propiedad propiedadActualizada = new Propiedad(idActualizar, nuevaDireccion, nuevoPrecio);
                        propiedadCSV.actualizarPropiedad(propiedadActualizada);
                        System.out.println("Propiedad actualizada exitosamente.");
                        break;
                    case 4:
                        System.out.print("Ingrese ID de la propiedad a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        propiedadCSV.eliminarPropiedad(idEliminar);
                        System.out.println("Propiedad eliminada exitosamente.");
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }
}