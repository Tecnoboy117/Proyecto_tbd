/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import conexion.Conexion;
import java.sql.SQLException;
import java.util.List;
import modelos.Compradetalle;
import vistas.ProductosT;

/**
 *
 * @author danyv
 */
public class ControladorCompraD {
    private ProductosT sistema;

    public ControladorCompraD(ProductosT sistema) {
        this.sistema = sistema;
    }
    public boolean registrarCompraD() throws SQLException{
        Compradetalle modeloCompraD = new Compradetalle();
        System.out.println(":(");
        //getTfCvCompraCD
        modeloCompraD.setCvcompra(Integer.parseInt(sistema.getTfCvCompraCD().getText()));
        modeloCompraD.setCantidad(Integer.parseInt(sistema.getTfCantidadCD().getText()));
        modeloCompraD.setCvproducto(sistema.getTfProductoCD().getText());
        modeloCompraD.setPrecioc(Double.parseDouble(sistema.getTfPrecioCD().getText()));
        return Compradetalle.agregarCompradetalle(Conexion.getConexion(), modeloCompraD);
    }
    public boolean actualizarCompraD() throws SQLException{
        Compradetalle modeloCompraD = new Compradetalle();
        modeloCompraD.setCantidad(Integer.parseInt((String) sistema.getTablaCD().getValueAt(sistema.getTablaCD().getSelectedRow(), 3)));
        modeloCompraD.setCvcompra(Integer.parseInt((String) sistema.getTablaCD().getValueAt(sistema.getTablaCD().getSelectedRow(), 1)));
        modeloCompraD.setCvproducto((String) sistema.getTablaCD().getValueAt(sistema.getTablaCD().getSelectedRow(), 2));
        modeloCompraD.setPrecioc(Double.parseDouble((String) sistema.getTablaCD().getValueAt(sistema.getTablaCD().getSelectedRow(), 4)));
        return Compradetalle.modificarCompradetalle(Conexion.getConexion(), modeloCompraD);
    }
    
    public boolean borrarCompraD() throws SQLException{
        return Compradetalle.eliminarDetalleCompra(Conexion.getConexion(), Integer.parseInt((String) sistema.getTablaCD().getValueAt(sistema.getTablaCD().getSelectedRow(), 0)));
    }
    public Compradetalle buscar() throws SQLException{
        Compradetalle cd = Compradetalle.buscarCompradetalle(Conexion.getConexion(), Integer.parseInt((String) sistema.getTablaCD().getValueAt(sistema.getTablaCD().getSelectedRow(), 0)));
        if(cd != null){
            System.out.println("Pase el if de buscar una propiedad de mi objeto es:" +cd.getId());
            return cd;
        }else{
            System.out.println("No pase el if de buscar");
            return null;
        }
    }
    public List<Compradetalle> listar() throws SQLException{
        List<Compradetalle> modeloCompraD = Compradetalle.listarCompradetalle(Conexion.getConexion());
        return modeloCompraD;
    }
}
