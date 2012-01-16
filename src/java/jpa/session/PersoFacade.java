/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;
import jpa.entities.Mperso;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class PersoFacade {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    //public PersoFacade() {
    //    super(Mperso.class);
    //}
    
    public String validaCredenciales(String user, String pass)
    {
        String sel = "";
        sel = "select a.pers from Mperso a where (a.pers = :varPers and a.clapers = :varPass)";
        
        Query q;
        Object persSalida = null;
        
        try{
        
        q = em.createQuery(sel);
        q.setParameter("varPers", user);
        q.setParameter("varPass", pass);
        }
        
        catch(Exception ex)
        {
        return "";
        }
        
        try
        {
            persSalida = q.getSingleResult();
            return persSalida.toString();
        }
        catch(Exception ex)
        {
        return "";
        }
    }
    
    public String userName(String user, String pass)
    {
        String sel = "";
        sel = "select a.npers from Mperso a where (a.pers = :varPers and a.clapers = :varPass)";
        
        Query q;
        Object persSalida = null;
        
        try{
        
        q = em.createQuery(sel);
        q.setParameter("varPers", user);
        q.setParameter("varPass", pass);
        }
        
        catch(Exception ex)
        {
        return "";
        }
        
        try
        {
            persSalida = q.getSingleResult();
            return persSalida.toString();
        }
        catch(Exception ex)
        {
        return "";
        }
    }
    
    public String userRol(String user, String pass)
    {
        String sel = "";
        sel = "select a.tpers from Mperso a where (a.pers = :varPers and a.clapers = :varPass)";
        
        Query q;
        Object persSalida = null;
        
        try{
        
        q = em.createQuery(sel);
        q.setParameter("varPers", user);
        q.setParameter("varPass", pass);
        }
        
        catch(Exception ex)
        {
        return "";
        }
        
        try
        {
            persSalida = q.getSingleResult();
            return persSalida.toString();
        }
        catch(Exception ex)
        {
        return "";
        }
    }
    
}
