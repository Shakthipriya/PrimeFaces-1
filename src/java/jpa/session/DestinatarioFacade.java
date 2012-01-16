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
import jpa.entities.Destinatario;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class DestinatarioFacade {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Destinatario> findDestinatario(String Sucursal, int Estado, String Rut, String Desde, String Hasta) throws ParseException {
        if(Desde == "")
        {
            Desde = "00/00/0000";
        }
        
        if(Hasta == "")
        {
            Hasta = "00/00/0000";
        }
        String sel;
        sel = "select new jpa.entities.Destinatario(a.mgiroPK.folioGiro, a.folioComp, ";
        sel = sel + "e.nombreestado , a.mgiroPK.sucRemite, ";
        sel = sel + "a.sucdestina, a.sucPagdev, a.rutRemite , a.digRemite, a.montoGiro, a.numedoc, ";
        sel = sel + "a.coFiGiro, a.fechaGiro, a.horaGiro, a.fecPagdev,a.horPagdev, ";
        sel = sel + " b.nombreclte ,b.appcliente,b.apmcliente) ";
        
        sel = sel + "from Mgiro a , Mcliente b , Estadogiro e ";
        sel = sel + "where a.rutdestina = b.rutcliente ";
        sel = sel + "and a.estadogiro = e.codigoestado ";
        sel = sel + "and (a.mgiroPK.sucRemite = :sucRemite or :sucRemite = '-1')";
        sel = sel + "and (e.codigoestado = :estado or :estado = 0)";
        sel = sel + "and (a.rutdestina = :rut or :rut = 0)";
        sel = sel + "and (b.rutcliente = :rut or :rut = 0)";
        sel = sel + "and (a.digdestina = :dig or :dig = '0')";
        sel = sel + "and (b.digcliente = :dig or :dig = '0')";
        sel = sel + "and (a.fechaGiro >= :desde)";
        sel = sel + "and (a.fechaGiro <= :hasta)";
        
        String[] datos;
        Query q;
        List<Destinatario> destinatario = null;
        
        try{
        datos = Rut.split("-");
        q = em.createQuery(sel);
        q.setParameter("sucRemite", Sucursal);
        q.setParameter("estado", Estado);
        q.setParameter("rut", Integer.parseInt(datos[0]));
        q.setParameter("rut", Integer.parseInt(datos[0]));
        q.setParameter("dig", datos[1]);
        q.setParameter("dig", datos[1]);
        q.setParameter("desde", formato.parse(Desde));
        q.setParameter("hasta", formato.parse(Hasta));
        }
        
        catch(Exception ex)
        {
        q = em.createQuery(sel);
        q.setParameter("sucRemite", Sucursal);
        q.setParameter("estado", Estado);
        q.setParameter("rut", 0);
        q.setParameter("rut", 0);
        q.setParameter("dig", "0");
        q.setParameter("dig", "0");
        q.setParameter("desde", formato.parse(Desde));
        q.setParameter("hasta", formato.parse(Hasta));
        }
        
        destinatario = q.getResultList();
        return destinatario;
        }
}
