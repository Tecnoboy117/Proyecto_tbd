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
public class Compra{
private int cvcompra;
    private Date fecha;
    private double total;
    private double subtotal;
    private double iva;
    private int estado;

    // Constructor
    public Compra(int cvcompra, Date fecha, double total, double subtotal, double iva, int estado) {
        this.cvcompra = cvcompra;
        this.fecha = fecha;
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
        this.estado = estado;
    }

    // Getters y Setters
    public int getCvcompra() {
        return cvcompra;
    }

    public void setCvcompra(int cvcompra) {
        this.cvcompra = cvcompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    public static void agregarCompra(Connection conn, Compra compra) throws SQLException {
        String sql = "INSERT INTO compra (cvcompra, fecha, total, subtotal, iva, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, compra.cvcompra);
            stmt.setDate(2, new java.sql.Date(compra.fecha.getTime()));
            stmt.setDouble(3, compra.total);
            stmt.setDouble(4, compra.subtotal);
            stmt.setDouble(5, compra.iva);
            stmt.setInt(6, compra.estado);
            stmt.executeUpdate();
            System.out.println("Compra agregada: " + compra);
        }
    }

    // Método para eliminar una compra por ID
    public static void eliminarCompra(Connection conn, int cvcompra) throws SQLException {
        String sql = "DELETE FROM compra WHERE cvcompra = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cvcompra);
            stmt.executeUpdate();
            System.out.println("Compra eliminada con ID: " + cvcompra);
        }
    }

    // Método para listar todas las compras
    public static List<Compra> listarCompras(Connection conn) throws SQLException {
        String sql = "SELECT * FROM compra";
        List<Compra> compras = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                compras.add(new Compra(
                        rs.getInt("cvcompra"),
                        rs.getDate("fecha"),
                        rs.getDouble("total"),
                        rs.getDouble("subtotal"),
                        rs.getDouble("iva"),
                        rs.getInt("estado")
                ));
            }
        }
        return compras;
    }
    public static void modificarCompra(Connection conn, Compra compra) throws SQLException {
    String sql = "UPDATE compra SET fecha = ?, total = ?, subtotal = ?, iva = ?, estado = ? WHERE cvcompra = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setDate(1, new java.sql.Date(compra.fecha.getTime()));
        stmt.setDouble(2, compra.total);
        stmt.setDouble(3, compra.subtotal);
        stmt.setDouble(4, compra.iva);
        stmt.setInt(5, compra.estado);
        stmt.setInt(6, compra.cvcompra);
        stmt.executeUpdate();
        System.out.println("Compra modificada: " + compra);
    }
}
    public static Compra buscarCompra(Connection conn, int cvcompra) throws SQLException {
    String sql = "SELECT * FROM compra WHERE cvcompra = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, cvcompra);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Compra(
                        rs.getInt("cvcompra"),
                        rs.getDate("fecha"),
                        rs.getDouble("total"),
                        rs.getDouble("subtotal"),
                        rs.getDouble("iva"),
                        rs.getInt("estado")
                );
            }
        }
    }
    return null;
    }
    @Override
    public String toString() {
        return "Compra{" + "cvcompra=" 
                + cvcompra + 
                ", fecha=" + fecha + ", total=" + total + ", subtotal=" + subtotal + ", iva=" + iva + ", estado=" + estado + '}';
    }
    
}
