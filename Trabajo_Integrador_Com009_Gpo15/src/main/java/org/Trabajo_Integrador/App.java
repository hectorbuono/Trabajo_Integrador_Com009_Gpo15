package org.Trabajo_Integrador;

import java.sql.Connection;

public class App {

    public static void main(String[] args) {
        // Obtener la conexión
        Connection conexion = conexionBD.obtenerConexion();

        // Realizar operaciones con la base de datos si es necesario
        // ...

        // Cerrar la conexión cuando hayas terminado
        ConexionBD.cerrarConexion();
    }
}

