package com.example.portafolio.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "ROLES") //Tabla base de datos (Tener en cuenta Mayúsculas y Minúsculas
public class Rol implements Serializable {

    @Id //Clave Primaria
    @Column(name = "id_rol") //nombre de la columna en la base de datos
    private String idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;
    
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(String idRol) {
        this.idRol = idRol;
    }
    
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
