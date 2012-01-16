/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@ApplicationScoped
@ManagedBean(name = "popup")
public class Popup {
    private boolean visible = false;
    private String a = "valor";
    public boolean isVisible() { return visible; }
    
    public void setVisible(boolean visible) { this.visible = visible; }
    
    public void closePopup() {
        visible = false;
    }
    
    public void openPopup() {
        visible = true;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

}
