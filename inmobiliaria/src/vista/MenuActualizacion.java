/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Clase que representa el menú de actualización de datos en la aplicación de Inmobiliaria.
 * Permite actualizar datos de comunas, casas, departamentos y terrenos.
 * Extiende de {@link javax.swing.JFrame}.
 *
 * @author gioahumada
 */
public class MenuActualizacion extends javax.swing.JFrame {
    private Inmobiliaria inmobiliaria;

    /**
     * Crea una nueva instancia de MenuActualizacion.
     *
     * @param inmobiliaria la instancia de la clase Inmobiliaria que contiene los datos a actualizar
     */
    public MenuActualizacion(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // Deshabilitar el cambio de tamaño
        setTitle("Inmobiliaria Java - Actualizar Datos");
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
        actualizarComuna = new javax.swing.JButton();
        actualizarCasa = new javax.swing.JButton();
        actualizarDepartamento = new javax.swing.JButton();
        actualizarTerreno = new javax.swing.JButton();

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
        jLabel4.setText("Menú Actualizar Datos");

        actualizarComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/updateComuna.png"))); // NOI18N
        actualizarComuna.setBorder(null);
        actualizarComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarComunaActionPerformed(evt);
            }
        });

        actualizarCasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/updateCasa.png"))); // NOI18N
        actualizarCasa.setBorder(null);
        actualizarCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarCasaActionPerformed(evt);
            }
        });

        actualizarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/updateDepto.png"))); // NOI18N
        actualizarDepartamento.setBorder(null);
        actualizarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarDepartamentoActionPerformed(evt);
            }
        });

        actualizarTerreno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/updateTerreno.png"))); // NOI18N
        actualizarTerreno.setBorder(null);
        actualizarTerreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarTerrenoActionPerformed(evt);
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
                                                                                .addComponent(actualizarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(actualizarTerreno, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(actualizarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(actualizarCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                        .addComponent(actualizarComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(actualizarCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(actualizarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(actualizarTerreno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
     * Acción realizada al hacer clic en el botón de actualizar comuna.
     * Muestra un cuadro de diálogo para seleccionar y actualizar una comuna.
     *
     * @param evt el evento de acción
     */
    private void actualizarComunaActionPerformed(java.awt.event.ActionEvent evt) {
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        if (comunas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay comunas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un array de nombres de comunas
        String[] nombresComunas = comunas.stream().map(Comuna::getNombre).toArray(String[]::new);

        // Mostrar un JComboBox con los nombres de las comunas
        String nombreComunaSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione una Comuna:",
                "Actualizar Comuna", JOptionPane.QUESTION_MESSAGE, null, nombresComunas, nombresComunas[0]);

        if (nombreComunaSeleccionada != null) {
            // Buscar la comuna seleccionada por nombre
            Comuna comunaSeleccionada = comunas.stream()
                    .filter(comuna -> comuna.getNombre().equals(nombreComunaSeleccionada))
                    .findFirst()
                    .orElse(null);

            if (comunaSeleccionada != null) {
                // Solicitar nuevos datos de la Comuna
                String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese nuevo Nombre de la Comuna:", comunaSeleccionada.getNombre());
                String nuevaClase = JOptionPane.showInputDialog(this, "Ingrese nueva Clase de la Comuna:", comunaSeleccionada.getClase());

                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty() && nuevaClase != null && !nuevaClase.trim().isEmpty()) {
                    comunaSeleccionada.setNombre(nuevoNombre.trim());
                    comunaSeleccionada.setClase(nuevaClase.trim());
                    JOptionPane.showMessageDialog(this, "Comuna actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Nombre o Clase no pueden estar vacíos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Comuna no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Acción realizada al hacer clic en el botón de actualizar casa.
     * Muestra un cuadro de diálogo para seleccionar y actualizar una casa.
     *
     * @param evt el evento de acción
     */
    private void actualizarCasaActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener todas las comunas
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        if (comunas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay comunas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un array de nombres de comunas
        String[] nombresComunas = comunas.stream().map(Comuna::getNombre).toArray(String[]::new);

        // Mostrar un JComboBox con los nombres de las comunas
        String nombreComunaSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione una Comuna:",
                "Actualizar Casa", JOptionPane.QUESTION_MESSAGE, null, nombresComunas, nombresComunas[0]);

        if (nombreComunaSeleccionada != null) {
            // Buscar la comuna seleccionada por nombre
            Comuna comunaSeleccionada = comunas.stream()
                    .filter(comuna -> comuna.getNombre().equals(nombreComunaSeleccionada))
                    .findFirst()
                    .orElse(null);

            if (comunaSeleccionada != null) {
                // Obtener los IDs de las casas en la comuna seleccionada
                String[] idsCasas = comunaSeleccionada.obtenerIdsCasas().stream().map(String::valueOf).toArray(String[]::new);

                if (idsCasas.length == 0) {
                    JOptionPane.showMessageDialog(this, "No hay casas disponibles para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Mostrar un JComboBox con los IDs de las casas
                String idCasaSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione el ID de la casa:",
                        "Actualizar Casa", JOptionPane.QUESTION_MESSAGE, null, idsCasas, idsCasas[0]);

                if (idCasaSeleccionada != null) {
                    int idCasa = Integer.parseInt(idCasaSeleccionada.trim());
                    Casa casa = comunaSeleccionada.obtenerCasaPorId(idCasa);

                    if (casa != null) {
                        // Solicitar nuevos datos de la Casa
                        String direccion = JOptionPane.showInputDialog(this, "Ingrese nueva Dirección:", casa.getDireccion());
                        String mts2Str = JOptionPane.showInputDialog(this, "Ingrese nuevos Metros Cuadrados:", casa.getMts2());
                        double mts2 = Double.parseDouble(mts2Str.trim());
                        String numHabitacionesStr = JOptionPane.showInputDialog(this, "Ingrese nuevo Número de Habitaciones:", casa.getNumHabitaciones());
                        int numHabitaciones = Integer.parseInt(numHabitacionesStr.trim());
                        String numBaniosStr = JOptionPane.showInputDialog(this, "Ingrese nuevo Número de Baños:", casa.getNumBanios());
                        int numBanios = Integer.parseInt(numBaniosStr.trim());
                        String numEstacionamientoStr = JOptionPane.showInputDialog(this, "Ingrese nuevo Número de Estacionamientos:", casa.getNumEstacionamiento());
                        int numEstacionamiento = Integer.parseInt(numEstacionamientoStr.trim());
                        String mts2ConstruidosStr = JOptionPane.showInputDialog(this, "Ingrese nuevos Metros Cuadrados Construidos:", casa.getMts2Construidos());
                        int mts2Construidos = Integer.parseInt(mts2ConstruidosStr.trim());

                        // Menú desplegable para seleccionar si tiene patio
                        String[] opcionesPatio = {"Sí", "No"};
                        String tienePatioStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Patio?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, opcionesPatio, casa.isTienePatio() ? "Sí" : "No");
                        boolean tienePatio = "Sí".equals(tienePatioStr);

                        // Actualizar la Casa
                        casa.setDireccion(direccion);
                        casa.setMts2(mts2);
                        casa.setNumHabitaciones(numHabitaciones);
                        casa.setNumBanios(numBanios);
                        casa.setNumEstacionamiento(numEstacionamiento);
                        casa.setMts2Construidos(mts2Construidos);
                        casa.setTienePatio(tienePatio);

                        // Calcular el nuevo precio
                        long precio = comunaSeleccionada.precioFinalCasa(comunaSeleccionada, casa);
                        casa.setPrecio(precio);

                        // Mostrar el precio calculado y preguntar si desea cambiarlo
                        int respuesta = JOptionPane.showConfirmDialog(this, "El precio calculado es: " + precio + "\n¿Desea mantener este precio?", "Confirmar Precio", JOptionPane.YES_NO_OPTION);
                        if (respuesta == JOptionPane.NO_OPTION) {
                            String precioManualStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo precio:");
                            try {
                                long precioManual = Long.parseLong(precioManualStr.trim());
                                casa.setPrecio(precioManual);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(this, "Precio inválido, se mantendrá el precio calculado.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        // Mostrar mensaje de confirmación
                        JOptionPane.showMessageDialog(this, "Casa actualizada con precio: " + casa.getPrecio(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Casa no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Comuna no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Acción realizada al hacer clic en el botón de actualizar departamento.
     * Muestra un cuadro de diálogo para seleccionar y actualizar un departamento.
     *
     * @param evt el evento de acción
     */
    private void actualizarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener todas las comunas
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        if (comunas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay comunas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un array de nombres de comunas
        String[] nombresComunas = comunas.stream().map(Comuna::getNombre).toArray(String[]::new);

        // Mostrar un JComboBox con los nombres de las comunas
        String nombreComunaSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione una Comuna:",
                "Seleccionar Comuna", JOptionPane.QUESTION_MESSAGE, null, nombresComunas, nombresComunas[0]);

        if (nombreComunaSeleccionada != null) {
            // Buscar la comuna seleccionada por nombre
            Comuna comunaSeleccionada = comunas.stream()
                    .filter(comuna -> comuna.getNombre().equals(nombreComunaSeleccionada))
                    .findFirst()
                    .orElse(null);

            if (comunaSeleccionada != null) {
                // Obtener todos los departamentos de la comuna seleccionada
                List<Departamento> departamentos = comunaSeleccionada.obtenerTodosLosDepartamentos();

                if (departamentos.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay departamentos disponibles en esta comuna", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un array de IDs de departamentos
                Integer[] idsDepartamentos = departamentos.stream().map(Departamento::getId).toArray(Integer[]::new);

                // Mostrar un JComboBox con los IDs de los departamentos
                Integer idDepartamentoSeleccionado = (Integer) JOptionPane.showInputDialog(this, "Seleccione un Departamento:",
                        "Seleccionar Departamento", JOptionPane.QUESTION_MESSAGE, null, idsDepartamentos, idsDepartamentos[0]);

                if (idDepartamentoSeleccionado != null) {
                    // Buscar el departamento seleccionado por ID
                    Departamento departamentoSeleccionado = departamentos.stream()
                            .filter(departamento -> departamento.getId() == idDepartamentoSeleccionado)
                            .findFirst()
                            .orElse(null);

                    if (departamentoSeleccionado != null) {
                        // Solicitar nuevos datos del Departamento
                        String direccion = JOptionPane.showInputDialog(this, "Ingrese nueva Dirección:", departamentoSeleccionado.getDireccion());
                        String mts2Str = JOptionPane.showInputDialog(this, "Ingrese nuevos Metros Cuadrados:", departamentoSeleccionado.getMts2());
                        double mts2 = Double.parseDouble(mts2Str.trim());
                        String numHabitacionesStr = JOptionPane.showInputDialog(this, "Ingrese nuevo Número de Habitaciones:", departamentoSeleccionado.getNumHabitaciones());
                        int numHabitaciones = Integer.parseInt(numHabitacionesStr.trim());
                        String numBaniosStr = JOptionPane.showInputDialog(this, "Ingrese nuevo Número de Baños:", departamentoSeleccionado.getNumBanos());
                        int numBanios = Integer.parseInt(numBaniosStr.trim());
                        String pisoStr = JOptionPane.showInputDialog(this, "Ingrese nuevo Piso:", departamentoSeleccionado.getPiso());
                        int piso = Integer.parseInt(pisoStr.trim());
                        String tieneEstacionamientoStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Estacionamiento?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"}, departamentoSeleccionado.isTieneEstacionamiento() ? "Sí" : "No");
                        boolean tieneEstacionamiento = "Sí".equals(tieneEstacionamientoStr);
                        String tieneBodegaStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Bodega?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"}, departamentoSeleccionado.isTieneBodega() ? "Sí" : "No");
                        boolean tieneBodega = "Sí".equals(tieneBodegaStr);

                        // Actualizar el Departamento
                        departamentoSeleccionado.setDireccion(direccion);
                        departamentoSeleccionado.setMts2(mts2);
                        departamentoSeleccionado.setNumHabitaciones(numHabitaciones);
                        departamentoSeleccionado.setNumBanos(numBanios);
                        departamentoSeleccionado.setPiso(piso);
                        departamentoSeleccionado.setTieneEstacionamiento(tieneEstacionamiento);
                        departamentoSeleccionado.setTieneBodega(tieneBodega);

                        // Calcular el nuevo precio
                        long precio = comunaSeleccionada.precioFinalDepartamento(comunaSeleccionada, departamentoSeleccionado);
                        departamentoSeleccionado.setPrecio(precio);

                        // Mostrar el precio calculado y preguntar si desea cambiarlo
                        int respuesta = JOptionPane.showConfirmDialog(this, "El precio calculado es: " + precio + "\n¿Desea mantener este precio?", "Confirmar Precio", JOptionPane.YES_NO_OPTION);
                        if (respuesta == JOptionPane.NO_OPTION) {
                            String precioManualStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo precio:");
                            try {
                                long precioManual = Long.parseLong(precioManualStr.trim());
                                departamentoSeleccionado.setPrecio(precioManual);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(this, "Precio inválido, se mantendrá el precio calculado.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        // Mostrar mensaje de confirmación
                        JOptionPane.showMessageDialog(this, "Departamento actualizado con precio: " + departamentoSeleccionado.getPrecio(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Departamento no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Comuna no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * Acción realizada al hacer clic en el botón de actualizar terreno.
     * Muestra un cuadro de diálogo para seleccionar y actualizar un terreno.
     *
     * @param evt el evento de acción
     */
    private void actualizarTerrenoActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtener todas las comunas
        List<Comuna> comunas = inmobiliaria.obtenerTodasLasComunas();

        if (comunas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay comunas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un array de nombres de comunas
        String[] nombresComunas = comunas.stream().map(Comuna::getNombre).toArray(String[]::new);

        // Mostrar un JComboBox con los nombres de las comunas
        String nombreComunaSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione una Comuna:",
                "Actualizar Terreno", JOptionPane.QUESTION_MESSAGE, null, nombresComunas, nombresComunas[0]);

        if (nombreComunaSeleccionada != null) {
            // Buscar la comuna seleccionada por nombre
            Comuna comunaSeleccionada = comunas.stream()
                    .filter(comuna -> comuna.getNombre().equals(nombreComunaSeleccionada))
                    .findFirst()
                    .orElse(null);

            if (comunaSeleccionada != null) {
                // Obtener todos los terrenos de la comuna seleccionada
                List<Terreno> terrenos = comunaSeleccionada.obtenerTodosLosTerrenos();

                if (terrenos.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay terrenos disponibles en esta comuna", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un array de IDs de terrenos
                Integer[] idsTerrenos = terrenos.stream().map(Terreno::getId).toArray(Integer[]::new);

                // Mostrar un JComboBox con los IDs de los terrenos
                Integer idTerrenoSeleccionado = (Integer) JOptionPane.showInputDialog(this, "Seleccione un Terreno:",
                        "Seleccionar Terreno", JOptionPane.QUESTION_MESSAGE, null, idsTerrenos, idsTerrenos[0]);

                if (idTerrenoSeleccionado != null) {
                    // Buscar el terreno seleccionado por ID
                    Terreno terrenoSeleccionado = terrenos.stream()
                            .filter(terreno -> terreno.getId() == idTerrenoSeleccionado)
                            .findFirst()
                            .orElse(null);

                    if (terrenoSeleccionado != null) {
                        // Solicitar nuevos datos del Terreno
                        String direccion = JOptionPane.showInputDialog(this, "Ingrese nueva Dirección:", terrenoSeleccionado.getDireccion());
                        String mts2Str = JOptionPane.showInputDialog(this, "Ingrese nuevos Metros Cuadrados:", terrenoSeleccionado.getMts2());
                        double mts2 = Double.parseDouble(mts2Str.trim());
                        String tieneAguaStr = JOptionPane.showInputDialog(this, "¿Tiene Agua? (true/false):", terrenoSeleccionado.isTieneServicioAgua());
                        boolean tieneAgua = Boolean.parseBoolean(tieneAguaStr.trim());
                        String tieneLuzStr = JOptionPane.showInputDialog(this, "¿Tiene Luz? (true/false):", terrenoSeleccionado.isTieneServicioLuz());
                        boolean tieneLuz = Boolean.parseBoolean(tieneLuzStr.trim());
                        String tieneGasStr = JOptionPane.showInputDialog(this, "¿Tiene Gas? (true/false):", terrenoSeleccionado.isTieneServicioGas());
                        boolean tieneGas = Boolean.parseBoolean(tieneGasStr.trim());

                        // Actualizar el Terreno
                        terrenoSeleccionado.setDireccion(direccion);
                        terrenoSeleccionado.setMts2(mts2);
                        terrenoSeleccionado.setTieneServicioAgua(tieneAgua);
                        terrenoSeleccionado.setTieneServicioLuz(tieneLuz);
                        terrenoSeleccionado.setTieneServicioGas(tieneGas);

                        // Calcular el nuevo precio
                        long precio = comunaSeleccionada.precioFinalTerreno(comunaSeleccionada, terrenoSeleccionado);
                        terrenoSeleccionado.setPrecio(precio);

                        // Mostrar el precio calculado y preguntar si desea cambiarlo
                        int respuesta = JOptionPane.showConfirmDialog(this, "El precio calculado es: " + precio + "\n¿Desea mantener este precio?", "Confirmar Precio", JOptionPane.YES_NO_OPTION);
                        if (respuesta == JOptionPane.NO_OPTION) {
                            String precioManualStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo precio:");
                            try {
                                long precioManual = Long.parseLong(precioManualStr.trim());
                                terrenoSeleccionado.setPrecio(precioManual);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(this, "Precio inválido, se mantendrá el precio calculado.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        // Mostrar mensaje de confirmación
                        JOptionPane.showMessageDialog(this, "Terreno actualizado con precio: " + terrenoSeleccionado.getPrecio(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Terreno no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
            java.util.logging.Logger.getLogger(MenuActualizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuActualizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuActualizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuActualizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inmobiliaria inmobiliaria = new Inmobiliaria();
                new MenuActualizacion(inmobiliaria).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton actualizarCasa;
    private javax.swing.JButton actualizarComuna;
    private javax.swing.JButton actualizarDepartamento;
    private javax.swing.JButton actualizarTerreno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration
}
