package basedatos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Statement;

public class CrearTablas {

    public static void crearTablas() {
        String productosTable = """
            CREATE TABLE IF NOT EXISTS productos (
                cvproducto INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(50) NOT NULL,
                marca VARCHAR(50),
                existencias INT DEFAULT 0,
                preciosu DOUBLE,
                preciosc DOUBLE,
                preciosvo DOUBLE,
                estado VARCHAR(20) DEFAULT 'activo'
            );
        """;

        String compraTable = """
            CREATE TABLE IF NOT EXISTS compra (
                cvcompra INT AUTO_INCREMENT PRIMARY KEY,
                fecha DATE NOT NULL,
                total DOUBLE,
                subtotal DOUBLE,
                iva DOUBLE,
                estado VARCHAR(20) DEFAULT 'pendiente'
            );
        """;

        String compradetalleTable = """
            CREATE TABLE IF NOT EXISTS compradetalle (
                id INT AUTO_INCREMENT PRIMARY KEY,
                cvcompra INT,
                cvproducto INT,
                cantidad INT DEFAULT 1,
                precios DOUBLE,
                FOREIGN KEY (cvcompra) REFERENCES compra(cvcompra),
                FOREIGN KEY (cvproducto) REFERENCES productos(cvproducto)
            );
        """;

        String pagosCPATable = """
            CREATE TABLE IF NOT EXISTS pagosCPA (
                cvpago INT AUTO_INCREMENT PRIMARY KEY,
                fecha DATE NOT NULL,
                pago DOUBLE,
                cvcompra INT,
                FOREIGN KEY (cvcompra) REFERENCES compra(cvcompra)
            );
        """;
        String usuariosTable = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id INT AUTO_INCREMENT PRIMARY KEY,
                usuario VARCHAR(20) NOT NULL UNIQUE,
                password VARCHAR(256) NOT NULL
            );
        """;

        try (Connection con = Conexion.getConexion();
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(productosTable);
            stmt.executeUpdate(compraTable);
            stmt.executeUpdate(compradetalleTable);
            stmt.executeUpdate(pagosCPATable);
            stmt.executeUpdate(usuariosTable);

            System.out.println("Yupi las tablas creadas con exito en la base de datos 'finaltienda'." );

        } catch (Exception e) {
            System.err.println("error al crear las tablas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearTablas(); 
    }
}
