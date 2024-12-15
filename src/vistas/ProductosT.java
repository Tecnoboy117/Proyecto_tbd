/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Controladores.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.*;

/**
 *
 * @author takia
 */
public class ProductosT extends javax.swing.JFrame {

    /**
     * Creates new form ProductosT
     */
    public ProductosT() throws SQLException {
        initComponents();
        
        Compradetalle modeloCD = new Compradetalle();
        actualizarTablaP();
        actualizarTablaC();
        actualizarTablaDC();
        System.out.println(":))))");
    }

    public JTextField getTfMarca() {
        return tfMarca;
    }

    public JTextField getTfCantidadC() {
        return tfTotalC;
    }

    public JTextField getTfCodigo() {
        return tfCodigo;
    }

    public JTextField getTfDetalle() {
        return tfCvCompraCD;
    }

    public JTextField getTfExitencias() {
        return tfExitencias;
    }

    public JTextField getTfFecha() {
        return tfProductoCD;
    }

    public JTextField getTfPrecio() {
        return tfPrecio;
    }

    public JTextField getTfProducto() {
        return tfProducto;
    }

    public JTable getTablaC() {
        return tablaC;
    }

    public void setTablaC(JTable tablaC) {
        this.tablaC = tablaC;
    }

    public JTable getTablaCD() {
        return tablaCD;
    }

    public void setTablaCD(JTable tablaCD) {
        this.tablaCD = tablaCD;
    }

    public JTable getTablaP() {
        return tablaP;
    }

    public void setTablaP(JTable tablaP) {
        this.tablaP = tablaP;
    }

    public JTextField getTfCvCompraCD() {
        return tfCvCompraCD;
    }

    public void setTfCvCompraCD(JTextField tfCvCompraCD) {
        this.tfCvCompraCD = tfCvCompraCD;
    }

    public JTextField getTfProductoCD() {
        return tfProductoCD;
    }

    public void setTfProductoCD(JTextField tfProductoCD) {
        this.tfProductoCD = tfProductoCD;
    }

    public JTextField getTfPrecioCD() {
        return tfPrecioCD;
    }

    public void setTfPrecioCD(JTextField tfPrecioCD) {
        this.tfPrecioCD = tfPrecioCD;
    }

    public JTextField getTfTotalC() {
        return tfTotalC;
    }

    public void setTfTotalC(JTextField tfTotalC) {
        this.tfTotalC = tfTotalC;
    }

    public JTextField getTfCantidadCD() {
        return tfCantidadCD;
    }

