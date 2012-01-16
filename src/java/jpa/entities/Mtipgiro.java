/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Entity
@Table(name = "MTIPGIRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mtipgiro.findAll", query = "SELECT m FROM Mtipgiro m"),
    @NamedQuery(name = "Mtipgiro.findByTipoGiro", query = "SELECT m FROM Mtipgiro m WHERE m.tipoGiro = :tipoGiro"),
    @NamedQuery(name = "Mtipgiro.findByDescGiro", query = "SELECT m FROM Mtipgiro m WHERE m.descGiro = :descGiro"),
    @NamedQuery(name = "Mtipgiro.findByOrigenGir", query = "SELECT m FROM Mtipgiro m WHERE m.origenGir = :origenGir"),
    @NamedQuery(name = "Mtipgiro.findByTipDocaso", query = "SELECT m FROM Mtipgiro m WHERE m.tipDocaso = :tipDocaso"),
    @NamedQuery(name = "Mtipgiro.findByIndPagseg", query = "SELECT m FROM Mtipgiro m WHERE m.indPagseg = :indPagseg"),
    @NamedQuery(name = "Mtipgiro.findByIndAplarq", query = "SELECT m FROM Mtipgiro m WHERE m.indAplarq = :indAplarq"),
    @NamedQuery(name = "Mtipgiro.findByTipDocing", query = "SELECT m FROM Mtipgiro m WHERE m.tipDocing = :tipDocing"),
    @NamedQuery(name = "Mtipgiro.findByDesDocing", query = "SELECT m FROM Mtipgiro m WHERE m.desDocing = :desDocing"),
    @NamedQuery(name = "Mtipgiro.findByTipDocpag", query = "SELECT m FROM Mtipgiro m WHERE m.tipDocpag = :tipDocpag"),
    @NamedQuery(name = "Mtipgiro.findByDesDocpag", query = "SELECT m FROM Mtipgiro m WHERE m.desDocpag = :desDocpag"),
    @NamedQuery(name = "Mtipgiro.findByTipDocdev", query = "SELECT m FROM Mtipgiro m WHERE m.tipDocdev = :tipDocdev"),
    @NamedQuery(name = "Mtipgiro.findByDesDocdev", query = "SELECT m FROM Mtipgiro m WHERE m.desDocdev = :desDocdev"),
    @NamedQuery(name = "Mtipgiro.findByClaItemow", query = "SELECT m FROM Mtipgiro m WHERE m.claItemow = :claItemow"),
    @NamedQuery(name = "Mtipgiro.findByTarifaIni", query = "SELECT m FROM Mtipgiro m WHERE m.tarifaIni = :tarifaIni"),
    @NamedQuery(name = "Mtipgiro.findByEstadoIni", query = "SELECT m FROM Mtipgiro m WHERE m.estadoIni = :estadoIni"),
    @NamedQuery(name = "Mtipgiro.findByAxsTps", query = "SELECT m FROM Mtipgiro m WHERE m.axsTps = :axsTps"),
    @NamedQuery(name = "Mtipgiro.findByTipDocow", query = "SELECT m FROM Mtipgiro m WHERE m.tipDocow = :tipDocow")})
