package org.Trabajo_Integrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conexionBD {

    // Definir la URL de conexión, el usuario y la contraseña
    static final String URL_CONEXION = "jdbc:mysql://localhost:3306/incidentes";
    static final String USUARIO = "root";
    static final String CONTRASENA = "";

    // La conexión se declara como miembro de la clase para que sea accesible desde otros métodos
    private static Connection conexion = null;

    // Método para obtener la conexión
    public static Connection obtenerConexion() {
        if (conexion == null) {
            try {
                // Paso 1: Cargar el controlador JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Paso 2: Establecer la conexión con la base de datos
                System.out.println("Conectando a la base de datos...");
                conexion = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASENA);
                System.out.println("Conexión exitosa");
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
