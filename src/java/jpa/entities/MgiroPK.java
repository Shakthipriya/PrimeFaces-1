/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Embeddable
public class MgiroPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLIO_GIRO")
    private int folioGiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SUC_REMITE")
    private String sucRemite;

    public MgiroPK() {
    }

    public MgiroPK(int folioGiro, String sucRemite) {
        this.folioGiro = folioGiro;
        this.sucRemite = sucRemite;
    }

    public int getFolioGiro() {
        return folioGiro;
    }

    public void setFolioGiro(int folioGiro) {
        this.folioGiro = folioGiro;
    }

    public String getSucRemite() {
        return sucRemite;
    }

    public void setSucRemite(String sucRemite) {
        this.sucRemite = sucRemite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) folioGiro;
        hash += (sucRemite != null ? sucRemite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgiroPK)) {
            return false;
        }
        MgiroPK other = (MgiroPK) object;
        if (this.folioGiro != other.folioGiro) {
            return false;
        }
        if ((this.sucRemite == null && other.sucRemite != null) || (this.sucRemite != null && !this.sucRemite.equals(other.sucRemite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MgiroPK[ folioGiro=" + folioGiro + ", sucRemite=" + sucRemite + " ]";
    }
    
}
