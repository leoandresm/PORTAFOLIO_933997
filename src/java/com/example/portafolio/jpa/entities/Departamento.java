package com.example.portafolio.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table ( name = "DEPARTAMENTOS")
public class Departamento implements Serializable {
    
    @Id
    @Column (name = "id_departamento")
    private int idDepartamento;
    
    @Column (name = "nombre_departamento")
    private String nombreDepartamento;
    
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
    
    @OneToMany(mappedBy = "departamento")
    private List<Ciudad> ciudades;
    

    public Departamento() {
    }

    public Departamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }    
    
}
