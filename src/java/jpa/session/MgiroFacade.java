/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Mgiro;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class MgiroFacade extends AbstractFacade<Mgiro> {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MgiroFacade() {
        super(Mgiro.class);
    }
    
}
