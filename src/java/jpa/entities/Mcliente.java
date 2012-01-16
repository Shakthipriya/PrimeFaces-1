/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
@Table(name = "MCLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mcliente.findAll", query = "SELECT m FROM Mcliente m"),
    @NamedQuery(name = "Mcliente.findByRutcliente", query = "SELECT m FROM Mcliente m WHERE m.rutcliente = :rutcliente"),
    @NamedQuery(name = "Mcliente.findByDigcliente", query = "SELECT m FROM Mcliente m WHERE m.digcliente = :digcliente"),
    @NamedQuery(name = "Mcliente.findByNombreclte", query = "SELECT m FROM Mcliente m WHERE m.nombreclte = :nombreclte"),
    @NamedQuery(name = "Mcliente.findByAppcliente", query = "SELECT m FROM Mcliente m WHERE m.appcliente = :appcliente"),
    @NamedQuery(name = "Mcliente.findByApmcliente", query = "SELECT m FROM Mcliente m WHERE m.apmcliente = :apmcliente"),
    @NamedQuery(name = "Mcliente.findByDircliente", query = "SELECT m FROM Mcliente m WHERE m.dircliente = :dircliente"),
    @NamedQuery(name = "Mcliente.findByCiucliente", query = "SELECT m FROM Mcliente m WHERE m.ciucliente = :ciucliente"),
    @NamedQuery(name = "Mcliente.findByComcliente", query = "SELECT m FROM Mcliente m WHERE m.comcliente = :comcliente"),
    @NamedQuery(name = "Mcliente.findByTelcliente", query = "SELECT m FROM Mcliente m WHERE m.telcliente = :telcliente"),
    @NamedQuery(name = "Mcliente.findByTelaboclte", query = "SELECT m FROM Mcliente m WHERE m.telaboclte = :telaboclte"),
    @NamedQuery(name = "Mcliente.findByCelcliente", query = "SELECT m FROM Mcliente m WHERE m.celcliente = :celcliente"),
    @NamedQuery(name = "Mcliente.findByEstBTarj", query = "SELECT m FROM Mcliente m WHERE m.estBTarj = :estBTarj"),
    @NamedQuery(name = "Mcliente.findByDesBTarj", query = "SELECT m FROM Mcliente m WHERE m.desBTarj = :desBTarj"),
    @NamedQuery(name = "Mcliente.findByEMailclte", query = "SELECT m FROM Mcliente m WHERE m.eMailclte = :eMailclte"),
    @NamedQuery(name = "Mcliente.findBySucOrigen", query = "SELECT m FROM Mcliente m WHERE m.sucOrigen = :sucOrigen"),
    @NamedQuery(name = "Mcliente.findByPtjeGiros", query = "SELECT m FROM Mcliente m WHERE m.ptjeGiros = :ptjeGiros"),
    @NamedQuery(name = "Mcliente.findByCliedin", query = "SELECT m FROM Mcliente m WHERE m.cliedin = :cliedin"),
    @NamedQuery(name = "Mcliente.findByTipoTrans", query = "SELECT m FROM Mcliente m WHERE m.tipoTrans = :tipoTrans"),
    @NamedQuery(name = "Mcliente.findByEstaComu", query = "SELECT m FROM Mcliente m WHERE m.estaComu = :estaComu"),
    @NamedQuery(name = "Mcliente.findByDatosclien", query = "SELECT m FROM Mcliente m WHERE m.datosclien = :datosclien"),
    @NamedQuery(name = "Mcliente.findByAxsTps", query = "SELECT m FROM Mcliente m WHERE m.axsTps = :axsTps"),
    @NamedQuery(name = "Mcliente.findByPrefijo", query = "SELECT m FROM Mcliente m WHERE m.prefijo = :prefijo")})
