/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
public class UsuarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USU_CODIGO")
    private String usuCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CODIGO")
    private BigInteger perCodigo;

    public UsuarioPK() {
    }

    public UsuarioPK(String usuCodigo, BigInteger perCodigo) {
        this.usuCodigo = usuCodigo;
        this.perCodigo = perCodigo;
    }

    public String getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(String usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public BigInteger getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(BigInteger perCodigo) {
        this.perCodigo = perCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuCodigo != null ? usuCodigo.hashCode() : 0);
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPK)) {
            return false;
        }
        UsuarioPK other = (UsuarioPK) object;
        if ((this.usuCodigo == null && other.usuCodigo != null) || (this.usuCodigo != null && !this.usuCodigo.equals(other.usuCodigo))) {
            return false;
        }
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.UsuarioPK[ usuCodigo=" + usuCodigo + ", perCodigo=" + perCodigo + " ]";
    }

    public void setPerCodigo(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
