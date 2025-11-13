/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.clase.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author andyc
 */
public class dbConnection {

// Link para descargar el drive jdbc → https://www.mysql.com/products/connector/

    private static String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static String USER = "root";
    private static String PASSWORD = "Andyco2003.";
     
    public static Connection obtenerConexion() throws SQLException {
        try { 
            // Cargar el driver de MySQL (opcional en versiones modernas)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer y retornar la conexión
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver de MySQL", e);
        }
    }
    
    public static void probarConexion() {
        try (Connection conn = obtenerConexion()) {
            System.out.println("Conexion exitosa a la base de datos");
            System.out.println("  Base de datos: " + conn.getCatalog());
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }

}
