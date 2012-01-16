/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.ListDataModel;
import javax.faces.model.DataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.entities.Musuarios;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class MusuariosFacade extends AbstractFacade<Musuarios> {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;
    private Musuarios[] objmusuarios;
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public MusuariosFacade() {
        super(Musuarios.class);
    }
    
    public List<Musuarios>  findAll2() {
        //javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        //cq.select(cq.from(entityClass));
        Query q = em.createQuery("SELECT m FROM Musuarios m");
        //q.setParameter("Rut_Usuario","13274161-1");
        //List<Musuarios> usr;
        //objmusuarios = new Musuarios[10];
        List<Musuarios> usr = q.getResultList();
        //for(int i = 0; i++; i > usr.
            return usr;
    }
    
    
    
}
