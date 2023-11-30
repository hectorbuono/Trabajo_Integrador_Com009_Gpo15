package org.Trabajo_Integrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class gestorBD {
    private final conexionBD conexion_BD;

    public gestorBD(conexionBD conexion_BD) {
        this.conexion_BD = conexion_BD;
    }

    public void listarTabla(String nombreTabla) {
        // ... (método listarTabla sigue igual)
    }

    public void agregarFila(String nombreTabla) {
        // Obtener la conexión desde la instancia de ConexionDB
        Connection conexion = conexionBD.obtenerConexion();

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
    public void listarTablaPorTeclado() {
        // Obtener la conexión desde la instancia de ConexionDB
        Connection conexion = conexionBD.obtenerConexion();

        try {
            // Solicitar el nombre de la tabla desde el teclado
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre de la tabla: ");
            String nombreTabla = scanner.nextLine();

            // Consulta SQL para seleccionar todos los datos de la tabla
            String consulta = "SELECT * FROM " + nombreTabla;

            // Crear una declaración
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery(consulta);

            // Imprimir los resultados
            while (resultSet.next()) {
                // Adaptar esta parte según la estructura de tu tabla
                int id_incidente = resultSet.getInt("id_incidente");
                int nro_Incidente = resultSet.getInt("nro_incidente");
                String tipo_incidente = resultSet.getString("tipo_incidente");
                String titulo_incidente = resultSet.getString("titulo_incidente");
                String descripcion_incidente= resultSet.getString("descripcion_incidente");


                System.out.println("ID: " + id_incidente);
                System.out.println("--------------------------------------------------------------");
                System.out.println("                                                              ");
                System.out.println("Tipo de incidente: "+ tipo_incidente);
                System.out.println("--------------------------------------------------------------");
                System.out.println("                                                              ");
                System.out.println("Titulo del Incidente: " + titulo_incidente);
                System.out.println("--------------------------------------------------------------");
                System.out.println("                                                              ");
                System.out.println("Descripcion: "+ descripcion_incidente);
                System.out.println("                                                              ");
                System.out.println("--------------------------------------------------------------");

            }

            // Cerrar recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    // ... (otros métodos siguen igual)
