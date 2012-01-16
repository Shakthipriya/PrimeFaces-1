/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Entity
@Table(name = "PRIVILEGIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegio.findAll", query = "SELECT p FROM Privilegio p"),
    @NamedQuery(name = "Privilegio.findByPriEstado", query = "SELECT p FROM Privilegio p WHERE p.priEstado = :priEstado"),
    @NamedQuery(name = "Privilegio.findByPerCodigo", query = "SELECT p FROM Privilegio p WHERE p.privilegioPK.perCodigo = :perCodigo"),
    @NamedQuery(name = "Privilegio.findByOpcCodigo", query = "SELECT p FROM Privilegio p WHERE p.privilegioPK.opcCodigo = :opcCodigo"),
    @NamedQuery(name = "Privilegio.findByFunCodigo", query = "SELECT p FROM Privilegio p WHERE p.privilegioPK.funCodigo = :funCodigo")})
public class Privilegio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrivilegioPK privilegioPK;
    @Column(name = "PRI_ESTADO")
    private Character priEstado;

    public Privilegio() {
    }

    public Privilegio(PrivilegioPK privilegioPK) {
        this.privilegioPK = privilegioPK;
    }

    public Privilegio(BigInteger perCodigo, BigInteger opcCodigo, BigInteger funCodigo) {
        this.privilegioPK = new PrivilegioPK(perCodigo, opcCodigo, funCodigo);
    }

    public PrivilegioPK getPrivilegioPK() {
        return privilegioPK;
    }

    public void setPrivilegioPK(PrivilegioPK privilegioPK) {
        this.privilegioPK = privilegioPK;
    }

    public Character getPriEstado() {
        return priEstado;
    }

    public void setPriEstado(Character priEstado) {
        this.priEstado = priEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegioPK != null ? privilegioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegio)) {
            return false;
        }
        Privilegio other = (Privilegio) object;
        if ((this.privilegioPK == null && other.privilegioPK != null) || (this.privilegioPK != null && !this.privilegioPK.equals(other.privilegioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Privilegio[ privilegioPK=" + privilegioPK + " ]";
    }
    
}
