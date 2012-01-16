/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Entity
@Table(name = "AUDITORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findByAudRuta", query = "SELECT a FROM Auditoria a WHERE a.audRuta = :audRuta"),
    @NamedQuery(name = "Auditoria.findByAudParametro", query = "SELECT a FROM Auditoria a WHERE a.audParametro = :audParametro"),
    @NamedQuery(name = "Auditoria.findByAudFecha", query = "SELECT a FROM Auditoria a WHERE a.audFecha = :audFecha"),
    @NamedQuery(name = "Auditoria.findByAudCodigo", query = "SELECT a FROM Auditoria a WHERE a.audCodigo = :audCodigo"),
    @NamedQuery(name = "Auditoria.findByPerCodigo", query = "SELECT a FROM Auditoria a WHERE a.perCodigo = :perCodigo"),
    @NamedQuery(name = "Auditoria.findByOpcCodigo", query = "SELECT a FROM Auditoria a WHERE a.opcCodigo = :opcCodigo"),
    @NamedQuery(name = "Auditoria.findByFunCodigo", query = "SELECT a FROM Auditoria a WHERE a.funCodigo = :funCodigo"),
    @NamedQuery(name = "Auditoria.findByUsuCodigo", query = "SELECT a FROM Auditoria a WHERE a.usuCodigo = :usuCodigo")})
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 256)
    @Column(name = "AUD_RUTA")
    private String audRuta;
    @Size(max = 256)
    @Column(name = "AUD_PARAMETRO")
    private String audParametro;
    @Column(name = "AUD_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUD_CODIGO")
    private BigDecimal audCodigo;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USU_CODIGO")
    private String usuCodigo;

    public Auditoria() {
    }

    public Auditoria(BigDecimal audCodigo) {
        this.audCodigo = audCodigo;
    }

    public Auditoria(BigDecimal audCodigo, BigInteger perCodigo, BigInteger opcCodigo, BigInteger funCodigo, String usuCodigo) {
        this.audCodigo = audCodigo;
        this.perCodigo = perCodigo;
        this.opcCodigo = opcCodigo;
        this.funCodigo = funCodigo;
        this.usuCodigo = usuCodigo;
    }

    public String getAudRuta() {
        return audRuta;
    }

    public void setAudRuta(String audRuta) {
        this.audRuta = audRuta;
    }

    public String getAudParametro() {
        return audParametro;
    }

    public void setAudParametro(String audParametro) {
        this.audParametro = audParametro;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public BigDecimal getAudCodigo() {
        return audCodigo;
    }

    public void setAudCodigo(BigDecimal audCodigo) {
        this.audCodigo = audCodigo;
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

    public String getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(String usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (audCodigo != null ? audCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.audCodigo == null && other.audCodigo != null) || (this.audCodigo != null && !this.audCodigo.equals(other.audCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Auditoria[ audCodigo=" + audCodigo + " ]";
    }
    
}
