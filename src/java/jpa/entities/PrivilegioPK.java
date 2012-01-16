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

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Embeddable
public class PrivilegioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CODIGO")
    private BigInteger perCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_CODIGO")
    private BigInteger opcCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUN_CODIGO")
    private BigInteger funCodigo;

    public PrivilegioPK() {
    }

    public PrivilegioPK(BigInteger perCodigo, BigInteger opcCodigo, BigInteger funCodigo) {
        this.perCodigo = perCodigo;
        this.opcCodigo = opcCodigo;
        this.funCodigo = funCodigo;
    }

    public BigInteger getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(BigInteger perCodigo) {
        this.perCodigo = perCodigo;
    }

    public BigInteger getOpcCodigo() {
        return opcCodigo;
    }

    public void setOpcCodigo(BigInteger opcCodigo) {
        this.opcCodigo = opcCodigo;
    }

    public BigInteger getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(BigInteger funCodigo) {
        this.funCodigo = funCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        hash += (opcCodigo != null ? opcCodigo.hashCode() : 0);
        hash += (funCodigo != null ? funCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrivilegioPK)) {
            return false;
        }
        PrivilegioPK other = (PrivilegioPK) object;
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        if ((this.opcCodigo == null && other.opcCodigo != null) || (this.opcCodigo != null && !this.opcCodigo.equals(other.opcCodigo))) {
            return false;
        }
        if ((this.funCodigo == null && other.funCodigo != null) || (this.funCodigo != null && !this.funCodigo.equals(other.funCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PrivilegioPK[ perCodigo=" + perCodigo + ", opcCodigo=" + opcCodigo + ", funCodigo=" + funCodigo + " ]";
    }

    public void setPerCodigo(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setOpcCodigo(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setFunCodigo(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
