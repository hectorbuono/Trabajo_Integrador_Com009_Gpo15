package org.Trabajo_Integrador;

public class cliente {

    ConexionDB bd = new ConexionBD;

    PreparedStatement pST = bd.getConnection().preparedStatement("SELECT * FROM incidentes.cliente");


}
