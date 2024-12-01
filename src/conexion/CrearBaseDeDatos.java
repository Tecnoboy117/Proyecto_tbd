package conexion;

import java.sql.Connection;
import java.sql.Statement;

public class CrearBaseDeDatos {

    public static void crearBase() {
        String sql = "CREATE DATABASE IF NOT EXISTS finaltienda";

        try (Connection con = Conexion.getConexionSinBase(); 
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("la base de datos 'finaltienda' creada o ya existente.");

        } catch (Exception e) {
            System.err.println("error al crear la base de datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearBase();
    }
}