public class Mcliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUTCLIENTE")
    private Long rutcliente;
    @Size(max = 1)
    @Column(name = "DIGCLIENTE")
    private String digcliente;
    @Size(max = 20)
    @Column(name = "NOMBRECLTE")
    private String nombreclte;
    @Size(max = 20)
    @Column(name = "APPCLIENTE")
    private String appcliente;
    @Size(max = 20)
    @Column(name = "APMCLIENTE")
    private String apmcliente;
    @Size(max = 40)
    @Column(name = "DIRCLIENTE")
    private String dircliente;
    @Size(max = 20)
    @Column(name = "CIUCLIENTE")
    private String ciucliente;
    @Size(max = 20)
    @Column(name = "COMCLIENTE")
    private String comcliente;
    @Size(max = 10)
    @Column(name = "TELCLIENTE")
    private String telcliente;
    @Size(max = 10)
    @Column(name = "TELABOCLTE")
    private String telaboclte;
    @Size(max = 10)
    @Column(name = "CELCLIENTE")
    private String celcliente;
    @Column(name = "EST_B_TARJ")
    private Short estBTarj;
    @Size(max = 30)
    @Column(name = "DES_B_TARJ")
    private String desBTarj;
    @Size(max = 50)
    @Column(name = "E_MAILCLTE")
    private String eMailclte;
    @Size(max = 3)
    @Column(name = "SUC_ORIGEN")
    private String sucOrigen;
    @Column(name = "PTJE_GIROS")
    private Long ptjeGiros;
    @Size(max = 1)
    @Column(name = "CLIEDIN")
    private String cliedin;
    @Size(max = 2)
    @Column(name = "TIPO_TRANS")
    private String tipoTrans;
    @Size(max = 2)
    @Column(name = "ESTA_COMU")
    private String estaComu;
    @Size(max = 3)
    @Column(name = "DATOSCLIEN")
    private String datosclien;
    @Size(max = 1)
    @Column(name = "AXS_TPS")
    private String axsTps;
    @Size(max = 3)
    @Column(name = "PREFIJO")
    private String prefijo;

    public Mcliente() {
    }

    public Mcliente(Long rutcliente) {
        this.rutcliente = rutcliente;
    }

    public Long getRutcliente() {
        return rutcliente;
    }

    public void setRutcliente(Long rutcliente) {
        this.rutcliente = rutcliente;
    }

    public String getDigcliente() {
        return digcliente;
    }

    public void setDigcliente(String digcliente) {
        this.digcliente = digcliente;
    }

    public String getNombreclte() {
        return nombreclte;
    }

    public void setNombreclte(String nombreclte) {
        this.nombreclte = nombreclte;
    }

    public String getAppcliente() {
        return appcliente;
    }

    public void setAppcliente(String appcliente) {
        this.appcliente = appcliente;
    }

    public String getApmcliente() {
        return apmcliente;
    }

    public void setApmcliente(String apmcliente) {
        this.apmcliente = apmcliente;
    }

    public String getDircliente() {
        return dircliente;
    }

    public void setDircliente(String dircliente) {
        this.dircliente = dircliente;
    }

    public String getCiucliente() {
        return ciucliente;
    }

    public void setCiucliente(String ciucliente) {
        this.ciucliente = ciucliente;
    }

    public String getComcliente() {
        return comcliente;
    }

    public void setComcliente(String comcliente) {
        this.comcliente = comcliente;
    }

    public String getTelcliente() {
        return telcliente;
    }

    public void setTelcliente(String telcliente) {
        this.telcliente = telcliente;
    }

    public String getTelaboclte() {
        return telaboclte;
    }

    public void setTelaboclte(String telaboclte) {
        this.telaboclte = telaboclte;
    }

    public String getCelcliente() {
        return celcliente;
    }

    public void setCelcliente(String celcliente) {
        this.celcliente = celcliente;
    }

    public Short getEstBTarj() {
        return estBTarj;
    }

    public void setEstBTarj(Short estBTarj) {
        this.estBTarj = estBTarj;
    }

    public String getDesBTarj() {
        return desBTarj;
    }

    public void setDesBTarj(String desBTarj) {
        this.desBTarj = desBTarj;
    }

    public String getEMailclte() {
        return eMailclte;
    }

    public void setEMailclte(String eMailclte) {
        this.eMailclte = eMailclte;
    }

    public String getSucOrigen() {
        return sucOrigen;
    }

    public void setSucOrigen(String sucOrigen) {
        this.sucOrigen = sucOrigen;
    }

    public Long getPtjeGiros() {
        return ptjeGiros;
    }

    public void setPtjeGiros(Long ptjeGiros) {
        this.ptjeGiros = ptjeGiros;
    }

    public String getCliedin() {
        return cliedin;
    }

    public void setCliedin(String cliedin) {
        this.cliedin = cliedin;
    }

    public String getTipoTrans() {
        return tipoTrans;
    }

    public void setTipoTrans(String tipoTrans) {
        this.tipoTrans = tipoTrans;
    }

    public String getEstaComu() {
        return estaComu;
    }

    public void setEstaComu(String estaComu) {
        this.estaComu = estaComu;
    }

    public String getDatosclien() {
        return datosclien;
    }

    public void setDatosclien(String datosclien) {
        this.datosclien = datosclien;
    }

    public String getAxsTps() {
        return axsTps;
    }

    public void setAxsTps(String axsTps) {
        this.axsTps = axsTps;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutcliente != null ? rutcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mcliente)) {
            return false;
        }
        Mcliente other = (Mcliente) object;
        if ((this.rutcliente == null && other.rutcliente != null) || (this.rutcliente != null && !this.rutcliente.equals(other.rutcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Mcliente[ rutcliente=" + rutcliente + " ]";
    }
    
}
