/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.entities.Musuarios;
import jpa.entities.Sucursal;

/**
 *
 * @author cristobalnicolasfritzherrera
 */

@ManagedBean(name = "sucursalController")
@ApplicationScoped

public class SucursalController implements Serializable{
    @EJB
    private jpa.session.SucursalFacade ejbFacade;
    //private Musuarios objmusuarios;
    private String sucursal = "-1";


    private List<Sucursal> lstSucursales = null;
    private List<SelectItem> selectSucursal = new ArrayList<SelectItem>();

    
    
    public SucursalController() {
    }
    
    public List getselectSucursal() {
        if (lstSucursales == null) {
            lstSucursales =  ejbFacade.findSucursales();
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
    /*public List getselectSucursal() {
        if (lstSucursales == null) {
            lstSucursales =  ejbFacade.findSucursalesRemitente();
            for(Sucursal s : lstSucursales)
            {
                selectSucursal.add(new SelectItem(s.getIdSucursal(), s.getIdSucursal()));
            }
        }
        return selectSucursal;
    }*/

}
