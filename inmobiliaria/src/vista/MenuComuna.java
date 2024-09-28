/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase que representa el menú de Comuna en la aplicación de Inmobiliaria.
 * Permite mostrar, ver, agregar y eliminar comunas.
 * Extiende de {@link javax.swing.JFrame}.
 *
 * @autor gioahumada
 */
public class MenuComuna extends javax.swing.JFrame {
    private Inmobiliaria inmobiliaria;

    /**
     * Crea una nueva instancia de MenuComuna.
     *
     * @param inmobiliaria la instancia de Inmobiliaria utilizada para gestionar las comunas.
     */
    public MenuComuna(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // Deshabilitar el cambio de tamaño
        setTitle("Inmobiliaria Java - Menú Comuna");
        Image icon = new ImageIcon(getClass().getResource("/img/favicon.png")).getImage();
        setIconImage(icon);
    }

    /**
     * Este método es llamado desde el constructor para inicializar los componentes del formulario.
     * ADVERTENCIA: No modificar este código. El contenido de este método es siempre
     * regenerado por el Editor de Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        mostrarComuna = new javax.swing.JButton();
        verComuna = new javax.swing.JButton();
        agregarComuna = new javax.swing.JButton();
        eliminarComuna = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/faviconwhite.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setText("Menú Comuna");

        mostrarComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mostrarComunas.png"))); // NOI18N
        mostrarComuna.setBorder(null);
        mostrarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarComunaActionPerformed(evt);
            }
        });

        verComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verComuna.png"))); // NOI18N
        verComuna.setBorder(null);
        verComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verComunaActionPerformed(evt);
            }
        });

        agregarComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregarComuna.png"))); // NOI18N
        agregarComuna.setBorder(null);
        agregarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarComunaActionPerformed(evt);
            }
        });

        eliminarComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminarComuna.png"))); // NOI18N
        eliminarComuna.setBorder(null);
        eliminarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarComunaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(agregarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(eliminarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(mostrarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(verComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mostrarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(verComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(agregarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(eliminarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 201, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    /**
     * Acción a realizar cuando se selecciona el botón de mostrar comunas.
     *
     * @param evt el evento de acción
     */
    private void mostrarComunaActionPerformed(java.awt.event.ActionEvent evt) {
        // Retrieve the list of all Comunas
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        // Create a new JFrame to display the Comunas
        JFrame frame = new JFrame("Lista de Comunas");
        Image icon = new ImageIcon(getClass().getResource("/img/favicon.png")).getImage();
        frame.setIconImage(icon);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Define column names for the table
        String[] columnNames = {"ID", "Nombre", "Clase", "Total Inmuebles"};

        // Create data array for the table
        Object[][] data = new Object[comunas.size()][4];
        StringBuilder informacionAExportar = new StringBuilder(); // StringBuilder to accumulate the data for export

        informacionAExportar.append("ID\tNombre\tClase\tTotal Inmuebles\n"); // Column headers in the export file
        for (int i = 0; i < comunas.size(); i++) {
            Comuna comuna = comunas.get(i);
            data[i][0] = comuna.getId();
            data[i][1] = comuna.getNombre();
            data[i][2] = comuna.getClase();
            data[i][3] = comuna.obtenerTodasLasPropiedades().size();

            // Append the data for each Comuna to the StringBuilder
            informacionAExportar.append(data[i][0]).append("\t")
                    .append(data[i][1]).append("\t")
                    .append(data[i][2]).append("\t")
                    .append(data[i][3]).append("\n");
        }

        // Create the table with the data and column names
        JTable table = new JTable(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are not editable
            }
        };

        // Set the font for the table
        Font projectFont = new Font("Helvetica Neue", Font.PLAIN, 12); // Adjust as needed
        table.setFont(projectFont);
        table.setFillsViewportHeight(true);

