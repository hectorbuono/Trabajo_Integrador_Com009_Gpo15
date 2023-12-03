package org.Trabajo_Integrador;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "incidentes")
public class incidentes {
    @Id
    @Column(name = "id_incidente", nullable = false, length= 11)
    private BigInteger id;

    @Column(name = "nro_incidente", nullable = false, length= 11)
    private BigInteger nro_incidente;


    @Column(name = "tipo_incidente", nullable = false, length = 3)
    private Integer tipo_incidente;

    @Column(name = "titulo_incidente", nullable = false, length = 50)
    private String titulo_incidente;

    @Column(name = "descripcion_incidente", nullable = false, length = 300)
    private String descripcion_incidente;

}