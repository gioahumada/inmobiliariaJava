import modelo.Inmobiliaria;
import java.io.IOException;
import vista.Login;
import vista.MenuToolBox;

import javax.swing.*;

public class App {
    public static void main(String[] args) {    
        Inmobiliaria inmobiliaria = new Inmobiliaria(); /* Nucleo */

        try {
            inmobiliaria.cargarUsuariosCSV("db/usuarios.csv");
            inmobiliaria.cargarComunasCSV("db/comunas.csv");
        } catch (IOException e) {
            e.printStackTrace(); /* Imprime el error en consola */
        }


        Login login = new Login(inmobiliaria); /* Iniciar Vista - Login*/
        login.setVisible(true);

        if (!inmobiliaria.hasRegisteredUsers()) { /* Si no hay usuarios, aparece menú para registrar Usuario. */
            ImageIcon icon = new ImageIcon("img/iconJ.png");
            JOptionPane.showMessageDialog(null, "¡Bienvenido a la aplicación InmobiliariaJava!\nRecuerda crear tu primer usuario como administrador.", "Bienvenida", JOptionPane.INFORMATION_MESSAGE, icon);
            MenuToolBox menuToolBox = new MenuToolBox(inmobiliaria);
            menuToolBox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            menuToolBox.setVisible(true);
        }
    }
}