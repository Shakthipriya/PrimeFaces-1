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
import jpa.entities.ClavesGiro;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class ClavesGiroFacade {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<ClavesGiro> findClavesGiro(String RutCliente, String RutDestinatario, String ApellidoCliente, String Desde, String Hasta) throws ParseException {
        if(Desde == "")
        {
            Desde = "00/00/0000";
        }
        
        if(Hasta == "")
        {
            Hasta = "00/00/0000";
        }
        
        if(RutCliente == "0")
        {
            RutCliente = "0-0";
        }
        
        if(RutDestinatario == "")
        {
            RutDestinatario = "0-0";
        }
        
        if(ApellidoCliente == "")
        {
            ApellidoCliente = "0";
        }
        String sel;
        sel = "select new jpa.entities.ClavesGiro(a.mgiroPK.folioGiro, a.folioComp, ";
        sel = sel + "e.nombreestado , a.mgiroPK.sucRemite, ";
        sel = sel + "a.sucdestina, a.sucPagdev, a.montoGiro, a.numedoc, ";
        sel = sel + "a.coFiGiro, a.fechaGiro, a.horaGiro, a.fecPagdev,a.horPagdev, ";
        sel = sel + " b.nombreclte ,b.appcliente,b.apmcliente, a.rutdestina, a.digdestina) ";
        
        sel = sel + "from Mgiro a , Mcliente b , Estadogiro e ";
        sel = sel + "where a.rutRemite = b.rutcliente ";
        sel = sel + "and a.estadogiro = e.codigoestado ";
        sel = sel + "and (a.rutRemite = :rutRmte or :rutRmte = 0)";
        sel = sel + "and (a.rutdestina = :rutClte or :rutClte = 0)";
        sel = sel + "and (a.digRemite = :digRmte or :digRmte = '0')";
        sel = sel + "and (a.digdestina = :digClte or :digClte = '0')";
        sel = sel + "and (b.appcliente = :apClte or :apClte = '0')";
        sel = sel + "and (a.fechaGiro >= :desde)";
        sel = sel + "and (a.fechaGiro <= :hasta)";
        
        String[] datos;
        String[] datos2;
        Query q;
        List<ClavesGiro> clavesGiro = null;
        
        try{
        datos = RutCliente.split("-");
        datos2 = RutDestinatario.split("-");
        q = em.createQuery(sel);
        q.setParameter("rutRmte", Integer.parseInt(datos[0]));
        q.setParameter("rutClte", Integer.parseInt(datos2[0]));
        q.setParameter("digRmte", datos[1]);
        q.setParameter("digClte", datos2[1]);
        q.setParameter("apClte", ApellidoCliente);
        q.setParameter("desde", formato.parse(Desde));
        q.setParameter("hasta", formato.parse(Hasta));
        }
        
        catch(Exception ex)
        {
        q = em.createQuery(sel);
        q.setParameter("rutRmte", 0);
        q.setParameter("rutClte", 0);
        q.setParameter("digRmte", "0");
        q.setParameter("digClte", "0");
        q.setParameter("apClte", ApellidoCliente);
        q.setParameter("desde", formato.parse(Desde));
        q.setParameter("hasta", formato.parse(Hasta));
        }
        
        clavesGiro = q.getResultList();
        return clavesGiro;
        }
}
