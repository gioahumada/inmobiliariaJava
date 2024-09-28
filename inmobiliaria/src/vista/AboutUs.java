package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * La clase AboutUs representa una ventana que muestra una imagen de "About Us".
 * Extiende JFrame para crear una ventana de aplicación.
 */
public class AboutUs extends JFrame {

    private BufferedImage image;

    /**
     * Constructor de la clase AboutUs.
     * Carga la imagen y configura la ventana.
     */
    public AboutUs() {
        // Cargar la imagen
        try {
            image = ImageIO.read(getClass().getResource("/img/AboutUsImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Configurar la ventana
        setTitle("About Us");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(image.getWidth(), image.getHeight());
        setResizable(false);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Agregar el panel que muestra la imagen
        ImagePanel panel = new ImagePanel();
        add(panel);

        // Mostrar la ventana
        setVisible(true);
    }

    /**
     * La clase ImagePanel es un JPanel personalizado que se utiliza para mostrar la imagen.
     */
    private class ImagePanel extends JPanel {
        /**
         * Sobrescribe el método paintComponent para dibujar la imagen en el panel.
         *
         * @param g el contexto gráfico en el que se dibuja la imagen
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }

        /**
         * Sobrescribe el método getPreferredSize para devolver el tamaño preferido del panel.
         *
         * @return las dimensiones preferidas del panel
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(image.getWidth(), image.getHeight());
        }
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AboutUs::new);
    }
}