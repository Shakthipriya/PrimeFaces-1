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
@Table(name = "MPERSO")
@XmlRootElement
public class Mperso implements Serializable {
    @Id
    private Long ID;
    @Column(name = "SUCUENT")
    private String sucuent;
    @Column(name = "RUT_PER")
    private String rutPer;
    @Column(name = "NPERS")
    private String npers;
    @Column(name = "PERS")
    private String pers;
    @Column(name = "CLAPERS")
    private String clapers;
    @Column(name = "TPERS")
    private String tpers;
    @Column(name = "NTPERS")
    private String ntpers;
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getClapers() {
        return clapers;
    }

    public void setClapers(String clapers) {
        this.clapers = clapers;
    }

    public String getNpers() {
        return npers;
    }

    public void setNpers(String npers) {
        this.npers = npers;
    }

    public String getNtpers() {
        return ntpers;
    }

    public void setNtpers(String ntpers) {
        this.ntpers = ntpers;
    }

    public String getPers() {
        return pers;
    }

    public void setPers(String pers) {
        this.pers = pers;
    }

    public String getRutPer() {
        return rutPer;
    }

    public void setRutPer(String rutPer) {
        this.rutPer = rutPer;
    }

    public String getSucuent() {
        return sucuent;
    }

    public void setSucuent(String sucuent) {
        this.sucuent = sucuent;
    }

    public String getTpers() {
        return tpers;
    }

    public void setTpers(String tpers) {
        this.tpers = tpers;
    }
    
    
    
}
