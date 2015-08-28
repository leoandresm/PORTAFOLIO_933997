/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jpa.entities;

import java.io.Serializable;

/**
 *
 * @author leoandresm
 */
public class CiudadPK implements Serializable {
    
    private int idCiudad;
    private int idDepartamento;

    public CiudadPK() {
    }

    public CiudadPK(int idCiudad, int idDepartamento) {
        this.idCiudad = idCiudad;
        this.idDepartamento = idDepartamento;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idCiudad;
        hash = 23 * hash + this.idDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CiudadPK other = (CiudadPK) obj;
        if (this.idCiudad != other.idCiudad) {
            return false;
        }
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        return true;
    }

}
