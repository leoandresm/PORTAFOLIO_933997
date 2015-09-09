/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jpa.sessions;

import com.example.portafolio.jpa.entities.Servicio;
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
public class ServicioSession {

   @PersistenceContext
   private EntityManager entityManager;
   
   public void create(Servicio servicio){
       entityManager.persist(servicio);
   }  
   
   public void edit(Servicio servicio) {
       entityManager.merge(servicio);
   }
   
   public void remove(Servicio servicio) {
       entityManager.remove(servicio);
   }
   
   public List<Servicio> findAll(){
       CriteriaQuery cq =
               entityManager.getCriteriaBuilder().createQuery();
       cq.select(cq.from(Servicio.class));
       return entityManager.createQuery(cq).getResultList();
   }
           
}
