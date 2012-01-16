/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Entity
@Table(name = "FUNCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcion.findAll", query = "SELECT f FROM Funcion f"),
    @NamedQuery(name = "Funcion.findByFunCodigo", query = "SELECT f FROM Funcion f WHERE f.funCodigo = :funCodigo"),
    @NamedQuery(name = "Funcion.findByFunNombre", query = "SELECT f FROM Funcion f WHERE f.funNombre = :funNombre")})
public class Funcion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUN_CODIGO")
    private BigDecimal funCodigo;
    @Size(max = 256)
    @Column(name = "FUN_NOMBRE")
    private String funNombre;

    public Funcion() {
    }

    public Funcion(BigDecimal funCodigo) {
        this.funCodigo = funCodigo;
    }

    public BigDecimal getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(BigDecimal funCodigo) {
        this.funCodigo = funCodigo;
    }

    public String getFunNombre() {
        return funNombre;
    }

    public void setFunNombre(String funNombre) {
        this.funNombre = funNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funCodigo != null ? funCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.funCodigo == null && other.funCodigo != null) || (this.funCodigo != null && !this.funCodigo.equals(other.funCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Funcion[ funCodigo=" + funCodigo + " ]";
    }
    
}
