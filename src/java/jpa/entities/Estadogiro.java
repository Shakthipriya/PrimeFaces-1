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
@Table(name = "ESTADOGIRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadogiro.findAll", query = "SELECT e FROM Estadogiro e"),
    @NamedQuery(name = "Estadogiro.findByCodigoestado", query = "SELECT e FROM Estadogiro e WHERE e.codigoestado = :codigoestado"),
    @NamedQuery(name = "Estadogiro.findByNombreestado", query = "SELECT e FROM Estadogiro e WHERE e.nombreestado = :nombreestado")})
public class Estadogiro implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOESTADO")
    private BigDecimal codigoestado;
    @Size(max = 256)
    @Column(name = "NOMBREESTADO")
    private String nombreestado;

    public Estadogiro() {
    }

    public Estadogiro(BigDecimal codigoestado) {
        this.codigoestado = codigoestado;
    }

    public BigDecimal getCodigoestado() {
        return codigoestado;
    }

    public void setCodigoestado(BigDecimal codigoestado) {
        this.codigoestado = codigoestado;
    }

    public String getNombreestado() {
        return nombreestado;
    }

    public void setNombreestado(String nombreestado) {
        this.nombreestado = nombreestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoestado != null ? codigoestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadogiro)) {
            return false;
        }
        Estadogiro other = (Estadogiro) object;
        if ((this.codigoestado == null && other.codigoestado != null) || (this.codigoestado != null && !this.codigoestado.equals(other.codigoestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Estadogiro[ codigoestado=" + codigoestado + " ]";
    }
    
}
