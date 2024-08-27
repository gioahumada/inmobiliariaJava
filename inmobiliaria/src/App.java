public class App {
    public static void main(String[] args) {
        PropiedadCSV propiedadCSV = new PropiedadCSV();
        MenuVista menuVista = new MenuVista();
        MenuControl menuController = new MenuControl(propiedadCSV, menuVista);
        menuController.iniciar();
    }
}