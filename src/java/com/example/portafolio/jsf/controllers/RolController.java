package com.example.portafolio.jsf.controllers;

import com.example.portafolio.jpa.entities.Rol;
import com.example.portafolio.jpa.sessions.RolSession;
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
public class RolController implements Serializable {
    
    @EJB //Enterprise Java Beans
    private RolSession rolSession;
    
    private Rol selectedRol;
    private List<Rol> itemsRol = null;

    /**
     * Creates a new instance of RolController
     */
    public RolController() {
    }

    public Rol getSelectedRol() {
        if (selectedRol == null) {
            selectedRol = new Rol();
        }
        return selectedRol;
    }

    public void setSelectedRol(Rol selectedRol) {
        this.selectedRol = selectedRol;
    }

    public RolSession getRolSession() {
        return rolSession;
    }
    
    public void create () {
        try {
            getRolSession().create(selectedRol);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Rol> getItemsRol() {
        if (itemsRol == null) {
            try {
                itemsRol = getRolSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsRol;
    }    
}
