package com.example.portafolio.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "TIPOS_SERVICIO") //Tabla base de datos (Tener en cuenta Mayúsculas y Minúsculas
public class TipoServicio implements Serializable {

    @Id //Clave Primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Clave Primaria Autoincrementable
    @Column(name = "id_tipo_servicio") //nombre de la columna en la base de datos
    private short idTipoServicio;

    private String nombre;

    public TipoServicio() {
    }

    public TipoServicio(short idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public short getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(short idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
