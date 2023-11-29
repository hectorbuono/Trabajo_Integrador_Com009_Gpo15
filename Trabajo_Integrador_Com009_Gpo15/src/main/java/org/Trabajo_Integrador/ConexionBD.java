package org.Trabajo_Integrador;

import java.sql.*;


public class ConexionBD {

    // Definir la URL de conexión, el usuario y la contraseña
    static final String URL_CONEXION = "jdbc:mysql://localhost:3306/incidentes";
    static final String USUARIO = "root";
    static final String CONTRASENA = "";

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Paso 1: Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Paso 2: Establecer la conexión con la base de datos
            System.out.println("Conectando a la base de datos...");
            conexion = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa");

            // Puedes realizar operaciones con la base de datos aquí

        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } finally {
            try {
                // Paso 3: Cerrar la conexión (si está abierta)
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                    System.out.println("Conexión cerrada");
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
