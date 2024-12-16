/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author josea
 */
public class Producto {
    private String cvproducto;
    private String nombre;
    private String marca;
    private int existencias;
    private double preciosu;
    private double preciosc;
    private double preciosvo;
    private int estado;
    
    
    public Producto() {
        this.cvproducto = "";
        this.nombre = "";
        this.marca = "";
        this.existencias = 0;
        this.preciosu = 0.0;
        this.preciosc = 0.0;
        this.preciosvo = 0.0;
        this.estado = 0;
    }

    // Constructor
    public Producto(String cvproducto, String nombre, String marca, int existencias, double preciosu, double precioc, double preciovo, int estado) {
        this.cvproducto = cvproducto;
        this.nombre = nombre;
        this.marca = marca;
        this.existencias = existencias;
        this.preciosu = preciosu;
        this.preciosc = precioc;
        this.preciosvo = preciovo;
        this.estado = estado;
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

    public double getPreciosu() {
        return preciosu;
    }

    public void setPreciosu(double preciosu) {
        this.preciosu = preciosu;
    }

    public double getPreciosc() {
        return preciosc;
    }

    public void setPreciosc(double preciosc) {
        this.preciosc = preciosc;
    }

    public double getPreciosvo() {
        return preciosvo;
    }

    public void setPreciosvo(double preciosvo) {
        this.preciosvo = preciosvo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public static boolean agregarProducto(Connection conn, Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (cvproducto, nombre, marca, existencias, preciosu, preciosc, preciosvo, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.cvproducto);
            stmt.setString(2, producto.nombre);
            stmt.setString(3, producto.marca);
            stmt.setInt(4, producto.existencias);
            stmt.setDouble(5, producto.preciosu);
            stmt.setDouble(6, producto.preciosc);
            stmt.setDouble(7, producto.preciosvo);
            stmt.setInt(8, producto.estado);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para eliminar un producto por clave
    public static boolean eliminarProducto(Connection conn, String cvproducto) throws SQLException {
        String sql = "DELETE FROM productos WHERE cvproducto = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cvproducto);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para listar todos los productos
    public static List<Producto> listarProductos(Connection conn) throws SQLException {
        String sql = "SELECT * FROM productos";
        List<Producto> productos = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                productos.add(new Producto(
                        rs.getString("cvproducto"),
                        rs.getString("nombre"),
                        rs.getString("marca"),
                        rs.getInt("existencias"),
                        rs.getDouble("preciosu"),
                        rs.getDouble("preciosc"),
                        rs.getDouble("preciosvo"),
                        rs.getInt("estado")
                ));
            }
        }
        return productos;
}
    public static boolean modificarProducto(Connection conn, Producto producto) throws SQLException {
    String sql = "UPDATE productos SET nombre = ?, marca = ?, existencias = ?, preciosu = ?, preciosc = ?, preciosvo = ?, estado = ? WHERE cvproducto = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, producto.nombre);
        stmt.setString(2, producto.marca);
        stmt.setInt(3, producto.existencias);
        stmt.setDouble(4, producto.preciosu);
        stmt.setDouble(5, producto.preciosc);
        stmt.setDouble(6, producto.preciosvo);
        stmt.setInt(7, producto.estado);
        stmt.setString(8, producto.cvproducto);
        int row = stmt.executeUpdate();
        return row > 0;
    }
}
    public static Producto buscarProducto(Connection conn, String cvproducto) throws SQLException {
        String sql = "SELECT * FROM productos WHERE cvproducto = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cvproducto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Producto(
                            rs.getString("cvproducto"),
                            rs.getString("nombre"),
                            rs.getString("marca"),
                            rs.getInt("existencias"),
                            rs.getDouble("preciosu"),
                            rs.getDouble("preciosc"),
                            rs.getDouble("preciosvo"),
                            rs.getInt("estado")
                    );
                }else{
                    return null;
                }
            }
        }
    }
    public static List<Object> detalleProducto(Connection conn, String cvproducto) throws SQLException {
        List<Object> detalle = new ArrayList();
        String procedimiento = "{CALL DetallerProducto(?, ?, ?, ?)}";
        try (CallableStatement stmt = (CallableStatement) conn.prepareCall(procedimiento)) {
            stmt.setString(1, cvproducto);
            stmt.registerOutParameter(2, Types.VARCHAR);  // Para marcaP
            stmt.registerOutParameter(3, Types.DATE);     // Para fechaP
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.execute();
            detalle.add(stmt.getString(2));
            detalle.add(stmt.getDate(3));
            detalle.add(stmt.getInt(4));
        }
        return detalle;
    }
    
    public static List<Object> ultimaFecha(Connection conn, String cvproducto) throws SQLException{
        List<Object> detalle = new ArrayList();
        String procedimiento = "{CALL UltimaFecha(?, ?, ?, ?)}";
        try (CallableStatement stmt = (CallableStatement) conn.prepareCall(procedimiento)) {
            stmt.setString(1, cvproducto);
            stmt.registerOutParameter(2, Types.VARCHAR);  // Para marcaP
            stmt.registerOutParameter(3, Types.DATE);     // Para fechaP
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.execute();
            detalle.add(stmt.getString(2));
            detalle.add(stmt.getDate(3));
            detalle.add(stmt.getInt(4));
        }
        return detalle;
    }
    
    public static double obtenerOferta(Connection conn, String cvproducto) throws SQLException{
        int scvproducto = Integer.parseInt(cvproducto);
        double oferta; 
        String procedimiento = "{CALL ObtenerOferta(?)}";
        try (CallableStatement stmt = (CallableStatement) conn.prepareCall(procedimiento)) {
            stmt.setInt("cvproduct", scvproducto);
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.execute();
            oferta = stmt.getDouble("cvproduct");
        }
        if(oferta < 0.0){
           JOptionPane.showMessageDialog(null, "Este producto no esta en oferta", "Oferta invalida", 1);
        }
         return oferta;
    }
    
    public static void realizarCompra(Connection conn, String cvproducto, int cantidad) throws SQLException{
        String procedimiento = "{CALL RealizarCompra(?, ?, ?)}";
        int bandera;
        try (CallableStatement stmt = (CallableStatement) conn.prepareCall(procedimiento)) {
            stmt.setString("cvproduct", cvproducto);
            stmt.setInt("cantidadP", cantidad);
            stmt.registerOutParameter(3, Types.INTEGER);
            stmt.execute();
            bandera = stmt.getInt(3);
        }
        if (bandera==0){
            JOptionPane.showMessageDialog(null, "La transaccion no fue completada", "Transación", 1);
        }
        JOptionPane.showMessageDialog(null, "La transaccion fue completada", "Transacción", 1);
    }

    @Override
    public String toString() {
        return "Producto{" + "cvproducto=" + cvproducto + ", nombre=" + nombre + ", marca=" + marca + ", existencias=" + existencias + ", preciosu=" + preciosu + ", preciosc=" + preciosc + ", preciosvo=" + preciosvo + ", estado=" + estado + ')';
    }
}

