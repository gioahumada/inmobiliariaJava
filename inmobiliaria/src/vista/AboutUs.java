package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AboutUs extends JFrame {

    private BufferedImage image;

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

    private class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(image.getWidth(), image.getHeight());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AboutUs::new);
    }
}