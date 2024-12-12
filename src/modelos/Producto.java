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
public class Producto {
    private String cvproducto;
    private String nombre;
    private String marca;
    private int existencias;
    private double preciov;
    private double precioc;
    private double preciovo;
    private int estado;
    private int oferta;

    // Constructor
    public Producto(String cvproducto, String nombre, String marca, int existencias, double preciov, double precioc, double preciovo, int estado, int oferta) {
        this.cvproducto = cvproducto;
        this.nombre = nombre;
        this.marca = marca;
        this.existencias = existencias;
        this.preciov = preciov;
        this.precioc = precioc;
        this.preciovo = preciovo;
        this.estado = estado;
        this.oferta = oferta;
    }

    // Getters y Setters
    public String getCvproducto() {
        return cvproducto;
    }

    public void setCvproducto(String cvproducto) {
        this.cvproducto = cvproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPreciov() {
        return preciov;
    }

    public void setPreciov(double preciov) {
        this.preciov = preciov;
    }

    public double getPrecioc() {
        return precioc;
    }

    public void setPrecioc(double precioc) {
        this.precioc = precioc;
    }

    public double getPreciovo() {
        return preciovo;
    }

    public void setPreciovo(double preciovo) {
        this.preciovo = preciovo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }
    public static boolean agregarProducto(Connection conn, Producto producto) throws SQLException {
        String sql = "INSERT INTO producto (cvproducto, nombre, marca, existencias, preciov, precioc, preciovo, estado, oferta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.cvproducto);
            stmt.setString(2, producto.nombre);
            stmt.setString(3, producto.marca);
            stmt.setInt(4, producto.existencias);
            stmt.setDouble(5, producto.preciov);
            stmt.setDouble(6, producto.precioc);
            stmt.setDouble(7, producto.preciovo);
            stmt.setInt(8, producto.estado);
            stmt.setInt(9, producto.oferta);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para eliminar un producto por clave
    public static boolean eliminarProducto(Connection conn, String cvproducto) throws SQLException {
        String sql = "DELETE FROM producto WHERE cvproducto = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cvproducto);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para listar todos los productos
    public static List<Producto> listarProductos(Connection conn) throws SQLException {
        String sql = "SELECT * FROM producto";
        List<Producto> productos = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                productos.add(new Producto(
                        rs.getString("cvproducto"),
                        rs.getString("nombre"),
                        rs.getString("marca"),
                        rs.getInt("existencias"),
                        rs.getDouble("preciov"),
                        rs.getDouble("precioc"),
                        rs.getDouble("preciovo"),
                        rs.getInt("estado"),
                        rs.getInt("oferta")
                ));
            }
        }
        return productos;
}
    public static boolean modificarProducto(Connection conn, Producto producto) throws SQLException {
    String sql = "UPDATE producto SET nombre = ?, marca = ?, existencias = ?, preciov = ?, precioc = ?, preciovo = ?, estado = ?, oferta = ? WHERE cvproducto = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, producto.nombre);
        stmt.setString(2, producto.marca);
        stmt.setInt(3, producto.existencias);
        stmt.setDouble(4, producto.preciov);
        stmt.setDouble(5, producto.precioc);
        stmt.setDouble(6, producto.preciovo);
        stmt.setInt(7, producto.estado);
        stmt.setInt(8, producto.oferta);
        stmt.setString(9, producto.cvproducto);
        int row = stmt.executeUpdate();
        return row > 0;
    }
}
    public static Producto buscarProducto(Connection conn, String cvproducto) throws SQLException {
    String sql = "SELECT * FROM producto WHERE cvproducto = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, cvproducto);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Producto(
                        rs.getString("cvproducto"),
                        rs.getString("nombre"),
                        rs.getString("marca"),
                        rs.getInt("existencias"),
                        rs.getDouble("preciov"),
                        rs.getDouble("precioc"),
                        rs.getDouble("preciovo"),
                        rs.getInt("estado"),
                        rs.getInt("oferta")
                );
            }
        }
    }
    return null;
}

    @Override
    public String toString() {
        return "Producto{" + "cvproducto=" + cvproducto + ", nombre=" + nombre + ", marca=" + marca + ", existencias=" + existencias + ", preciov=" + preciov + ", precioc=" + precioc + ", preciovo=" + preciovo + ", estado=" + estado + ", oferta=" + oferta + '}';
    }
}

