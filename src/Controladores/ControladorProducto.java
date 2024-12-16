/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import conexion.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelos.Producto;
import vistas.ProductosT;

/**
 *
 * @author danyv
 */
public class ControladorProducto {
    private ProductosT sistema;
    private Conexion con;

    public ControladorProducto(ProductosT sistema) {
        this.sistema = sistema;
    }
    public boolean registrarProductos() throws SQLException{
        Producto modeloP = new Producto();
        double precioV = Integer.parseInt(sistema.getTfPrecio().getText())+Integer.parseInt(sistema.getTfGanaciaP().getText()); 
        modeloP.setCvproducto(sistema.getTfCodigo().getText());
        modeloP.setNombre(sistema.getTfProducto().getText());
        modeloP.setMarca(sistema.getTfMarca().getText());
        modeloP.setExistencias(Integer.parseInt(sistema.getTfExitencias().getText()));
        modeloP.setPreciosu(Integer.parseInt(sistema.getTfPrecio().getText()));
        modeloP.setPreciosc(precioV);
        modeloP.setPreciosvo(0);
        modeloP.setEstado(2);
        return Producto.agregarProducto(Conexion.getConexion(), modeloP);
    }
    
    public boolean actualizarProducto() throws SQLException{
        Producto modeloP = new Producto();
        if(Integer.parseInt((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 7))==2){
            System.out.println("La ganancia es: " + sistema.getTfGanaciaP().getText());
            double precioV = Double.parseDouble((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 4)) + Integer.parseInt(sistema.getTfGanaciaP().getText()); 
            modeloP.setCvproducto(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 0)));
            modeloP.setNombre(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 1)));
            modeloP.setMarca(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 2)));
            modeloP.setExistencias(Integer.parseInt((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 3)));
            modeloP.setPreciosu(Double.parseDouble((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 4)));
            modeloP.setPreciosc(precioV);
            modeloP.setPreciosvo(0);
            modeloP.setEstado(2);
        }else{
            System.out.println("La ganancia es: " + sistema.getTfGanaciaP().getText());
            double precioV = Double.parseDouble((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 4)) + Integer.parseInt(sistema.getTfGanaciaP().getText()); 
            modeloP.setCvproducto(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 0)));
            modeloP.setNombre(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 1)));
            modeloP.setMarca(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 2)));
            modeloP.setExistencias(Integer.parseInt((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 3)));
            modeloP.setPreciosu(Double.parseDouble((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 4)));
            modeloP.setPreciosc(precioV);
            modeloP.setPreciosvo(precioV-(precioV*.20));
            modeloP.setEstado(Integer.parseInt((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 7)));
        }
        return Producto.modificarProducto(Conexion.getConexion(), modeloP);
    }
    
    public boolean eliminarProductos() throws SQLException{
        return Producto.eliminarProducto(Conexion.getConexion(), String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 0)));
    }
    
    public List<Producto> listar() throws SQLException{
        List<Producto>  productos = Producto.listarProductos(Conexion.getConexion());
        return productos;
    }
    
    public void fechaOferta() throws SQLException{
        sistema.getPrecioO().setText("El precio de oferta es: ");
        List<Object> ultimaO = Producto.ultimaFecha(Conexion.getConexion(), sistema.getTfNumProCS().getText());
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Nombre");
        tabla.addColumn("Fecha");
        tabla.addColumn("Existencias");
        String [] fila = new String[3];
        fila [0] = String.valueOf(ultimaO.get(0));
        fila [1] = String.valueOf(ultimaO.get(1));
        fila [2] = String.valueOf(ultimaO.get(2));
        tabla.addRow(fila);
        sistema.getTablaCU().setModel(tabla);
        sistema.getTablaCU().clearSelection();
        double precioOfer = Producto.obtenerOferta(Conexion.getConexion(), sistema.getTfNumProCS().getText());
        sistema.getPrecioO().setText(sistema.getPrecioO().getText()+precioOfer);
    }
    
    public static Producto buscarProductos(String cvproducto) throws SQLException{
        System.out.println("Hola Estoy en buscar");
        Producto p = Producto.buscarProducto(Conexion.getConexion(), cvproducto);
        if(p != null){
            System.out.println("Pase el if de buscar una propiedad de mi objeto es:" +p.getCvproducto());
            return p;
        }else{
            System.out.println("No pase el if de buscar");
            return null;
        }
    }
    
    public void realizarCompra() throws SQLException{
        sistema.getPrecioT().setText("Total: ");
        String cvproductoR = String.valueOf(sistema.getTablaProcutosA().getValueAt(sistema.getTablaProcutosA().getSelectedRow(), 0));
        int cantidad = Integer.parseInt(sistema.getTfCantidadR().getText());
        Producto.realizarCompra(Conexion.getConexion(), cvproductoR, cantidad);
        double precio = buscarProductos(cvproductoR).getPreciosu();
        sistema.getPrecioT().setText(sistema.getPrecioT().getText()+(cantidad*precio));
    } 
    
    public List<Object> detalleP (ProductosT sistema) throws SQLException{
        List<Object> detalle = Producto.detalleProducto(Conexion.getConexion(), sistema.getTfNumProCS().getText());
        return detalle;
    }
}