public class Mtipgiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_GIRO")
    private String tipoGiro;
    @Size(max = 20)
    @Column(name = "DESC_GIRO")
    private String descGiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ORIGEN_GIR")
    private String origenGir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIP_DOCASO")
    private String tipDocaso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "IND_PAGSEG")
    private String indPagseg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "IND_APLARQ")
    private String indAplarq;
    @Size(max = 3)
    @Column(name = "TIP_DOCING")
    private String tipDocing;
    @Size(max = 20)
    @Column(name = "DES_DOCING")
    private String desDocing;
    @Size(max = 3)
    @Column(name = "TIP_DOCPAG")
    private String tipDocpag;
    @Size(max = 20)
    @Column(name = "DES_DOCPAG")
    private String desDocpag;
    @Size(max = 3)
    @Column(name = "TIP_DOCDEV")
    private String tipDocdev;
    @Size(max = 20)
    @Column(name = "DES_DOCDEV")
    private String desDocdev;
    @Size(max = 3)
    @Column(name = "CLA_ITEMOW")
    private String claItemow;
    @Column(name = "TARIFA_INI")
    private Short tarifaIni;
    @Size(max = 2)
    @Column(name = "ESTADO_INI")
    private String estadoIni;
    @Size(max = 1)
    @Column(name = "AXS_TPS")
    private String axsTps;
    @Size(max = 2)
    @Column(name = "TIP_DOCOW")
    private String tipDocow;
    @OneToMany(mappedBy = "tipoGiro")
    private Collection<Mgiro> mgiroCollection;
    @OneToMany(mappedBy = "tipoGiro")
    private Collection<MgiroHistorico> mgiroHistoricoCollection;

    public Mtipgiro() {
    }

    public Mtipgiro(String tipoGiro) {
        this.tipoGiro = tipoGiro;
    }

    public Mtipgiro(String tipoGiro, String origenGir, String tipDocaso, String indPagseg, String indAplarq) {
        this.tipoGiro = tipoGiro;
        this.origenGir = origenGir;
        this.tipDocaso = tipDocaso;
        this.indPagseg = indPagseg;
        this.indAplarq = indAplarq;
    }

    public String getTipoGiro() {
        return tipoGiro;
    }

    public void setTipoGiro(String tipoGiro) {
        this.tipoGiro = tipoGiro;
    }

    public String getDescGiro() {
        return descGiro;
    }

    public void setDescGiro(String descGiro) {
        this.descGiro = descGiro;
    }

    public String getOrigenGir() {
        return origenGir;
    }

    public void setOrigenGir(String origenGir) {
        this.origenGir = origenGir;
    }

    public String getTipDocaso() {
        return tipDocaso;
    }

    public void setTipDocaso(String tipDocaso) {
        this.tipDocaso = tipDocaso;
    }

    public String getIndPagseg() {
        return indPagseg;
    }

    public void setIndPagseg(String indPagseg) {
        this.indPagseg = indPagseg;
    }

    public String getIndAplarq() {
        return indAplarq;
    }

    public void setIndAplarq(String indAplarq) {
        this.indAplarq = indAplarq;
    }

    public String getTipDocing() {
        return tipDocing;
    }

    public void setTipDocing(String tipDocing) {
        this.tipDocing = tipDocing;
    }

    public String getDesDocing() {
        return desDocing;
    }

    public void setDesDocing(String desDocing) {
        this.desDocing = desDocing;
    }

    public String getTipDocpag() {
        return tipDocpag;
    }

    public void setTipDocpag(String tipDocpag) {
        this.tipDocpag = tipDocpag;
    }

    public String getDesDocpag() {
        return desDocpag;
    }

    public void setDesDocpag(String desDocpag) {
        this.desDocpag = desDocpag;
    }

    public String getTipDocdev() {
        return tipDocdev;
    }

    public void setTipDocdev(String tipDocdev) {
        this.tipDocdev = tipDocdev;
    }

    public String getDesDocdev() {
        return desDocdev;
    }

    public void setDesDocdev(String desDocdev) {
        this.desDocdev = desDocdev;
    }

    public String getClaItemow() {
        return claItemow;
    }

    public void setClaItemow(String claItemow) {
        this.claItemow = claItemow;
    }

    public Short getTarifaIni() {
        return tarifaIni;
    }

    public void setTarifaIni(Short tarifaIni) {
        this.tarifaIni = tarifaIni;
    }

    public String getEstadoIni() {
        return estadoIni;
    }

    public void setEstadoIni(String estadoIni) {
        this.estadoIni = estadoIni;
    }

    public String getAxsTps() {
        return axsTps;
    }

    public void setAxsTps(String axsTps) {
        this.axsTps = axsTps;
    }

    public String getTipDocow() {
        return tipDocow;
    }

    public void setTipDocow(String tipDocow) {
        this.tipDocow = tipDocow;
    }

    @XmlTransient
    public Collection<Mgiro> getMgiroCollection() {
        return mgiroCollection;
    }

    public void setMgiroCollection(Collection<Mgiro> mgiroCollection) {
        this.mgiroCollection = mgiroCollection;
    }

    @XmlTransient
    public Collection<MgiroHistorico> getMgiroHistoricoCollection() {
        return mgiroHistoricoCollection;
    }

    public void setMgiroHistoricoCollection(Collection<MgiroHistorico> mgiroHistoricoCollection) {
        this.mgiroHistoricoCollection = mgiroHistoricoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoGiro != null ? tipoGiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mtipgiro)) {
            return false;
        }
        Mtipgiro other = (Mtipgiro) object;
        if ((this.tipoGiro == null && other.tipoGiro != null) || (this.tipoGiro != null && !this.tipoGiro.equals(other.tipoGiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Mtipgiro[ tipoGiro=" + tipoGiro + " ]";
    }
    
}
