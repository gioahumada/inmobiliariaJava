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
 * Clase que representa el menú de propiedades en la aplicación de Inmobiliaria.
 * Permite a los usuarios gestionar las propiedades dentro de las comunas.
 * Extiende de {@link javax.swing.JFrame}.
 *
 * @author gioahumada
 */
public class MenuPropiedades extends javax.swing.JFrame {
    private Inmobiliaria inmobiliaria;

    /**
     * Crea una nueva instancia de MenuPropiedades.
     *
     * @param inmobiliaria la instancia de la clase Inmobiliaria que contiene los datos de la aplicación.
     */
    public MenuPropiedades(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // Deshabilitar el cambio de tamaño
        setTitle("Inmobiliaria Java - Menú Propiedades");
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
        addToComuna = new javax.swing.JButton();
        quitarDeComuna = new javax.swing.JButton();

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
        jLabel4.setText("Menú Propiedades");

        addToComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPropiedad.png"))); // NOI18N
        addToComuna.setBorder(null);
        addToComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToComunaActionPerformed(evt);
            }
        });

        quitarDeComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminarPropiedad.png"))); // NOI18N
        quitarDeComuna.setBorder(null);
        quitarDeComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarDeComunaActionPerformed(evt);
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
                                                                .addComponent(addToComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(quitarDeComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(addToComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quitarDeComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
     * Acción a realizar cuando se presiona el botón "Añadir a Comuna".
     * Permite al usuario añadir una propiedad a una comuna seleccionada.
     *
     * @param evt el evento de acción.
     */
    private void addToComunaActionPerformed(java.awt.event.ActionEvent evt) {
        // Opciones de tipo de propiedad
        String[] options = {"Casa", "Departamento", "Terreno"};
        String tipoPropiedad = (String) JOptionPane.showInputDialog(this, "Seleccione el tipo de propiedad a añadir:",
                "Añadir Propiedad", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (tipoPropiedad != null) {
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
                    switch (tipoPropiedad) {
                        case "Casa":
                            agregarCasaAComuna(comunaSeleccionada);
                            break;
                        case "Departamento":
                            agregarDepartamentoAComuna(comunaSeleccionada);
                            break;
                        case "Terreno":
                            agregarTerrenoAComuna(comunaSeleccionada);
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Tipo de propiedad no válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Comuna no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Solicita los datos de una casa y la añade a la comuna seleccionada.
     *
     * @param comuna la comuna a la que se añadirá la casa.
     */
    private void agregarCasaAComuna(Comuna comuna) {
        // Solicitar datos de la Casa
        String idCasaStr = JOptionPane.showInputDialog(this, "Ingrese ID de la Casa:");
        if (idCasaStr != null) {
            try {
                int iddCasa = Integer.parseInt(idCasaStr.trim());
                // Verificar si el ID ya existe en la comuna
                try {
                    if (comuna.idExisteCasa(iddCasa)) {
                        throw new YaExiste("El ID de casa " + iddCasa + " ya existe en la comuna.");
                    }
                } catch (NoEncontrado e) {
                    // Si NoEncontrado es lanzado, significa que la casa no existe, así que podemos proceder
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID de Casa inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (YaExiste e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (idCasaStr != null && !idCasaStr.trim().isEmpty()) {
            try {
                int idCasa = Integer.parseInt(idCasaStr.trim());
                String direccion = JOptionPane.showInputDialog(this, "Ingrese Dirección:");
                String mts2Str = JOptionPane.showInputDialog(this, "Ingrese Metros Cuadrados:");
                double mts2 = Double.parseDouble(mts2Str.trim());
                String numHabitacionesStr = JOptionPane.showInputDialog(this, "Ingrese Número de Habitaciones:");
                int numHabitaciones = Integer.parseInt(numHabitacionesStr.trim());
                String numBaniosStr = JOptionPane.showInputDialog(this, "Ingrese Número de Baños:");
                int numBanios = Integer.parseInt(numBaniosStr.trim());
                String numEstacionamientoStr = JOptionPane.showInputDialog(this, "Ingrese Número de Estacionamientos:");
                int numEstacionamiento = Integer.parseInt(numEstacionamientoStr.trim());
                String mts2ConstruidosStr = JOptionPane.showInputDialog(this, "Ingrese Metros Cuadrados Construidos:");
                int mts2Construidos = Integer.parseInt(mts2ConstruidosStr.trim());

                // Menú desplegable para seleccionar si tiene patio
                String[] opcionesPatio = {"Sí", "No"};
                String tienePatioStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Patio?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, opcionesPatio, opcionesPatio[0]);
                boolean tienePatio = "Sí".equals(tienePatioStr);

                // Crear la Casa
                Casa casa = new Casa(idCasa, 0, direccion, mts2, numHabitaciones, numBanios, numEstacionamiento, mts2Construidos, tienePatio);
                long precio = comuna.precioFinalCasa(comuna, casa); // Calcula el precio automáticamente
                casa.setPrecio(precio);

                // Mostrar el precio calculado y preguntar si desea cambiarlo
                int respuesta = JOptionPane.showConfirmDialog(this, "El precio calculado es: $" + precio + "\n¿Desea mantener este precio?", "Confirmar Precio", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    String precioManualStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo precio:");
                    try {
                        long precioManual = Long.parseLong(precioManualStr.trim());
                        casa.setPrecio(precioManual);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Precio inválido, se mantendrá el precio calculado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                comuna.agregarCasa(casa);

                // Mostrar mensaje de confirmación
                JOptionPane.showMessageDialog(this, "Casa añadida a la comuna con precio $: " + casa.getPrecio(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ID de la Casa no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Solicita los datos de un departamento y lo añade a la comuna seleccionada.
     *
     * @param comuna la comuna a la que se añadirá el departamento.
     */
    private void agregarDepartamentoAComuna(Comuna comuna) {
        // Solicitar datos del Departamento
        String idDepartamentoStr = JOptionPane.showInputDialog(this, "Ingrese ID del Departamento:");
        if (idDepartamentoStr != null) {
            try {
                int iddD = Integer.parseInt(idDepartamentoStr.trim());
                // Verificar si el ID ya existe en la comuna
                try {
                    if (comuna.idExisteDepartamento(iddD)) {
                        throw new YaExiste("El ID de Departamento " + iddD + " ya existe en la comuna.");
                    }
                } catch (NoEncontrado e) {
                    // Si NoEncontrado es lanzado, significa que el departamento no existe, así que podemos proceder
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID de Departamento inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (YaExiste e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (idDepartamentoStr != null && !idDepartamentoStr.trim().isEmpty()) {
            try {
                int idDepartamento = Integer.parseInt(idDepartamentoStr.trim());
                String direccion = JOptionPane.showInputDialog(this, "Ingrese Dirección:");
                String mts2Str = JOptionPane.showInputDialog(this, "Ingrese Metros Cuadrados:");
                double mts2 = Double.parseDouble(mts2Str.trim());
                String numHabitacionesStr = JOptionPane.showInputDialog(this, "Ingrese Número de Habitaciones:");
                int numHabitaciones = Integer.parseInt(numHabitacionesStr.trim());
                String numBaniosStr = JOptionPane.showInputDialog(this, "Ingrese Número de Baños:");
                int numBanios = Integer.parseInt(numBaniosStr.trim());
                String pisoStr = JOptionPane.showInputDialog(this, "Ingrese Piso:");
                int piso = Integer.parseInt(pisoStr.trim());

                // Menú desplegable para seleccionar si tiene estacionamiento
                String[] opcionesEstacionamiento = {"Sí", "No"};
                String tieneEstacionamientoStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Estacionamiento?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, opcionesEstacionamiento, opcionesEstacionamiento[0]);
                boolean tieneEstacionamiento = "Sí".equals(tieneEstacionamientoStr);

                // Menú desplegable para seleccionar si tiene bodega
                String[] opcionesBodega = {"Sí", "No"};
                String tieneBodegaStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Bodega?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, opcionesBodega, opcionesBodega[0]);
                boolean tieneBodega = "Sí".equals(tieneBodegaStr);

                // Crear el Departamento
                Departamento departamento = new Departamento(idDepartamento, 0, direccion, mts2, numHabitaciones, numBanios, piso, tieneEstacionamiento, tieneBodega);
                int precio = comuna.precioFinalDepartamento(comuna, departamento); // Calcula el precio automáticamente
                departamento.setPrecio(precio);

                // Mostrar el precio calculado y preguntar si desea cambiarlo
                int respuesta = JOptionPane.showConfirmDialog(this, "El precio calculado es: $" + precio + "\n¿Desea mantener este precio?", "Confirmar Precio", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    String precioManualStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo precio:");
                    try {
                        int precioManual = Integer.parseInt(precioManualStr.trim());
                        departamento.setPrecio(precioManual);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Precio inválido, se mantendrá el precio calculado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                comuna.agregarDepartamento(departamento);

                // Mostrar mensaje de confirmación
                JOptionPane.showMessageDialog(this, "Departamento añadido a la comuna con precio: $" + departamento.getPrecio(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ID del Departamento no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Solicita los datos de un terreno y lo añade a la comuna seleccionada.
     *
     * @param comuna la comuna a la que se añadirá el terreno.
     */
    private void agregarTerrenoAComuna(Comuna comuna) {
        // Solicitar datos del Terreno
        String idTerrenoStr = JOptionPane.showInputDialog(this, "Ingrese ID del Terreno:");
        if (idTerrenoStr != null) {
            try {
                int iddT = Integer.parseInt(idTerrenoStr.trim());
                // Verificar si el ID ya existe en la comuna
                try {
                    if (comuna.idExisteTerreno(iddT)) {
                        throw new YaExiste("El ID de Terreno " + iddT + " ya existe en la comuna.");
                    }
                } catch (modelo.NoEncontrado e) {
                    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID de Terreno inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (YaExiste e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (idTerrenoStr != null && !idTerrenoStr.trim().isEmpty()) {
            try {
                int idTerreno = Integer.parseInt(idTerrenoStr.trim());
                String direccion = JOptionPane.showInputDialog(this, "Ingrese Dirección:");
                String mts2Str = JOptionPane.showInputDialog(this, "Ingrese Metros Cuadrados:");
                double mts2 = Double.parseDouble(mts2Str.trim());

                // Menú desplegable para seleccionar si tiene agua
                String[] opcionesAgua = {"Sí", "No"};
                String tieneAguaStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Agua?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, opcionesAgua, opcionesAgua[0]);
                boolean tieneAgua = "Sí".equals(tieneAguaStr);

                // Menú desplegable para seleccionar si tiene luz
                String[] opcionesLuz = {"Sí", "No"};
                String tieneLuzStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Luz?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, opcionesLuz, opcionesLuz[0]);
                boolean tieneLuz = "Sí".equals(tieneLuzStr);

                // Menú desplegable para seleccionar si tiene gas
                String[] opcionesGas = {"Sí", "No"};
                String tieneGasStr = (String) JOptionPane.showInputDialog(this, "¿Tiene Gas?", "Seleccionar", JOptionPane.QUESTION_MESSAGE, null, opcionesGas, opcionesGas[0]);
                boolean tieneGas = "Sí".equals(tieneGasStr);

                // Crear el Terreno
                Terreno terreno = new Terreno(idTerreno, 0, direccion, mts2, tieneAgua, tieneLuz, tieneGas);
                int precio = comuna.precioFinalTerreno(comuna, terreno); // Calcula el precio automáticamente
                terreno.setPrecio(precio);

                // Mostrar el precio calculado y preguntar si desea cambiarlo
                int respuesta = JOptionPane.showConfirmDialog(this, "El precio calculado es: $" + precio + "\n¿Desea mantener este precio?", "Confirmar Precio", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    String precioManualStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo precio:");
                    try {
                        int precioManual = Integer.parseInt(precioManualStr.trim());
                        terreno.setPrecio(precioManual);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Precio inválido, se mantendrá el precio calculado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                comuna.agregarTerreno(terreno);

                // Mostrar mensaje de confirmación
                JOptionPane.showMessageDialog(this, "Terreno añadido a la comuna con precio: $" + terreno.getPrecio(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ID del Terreno no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Acción a realizar cuando se presiona el botón "Quitar de Comuna".
     * Permite al usuario quitar una propiedad de una comuna seleccionada.
     *
     * @param evt el evento de acción.
     */
    private void quitarDeComunaActionPerformed(java.awt.event.ActionEvent evt) {
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
                "Quitar Propiedad", JOptionPane.QUESTION_MESSAGE, null, nombresComunas, nombresComunas[0]);

        if (nombreComunaSeleccionada != null) {
            // Buscar la comuna seleccionada por nombre
            Comuna comunaSeleccionada = comunas.stream()
                    .filter(comuna -> comuna.getNombre().equals(nombreComunaSeleccionada))
                    .findFirst()
                    .orElse(null);

            if (comunaSeleccionada != null) {
                // Opciones de tipo de propiedad
                String[] options = {"Casa", "Departamento", "Terreno"};
                String tipoPropiedad = (String) JOptionPane.showInputDialog(this, "Seleccione el tipo de propiedad a quitar:",
                        "Quitar Propiedad", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (tipoPropiedad != null) {
                    // Obtener los IDs de las propiedades según el tipo seleccionado
                    String[] idsPropiedades;
                    switch (tipoPropiedad) {
                        case "Casa":
                            idsPropiedades = comunaSeleccionada.obtenerIdsCasas().stream().map(String::valueOf).toArray(String[]::new);
                            break;
                        case "Departamento":
                            idsPropiedades = comunaSeleccionada.obtenerTodosLosDepartamentos().stream().map(d -> String.valueOf(d.getId())).toArray(String[]::new);
                            break;
                        case "Terreno":
                            idsPropiedades = comunaSeleccionada.obtenerTodosLosTerrenos().stream().map(t -> String.valueOf(t.getId())).toArray(String[]::new);
                            break;
                        default:
                            idsPropiedades = new String[0];
                    }

                    if (idsPropiedades.length == 0) {
                        JOptionPane.showMessageDialog(this, "No hay propiedades disponibles para quitar", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Mostrar un JComboBox con los IDs de las propiedades
                    String idPropiedadSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione el ID de la propiedad:",
                            "Quitar Propiedad", JOptionPane.QUESTION_MESSAGE, null, idsPropiedades, idsPropiedades[0]);

                    if (idPropiedadSeleccionada != null) {
                        int idPropiedad = Integer.parseInt(idPropiedadSeleccionada.trim());

                        switch (tipoPropiedad) {
                            case "Casa":
                                comunaSeleccionada.eliminarCasa(idPropiedad);
                                JOptionPane.showMessageDialog(this, "Casa quitada de la comuna.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case "Departamento":
                                comunaSeleccionada.eliminarDepartamento(idPropiedad);
                                JOptionPane.showMessageDialog(this, "Departamento quitado de la comuna.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case "Terreno":
                                comunaSeleccionada.eliminarTerreno(idPropiedad);
                                JOptionPane.showMessageDialog(this, "Terreno quitado de la comuna.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            default:
                                JOptionPane.showMessageDialog(this, "Tipo de propiedad no válido", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un ID de propiedad", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de propiedad", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Comuna no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args los argumentos de la línea de comandos.
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
            java.util.logging.Logger.getLogger(MenuPropiedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPropiedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPropiedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPropiedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MenuPropiedades(inmobiliaria).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton addToComuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton quitarDeComuna;
    // End of variables declaration
}
