import modelo.Inmobiliaria;
import vista.InmobiliariaVista;
import java.io.IOException;
import vista.Login;
import vista.MenuToolBox;

import javax.swing.*;

public class App {
    public static void main(String[] args) {    
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        InmobiliariaVista vista = new InmobiliariaVista(inmobiliaria);

        try {
            inmobiliaria.cargarUsuariosCSV("db/usuarios.csv");
            inmobiliaria.cargarComunasCSV("db/comunas.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Login login = new Login(inmobiliaria);
        login.setVisible(true);

        if (!inmobiliaria.hasRegisteredUsers()) {
            ImageIcon icon = new ImageIcon("img/iconJ.png");
            JOptionPane.showMessageDialog(null, "¡Bienvenido a la aplicación InmobiliariaJava!\nRecuerda crear tu primer usuario como administrador.", "Bienvenida", JOptionPane.INFORMATION_MESSAGE, icon);
            MenuToolBox menuToolBox = new MenuToolBox(inmobiliaria);
            menuToolBox.setVisible(true);
        }
    }
}