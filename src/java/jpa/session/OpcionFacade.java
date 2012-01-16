/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.entities.Opcion;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class OpcionFacade extends AbstractFacade<Opcion> {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionFacade() {
        super(Opcion.class);
    }
   
}
