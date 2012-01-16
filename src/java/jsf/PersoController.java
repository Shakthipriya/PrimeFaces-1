/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import com.sun.mail.imap.Rights.Right;
import jpa.entities.Perfil;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.session.PersoFacade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author cristobalnicolasfritzherrera
 */

@ManagedBean(name = "persoController")
@SessionScoped

public class PersoController implements Serializable {
    
    @EJB
    private jpa.session.PersoFacade ejbFacade;
    
    @EJB
    private jpa.session.PerfilUsrRolFacade ejbFacade2;
    private String user;
    private BigInteger pass;
    private BigInteger newPass4 = BigInteger.valueOf(0);
    private String userName;
    private String userRol;
    private String menu;
    private String menu2;

    public String getMenu2() {
        String passEncr = "";
        passEncr = newPass4.toString().substring(newPass4.toString().length() - 5);
        userRol = ejbFacade.userRol(user, passEncr);
        //if(val != "")
       // {
       //     return val;
       // }
       // else
       //     user = "";
            //pass = 0;
       //     return "";
        String val = ejbFacade2.findIdPerfil2(userRol);
        if(val != "")
        {
            return val;
        }
        else
            user = "";
            //pass = 0;
            return "";
    }

    public void setMenu2(String menu2) {
        this.menu2 = menu2;
    }

    public String getMenu() {
        String passEncr = "";
        passEncr = newPass4.toString().substring(newPass4.toString().length() - 5);
        userRol = ejbFacade.userRol(user, passEncr);
        //if(val != "")
       // {
       //     return val;
       // }
       // else
       //     user = "";
            //pass = 0;
       //     return "";
        String val = ejbFacade2.findIdPerfil(userRol);
        if(val != "")
        {
            return val;
        }
        else
            user = "";
            //pass = 0;
            return "";
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
    
    public BigInteger getPass() {
        return pass;
    }

    public void setPass(BigInteger pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigInteger getNewPass4() {
        return newPass4;
    }

    public void setNewPass4(BigInteger newPass4) {
        this.newPass4 = newPass4;
    }

    public String getUserName() {
         String passEncr = "";
        passEncr = newPass4.toString().substring(newPass4.toString().length() - 5);
        String val = ejbFacade.userName(user, passEncr);
        if(val != "")
        {
            return val;
        }
        else
            user = "";
            //pass = 0;
            return "";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRol() {
        String passEncr = "";
        passEncr = newPass4.toString().substring(newPass4.toString().length() - 5);
        String val = ejbFacade.userRol(user, passEncr);
        if(val != "")
        {
            return val;
        }
        else
            user = "";
            //pass = 0;
            return "";
    }

    public void setUserRol(String userRol) {
        this.userRol = userRol;
    }
    
    
    public boolean validaPass()
    {
        BigInteger newPass1 = BigInteger.valueOf(0);
        BigInteger newPass2 = BigInteger.valueOf(0);
        BigInteger newPass3 = BigInteger.valueOf(0);
        
        String passEncr = "";
        BigInteger tres = BigInteger.valueOf(3);
        BigInteger cinco = BigInteger.valueOf(5);
        BigInteger siete = BigInteger.valueOf(7);
        newPass1 = newPass1.add(tres);
        newPass1 = newPass1.multiply(pass);
        newPass2 = newPass2.add(cinco);
        newPass2 = newPass2.multiply(pass);
        newPass2 = newPass2.multiply(pass);
        newPass3 = newPass3.add(siete);
        newPass3 = newPass3.multiply(pass);
        newPass3 = newPass3.multiply(pass);
        newPass3 = newPass3.multiply(pass);
        newPass4 = newPass4.add(newPass1);
        newPass4 = newPass4.add(newPass2);
        newPass4 = newPass4.add(newPass3);
       // * pass;
       // newPass += 5 * pass * pass;
     //   newPass += 7 * pass * pass * pass;
        passEncr = newPass4.toString().substring(newPass4.toString().length() - 5);
        String val = ejbFacade.validaCredenciales(user, passEncr);
        if(val != "")
        {
            return true;
        }
        else
            user = "";
            //pass = 0;
            return false;
    }
    
    public boolean cerrarSesion()
    {
        user = "";
        //pass = 0;
        return true;
    }
    
    
    
}
