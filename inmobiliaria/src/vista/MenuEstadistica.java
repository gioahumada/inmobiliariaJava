/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Clase que representa el menú de estadísticas de la aplicación de Inmobiliaria.
 * Permite visualizar estadísticas de comunas y propiedades.
 * Extiende de JFrame.
 *
 * @author gioahumada
 */
public class MenuEstadistica extends javax.swing.JFrame {
    private Inmobiliaria inmobiliaria;

    /**
     * Crea una nueva instancia de MenuEstadistica.
     *
     * @param inmobiliaria la instancia de Inmobiliaria utilizada para obtener datos.
     */
    public MenuEstadistica(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // Deshabilitar el cambio de tamaño
        setTitle("Inmobiliaria Java - Menú Estadistica");
        Image icon = new ImageIcon(getClass().getResource("/img/favicon.png")).getImage();
        setIconImage(icon);
    }

    /**
     * Este método es llamado desde el constructor para inicializar el formulario.
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
        datosComuna = new javax.swing.JButton();
        datosPropiedades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

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
        jLabel4.setText("Menú Estadísticas");

        datosComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/datosComuna.png"))); // NOI18N
        datosComuna.setBorder(null);
        datosComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datosComunaActionPerformed(evt);
            }
        });

        datosPropiedades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/datosPropiedades.png"))); // NOI18N
        datosPropiedades.setBorder(null);
        datosPropiedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datosPropiedadesActionPerformed(evt);
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
                                                                .addComponent(datosComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(datosPropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(datosComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(datosPropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 313, Short.MAX_VALUE))
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
     * Acción a realizar cuando se selecciona el botón de datos de comuna.
     *
     * @param evt el evento de acción
     */
    private void datosComunaActionPerformed(java.awt.event.ActionEvent evt) {
        // Create a new JFrame to display the data
        JFrame frame = new JFrame("Estadísticas de Comunas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the window

        // Create a panel to hold the data
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Fetch the data from the Inmobiliaria instance
        StringBuilder data = new StringBuilder();
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        // Calculate statistics
        int totalComunas = comunas.size();
        int[] tipoCount = new int[6]; // A, B, C, D, E, F
        Comuna maxPropiedadesComuna = null;
        int maxPropiedades = 0;

        for (Comuna comuna : comunas) {
            int totalPropiedades = comuna.obtenerTodasLasPropiedades().size();
            if (totalPropiedades > maxPropiedades) {
                maxPropiedades = totalPropiedades;
                maxPropiedadesComuna = comuna;
            }

            switch (comuna.getClase()) {
                case "A" -> tipoCount[0]++;
                case "B" -> tipoCount[1]++;
                case "C" -> tipoCount[2]++;
                case "D" -> tipoCount[3]++;
                case "E" -> tipoCount[4]++;
                case "F" -> tipoCount[5]++;
            }
        }

        // Build the data string
        data.append("Total Comunas: ").append(totalComunas).append("\n");
        data.append("Comuna con más propiedades: ").append(maxPropiedadesComuna != null ? maxPropiedadesComuna.getNombre() : "N/A").append("\n");
        data.append("Cantidad de Comunas por tipo:\n");
        data.append("Tipo A: ").append(tipoCount[0]).append("\n");
        data.append("Tipo B: ").append(tipoCount[1]).append("\n");
        data.append("Tipo C: ").append(tipoCount[2]).append("\n");
        data.append("Tipo D: ").append(tipoCount[3]).append("\n");
        data.append("Tipo E: ").append(tipoCount[4]).append("\n");
        data.append("Tipo F: ").append(tipoCount[5]).append("\n");

        // Create a text area to display the data
        JTextArea textArea = new JTextArea(data.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setMargin(new Insets(10, 10, 10, 10));

        // Add a scroll pane to the text area
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a pie chart for the types of comunas
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Tipo A", tipoCount[0]);
        pieDataset.setValue("Tipo B", tipoCount[1]);
        pieDataset.setValue("Tipo C", tipoCount[2]);
        pieDataset.setValue("Tipo D", tipoCount[3]);
        pieDataset.setValue("Tipo E", tipoCount[4]);
        pieDataset.setValue("Tipo F", tipoCount[5]);

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Distribución de Comunas por Tipo",
                pieDataset,
                true, true, false);

        ChartPanel pieChartPanel = new ChartPanel(pieChart);

        // Create a bar chart for the number of properties in each comuna
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        for (Comuna comuna : comunas) {
            barDataset.addValue(comuna.obtenerTodasLasPropiedades().size(), "Propiedades", comuna.getNombre());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Número de Propiedades por Comuna",
                "Comuna",
                "Número de Propiedades",
                barDataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Set bar color to orange
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0xFF8C00));

        ChartPanel barChartPanel = new ChartPanel(barChart);

        // Add components to the panel
        panel.add(scrollPane, BorderLayout.NORTH);
        panel.add(pieChartPanel, BorderLayout.CENTER);
        panel.add(barChartPanel, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.add(panel);

        // Display the frame
        frame.setVisible(true);
    }

    /**
     * Acción a realizar cuando se selecciona el botón de datos de propiedades.
     *
     * @param evt el evento de acción
     */
    private void datosPropiedadesActionPerformed(java.awt.event.ActionEvent evt) {
        // Fetch all available Comunas
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        // Create an array of Comuna names for the dropdown
        String[] comunaNames = comunas.stream().map(Comuna::getNombre).toArray(String[]::new);

        // Display a dropdown for the user to select a Comuna
        String selectedComunaName = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione la Comuna que desea revisar:",
                "Seleccionar Comuna",
                JOptionPane.QUESTION_MESSAGE,
                null,
                comunaNames,
                comunaNames[0]);

        if (selectedComunaName != null && !selectedComunaName.isEmpty()) {
            // Find the selected Comuna by name
            Comuna selectedComuna = comunas.stream()
                    .filter(comuna -> comuna.getNombre().equals(selectedComunaName))
                    .findFirst()
                    .orElse(null);

            if (selectedComuna != null) {
                int numCasas = (int) selectedComuna.obtenerTodasLasPropiedades().stream().filter(p -> p instanceof Casa).count();
                int numDepartamentos = (int) selectedComuna.obtenerTodasLasPropiedades().stream().filter(p -> p instanceof Departamento).count();
                int numTerrenos = (int) selectedComuna.obtenerTodasLasPropiedades().stream().filter(p -> p instanceof Terreno).count();

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.addValue(numCasas, "Cantidad", "Casas");
                dataset.addValue(numDepartamentos, "Cantidad", "Departamentos");
                dataset.addValue(numTerrenos, "Cantidad", "Terrenos");

                JFreeChart barChart = ChartFactory.createBarChart(
                        "Estadísticas de Propiedades de la Comuna " + selectedComuna.getNombre(),
                        "Tipo de Propiedad",
                        "Cantidad",
                        dataset,
                        PlotOrientation.VERTICAL,
                        false, true, false);

                // Set bar color to orange
                CategoryPlot plot = barChart.getCategoryPlot();
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setSeriesPaint(0, new Color(0xFF8C00));

                ChartPanel chartPanel = new ChartPanel(barChart);
                chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

                JFrame frame = new JFrame("Estadísticas de Propiedades");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(chartPanel);
                frame.pack();
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la comuna seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(MenuEstadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEstadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEstadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEstadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new MenuEstadistica(inmobiliaria).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton datosComuna;
    private javax.swing.JButton datosPropiedades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration
}
