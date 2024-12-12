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
   private int cantidad;
    private double precioc;
    private String cvproducto;
    private int cvcompra;

    // Constructor
    public Compradetalle(int cantidad, double precioc, String cvproducto, int cvcompra) {
        this.cantidad = cantidad;
        this.precioc = precioc;
        this.cvproducto = cvproducto;
        this.cvcompra = cvcompra;
    }

    // Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioc() {
        return precioc;
    }

    public void setPrecioc(double precioc) {
        this.precioc = precioc;
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
    public static void agregarCompradetalle(Connection conn, Compradetalle detalle) throws SQLException {
        String sql = "INSERT INTO detallecompra (cantidad, precioc, cvproducto, cvcompra) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detalle.cantidad);
            stmt.setDouble(2, detalle.precioc);
            stmt.setString(3, detalle.cvproducto);
            stmt.setInt(4, detalle.cvcompra);
            stmt.executeUpdate();
            System.out.println("Detalle agregado: " + detalle);
        }
    }

    // Método para eliminar un detalle de compra por ID de compra
    public static boolean eliminarDetalleCompra(Connection conn, int cvcompra) throws SQLException {
        String sql = "DELETE FROM detallecompra WHERE cvcompra = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cvcompra);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para listar todos los detalles de compra
    public static List<Compradetalle> listarCompradetalle(Connection conn) throws SQLException {
        String sql = "SELECT * FROM detallecompra";
        List<Compradetalle> detalles = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                detalles.add(new Compradetalle(
                        rs.getInt("cantidad"),
                        rs.getDouble("precioc"),
                        rs.getString("cvproducto"),
                        rs.getInt("cvcompra")
                ));
            }
        }
        return detalles;
    }
    public static boolean modificarCompradetalle(Connection conn, Compradetalle detalle) throws SQLException {
    String sql = "UPDATE detallecompra SET cantidad = ?, precioc = ? WHERE cvcompra = ? AND cvproducto = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, detalle.cantidad);
        stmt.setDouble(2, detalle.precioc);
        stmt.setInt(3, detalle.cvcompra);
        stmt.setString(4, detalle.cvproducto);
        int row = stmt.executeUpdate();
        return row > 0;
    }
}

// Método para buscar un detalle de compra por ID de compra
public static List<Compradetalle> buscarCompradetalle(Connection conn, int cvcompra) throws SQLException {
    String sql = "SELECT * FROM detallecompra WHERE cvcompra = ?";
    List<Compradetalle> detalles = new ArrayList<>();
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, cvcompra);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                detalles.add(new Compradetalle(
                        rs.getInt("cantidad"),
                        rs.getDouble("precioc"),
                        rs.getString("cvproducto"),
                        rs.getInt("cvcompra")
                ));
            }
        }
    }
    return detalles;
}

    @Override
    public String toString() {
        return "Compradetalle{" + "cantidad=" + cantidad + ", precioc=" + precioc + ", cvproducto=" + cvproducto + ", cvcompra=" + cvcompra + '}';
    }
    
}