        // Customize the table header
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(new Color(255, 165, 0)); // Orange color for the header
                return c;
            }
        });

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the "Exportar a TXT" button
        JButton exportButton = new JButton("Exportar...");
        exportButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar como");
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave + ".txt"))) {
                    writer.write(informacionAExportar.toString());
                    JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add the JScrollPane and button to the JFrame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(exportButton, BorderLayout.SOUTH);

        // Make the JFrame visible
        frame.setVisible(true);
    }

    /**
     * Acción a realizar cuando se selecciona el botón de ver comuna.
     *
     * @param evt el evento de acción
     */
    private void verComunaActionPerformed(java.awt.event.ActionEvent evt) {
        // Preguntar si desea ver todos los datos
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea ver todos los datos?", "Ver Todos los Datos", JOptionPane.YES_NO_OPTION);
        boolean verTodosLosDatos = (respuesta == JOptionPane.YES_OPTION);

        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        if (comunas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay comunas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un array de nombres de comunas
        String[] nombresComunas = comunas.stream().map(Comuna::getNombre).toArray(String[]::new);

        // Mostrar un JComboBox con los nombres de las comunas
        String nombreComunaSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione una Comuna:",
                "Ver Comuna", JOptionPane.QUESTION_MESSAGE, null, nombresComunas, nombresComunas[0]);

        if (nombreComunaSeleccionada != null) {
            // Buscar la comuna seleccionada por nombre
            Comuna comunaSeleccionada = comunas.stream()
                    .filter(comuna -> comuna.getNombre().equals(nombreComunaSeleccionada))
                    .findFirst()
                    .orElse(null);

            if (comunaSeleccionada != null) {
                // Crear un nuevo JFrame para mostrar los detalles de la comuna
                JFrame frame = new JFrame("Detalles de la Comuna");
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                // Crear un JPanel para los detalles de la comuna
                JPanel detailsPanel = new JPanel();
                detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
                detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // Añadir los detalles de la comuna
                String detallesComuna = "<html><b>Detalles de la Comuna:</b><br>" + comunaSeleccionada.toString(verTodosLosDatos) + "</html>";
                JLabel detailsLabel = new JLabel(detallesComuna);
                detailsPanel.add(detailsLabel);

                // Crear un JPanel para las propiedades
                JPanel propertiesPanel = new JPanel();
                propertiesPanel.setLayout(new BoxLayout(propertiesPanel, BoxLayout.Y_AXIS));

                StringBuilder informacionAExportar = new StringBuilder();
                informacionAExportar.append("Detalles de la Comuna:").append("\n").append(comunaSeleccionada.toString(verTodosLosDatos)).append("\n");

                // Añadir las propiedades al panel
                List<Object> propiedades = comunaSeleccionada.obtenerTodasLasPropiedades();
                if (propiedades.isEmpty()) {
                    propertiesPanel.add(new JLabel("No hay propiedades registradas en esta comuna."));
                    informacionAExportar.append("No hay propiedades registradas en esta comuna.\n");
                } else {
                    for (Object propiedad : propiedades) {
                        JPanel propertyPanel = new JPanel();
                        propertyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                        // Determine the icon based on the property type
                        String iconPath = "/img/favicon.png"; // Default icon
                        String propertyDetails = "";
                        if (propiedad instanceof Casa) {
                            iconPath = "/img/casa.png";
                            propertyDetails = ((Casa) propiedad).toString(verTodosLosDatos);
                        } else if (propiedad instanceof Departamento) {
                            iconPath = "/img/departamento.png";
                            propertyDetails = ((Departamento) propiedad).toString(verTodosLosDatos);
                        } else if (propiedad instanceof Terreno) {
                            iconPath = "/img/terreno.png";
                            propertyDetails = ((Terreno) propiedad).toString(verTodosLosDatos);
                        }

                        JLabel iconLabel = new JLabel(new ImageIcon(getClass().getResource(iconPath)));
                        JLabel propertyLabel = new JLabel(propertyDetails);
                        propertyPanel.add(iconLabel);
                        propertyPanel.add(propertyLabel);
                        propertiesPanel.add(propertyPanel);

                        // Añadir la propiedad al StringBuilder para exportar
                        informacionAExportar.append(propertyDetails).append("\n");
                    }
                }

                // Añadir el panel de propiedades a un JScrollPane
                JScrollPane scrollPane = new JScrollPane(propertiesPanel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                // Crear un botón de "Exportar..."
                JButton exportButton = new JButton("Exportar...");
                exportButton.addActionListener(e -> {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Guardar como");
                    int userSelection = fileChooser.showSaveDialog(null);

                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave + ".txt"))) {
                            writer.write(informacionAExportar.toString());
                            JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente.");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // Añadir los paneles y el botón al frame
                frame.add(detailsPanel, BorderLayout.NORTH);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.add(exportButton, BorderLayout.SOUTH);

                // Hacer visible el frame
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Comuna no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Acción a realizar cuando se selecciona el botón de agregar comuna.
     *
     * @param evt el evento de acción
     */
    private void agregarComunaActionPerformed(java.awt.event.ActionEvent evt) {
        // Retrieve the Inmobiliaria instance
        Inmobiliaria inmobiliaria = this.inmobiliaria;

        // Prompt the user to enter the details for the new Comuna
        String idStr = JOptionPane.showInputDialog(this, "Ingrese ID de la Comuna:");
        if (idStr != null)
        {
            try{
                int idd= Integer.parseInt(idStr.trim());
                // Check if the ID already exists
                if (inmobiliaria.existeComunaConId(idd)) {
                    JOptionPane.showMessageDialog(this, "El ID " + idd + " ya existe. Por favor, ingrese otro ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "ID de Comuna inválido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String nombre = JOptionPane.showInputDialog(this, "Ingrese Nombre de la Comuna:");

        if (idStr != null && nombre != null && !idStr.trim().isEmpty() && !nombre.trim().isEmpty()) {
            // Prompt the user to select the Clase of the Comuna
            String[] options = {"A", "B", "C", "D", "E", "F"};
            String clase = (String) JOptionPane.showInputDialog(this, "Seleccione Clase de la Comuna:", "Clase de la Comuna",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (clase != null) {
                try {
                    int id = Integer.parseInt(idStr.trim());

                    // Add the new Comuna to the Inmobiliaria instance
                    inmobiliaria.agregarComuna(id, nombre, clase);

                    // Display a confirmation message
                    JOptionPane.showMessageDialog(this, "Comuna añadida exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID de Comuna inválido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una clase", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Acción a realizar cuando se selecciona el botón de eliminar comuna.
     *
     * @param evt el evento de acción
     */
    private void eliminarComunaActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener todas las comunas
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        if (comunas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay comunas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un array de nombres de comunas
        String[] nombresComunas = comunas.stream().map(Comuna::getNombre).toArray(String[]::new);

        // Mostrar un JComboBox con los nombres de las comunas
        String nombreComunaSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione una Comuna para eliminar:",
                "Eliminar Comuna", JOptionPane.QUESTION_MESSAGE, null, nombresComunas, nombresComunas[0]);

        if (nombreComunaSeleccionada != null) {
            // Buscar la comuna seleccionada por nombre
            Comuna comunaSeleccionada = comunas.stream()
                    .filter(comuna -> comuna.getNombre().equals(nombreComunaSeleccionada))
                    .findFirst()
                    .orElse(null);

            if (comunaSeleccionada != null) {
                // Eliminar la comuna seleccionada
                boolean success = inmobiliaria.eliminarComunaPorId(comunaSeleccionada.getId());

                if (success) {
                    // Mostrar un mensaje de confirmación
                    JOptionPane.showMessageDialog(this, "Comuna eliminada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Mostrar un mensaje de error si la comuna no fue encontrada
                    JOptionPane.showMessageDialog(this, "Comuna no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Comuna no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuComuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuComuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuComuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuComuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inmobiliaria inmobiliaria = new Inmobiliaria();
                new MenuComuna(inmobiliaria).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton agregarComuna;
    private javax.swing.JButton eliminarComuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton mostrarComuna;
    private javax.swing.JButton verComuna;
    // End of variables declaration
}
