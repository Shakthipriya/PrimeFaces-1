/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import jpa.entities.Estadogiro;
import jpa.entities.ClavesGiro;
import jpa.entities.Sucursal;
import jsf.EstadoGiroController;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
@ManagedBean(name = "clavesgiroController")
@SessionScoped
public class ClavesGiroController {
    @EJB
    private jpa.session.ClavesGiroFacade ejbFacade;
    private List<ClavesGiro> lstClavesGiro = null;
    private List<ClavesGiro> lstClavesGiros = null;
    //@EJB
    //private jpa.session.SucursalFacade ejbFacade2;
    //private String sucursal = "-1";
    @EJB
    private jpa.session.EstadoGiroFacade ejbFacade3;
    private String rutCliente = "";
    private String rutDestinatario = "";
    private String apellidoCliente = "";
    private String desde ;
    private String hasta;
    
    public String getHasta() {
        if(hasta == "0")
        {
        return "";
        }
        else
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

 public String getDesde() {
        if(desde == "0")
        {
        return "";
        }
        else
             return desde;
 }

 public void setDesde(String desde) {
     this.desde = desde;
 }

    public String getApellidoCliente() {
        if(apellidoCliente == "0")
        {
        return apellidoCliente;
        }
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getRutCliente() {
        if(rutCliente == "0")
        {
        return rutCliente;
        }
        else
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getRutDestinatario() {
        if(rutDestinatario == "0")
        {
        return rutDestinatario;
        }
        return rutDestinatario;
    }

    public void setRutDestinatario(String rutDestinatario) {
        this.rutDestinatario = rutDestinatario;
    }
 
    public List<ClavesGiro> getlstClavesGiro() throws ParseException {
        //String a = ejc.getEstado();
        //String a = ejc.
        //String a = sucursal;
        //if (lstRemitente == null) {
        if(rutCliente == "")
        {
            rutCliente = "0";
        }
        
        
        
        if(desde == null)
        {
            desde = "";
        }
        if(hasta == null)
        {
            hasta = "";
        }
            lstClavesGiro =  ejbFacade.findClavesGiro(rutCliente, rutDestinatario, apellidoCliente, desde, hasta);
            
        //}
        return lstClavesGiro;
    }
}
