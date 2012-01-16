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
import jpa.entities.Opcion;
import jpa.entities.PerfilUsrRol;
import jpa.entities.Privilegio;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Stateless
public class PerfilUsrRolFacade {
    @PersistenceContext(unitName = "ABCDin1PU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public String findIdPerfil(String usrRol)
    {
        String sel = "";
        sel = "select a.codigoPerfil from PerfilUsrRol a where a.usrRol = :varRol";
        
        Query q;
        Object persSalida = null;
        
        try{
        
        q = em.createQuery(sel);
        q.setParameter("varRol", usrRol);
        }
        
        catch(Exception ex)
        {
        return "";
        }
        
        try
        {
            persSalida = q.getSingleResult();
            sel = "";
            sel = "select p from Privilegio p where p.privilegioPK.perCodigo = :perCodigo";
            
            q  = em.createQuery(sel);
            
            q.setParameter("perCodigo", Integer.parseInt(persSalida.toString()));
            List<Privilegio> lstPrivilegio = q.getResultList();
            String menu = "";
            for(Privilegio p : lstPrivilegio)
            {
                sel = "";
                //selectSucursal.add(new SelectItem(s.getCodigoSuc(), s.getCodigoSuc()));
                p.getPrivilegioPK().getOpcCodigo();
                sel = "select o from Opcion o where o.opcionPK.opcCodigo = :opcCodigo";
                q  = em.createQuery(sel);
            
                q.setParameter("opcCodigo", p.getPrivilegioPK().getOpcCodigo());
                
                Opcion op = (Opcion) q.getSingleResult();
                menu = menu + "<li> ";
                
                menu = menu + "<a  href='./" + op.getOpcNombre() + "/" + op.getOpcNombre() + ".jsf' > ";
                menu = menu + "<img src='./resources/img/botongiros" + op.getOpcNombre() + ".png' width = '146px' height='33px' style='cursor:pointer;' />"; 
                menu = menu + "</a></li>";   
                
            }
            return menu;
        }
        catch(Exception ex)
        {
        return "";
        }
        
        
        
    }
    
    public String findIdPerfil2(String usrRol)
    {
        String sel = "";
        sel = "select a.codigoPerfil from PerfilUsrRol a where a.usrRol = :varRol";
        
        Query q;
        Object persSalida = null;
        
        try{
        
        q = em.createQuery(sel);
        q.setParameter("varRol", usrRol);
        }
        
        catch(Exception ex)
        {
        return "";
        }
        
        try
        {
            persSalida = q.getSingleResult();
            sel = "";
            sel = "select p from Privilegio p where p.privilegioPK.perCodigo = :perCodigo";
            
            q  = em.createQuery(sel);
            
            q.setParameter("perCodigo", Integer.parseInt(persSalida.toString()));
            List<Privilegio> lstPrivilegio = q.getResultList();
            String menu = "";
            for(Privilegio p : lstPrivilegio)
            {
                sel = "";
                //selectSucursal.add(new SelectItem(s.getCodigoSuc(), s.getCodigoSuc()));
                p.getPrivilegioPK().getOpcCodigo();
                sel = "select o from Opcion o where o.opcionPK.opcCodigo = :opcCodigo";
                q  = em.createQuery(sel);
            
                q.setParameter("opcCodigo", p.getPrivilegioPK().getOpcCodigo());
                
                Opcion op = (Opcion) q.getSingleResult();
                menu = menu + "<li> ";
                
                menu = menu + "<a  href='./../" + op.getOpcNombre() + "/" + op.getOpcNombre() + ".jsf' > ";
                menu = menu + "<img src='./../resources/img/botongiros" + op.getOpcNombre() + ".png' width = '146px' height='33px' style='cursor:pointer;' />"; 
                menu = menu + "</a></li>";   
                
            }
            return menu;
        }
        catch(Exception ex)
        {
        return "";
        }
    }
        
}
