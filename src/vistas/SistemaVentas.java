package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SistemaVentas extends JFrame {
    private JTextField txtCodigoCliente, txtNombreCliente, txtCodigoProducto, txtDescripcionProducto, txtPrecioProducto, txtCantidadProducto;
    private DefaultTableModel modeloTabla;
    private JLabel lblTotal;

    private ArrayList<String> listaClientes = new ArrayList<>();

    public SistemaVentas() {
        // Configuración del JFrame principal
        setTitle("Sistema de Ventas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Barra superior
        JPanel barraSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        barraSuperior.setBackground(new Color(0, 153, 204));
        barraSuperior.setPreferredSize(new Dimension(900, 50));

        JButton btnProductos = new JButton("Productos");
        JButton btnClientes = new JButton("Clientes");
        JButton btnNuevaVenta = new JButton("Nueva Venta");

        barraSuperior.add(btnProductos);
        barraSuperior.add(btnClientes);
        barraSuperior.add(btnNuevaVenta);
        add(barraSuperior, BorderLayout.NORTH);

        // Acciones de los botones de la barra superior
        btnProductos.addActionListener(e -> mostrarProductos());
        btnClientes.addActionListener(e -> mostrarVentanaClientes());
        btnNuevaVenta.addActionListener(e -> limpiarFormulario());

        // Panel principal
        JPanel panelPrincipal = new JPanel(new GridLayout(1, 2, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel de datos cliente y producto
        JPanel panelDatos = new JPanel(new GridLayout(6, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos Cliente y Producto"));

    

        JLabel lblCodigoProducto = new JLabel("Código Producto:");
        txtCodigoProducto = new JTextField();
        JButton btnBuscarProducto = new JButton("Buscar");

        JLabel lblDescripcionProducto = new JLabel("Descripción:");
        txtDescripcionProducto = new JTextField();

        JLabel lblPrecioProducto = new JLabel("Precio:");
        txtPrecioProducto = new JTextField();

        JLabel lblCantidadProducto = new JLabel("Cantidad:");
        txtCantidadProducto = new JTextField();

        JButton btnAgregarProducto = new JButton("Agregar Producto");

        panelDatos.add(txtNombreCliente);
        panelDatos.add(lblCodigoProducto);
        panelDatos.add(txtCodigoProducto);
        panelDatos.add(btnBuscarProducto);
        panelDatos.add(lblDescripcionProducto);
        panelDatos.add(txtDescripcionProducto);
        panelDatos.add(lblPrecioProducto);
        panelDatos.add(txtPrecioProducto);
        panelDatos.add(lblCantidadProducto);
        panelDatos.add(txtCantidadProducto);
        panelDatos.add(btnAgregarProducto);
        panelPrincipal.add(panelDatos);

        // Tabla de productos
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));

        String[] columnas = {"NRO", "PRODUCTO", "COD", "PRECIO", "CANT", "TOTAL", "ACCIÓN"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tablaProductos = new JTable(modeloTabla);

        // Botón eliminar dentro de la tabla
        tablaProductos.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        tablaProductos.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        panelTabla.add(scrollTabla, BorderLayout.CENTER);

        JPanel panelTotales = new JPanel(new BorderLayout());
        lblTotal = new JLabel("Total a pagar: S/. 0.00", SwingConstants.RIGHT);
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGenerarVenta = new JButton("Generar Venta");
        JButton btnCancelar = new JButton("Cancelar");

        // Estilo de botones
        estiloBoton(btnGenerarVenta);
        estiloBoton(btnCancelar);

        panelBotones.add(btnGenerarVenta);
        panelBotones.add(btnCancelar);

        panelTotales.add(lblTotal, BorderLayout.NORTH);
        panelTotales.add(panelBotones, BorderLayout.SOUTH);
        panelTabla.add(panelTotales, BorderLayout.SOUTH);

        panelPrincipal.add(panelTabla);
        add(panelPrincipal, BorderLayout.CENTER);

        // Acción del botón "Agregar Producto"
        btnAgregarProducto.addActionListener(e -> agregarProducto());


        // Acción del botón "Generar Venta"
        btnGenerarVenta.addActionListener(e -> generarVenta());

        // Acción del botón "Cancelar"
        btnCancelar.addActionListener(e -> cancelarVenta());

        setVisible(true);
    }

    // Métodos para las acciones de los botones de la barra superior
    private void mostrarProductos() {
        JOptionPane.showMessageDialog(this, "Lista de productos: Producto A, Producto B, Producto C", "Productos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarVentanaClientes() {
        JFrame ventanaClientes = new JFrame("Clientes");
        ventanaClientes.setSize(400, 300);
        ventanaClientes.setLocationRelativeTo(this);
        ventanaClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaClientes = new JTextArea("Lista de Clientes:\n" + String.join("\n", listaClientes));
        areaClientes.setEditable(false);
        ventanaClientes.add(new JScrollPane(areaClientes));

        ventanaClientes.setVisible(true);
    }

    private void limpiarFormulario() {
        cancelarVenta();
        JOptionPane.showMessageDialog(this, "Formulario listo para una nueva venta.", "Nueva Venta", JOptionPane.INFORMATION_MESSAGE);
    }

    // Métodos auxiliares
    private void agregarProducto() {
        // Lógica para agregar un producto a la tabla
        String codigo = txtCodigoProducto.getText();
        String descripcion = txtDescripcionProducto.getText();
        double precio = Double.parseDouble(txtPrecioProducto.getText());
        int cantidad = Integer.parseInt(txtCantidadProducto.getText());
        double total = precio * cantidad;

        modeloTabla.addRow(new Object[]{modeloTabla.getRowCount() + 1, descripcion, codigo, precio, cantidad, total, "Eliminar"});
        calcularTotal();
    }

    private void agregarCliente() {
        String codigoCliente = txtCodigoCliente.getText();
        String nombreCliente = txtNombreCliente.getText();

        if (!codigoCliente.isEmpty() && !nombreCliente.isEmpty()) {
            listaClientes.add("Código: " + codigoCliente + ", Nombre: " + nombreCliente);
            JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.", "Cliente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos para agregar un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularTotal() {
        double total = 0;
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            total += (double) modeloTabla.getValueAt(i, 5);
        }
        lblTotal.setText("Total a pagar: S/. " + total);
    }

    private void generarVenta() {
        JOptionPane.showMessageDialog(this, "Venta generada con éxito.", "Generar Venta", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cancelarVenta() {
        modeloTabla.setRowCount(0);
        calcularTotal();
    }

    private void estiloBoton(JButton boton) {
        boton.setBackground(new Color(0, 153, 204));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
    }

    // Renderizador para el botón en la tabla
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Editor para el botón en la tabla
    class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> eliminarProducto(selectedRow));
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            selectedRow = row;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }

        private void eliminarProducto(int row) {
            if (row >= 0 && row < modeloTabla.getRowCount()) {
                modeloTabla.removeRow(row);
                calcularTotal();
            }
        }
    }

    public static void main(String[] args) {
        new SistemaVentas();
    }
}
