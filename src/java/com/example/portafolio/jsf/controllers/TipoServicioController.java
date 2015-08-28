package com.example.portafolio.jsf.controllers;

import com.example.portafolio.jpa.entities.TipoServicio;
import com.example.portafolio.jpa.sessions.TipoServicioSession;
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
public class TipoServicioController implements Serializable {
    
    @EJB //Enterprise Java Beans
    private TipoServicioSession tipoServicioSession;
    
    private TipoServicio selectedTipoServicio;
    private List<TipoServicio> itemsTipoServicio = null;

    /**
     * Creates a new instance of TipoServicioController
     */
    public TipoServicioController() {
    }

    public TipoServicio getSelectedTipoServicio() {
        if (selectedTipoServicio == null) {
            selectedTipoServicio = new TipoServicio();
        }
        return selectedTipoServicio;
    }

    public void setSelectedTipoServicio(TipoServicio selectedTipoServicio) {
        this.selectedTipoServicio = selectedTipoServicio;
    }

    public TipoServicioSession getTipoServicioSession() {
        return tipoServicioSession;
    }
    
    public void create () {
        try {
            getTipoServicioSession().create(selectedTipoServicio);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<TipoServicio> getItemsTipoServicio() {
        if (itemsTipoServicio == null) {
            try {
                itemsTipoServicio = getTipoServicioSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsTipoServicio;
    }    
}
