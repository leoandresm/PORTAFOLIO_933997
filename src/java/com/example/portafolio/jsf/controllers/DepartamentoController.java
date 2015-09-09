package com.example.portafolio.jsf.controllers;

import com.example.portafolio.jpa.entities.Departamento;
import com.example.portafolio.jpa.entities.Pais;
import com.example.portafolio.jpa.sessions.DepartamentoSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author leoandresm
 */
@ManagedBean
@ViewScoped
public class DepartamentoController implements Serializable {
    
    @EJB //Enterprise Java Beans
    private DepartamentoSession departamentoSession;
    
    private Departamento selectedDepartamento;
    private List<Departamento> itemsDepartamento = null;
    private String idPais;

    /**
     * Creates a new instance of DepartamentoController
     */
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
    
    public void create () {
        try {
            selectedDepartamento.setPais(new Pais(idPais));
            getDepartamentoSession().create(selectedDepartamento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Departamento> getItemsDepartamento() {
        if (itemsDepartamento == null) {
            try {
                itemsDepartamento = getDepartamentoSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsDepartamento;
    }    
}
