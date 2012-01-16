/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;
import javax.ejb.Stateless;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;
import jpa.entities.SucursalSalida;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class SucursalSalidaFacade {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<SucursalSalida> findSucursal(String Sucursal, String Desde, String Hasta) throws ParseException {
        if(Desde == "")
        {
            Desde = "00/00/0000";
        }
        
        if(Hasta == "")
        {
            Hasta = "00/00/0000";
        }
        String sel;
        sel = "select new jpa.entities.SucursalSalida(a.mgiroPK.folioGiro, a.folioComp, ";
        sel = sel + "e.nombreestado , a.mgiroPK.sucRemite, ";
        sel = sel + "a.sucdestina, a.sucPagdev, a.rutRemite , a.digRemite, a.montoGiro, a.numedoc, ";
        sel = sel + "a.coFiGiro, a.fechaGiro, a.horaGiro, a.fecPagdev,a.horPagdev, ";
        sel = sel + " b.nombreclte ,b.appcliente,b.apmcliente) ";
        
        sel = sel + "from Mgiro a , Mcliente b , Estadogiro e ";
        //sel = sel + "where a.rutdestina = b.rutcliente ";
        //sel = sel + "and a.estadogiro = e.codigoestado ";
        sel = sel + "where (a.mgiroPK.sucRemite = :sucRemite or :sucRemite = '-1')";
        sel = sel + "and (a.fechaGiro >= :desde)";
        sel = sel + "and (a.fechaGiro <= :hasta)";
        
        Query q;
        List<SucursalSalida> sucursalSalida = null;
        
        try{
        
        q = em.createQuery(sel);
        q.setParameter("sucRemite", Sucursal);
        q.setParameter("desde", formato.parse(Desde));
        q.setParameter("hasta", formato.parse(Hasta));
        }
        
        catch(Exception ex)
        {
        q = em.createQuery(sel);
        q.setParameter("sucRemite", Sucursal);
        q.setParameter("desde", formato.parse(Desde));
        q.setParameter("hasta", formato.parse(Hasta));
        }
        
        sucursalSalida = q.getResultList();
        return sucursalSalida;
        }
}
