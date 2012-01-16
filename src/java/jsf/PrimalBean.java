/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jpa.entities.SucursalSalida;
import jpa.entities.Sucursal;

/**
 *
 * @author andres
 */
@ManagedBean(name="primalBean")
@RequestScoped
public class PrimalBean {
 @EJB
    private jpa.session.SucursalSalidaFacade ejbFacade;
    private List<SucursalSalida> lstSucursalSalida = null;

    public List<SucursalSalida> getLstSucursalSalida() {
        return lstSucursalSalida;
    }

    
    /**
     * Creates a new instance of PrimalBean
     */
    private String param;
    private String from;
    private String to;
    private String rut;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String From) {
        this.from = From;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
   
    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
    
    public void action(){
        param = "Hola " + param;
    }
    public void getlstSucursalSalida() throws ParseException {

        
        
        long tot = 0;
        long totIng = 0;
        long totPag = 0;
        long totDev = 0;
        int cantGiros;
        if(rut == "")
        {
            rut = "0";
        }
        if(from == null)
        {
            from = "";
        }
        if(to == null)
        {
            to = "";
        }
            lstSucursalSalida =  ejbFacade.findSucursal(rut, from, to );
            //SucursalSalida sucursal =  new SucursalSalida();
        //}
            
        
        
    }
    public PrimalBean() {
    }
}
