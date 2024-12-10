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
 * @author danyv
 */
public class Usuarios {
    private int id;
    private String user;
    private String password;
    
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
    public static void agregarUsuario(Connection conn, Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO usuario (id, user, password, email, rol) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.id);
            stmt.setString(2, usuario.user);
            stmt.setString(3, usuario.password);
            stmt.executeUpdate();
            System.out.println("Usuario agregado: " + usuario);
        }
    }

    // Método para eliminar un usuario por ID
    public static void eliminarUsuario(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado con ID: " + id);
        }
    }

    // Método para listar todos los usuarios
    public static List<Usuarios> listarUsuarios(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usuario";
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

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", user=" + user + ", password=" + password + '}';
    }
    
}
