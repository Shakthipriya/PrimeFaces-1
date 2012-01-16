/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.entities.Estadogiro;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class EstadoGiroFacade {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Estadogiro> findEstados() {
        Query q = em.createQuery("SELECT e FROM Estadogiro e");
        List<Estadogiro> estados = q.getResultList();
        return estados;
    }
    
    public String findEstadoById(String Id)
    {
        Query q = em.createQuery("SELECT e FROM Estadogiro e where e.codigoestado = :codigoestado");
        q.setParameter("codigoestado", Id);
        Estadogiro est = (Estadogiro) q.getSingleResult();
        return est.getNombreestado();
    }
    
}
