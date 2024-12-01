package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE = "finaltienda"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

 //para crear y modificar tablas hola gael
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL + DATABASE, USER, PASSWORD);
    }

//para crear DB , hola carlos
    public static Connection getConexionSinBase() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
