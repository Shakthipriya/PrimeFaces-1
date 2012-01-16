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
import jpa.entities.SucursalSalida;
import jpa.entities.Sucursal;
import jsf.EstadoGiroController;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
@ManagedBean(name = "sucursalSalidaController")
@SessionScoped
public class SucursalSalidaController {
    @EJB
    private jpa.session.SucursalSalidaFacade ejbFacade;
    private List<SucursalSalida> lstSucursalSalida = null;
    private List<SucursalSalida> lstSucursalSalidas = null;
    
    @EJB
    private jpa.session.SucursalFacade ejbFacade2;
    private String sucursal = "-1";
    @EJB
    private jpa.session.EstadoGiroFacade ejbFacade3;
    private int estado = 0;
    private String rut = "";
    private String desde ;
    private String hasta;
    private long totales;
    private long totalIngresos;
    private long totalPagados;
    private long totalDevueltos;
    private Integer totalSaldo;
    private Integer cantidadGiros;

    public long getTotalDevueltos() {
        return totalDevueltos;
    }

    public void setTotalDevueltos(long totalDevueltos) {
        this.totalDevueltos = totalDevueltos;
    }

    public long getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(long totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public long getTotalPagados() {
        return totalPagados;
    }

    public void setTotalPagados(long totalPagados) {
        this.totalPagados = totalPagados;
    }

    public Integer getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(Integer totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

    public long getTotales() {
        return totales;
    }

    public void setTotales(long totales) {
        this.totales = totales;
    }

    public Integer getCantidadGiros() {
        return cantidadGiros;
    }

    public void setCantidadGiros(Integer cantidadGiros) {
        this.cantidadGiros = cantidadGiros;
    }
    
    
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
    public SucursalSalidaController() {
        
    }
    
    public List<SucursalSalida> getlstSucursalSalida() throws ParseException {

        String a = sucursal;
        
        long tot = 0;
        long totIng = 0;
        long totPag = 0;
        long totDev = 0;
        int cantGiros;
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
            lstSucursalSalida =  ejbFacade.findSucursal(sucursal, desde, hasta );
            //SucursalSalida sucursal =  new SucursalSalida();
        //}
            for(SucursalSalida s : lstSucursalSalida)
            {
                if("Ingreso de Giro".equals(s.getEstadoGiro()))
                {
                    totIng = totIng + s.getMontoGiro();
                }
                if("Pago de Giro".equals(s.getEstadoGiro()))
                {
                    totPag = totPag + s.getMontoGiro();
                }
                if("Devolucion de Giro".equals(s.getEstadoGiro()))
                {
                    totDev = totDev + s.getMontoGiro();
                }
                
                tot = tot + s.getMontoGiro();
            }
        totales = tot;
        totalIngresos = totIng;
        totalPagados = totPag;
        totalDevueltos = totDev;
        cantidadGiros = lstSucursalSalida.size();
        return lstSucursalSalida;
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
