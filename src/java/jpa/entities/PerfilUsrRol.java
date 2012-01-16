/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Entity
@Table(name = "PERFIL_USRROL")
@XmlRootElement
public class PerfilUsrRol implements Serializable {
    @Id
    private Long ID;
    @Column(name = "CODIGOPERFIL")
    private int codigoPerfil;
    @Column(name = "USRROL")
    private String usrRol;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(int codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public String getUsrRol() {
        return usrRol;
    }

    public void setUsrRol(String usrRol) {
        this.usrRol = usrRol;
    }
    
    
}
