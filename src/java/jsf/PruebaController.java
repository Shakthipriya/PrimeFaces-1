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
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.entities.Musuarios;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@ManagedBean(name = "pruebaController")
@SessionScoped()

public class PruebaController implements Serializable{
    //@PersistenceContext(unitName = "ABCDin1PU")
    @EJB
    private jpa.session.MusuariosFacade ejbFacade;
    private Musuarios objmusuarios;
    
    private String usuario = "-1";

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }
    private List<Musuarios> lstUsuarios = null;
    private List<SelectItem> selectUsuarios = new ArrayList<SelectItem>();
    private String PersistenceUnit = "ABCDin1PU";
    EntityManagerFactory factory = Persistence.createEntityManagerFactory(PersistenceUnit, System.getProperties());

    //private     
    //em = factory.createEntityManager();
    
    public PruebaController() {
    }
    
    public List<Musuarios> getUserList() {
            if (lstUsuarios == null) {
                lstUsuarios =  ejbFacade.findAll2();
            }
            return lstUsuarios;

    }
    
    public List getselectUsuarios() {
        if (lstUsuarios == null) {
            lstUsuarios =  ejbFacade.findAll2();
            for(Musuarios mu : lstUsuarios)
            {
                selectUsuarios.add(new SelectItem(mu.getRutUsuario(), mu.getNombreUsuario()));
            }
        }
        return selectUsuarios;
    }

 
	

}