    public void setTfCantidadCD(JTextField tfCantidadCD) {
        this.tfCantidadCD = tfCantidadCD;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jmenu = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfPrecio = new javax.swing.JTextField();
        tfProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaP = new javax.swing.JTable();
        tfExitencias = new javax.swing.JTextField();
        btnBorrarP = new javax.swing.JButton();
        btnGuardarP = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        btnActualizarP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCD = new javax.swing.JTable();
        tfCvCompraCD = new javax.swing.JTextField();
        tfProductoCD = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizarP1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfCantidadCD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfPrecioCD = new javax.swing.JTextField();
        jPanelPANEL = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfTotalC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaC = new javax.swing.JTable();
        btnGuardarC = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBorrarC = new javax.swing.JButton();
        btnActualizarP2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonCOMPRAS = new javax.swing.JButton();
        jButtonCD = new javax.swing.JButton();
        jButtonProductos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Codigo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, -1, -1));

        jLabel10.setText("Nombre");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, 57, -1));

        jLabel11.setText("Existencias");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));
        jPanel1.add(tfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 11, 251, -1));
        jPanel1.add(tfPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 86, -1));

        tfProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProductoActionPerformed(evt);
            }
        });
        jPanel1.add(tfProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 44, 251, -1));

        jLabel12.setText("Precio");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 43, -1));

        tablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaP);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 730, 200));
        jPanel1.add(tfExitencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 86, -1));

        btnBorrarP.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\goma-de-borrar.png")); // NOI18N
        btnBorrarP.setText("Borrar");
        btnBorrarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarPMouseClicked(evt);
            }
        });
        jPanel1.add(btnBorrarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 126, -1));

        btnGuardarP.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\guardarbred_1.png")); // NOI18N
        btnGuardarP.setText("Guardar");
        btnGuardarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarPMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, 41));

        jLabel15.setText("Marca");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 43, -1));
        jPanel1.add(tfMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 90, -1));

        btnActualizarP.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\rotacion.png")); // NOI18N
        btnActualizarP.setText("Actualizar");
        btnActualizarP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarPMouseClicked(evt);
            }
        });
        jPanel1.add(btnActualizarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 120, 40));

        jmenu.addTab("Productos", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Compra");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        jLabel14.setText("Producto");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 48, -1));

        tablaCD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaCD);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, 530, 190));
        jPanel2.add(tfCvCompraCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 71, -1));
        jPanel2.add(tfProductoCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 71, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\guardarbred_1.png")); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 261, 130, 41));

        btnBorrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\goma-de-borrar.png")); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarMouseClicked(evt);
            }
        });
        jPanel2.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 261, 127, 40));

        btnActualizarP1.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\rotacion.png")); // NOI18N
        btnActualizarP1.setText("Actualizar");
        btnActualizarP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarP1MouseClicked(evt);
            }
        });
        jPanel2.add(btnActualizarP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 120, 40));

        jLabel3.setText("Cantidad");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));
        jPanel2.add(tfCantidadCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 70, -1));

        jLabel6.setText("Precio");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));
        jPanel2.add(tfPrecioCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 80, -1));

        jmenu.addTab("Compra Detalle", jPanel2);

        jPanelPANEL.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPANEL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Total");
        jPanelPANEL.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));
        jPanelPANEL.add(tfTotalC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 71, -1));

        tablaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaC);

        jPanelPANEL.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 81, 690, 136));

        btnGuardarC.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\guardarbred_1.png")); // NOI18N
        btnGuardarC.setText("Guardar");
        btnGuardarC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarCMouseClicked(evt);
            }
        });
        jPanelPANEL.add(btnGuardarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 252, -1, -1));

        jLabel7.setText("Total a Pagar");
        jPanelPANEL.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 279, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("$");
        jPanelPANEL.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 262, 20, 40));

        btnBorrarC.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\goma-de-borrar.png")); // NOI18N
        btnBorrarC.setText("Borrar");
        btnBorrarC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrarC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarCMouseClicked(evt);
            }
        });
        jPanelPANEL.add(btnBorrarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 120, 50));

        btnActualizarP2.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\rotacion.png")); // NOI18N
        btnActualizarP2.setText("Actualizar");
        btnActualizarP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarP2MouseClicked(evt);
            }
        });
        jPanelPANEL.add(btnActualizarP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 120, 50));

        jmenu.addTab("Compras", jPanelPANEL);

        jPanel3.add(jmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 740, 420));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCOMPRAS.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\añadeventa.png")); // NOI18N
        jButtonCOMPRAS.setText("Compras");
        jButtonCOMPRAS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCOMPRAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCOMPRASMouseClicked(evt);
            }
        });
        jPanel5.add(jButtonCOMPRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 170, -1));

        jButtonCD.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\compraDETALLE.png")); // NOI18N
        jButtonCD.setText("Compra Detalle");
        jButtonCD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCDMouseClicked(evt);
            }
        });
        jPanel5.add(jButtonCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 60));

        jButtonProductos.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\productosre.png")); // NOI18N
        jButtonProductos.setText("Productos");
        jButtonProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonProductosMouseClicked(evt);
            }
        });
        jPanel5.add(jButtonProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\danyv\\OneDrive\\Escritorio\\Proyecto_BD\\Proyecto_tbd\\src\\IMG\\carrito_chico-removebg-preview_2.png")); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 110, 240));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 500));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 760, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarPMouseClicked
        if(!tfProducto.getText().equals("") && !this.tfCodigo.getText().equals("") && !this.tfExitencias.getText().equals("") && !this.tfMarca.getText().equals("") && !this.tfPrecio.getText().equals("")){
            ControladorProducto productoC = new ControladorProducto(this);
            try {
                // TODO add your handling code here:
                if(productoC.buscarProductos(this.tfCodigo.getText()) == null){
                   if(productoC.registrarProductos()){
                        JOptionPane.showMessageDialog(null, "El producto se registro", "Registro aceptado", 1);
                        System.out.println("Hola");
                    }else{
                        JOptionPane.showMessageDialog(null, "El producto no se registro", "Registro denegado", 1);
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "El producto Ya existe", "Registro denegado", 1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                actualizarTablaP();
                actualizarTablaC();
                actualizarTablaDC();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay algún campo vacio aún", "Acceso denegado", 1);
        }
    }//GEN-LAST:event_btnGuardarPMouseClicked

    private void tfProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProductoActionPerformed

    private void btnBorrarCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarCMouseClicked
        // TODO add your handling code here:
        ControladorCompra compraC = new ControladorCompra(this);
        int fila = tablaC.getColumnCount();
        if(fila > -1){
            try {
                if(compraC.elmininar()){
                    JOptionPane.showMessageDialog(null, "Se elimino el registro", "Accion Autorizada", 1);
                    actualizarTablaP();
                    actualizarTablaC();
                    actualizarTablaDC();
                    System.out.println("Hola");
                }else{
                    JOptionPane.showMessageDialog(null, "No se elimino el registro", "Accion Denegada", 1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado", "Accion denegada", 1);
        }
    }//GEN-LAST:event_btnBorrarCMouseClicked

    private void btnBorrarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarPMouseClicked
        // TODO add your handling code here:
        ControladorProducto productoP = new ControladorProducto(this);
        int fila = tablaP.getSelectedRow();
        if(fila > -1){
            System.out.println("La columna elegida es: "+fila+" y el valor de la clave es"+tablaP.getValueAt(fila, 0).toString());
            try {
                if(productoP.eliminarProductos()){
                    JOptionPane.showMessageDialog(null, "Se elimino el registro", "Accion Autorizada", 1);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "No se elimino el registro", "Accion Denegada", 1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado", "Accion denegada", 1);
        }
        try {
                actualizarTablaP();
                actualizarTablaC();
                actualizarTablaDC();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnBorrarPMouseClicked

    private void btnActualizarPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarPMouseClicked
        // TODO add your handling code here:
        ControladorProducto productoP = new ControladorProducto(this);
        int fila = tablaP.getSelectedRow();
        if(fila > -1){
            try {
                System.out.println("Hola");
                if(productoP.actualizarProducto()){
                    JOptionPane.showMessageDialog(null, "El registro fue modificado", "Accion aceptada", 1);
                }else{
                    JOptionPane.showMessageDialog(null, "El registro no fue modificado", "Accion denegada", 1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado", "Accion denegada", 1);
        }
        try {
            actualizarTablaP();
            actualizarTablaC();
            actualizarTablaDC();
        } catch (SQLException ex) {
            Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hola");
    }//GEN-LAST:event_btnActualizarPMouseClicked

    private void btnGuardarCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCMouseClicked
        // TODO add your handling code here:
        ControladorCompra compraC = new ControladorCompra(this);
        if(!tfTotalC.getText().equals("")){
            try {
            if(compraC.registrarCompra()){
                JOptionPane.showMessageDialog(null, "La compra se registro", "Registro aceptado", 1);
                actualizarTablaP();
                actualizarTablaC();
                actualizarTablaDC();
            }else{
                JOptionPane.showMessageDialog(null, "La compra no se registro", "Registro Denegado", 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Hay algún campo vacio aún", "Acceso denegado", 1);
        }
    }//GEN-LAST:event_btnGuardarCMouseClicked

    private void btnActualizarP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarP2MouseClicked
        // TODO add your handling code here:
        ControladorCompra compraC = new ControladorCompra(this);
        int fila = tablaC.getSelectedRow();
        if(fila > -1){
            try {
                if(compraC.actualizarCompra()){
                    JOptionPane.showMessageDialog(null, "El registro fue modificado", "Accion aceptada", 1);
                    actualizarTablaP();
                    actualizarTablaC();
                    actualizarTablaDC();
                    System.out.println("Hola");
                }else{
                    JOptionPane.showMessageDialog(null, "El registro no fue modificado", "Accion denegada", 1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado", "Accion denegada", 1);
        }
    }//GEN-LAST:event_btnActualizarP2MouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        ControladorCompraD compraDC = new ControladorCompraD(this);
        if(!this.tfCvCompraCD.getText().equals("") && !this.tfProductoCD.getText().equals("") && !this.tfCantidadCD.getText().equals("") && !this.tfPrecioCD.getText().equals("")){
            try {
                System.out.println(":(");
                if(compraDC.registrarCompraD()){
                    JOptionPane.showMessageDialog(null, "El detalle se registro", "Registro aceptado", 1);
                    System.out.println(":)");
                    actualizarTablaP();
                    actualizarTablaC();
                    actualizarTablaDC();
                }else{
                    JOptionPane.showMessageDialog(null, "El detalle no se registro", "Registro Denegado", 1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hay algún campo vacio aún", "Accion denegado", 1);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseClicked
        // TODO add your handling code here:
        ControladorCompraD compraDC = new ControladorCompraD(this);
        int fila = tablaP.getSelectedRow();
        if(fila > -1){
            System.out.println("La columna elegida es: "+fila+" y el valor de la clave es"+tablaP.getValueAt(fila, 0).toString());
            try {
                if(compraDC.borrarCompraD()){
                    JOptionPane.showMessageDialog(null, "Se elimino el registro", "Accion Autorizada", 1);
                    actualizarTablaP();
                    actualizarTablaC();
                    actualizarTablaDC();
                }else{
                    JOptionPane.showMessageDialog(null, "No se elimino el registro", "Accion Denegada", 1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado", "Accion denegada", 1);
        }
    }//GEN-LAST:event_btnBorrarMouseClicked

    private void btnActualizarP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarP1MouseClicked
        // TODO add your handling code here:
        ControladorCompraD compraDC = new ControladorCompraD(this);
        int fila = tablaCD.getSelectedRow();
        if(fila > -1){
            try {
                if(compraDC.actualizarCompraD()){
                    JOptionPane.showMessageDialog(null, "El registro fue modificado", "Accion aceptada", 1);
                    actualizarTablaP();
                    actualizarTablaC();
                    actualizarTablaDC();
                }else{
                    JOptionPane.showMessageDialog(null, "El registro no fue modificado", "Accion denegada", 1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ningun registro seleccionado", "Accion denegada", 1);
        }
    }//GEN-LAST:event_btnActualizarP1MouseClicked

    private void jButtonCOMPRASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCOMPRASMouseClicked
        try {
            // TODO add your handling code here:
            jmenu.setSelectedIndex(1);
            actualizarTablaP();
            actualizarTablaC();
            actualizarTablaDC();
        } catch (SQLException ex) {
            Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCOMPRASMouseClicked

    private void jButtonProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProductosMouseClicked
        try {
            // TODO add your handling code here:
            jmenu.setSelectedIndex(0);
            actualizarTablaP();
            actualizarTablaC();
            actualizarTablaDC();
        } catch (SQLException ex) {
            Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonProductosMouseClicked

    private void jButtonCDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCDMouseClicked
        try {
            // TODO add your handling code here:
            jmenu.setSelectedIndex(2);
            actualizarTablaP();
            actualizarTablaC();
            actualizarTablaDC();
        } catch (SQLException ex) {
            Logger.getLogger(ProductosT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCDMouseClicked

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarMouseEntered
    
    private void actualizarTablaP() throws SQLException{
        ControladorProducto productoC = new ControladorProducto(this);
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Clave");
        tabla.addColumn("Nombre");
        tabla.addColumn("Marca");
        tabla.addColumn("Existencias");
        tabla.addColumn("Precio Unitario");
        tabla.addColumn("Precio Compra");
        tabla.addColumn("Precio Vo");
        tabla.addColumn("Estado");
        List<Producto> productos = productoC.listar();
        String [] fila = new String[8];
        for(int i = 0;i<productos.size();i++){
            Producto producto = productos.get(i);
            fila [0] = producto.getCvproducto();
            fila [1] = producto.getNombre();
            fila [2] = producto.getMarca();
            fila [3] = String.valueOf(producto.getExistencias());
            fila [4] = String.valueOf(producto.getPreciosu());
            fila [5] = String.valueOf(producto.getPreciosc());
            fila [6] = String.valueOf(producto.getPreciosvo());
            fila [7] = String.valueOf(producto.getEstado());
            tabla.addRow(fila);
        }
        tablaP.setModel(tabla);
        tablaP.clearSelection();
    }
    
    private void actualizarTablaC() throws SQLException{
        ControladorCompra compraC = new ControladorCompra(this);
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Clave");
        tabla.addColumn("Fecha");
        tabla.addColumn("Total");
        tabla.addColumn("Subtotal");
        tabla.addColumn("Iva");
        tabla.addColumn("Estado");
        String [] fila = new String[6];
        List<Compra> compras = compraC.listar();
        for(int i = 0;i < compras.size();i++){
            Compra compra = compras.get(i);
            fila [0] = String.valueOf(compra.getCvcompra());
            fila [1] = compra.getFecha();
            fila [2] = String.valueOf(compra.getTotal());
            fila [3] = String.valueOf(compra.getSubtotal());
            fila [4] = String.valueOf(compra.getIva());
            fila [5] = String.valueOf(compra.getEstado());
            tabla.addRow(fila);
        }
        tablaC.setModel(tabla);
        tablaC.clearSelection();
    }
    
    private void actualizarTablaDC() throws SQLException{
        ControladorCompraD compraDC = new ControladorCompraD(this);
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Clave");
        tabla.addColumn("Compra");
        tabla.addColumn("Producto");
        tabla.addColumn("Cantidad");
        tabla.addColumn("Precio");
        String [] fila = new String[5];
        List<Compradetalle> comprascd = compraDC.listar();
        for(int i = 0;i < comprascd.size();i++){
            Compradetalle compra = comprascd.get(i);
            fila [0] = String.valueOf(compra.getId());
            fila [1] = String.valueOf(compra.getCvcompra());
            fila [2] = String.valueOf(compra.getCvproducto());
            fila [3] = String.valueOf(compra.getCantidad());
            fila [4] = String.valueOf(compra.getPrecioc());
            tabla.addRow(fila);
        }
        tablaCD.setModel(tabla);
        tablaCD.clearSelection();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarP;
    private javax.swing.JButton btnActualizarP1;
    private javax.swing.JButton btnActualizarP2;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarC;
    private javax.swing.JButton btnBorrarP;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnGuardarP;
    private javax.swing.JButton jButtonCD;
    private javax.swing.JButton jButtonCOMPRAS;
    private javax.swing.JButton jButtonProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelPANEL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jmenu;
    private javax.swing.JTable tablaC;
    private javax.swing.JTable tablaCD;
    private javax.swing.JTable tablaP;
    private javax.swing.JTextField tfCantidadCD;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCvCompraCD;
    private javax.swing.JTextField tfExitencias;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfPrecio;
    private javax.swing.JTextField tfPrecioCD;
    private javax.swing.JTextField tfProducto;
    private javax.swing.JTextField tfProductoCD;
    private javax.swing.JTextField tfTotalC;
    // End of variables declaration//GEN-END:variables
}
