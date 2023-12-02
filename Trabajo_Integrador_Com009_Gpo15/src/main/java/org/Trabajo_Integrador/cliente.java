package org.Trabajo_Integrador;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;
import javax.persistence.Entity;

public class cliente {

    private static conexionBD conexion_BD;

    public static void main(String[] args) throws SQLException {
        // Obtener la conexión
        conexion_BD = new conexionBD();
        listarTablaClientes();
        conexionBD.cerrarConexion();

    }



    private static void listarTablaClientes() {
        // Consulta SQL para seleccionar todos los datos de la tabla
        String consulta = "SELECT * FROM cliente";

        try {
            // Obtener la conexión de la instancia de conexionBD
            Connection connection = conexion_BD.obtenerConexion();

            // Crear una declaración
            Statement statement = connection.createStatement();

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery(consulta);

            // Imprimir los resultados
            while (resultSet.next()) {
                int id_cliente = resultSet.getInt("id_cliente");
                BigDecimal cuit_cliente = resultSet.getBigDecimal("cuit_cliente");
                String razon_social_cliente = resultSet.getString("razon_social_cliente");
                System.out.println("ID: " + id_cliente + ", CUIT: " + cuit_cliente + ", Razón Social: " + razon_social_cliente);
            }

            // Cerrar recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static void agregarRegistroClientes(String nombreTabla) {
        // Obtener la conexión desde la instancia de ConexionDB
        Connection conexion = conexion_BD.obtenerConexion();

        try {
            // Obtener las columnas de la tabla desde la base de datos
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nombreTabla);
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Crear un StringBuilder para construir la consulta SQL
            StringBuilder consultaBuilder = new StringBuilder("INSERT INTO " + nombreTabla + " (");
            for (int i = 1; i <= columnCount; i++) {
                consultaBuilder.append(resultSet.getMetaData().getColumnName(i));
                if (i < columnCount) {
                    consultaBuilder.append(", ");
                }
            }
            consultaBuilder.append(") VALUES (");

            // Construir los placeholders para los valores
            for (int i = 1; i <= columnCount; i++) {
                consultaBuilder.append("?");
                if (i < columnCount) {
                    consultaBuilder.append(", ");
                }
            }
            consultaBuilder.append(")");

            // Crear una declaración preparada
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaBuilder.toString());

            // Solicitar datos desde el teclado y establecer los valores para los parámetros
            Scanner scanner = new Scanner(System.in);
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("Ingrese el valor para la columna '" + resultSet.getMetaData().getColumnName(i) + "': ");
                if (resultSet.getMetaData().getColumnClassName(i).equals("java.lang.String")) {
                    preparedStatement.setString(i, scanner.next());
                } else if (resultSet.getMetaData().getColumnClassName(i).equals("java.lang.Integer")) {
                    preparedStatement.setInt(i, scanner.nextInt());
                }
            }

            // Ejecutar la consulta de inserción
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Fila insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la fila.");
            }

            // Cerrar recursos
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

