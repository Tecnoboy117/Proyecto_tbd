/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import conexion.Conexion;
import java.sql.SQLException;
import java.util.List;
import modelos.Compra;
import vistas.ProductosT;

/**
 *
 * @author danyv
 */
public class ControladorCompra {
    private ProductosT sistema;
    private Conexion con;

    public ControladorCompra(ProductosT sistema) {
        this.sistema = sistema;
    }
    
    public boolean registrarCompra() throws SQLException{
        Compra modeloC = new Compra();
        double t = Double.parseDouble(sistema.getTfTotalC().getText());
        double i = t *.16;
        modeloC.setFecha(Compra.hacerFecha());
        modeloC.setTotal(t);
        modeloC.setSubtotal(t+i);
        modeloC.setIva(i);
        modeloC.setEstado(2);
        return Compra.agregarCompra(Conexion.getConexion(), modeloC);
    }
    
    public boolean actualizarCompra() throws SQLException{
        Compra modeloC = new Compra();
        double t = Double.parseDouble((String) sistema.getTablaC().getValueAt(sistema.getTablaC().getSelectedRow(), 2));
        double i = t *.16;
        modeloC.setCvcompra(Integer.parseInt((String) sistema.getTablaC().getValueAt(sistema.getTablaC().getSelectedRow(), 0)));
        modeloC.setFecha(String.valueOf(sistema.getTablaC().getValueAt(sistema.getTablaC().getSelectedRow(), 1)));
        modeloC.setTotal(t);
        modeloC.setSubtotal(t+i);
        modeloC.setIva(i);
        modeloC.setEstado(2);
        return Compra.modificarCompra(Conexion.getConexion(), modeloC);
    }
    
    public boolean elmininar() throws SQLException{
        return Compra.eliminarCompra(Conexion.getConexion(), Integer.parseInt((String)sistema.getTablaC().getValueAt(sistema.getTablaC().getSelectedRow(), 0)));
    }
    
    public List<Compra> listar() throws SQLException{
        List<Compra> compras = Compra.listarCompras(Conexion.getConexion());
        return compras;
    }
    
    public Compra buscar() throws SQLException{
        Compra c = Compra.buscarCompra(Conexion.getConexion(), Integer.parseInt((String) sistema.getTablaC().getValueAt(sistema.getTablaC().getSelectedRow(), 0)));
        if(c != null){
            System.out.println("Pase el if de buscar una propiedad de mi objeto es:" +c.getCvcompra());
            return c;
        }else{
            System.out.println("No pase el if de buscar");
            return null;
        }
    }
}
