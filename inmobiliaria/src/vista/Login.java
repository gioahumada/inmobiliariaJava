// src/vista/Login.java
package vista;

import modelo.Inmobiliaria;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JDialog {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JButton logAsGuessButton;
    private JPanel loginPanel;
    private Inmobiliaria inmobiliaria;

    public Login(JFrame parent, Inmobiliaria inmobiliaria) {
        super(parent);
        this.inmobiliaria = inmobiliaria;
        setTitle("InmobiliariaJava - Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(570, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        logAsGuessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuestLogin();
            }
        });

        setVisible(true);
    }

    private void handleLogin() {
        String username = userField.getText();
        String password = new String(passwordField.getPassword());

        Usuario usuario = inmobiliaria.obtenerUsuario(username);
        if (usuario != null && usuario.verificarContraseña(password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose(); // Close the login dialog
            // Proceed to the next step in the application
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleGuestLogin() {
        JOptionPane.showMessageDialog(this, "Logged in as guest");
        dispose(); // Close the login dialog
        // Proceed to the next step in the application
    }

    public static void main(String[] args) {
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        // Load users from CSV or other data source
        try {
            inmobiliaria.cargarUsuariosCSV("usuarios.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Login(null, inmobiliaria);
    }
}