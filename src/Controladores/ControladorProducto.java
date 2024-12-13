/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import conexion.Conexion;
import java.sql.SQLException;
import java.util.List;
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
        modeloP.setCvproducto(sistema.getTfCodigo().getText());
        modeloP.setNombre(sistema.getTfProducto().getText());
        modeloP.setMarca(sistema.getTfMarca().getText());
        modeloP.setExistencias(Integer.parseInt(sistema.getTfExitencias().getText()));
        modeloP.setPreciosu(Integer.parseInt(sistema.getTfPrecio().getText()));
        modeloP.setPreciosc(0);
        modeloP.setPreciosvo(0);
        return Producto.agregarProducto(Conexion.getConexion(), modeloP);
    }
    
    public boolean actualizarProducto() throws SQLException{
        Producto modeloP = new Producto();
        modeloP.setCvproducto(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 0)));
        modeloP.setNombre(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 1)));
        modeloP.setMarca(String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 2)));
        modeloP.setExistencias(Integer.parseInt((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 3)));
        modeloP.setPreciosu(Double.parseDouble((String) sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 4)));
        modeloP.setPreciosc(0);
        modeloP.setPreciosvo(0);
        return Producto.modificarProducto(Conexion.getConexion(), modeloP);
    }
    
    public boolean eliminarProductos() throws SQLException{
        return Producto.eliminarProducto(Conexion.getConexion(), String.valueOf(sistema.getTablaP().getValueAt(sistema.getTablaP().getSelectedRow(), 0)));
    }
    
    public List<Producto> listar() throws SQLException{
        List<Producto>  productos = Producto.listarProductos(Conexion.getConexion());
        return productos;
    }
    
    public Producto buscarProductos(String cvproducto) throws SQLException{
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
}
