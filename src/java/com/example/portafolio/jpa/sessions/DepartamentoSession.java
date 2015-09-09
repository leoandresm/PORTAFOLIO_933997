package com.example.portafolio.jpa.sessions;

import com.example.portafolio.jpa.entities.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class DepartamentoSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Departamento departamento) {
        entityManager.persist(departamento);
    }

    public void edit(Departamento departamento) {
        entityManager.merge(departamento);
    }

    public void remove(Departamento departamento) {
        entityManager.remove(departamento);
    }

    public List<Departamento> findAll() {
        CriteriaQuery cq
                = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Departamento.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
