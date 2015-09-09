/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "PAISES") //Tabla base de datos (Tener en cuenta Mayúsculas y Minúsculas
public class Pais implements Serializable {
    
    @Id //Clave Primaria
    @Column (name = "id_pais") //nombre de la columna en la base de datos
    private String idPais;
    
    @Column (name = "nombre_pais")
    @Size(max = 60)
    private String nombrePais;
    
    @OneToMany(mappedBy = "pais")
    private List<Departamento> departamentos;

    public Pais() {
    }

    public Pais(String idPais) {
        this.idPais = idPais;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
}//Fin clase Pais
