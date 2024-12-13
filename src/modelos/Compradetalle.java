/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author josea
 */
public class Compradetalle {
    private int id;
    private int cantidad;
    private double precios;
    private String cvproducto;
    private int cvcompra;
    
    public Compradetalle() {
        this.id = 0;
        this.cantidad = 0;
        this.precios = 0.0;
        this.cvproducto = "";
        this.cvcompra = 0;
    }

    // Constructor
    public Compradetalle(int id, int cantidad, double precioc, String cvproducto, int cvcompra) {
        this.id = id;
        this.cantidad = cantidad;
        this.precios = precioc;
        this.cvproducto = cvproducto;
        this.cvcompra = cvcompra;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioc() {
        return precios;
    }

    public void setPrecioc(double precios) {
        this.precios = precios;
    }

    public String getCvproducto() {
        return cvproducto;
    }

    public void setCvproducto(String cvproducto) {
        this.cvproducto = cvproducto;
    }

    public int getCvcompra() {
        return cvcompra;
    }

    public void setCvcompra(int cvcompra) {
        this.cvcompra = cvcompra;
    } 
    public static boolean agregarCompradetalle(Connection conn, Compradetalle detalle) throws SQLException {
        String sql = "INSERT INTO compradetalle (cantidad, precios, cvproducto, cvcompra) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalle.cantidad);
            stmt.setDouble(2, detalle.precios);
            stmt.setString(3, detalle.cvproducto);
            stmt.setInt(4, detalle.cvcompra);
            System.out.println("Cantidad: "+detalle.cantidad+" Precio: "+detalle.precios+" cvproducto: "+detalle.cvproducto+" cvcompra:"+detalle.cvcompra);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para eliminar un detalle de compra por ID de compra
    public static boolean eliminarDetalleCompra(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM compradetalle WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para listar todos los detalles de compra
    public static List<Compradetalle> listarCompradetalle(Connection conn) throws SQLException {
        String sql = "SELECT * FROM compradetalle";
        List<Compradetalle> detalles = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                detalles.add(new Compradetalle(
                        rs.getInt("id"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precios"),
                        rs.getString("cvproducto"),
                        rs.getInt("cvcompra")
                ));
            }
        }
        return detalles;
    }
    public static boolean modificarCompradetalle(Connection conn, Compradetalle detalle) throws SQLException {
    String sql = "UPDATE compradetalle SET cantidad = ?, precios = ? WHERE cvcompra = ? AND cvproducto = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalle.cantidad);
            stmt.setDouble(2, detalle.precios);
            stmt.setInt(3, detalle.cvcompra);
            stmt.setString(4, detalle.cvproducto);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

// Método para buscar un detalle de compra por ID de compra
    public static Compradetalle buscarCompradetalle(Connection conn, int id) throws SQLException {
    String sql = "SELECT * FROM compradetalle";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Compradetalle(
                        rs.getInt("id"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precioc"),
                        rs.getString("cvproducto"),
                        rs.getInt("cvcompra")
                );
                
                }else{
                return null;
            }
            }
        }
        
    }

    @Override
    public String toString() {
        return "Compradetalle{" + "cantidad=" + cantidad + ", precioc=" + precios + ", cvproducto=" + cvproducto + ", cvcompra=" + cvcompra + '}';
    }
}
