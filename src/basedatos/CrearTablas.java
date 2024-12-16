package basedatos;

import com.mysql.cj.jdbc.CallableStatement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;

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
        String roleTable = """
            CREATE TABLE IF NOT EXISTS roles(
                idRol INT AUTO_INCREMENT PRIMARY KEY,
                Rol VARCHAR(10) NOT NULL
            );
                           """;
        String usuariosTable = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id INT AUTO_INCREMENT PRIMARY KEY,
                usuario VARCHAR(20) NOT NULL UNIQUE,
                password VARCHAR(256) NOT NULL,
                rolUsu INT, 
                CONSTRAINT Rel_Usu_Rol 
                FOREIGN KEY (rolUsu)
                REFERENCES roles(idRol)
                ON DELETE NO ACTION
                ON UPDATE CASCADE
            );
        """;

        try (Connection con = Conexion.getConexion();
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(productosTable);
            stmt.executeUpdate(compraTable);
            stmt.executeUpdate(compradetalleTable);
            stmt.executeUpdate(pagosCPATable);
            stmt.executeUpdate(roleTable );
            stmt.executeUpdate(usuariosTable);

            System.out.println("Yupi las tablas creadas con exito en la base de datos 'finaltienda'." );

        } catch (Exception e) {
            System.err.println("error al crear las tablas: " + e.getMessage());
        }
    }
    public static void consultasEspeciales(){
        String outP = """
            CREATE PROCEDURE IF NOT EXISTS DetallerProducto(IN cvproduct VARCHAR(10), OUT marcaP VARCHAR(50), OUT fechaP DATE, OUT cantidadP INT)
            BEGIN
            DECLARE nCompra INT;
            SELECT cvcompra INTO nCompra FROM compradetalle WHERE cvproducto = cvproduct LIMIT 1;
            SELECT marca INTO marcaP FROM productos WHERE cvproducto = cvproduct LIMIT 1;
            SELECT fecha INTO fechaP FROM compra WHERE cvcompra = nCompra LIMIT 1;
            SELECT cantidad INTO cantidadP FROM compradetalle WHERE cvproducto = cvproduct LIMIT 1;
            END;
            """;
        String inoutP = """
            CREATE PROCEDURE IF NOT EXISTS ObtenerOferta (INOUT cvproduct DOUBLE)
            BEGIN
            DECLARE estadoO INT;
            SELECT estado
            INTO estadoO
            FROM productos WHERE cvproducto = cvproduct LIMIT 1;
                IF estadoO = 1 THEN
                    SELECT preciosvo
                    INTO cvproduct
                    FROM productos
                    WHERE cvproducto = cvproduct;
                ELSE
                    SET cvproduct = 0.0;
                END IF;
            END;
            """;
        String union = """
            CREATE PROCEDURE IF NOT EXISTS UltimaFecha(IN cvproduct INT, out nombreP VARCHAR(20), out fechaP DATE, OUT cantidadP INT)
            BEGIN
                SELECT p.nombre, p.existencias, c.fecha
                INTO nombreP, cantidadP, fechaP
                FROM productos p
                JOIN compra c ON p.cvproducto = c.cvcompra
                WHERE p.cvproducto = cvproduct
                ORDER BY
                c.fecha DESC
                LIMIT 1;
            END;
                       """;
        String transaccion = """
            CREATE PROCEDURE IF NOT EXISTS RealizarCompra(IN cvproduct INT, IN cantidadP INT, OUT confirmacion INT)
            BEGIN
                DECLARE cantidadDispo INT;
                START TRANSACTION;
                SELECT existencias
                INTO cantidadDispo
                FROM productos
                WHERE cvproducto = cvproduct
                FOR UPDATE;
                IF cantidadDispo < cantidadP THEN
                   ROLLBACK;
                   SET confirmacion = 0;
                ELSE
                   UPDATE productos
                   SET existencias = existencias - cantidadP
                   WHERE cvproducto = cvproduct;
                   COMMIT;
                   SET confirmacion = 1;
                END IF;
            END;""";
        String tggUpdate = """
                CREATE TRIGGER ActualizarProductos
                    AFTER INSERT ON compradetalle
                    FOR EACH ROW
                    BEGIN
                    DECLARE cvproductoP INT;
                    DECLARE nCantidad INT;
                    DECLARE nuPrecio DOUBLE;
                    DECLARE estadoP INT;
                    SELECT cantidad, cvproducto, precios 
                    INTO nCantidad, cvproductoP, nuPrecio
                    FROM compradetalle
                    ORDER BY id DESC LIMIT 1;
                    SELECT estado INTO estadoP
                    FROM productos WHERE cvproducto = cvproductoP;
                        IF estadoP = 1 THEN
                            UPDATE productos 
                            SET existencias = existencias + nCantidad, preciosu = nuPrecio, preciosC = preciosu + 5, preciosvo = preciosC*.20
                            WHERE cvproducto = cvproductoP;
                        ELSE
                            UPDATE productos 
                            SET existencias = existencias + nCantidad, preciosu = nuPrecio, preciosC = preciosu + 5
                            WHERE cvproducto = cvproductoP;
                        END IF;
                END;
                     """;
        try (Connection con = Conexion.getConexion();
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(outP);
            stmt.executeUpdate(inoutP);
            stmt.executeUpdate(union);
            stmt.executeUpdate(transaccion);
            stmt.execute(tggUpdate);

            System.out.println("Consultas especiales creada" );

        } catch (Exception e) {
            System.err.println("error al crear las tablas: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        crearTablas();
        //consultasEspeciales();
        String procedimiento = "{CALL UltimaFecha(?, ?, ?, ?)}";
        String procedimiento2 = "{CALL ObtenerOferta (?)}";
        try (Connection con = Conexion.getConexion()) {
            CallableStatement stmt = (CallableStatement) con.prepareCall(procedimiento);
            CallableStatement stmt2 = (CallableStatement) con.prepareCall(procedimiento2);
            // Parámetros de entrada
            stmt.setString(1, "1"); // ejemplo de cvproducto que pasas
            stmt2.setInt("cvproduct", 1);

            // Parámetros de salida
            stmt.registerOutParameter(2, Types.VARCHAR);  // Para marcaP
            stmt.registerOutParameter(3, Types.DATE);     // Para fechaP
            stmt.registerOutParameter(4, Types.INTEGER);  // Para cantidadP
            stmt2.registerOutParameter(1, Types.INTEGER);
            // Ejecutar el procedimiento
            stmt.execute();
            stmt2.execute();

            // Obtener los valores de salida
            String marca = stmt.getString(2);
            Date fecha = stmt.getDate(3);
            int cantidad = stmt.getInt(4);
            double stado = stmt2.getDouble("cvproduct");

            System.out.println("Marca: " + marca);
            System.out.println("Fecha: " + fecha);
            System.out.println("Cantida: " + cantidad);
            System.out.println("Estado: " + stado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
