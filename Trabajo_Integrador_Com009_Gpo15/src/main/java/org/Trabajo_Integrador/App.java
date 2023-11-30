package org.Trabajo_Integrador;

import java.sql.Connection;

public class App {

    public static void main(String[] args) {
        // Obtener la conexión
        conexionBD conexion_BD = new conexionBD();
        ;
        gestorBD gestor_BD = new gestorBD(conexion_BD);
        gestor_BD.listarTablaPorTeclado();
    }

}