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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Entity
@Table(name = "OPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o"),
    @NamedQuery(name = "Opcion.findByOpcCodigo", query = "SELECT o FROM Opcion o WHERE o.opcionPK.opcCodigo = :opcCodigo"),
    @NamedQuery(name = "Opcion.findByOpcNombre", query = "SELECT o FROM Opcion o WHERE o.opcNombre = :opcNombre"),
    @NamedQuery(name = "Opcion.findByOpcRuta", query = "SELECT o FROM Opcion o WHERE o.opcRuta = :opcRuta"),
    @NamedQuery(name = "Opcion.findByFunCodigo", query = "SELECT o FROM Opcion o WHERE o.opcionPK.funCodigo = :funCodigo")})
public class Opcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpcionPK opcionPK;
    @Size(max = 256)
    @Column(name = "OPC_NOMBRE")
    private String opcNombre;
    @Size(max = 256)
    @Column(name = "OPC_RUTA")
    private String opcRuta;

    public Opcion() {
    }

    public Opcion(OpcionPK opcionPK) {
        this.opcionPK = opcionPK;
    }

    public Opcion(BigInteger opcCodigo, BigInteger funCodigo) {
        this.opcionPK = new OpcionPK(opcCodigo, funCodigo);
    }

    public OpcionPK getOpcionPK() {
        return opcionPK;
    }

    public void setOpcionPK(OpcionPK opcionPK) {
        this.opcionPK = opcionPK;
    }

    public String getOpcNombre() {
        return opcNombre;
    }

    public void setOpcNombre(String opcNombre) {
        this.opcNombre = opcNombre;
    }

    public String getOpcRuta() {
        return opcRuta;
    }

    public void setOpcRuta(String opcRuta) {
        this.opcRuta = opcRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionPK != null ? opcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.opcionPK == null && other.opcionPK != null) || (this.opcionPK != null && !this.opcionPK.equals(other.opcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Opcion[ opcionPK=" + opcionPK + " ]";
    }
    
}
