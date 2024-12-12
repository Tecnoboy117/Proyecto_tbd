/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author danyv
 */
public class Usuarios {
    private int id;
    private String user;
    private String password;
    
    public Usuarios() { 
        this.id = 0;
        this.user = "";
        this.password = "";
    }   
    
    public Usuarios(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Este es el metodo para encriptar el sha 256
    public static String encriptarPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println(hexString.toString());
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña: " + e.getMessage());
        }
    }
    public static boolean agregarUsuario(Connection conn, Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (usuario, password) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.user);
            stmt.setString(2, usuario.password);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para eliminar un usuario por ID
    public static boolean eliminarUsuario(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int row = stmt.executeUpdate();
            return row > 0;
        }
    }

    // Método para listar todos los usuarios
    public static List<Usuarios> listarUsuarios(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usuarios";
        List<Usuarios> usuarios = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(new Usuarios(
                        rs.getInt("id"),
                        rs.getString("user"),
                        rs.getString("password")));
            }
        }
        return usuarios;
    }
    //este es el metodo de acceso modificado para encriptar
    public static boolean acceso(Connection conn, Usuarios usuario) throws SQLException {
        System.out.println("Usuario: " + usuario.user + " Contraseña (encriptada): " + encriptarPassword(usuario.password));
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.user);
            pstmt.setString(2, encriptarPassword(usuario.password)); // Comparar con contraseña encriptada
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", user=" + user + ", password=" + password + '}';
    }
    
} 
