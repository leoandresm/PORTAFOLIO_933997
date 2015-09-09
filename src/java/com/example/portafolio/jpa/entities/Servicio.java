package com.example.portafolio.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "SERVICIOS")
public class Servicio implements Serializable {

    @Id //Clave Primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Clave Primaria Autoincrementable
    @Column(name = "id_servicio") //nombre de la columna en la base de datos
    private int idServicio;

    private String nombre;

    private String descripcion;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_tipo_servicio")
    private TipoServicio tipoServicio;
    
    @OneToMany(mappedBy = "servicio")
    private List<CalificacionServicio> calificacionesServicios;

    public Servicio() {
    }

    public Servicio(int idServicio) {
        this.idServicio = idServicio;
    }
    
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public List<CalificacionServicio> getCalificacionesServicios() {
        return calificacionesServicios;
    }

    public void setCalificacionesServicios(List<CalificacionServicio> calificacionesServicios) {
        this.calificacionesServicios = calificacionesServicios;
    }
    
}
