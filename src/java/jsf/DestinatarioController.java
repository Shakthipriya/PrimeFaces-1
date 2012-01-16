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
import jpa.entities.Destinatario;
import jpa.entities.Sucursal;
import jsf.EstadoGiroController;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
@ManagedBean(name = "destinatarioController")
@SessionScoped
public class DestinatarioController implements Serializable{
    @EJB
    private jpa.session.DestinatarioFacade ejbFacade;
    private List<Destinatario> lstDestinatario = null;
    private List<Destinatario> lstDestinatarios = null;
    @EJB
    private jpa.session.SucursalFacade ejbFacade2;
    private String sucursal = "-1";
    @EJB
    private jpa.session.EstadoGiroFacade ejbFacade3;
    private int estado = 0;
    private String rut = "";
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

    public String getRut() {
        if(rut == "0")
        {
            return "";
        }
        else
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    private List<Sucursal> lstSucursales = null;
    private List<SelectItem> selectSucursal = new ArrayList<SelectItem>();

 
        
    private List<Estadogiro> lstEstados = null;
    private List<SelectItem> selectEstado = new ArrayList<SelectItem>();
    SimpleDateFormat f = new SimpleDateFormat("dd-mm-yyyy");
    public DestinatarioController() {
        
    }
    
    public List<Destinatario> getlstDestinatario() throws ParseException {
        //String a = ejc.getEstado();
        //String a = ejc.
        String a = sucursal;
        //if (lstRemitente == null) {
        if(rut == "")
        {
            rut = "0";
        }
        if(desde == null)
        {
            desde = "";
        }
        if(hasta == null)
        {
            hasta = "";
        }
            lstDestinatario =  ejbFacade.findDestinatario(sucursal, estado, rut, desde, hasta );
            
        //}
        return lstDestinatario;
    }

    
    public List getselectSucursal() {
        if (lstSucursales == null) {
            lstSucursales =  ejbFacade2.findSucursales();
            for(Sucursal s : lstSucursales)
            {
                selectSucursal.add(new SelectItem(s.getCodigoSuc(), s.getCodigoSuc()));
            }
        }
        return selectSucursal;
    }
    
    public String getSucursal() {
        return sucursal;
    }
    
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    public List getselectEstado() {
        if (lstEstados == null) {
            lstEstados =  ejbFacade3.findEstados();
            for(Estadogiro e : lstEstados)
            {
                selectEstado.add(new SelectItem(e.getCodigoestado(), e.getNombreestado()));
            }
        }
        return selectEstado;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
