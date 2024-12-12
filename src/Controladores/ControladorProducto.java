/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import conexion.Conexion;
import java.sql.SQLException;
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
        return Producto.agregarProducto(con.getConexion(), modeloP);
    }
    
    public void actualizarProducto(){
        Producto modeloP = new Producto();
    }
    
    public void eliminarProductos(){
        Producto modeloP = new Producto();
    }
    
    public void buscarProductos(){
        Producto modeloP = new Producto();
    }
}
