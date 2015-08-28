package com.example.portafolio.jpa.sessions;

import com.example.portafolio.jpa.entities.TipoServicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author leoandresm
 */
@Stateless
public class TipoServicioSession {

    @PersistenceContext
    private EntityManager entityManager;
    
    public void create(TipoServicio tipoServicio) {
        entityManager.persist(tipoServicio);
    }
    
    public void update(TipoServicio tipoServicio) {
        entityManager.merge(tipoServicio);
    }
    
    public void remove(TipoServicio tipoServicio) {
        entityManager.remove(tipoServicio);
    }
    
    public List<TipoServicio> findAll(){
        CriteriaQuery cq = 
                entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TipoServicio.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
