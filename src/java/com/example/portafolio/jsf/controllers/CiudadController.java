/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jsf.controllers;

import com.example.portafolio.jpa.entities.Ciudad;
import com.example.portafolio.jpa.entities.Departamento;
import com.example.portafolio.jpa.sessions.CiudadSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


/**
 *
 * @author leoandresm
 */
@Named
@ViewScoped
public class CiudadController implements Serializable {

    @EJB //Enterprise Java Beans
    private CiudadSession ciudadSession;
    
    private Ciudad selectedCiudad;
    private int idDepartamento;
    private List<Ciudad> itemsCiudad = null;
    
    public CiudadController() {
    }

    public Ciudad getSelectedCiudad() {
        if (selectedCiudad == null) {
            selectedCiudad = new Ciudad();
        }
        return selectedCiudad;
    }

    public void setSelectedCiudad(Ciudad selectedCiudad) {
        this.selectedCiudad = selectedCiudad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public CiudadSession getCiudadSession() {
        return ciudadSession;
    }

    public List<Ciudad> getItemsCiudad() {
        if (itemsCiudad == null) {
            try {
                itemsCiudad = getCiudadSession().findAll();
            } catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
        return itemsCiudad;
    }
    
    public void create(){
        try {
            selectedCiudad.setIdDepartamento(new Departamento(idDepartamento));
            getCiudadSession().create(selectedCiudad);
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
    
    public void remove(){
        try {
            getCiudadSession().remove(selectedCiudad);
            itemsCiudad = null;
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
    
}
