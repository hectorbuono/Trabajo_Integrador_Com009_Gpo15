package org.Trabajo_Integrador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class cliente {

    public static void main(String[] args) throws SQLException {
        // Obtener la conexión
        Connection conexion_BD = conexionBD.obtenerConexion();

        Statement stmt= conexion_BD.createStatement();

        ResultSet rs=stmt.executeQuery("select * from cliente");


        while(rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getBigDecimal(2)+" "+rs.getString(3));

        /*int rs2 = stmt.executeUpdate("INSERT into cliente (cuit_cliente,razon_social_cliente) VALUES ('30265554748','Los Abuelos S.A.')");*/


        // Cerrar la conexión cuando hayas terminado
        conexionBD.cerrarConexion();
    }
}
