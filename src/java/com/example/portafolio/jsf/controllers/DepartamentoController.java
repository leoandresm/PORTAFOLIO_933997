/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jsf.controllers;

import com.example.portafolio.jpa.entities.Departamento;
import com.example.portafolio.jpa.entities.Pais;
import com.example.portafolio.jpa.sessions.DepartamentoSession;
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
public class DepartamentoController implements Serializable {

    @EJB //Enterprise Java Beans
    private DepartamentoSession departamentoSession;
    
    private Departamento selectedDepartamento;
    private String idPais;
    private List<Departamento> itemsDepartamento = null;
    
    public DepartamentoController() {
    }

    public Departamento getSelectedDepartamento() {
        if (selectedDepartamento == null) {
            selectedDepartamento = new Departamento();
        }
        return selectedDepartamento;
    }

    public void setSelectedDepartamento(Departamento selectedDepartamento) {
        this.selectedDepartamento = selectedDepartamento;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public DepartamentoSession getDepartamentoSession() {
        return departamentoSession;
    }

    public List<Departamento> getItemsDepartamento() {
        if (itemsDepartamento == null) {
            try {
                itemsDepartamento = getDepartamentoSession().findAll();
            } catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
        return itemsDepartamento;
    }
    
    public void create(){
        try {
            selectedDepartamento.setIdPais(new Pais(idPais));
            getDepartamentoSession().create(selectedDepartamento);
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
    
    public void remove(){
        try {
            getDepartamentoSession().remove(selectedDepartamento);
            itemsDepartamento = null;
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
    
}
