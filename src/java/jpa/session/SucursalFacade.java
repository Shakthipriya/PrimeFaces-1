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
import jpa.entities.Sucursal;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class SucursalFacade {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Sucursal> findSucursales() {
        Query q = em.createQuery("SELECT s FROM Sucursal s");
        List<Sucursal> sucursales = q.getResultList();
        return sucursales;
    }
}
