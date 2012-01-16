/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import jpa.entities.Estadogiro;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@ManagedBean(name = "estadoGiroController")
@RequestScoped()
public class EstadoGiroController implements Serializable{
    @EJB
    private jpa.session.EstadoGiroFacade ejbFacade;
    //private Musuarios objmusuarios;
    private String estado = "-1";


    private String estadoGiro;

    public String getEstadoGiro(String Id) {
            estadoGiro = ejbFacade.findEstadoById(Id);
             return estadoGiro;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    private List<Estadogiro> lstEstados = null;
    private List<SelectItem> selectEstado = new ArrayList<SelectItem>();

        
    public EstadoGiroController() {
        
    }
    
    public List getselectEstado() {
        if (lstEstados == null) {
            lstEstados =  ejbFacade.findEstados();
            for(Estadogiro e : lstEstados)
            {
                selectEstado.add(new SelectItem(e.getCodigoestado(), e.getNombreestado()));
            }
        }
        return selectEstado;
    }
    
    
    public String getEstado() {
        return estado;
    }
    
    public String estadoChange(AjaxBehaviorEvent event) {
        return estado + "ddd";
    }
}
