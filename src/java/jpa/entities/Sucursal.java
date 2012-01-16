/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
@Table(name = "SUCURSAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByCodigoSuc", query = "SELECT s FROM Sucursal s WHERE s.codigoSuc = :codigoSuc"),
    @NamedQuery(name = "Sucursal.findByRegionSuc", query = "SELECT s FROM Sucursal s WHERE s.regionSuc = :regionSuc"),
    @NamedQuery(name = "Sucursal.findByDireccSuc", query = "SELECT s FROM Sucursal s WHERE s.direccSuc = :direccSuc"),
    @NamedQuery(name = "Sucursal.findByCiudadSuc", query = "SELECT s FROM Sucursal s WHERE s.ciudadSuc = :ciudadSuc"),
    @NamedQuery(name = "Sucursal.findByComunaSuc", query = "SELECT s FROM Sucursal s WHERE s.comunaSuc = :comunaSuc"),
    @NamedQuery(name = "Sucursal.findByCodArea", query = "SELECT s FROM Sucursal s WHERE s.codArea = :codArea"),
    @NamedQuery(name = "Sucursal.findByTelefonos", query = "SELECT s FROM Sucursal s WHERE s.telefonos = :telefonos"),
    @NamedQuery(name = "Sucursal.findByZona", query = "SELECT s FROM Sucursal s WHERE s.zona = :zona"),
    @NamedQuery(name = "Sucursal.findByHorarioini", query = "SELECT s FROM Sucursal s WHERE s.horarioini = :horarioini"),
    @NamedQuery(name = "Sucursal.findByHorarioter", query = "SELECT s FROM Sucursal s WHERE s.horarioter = :horarioter"),
    @NamedQuery(name = "Sucursal.findByTipoSuc", query = "SELECT s FROM Sucursal s WHERE s.tipoSuc = :tipoSuc"),
    @NamedQuery(name = "Sucursal.findByAdminSucu", query = "SELECT s FROM Sucursal s WHERE s.adminSucu = :adminSucu"),
    @NamedQuery(name = "Sucursal.findByReempSucu", query = "SELECT s FROM Sucursal s WHERE s.reempSucu = :reempSucu"),
    @NamedQuery(name = "Sucursal.findByEMailSuc", query = "SELECT s FROM Sucursal s WHERE s.eMailSuc = :eMailSuc"),
    @NamedQuery(name = "Sucursal.findByFeSalIni", query = "SELECT s FROM Sucursal s WHERE s.feSalIni = :feSalIni"),
    @NamedQuery(name = "Sucursal.findBySaldoIni", query = "SELECT s FROM Sucursal s WHERE s.saldoIni = :saldoIni"),
    @NamedQuery(name = "Sucursal.findBySaldoAct", query = "SELECT s FROM Sucursal s WHERE s.saldoAct = :saldoAct"),
    @NamedQuery(name = "Sucursal.findByMonmaxdisp", query = "SELECT s FROM Sucursal s WHERE s.monmaxdisp = :monmaxdisp"),
    @NamedQuery(name = "Sucursal.findByAxsTps", query = "SELECT s FROM Sucursal s WHERE s.axsTps = :axsTps"),
    @NamedQuery(name = "Sucursal.findByEstVig", query = "SELECT s FROM Sucursal s WHERE s.estVig = :estVig"),
    @NamedQuery(name = "Sucursal.findByEnviaGiro", query = "SELECT s FROM Sucursal s WHERE s.enviaGiro = :enviaGiro"),
    @NamedQuery(name = "Sucursal.findByRecibeGiro", query = "SELECT s FROM Sucursal s WHERE s.recibeGiro = :recibeGiro"),
    @NamedQuery(name = "Sucursal.findByDesenviaTfija", query = "SELECT s FROM Sucursal s WHERE s.desenviaTfija = :desenviaTfija"),
    @NamedQuery(name = "Sucursal.findByDesenviaTvar", query = "SELECT s FROM Sucursal s WHERE s.desenviaTvar = :desenviaTvar"),
    @NamedQuery(name = "Sucursal.findByDesrecibeTfija", query = "SELECT s FROM Sucursal s WHERE s.desrecibeTfija = :desrecibeTfija"),
    @NamedQuery(name = "Sucursal.findByDesrecibeTvar", query = "SELECT s FROM Sucursal s WHERE s.desrecibeTvar = :desrecibeTvar"),
    @NamedQuery(name = "Sucursal.findByFecinivig", query = "SELECT s FROM Sucursal s WHERE s.fecinivig = :fecinivig"),
    @NamedQuery(name = "Sucursal.findByFecfinvig", query = "SELECT s FROM Sucursal s WHERE s.fecfinvig = :fecfinvig"),
    @NamedQuery(name = "Sucursal.findByFecinipro", query = "SELECT s FROM Sucursal s WHERE s.fecinipro = :fecinipro"),
    @NamedQuery(name = "Sucursal.findByFecfinpro", query = "SELECT s FROM Sucursal s WHERE s.fecfinpro = :fecfinpro"),
    @NamedQuery(name = "Sucursal.findByFecinibol", query = "SELECT s FROM Sucursal s WHERE s.fecinibol = :fecinibol"),
    @NamedQuery(name = "Sucursal.findByFecfinbol", query = "SELECT s FROM Sucursal s WHERE s.fecfinbol = :fecfinbol")})
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_SUC")
    private String codigoSuc;
    @Column(name = "REGION_SUC")
    private Short regionSuc;
    @Size(max = 40)
    @Column(name = "DIRECC_SUC")
    private String direccSuc;
    @Size(max = 20)
    @Column(name = "CIUDAD_SUC")
    private String ciudadSuc;
    @Size(max = 20)
    @Column(name = "COMUNA_SUC")
    private String comunaSuc;
    @Size(max = 3)
    @Column(name = "COD_AREA")
    private String codArea;
    @Size(max = 34)
    @Column(name = "TELEFONOS")
    private String telefonos;
    @Size(max = 15)
    @Column(name = "ZONA")
    private String zona;
    @Size(max = 8)
    @Column(name = "HORARIOINI")
    private String horarioini;
    @Size(max = 8)
    @Column(name = "HORARIOTER")
    private String horarioter;
    @Size(max = 1)
    @Column(name = "TIPO_SUC")
    private String tipoSuc;
    @Size(max = 34)
    @Column(name = "ADMIN_SUCU")
    private String adminSucu;
    @Size(max = 34)
    @Column(name = "REEMP_SUCU")
    private String reempSucu;
    @Size(max = 50)
    @Column(name = "E_MAIL_SUC")
    private String eMailSuc;
    @Column(name = "FE_SAL_INI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feSalIni;
    @Column(name = "SALDO_INI")
    private Long saldoIni;
    @Column(name = "SALDO_ACT")
    private Long saldoAct;
    @Column(name = "MONMAXDISP")
    private Long monmaxdisp;
    @Size(max = 1)
    @Column(name = "AXS_TPS")
    private String axsTps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_VIG")
    private char estVig;
    @Size(max = 1)
    @Column(name = "ENVIA_GIRO")
    private String enviaGiro;
    @Size(max = 1)
    @Column(name = "RECIBE_GIRO")
    private String recibeGiro;
    @Column(name = "DESENVIA_TFIJA")
    private BigInteger desenviaTfija;
    @Column(name = "DESENVIA_TVAR")
    private BigInteger desenviaTvar;
    @Column(name = "DESRECIBE_TFIJA")
    private BigInteger desrecibeTfija;
    @Column(name = "DESRECIBE_TVAR")
    private BigInteger desrecibeTvar;
    @Column(name = "FECINIVIG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecinivig;
    @Column(name = "FECFINVIG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecfinvig;
    @Column(name = "FECINIPRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecinipro;
    @Column(name = "FECFINPRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecfinpro;
    @Column(name = "FECINIBOL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecinibol;
    @Column(name = "FECFINBOL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecfinbol;


    public Sucursal() {
    }

    public Sucursal(String codigoSuc) {
        this.codigoSuc = codigoSuc;
    }

    public Sucursal(String codigoSuc, char estVig) {
        this.codigoSuc = codigoSuc;
        this.estVig = estVig;
    }

    public String getCodigoSuc() {
        return codigoSuc;
    }

    public void setCodigoSuc(String codigoSuc) {
        this.codigoSuc = codigoSuc;
    }

    public Short getRegionSuc() {
        return regionSuc;
    }

    public void setRegionSuc(Short regionSuc) {
        this.regionSuc = regionSuc;
    }

    public String getDireccSuc() {
        return direccSuc;
    }

    public void setDireccSuc(String direccSuc) {
        this.direccSuc = direccSuc;
    }

    public String getCiudadSuc() {
        return ciudadSuc;
    }

    public void setCiudadSuc(String ciudadSuc) {
        this.ciudadSuc = ciudadSuc;
    }

    public String getComunaSuc() {
        return comunaSuc;
    }

    public void setComunaSuc(String comunaSuc) {
        this.comunaSuc = comunaSuc;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getHorarioini() {
        return horarioini;
    }

    public void setHorarioini(String horarioini) {
        this.horarioini = horarioini;
    }

    public String getHorarioter() {
        return horarioter;
    }

    public void setHorarioter(String horarioter) {
        this.horarioter = horarioter;
    }

    public String getTipoSuc() {
        return tipoSuc;
    }

    public void setTipoSuc(String tipoSuc) {
        this.tipoSuc = tipoSuc;
    }

    public String getAdminSucu() {
        return adminSucu;
    }

    public void setAdminSucu(String adminSucu) {
        this.adminSucu = adminSucu;
    }

    public String getReempSucu() {
        return reempSucu;
    }

    public void setReempSucu(String reempSucu) {
        this.reempSucu = reempSucu;
    }

    public String getEMailSuc() {
        return eMailSuc;
    }

    public void setEMailSuc(String eMailSuc) {
        this.eMailSuc = eMailSuc;
    }

    public Date getFeSalIni() {
        return feSalIni;
    }

    public void setFeSalIni(Date feSalIni) {
        this.feSalIni = feSalIni;
    }

    public Long getSaldoIni() {
        return saldoIni;
    }

    public void setSaldoIni(Long saldoIni) {
        this.saldoIni = saldoIni;
    }

    public Long getSaldoAct() {
        return saldoAct;
    }

    public void setSaldoAct(Long saldoAct) {
        this.saldoAct = saldoAct;
    }

    public Long getMonmaxdisp() {
        return monmaxdisp;
    }

    public void setMonmaxdisp(Long monmaxdisp) {
        this.monmaxdisp = monmaxdisp;
    }

    public String getAxsTps() {
        return axsTps;
    }

    public void setAxsTps(String axsTps) {
        this.axsTps = axsTps;
    }

    public char getEstVig() {
        return estVig;
    }

    public void setEstVig(char estVig) {
        this.estVig = estVig;
    }

    public String getEnviaGiro() {
        return enviaGiro;
    }

    public void setEnviaGiro(String enviaGiro) {
        this.enviaGiro = enviaGiro;
    }

    public String getRecibeGiro() {
        return recibeGiro;
    }

    public void setRecibeGiro(String recibeGiro) {
        this.recibeGiro = recibeGiro;
    }

    public BigInteger getDesenviaTfija() {
        return desenviaTfija;
    }

    public void setDesenviaTfija(BigInteger desenviaTfija) {
        this.desenviaTfija = desenviaTfija;
    }

    public BigInteger getDesenviaTvar() {
        return desenviaTvar;
    }

    public void setDesenviaTvar(BigInteger desenviaTvar) {
        this.desenviaTvar = desenviaTvar;
    }

    public BigInteger getDesrecibeTfija() {
        return desrecibeTfija;
    }

    public void setDesrecibeTfija(BigInteger desrecibeTfija) {
        this.desrecibeTfija = desrecibeTfija;
    }

    public BigInteger getDesrecibeTvar() {
        return desrecibeTvar;
    }

    public void setDesrecibeTvar(BigInteger desrecibeTvar) {
        this.desrecibeTvar = desrecibeTvar;
    }

    public Date getFecinivig() {
        return fecinivig;
    }

    public void setFecinivig(Date fecinivig) {
        this.fecinivig = fecinivig;
    }

    public Date getFecfinvig() {
        return fecfinvig;
    }

    public void setFecfinvig(Date fecfinvig) {
        this.fecfinvig = fecfinvig;
    }

    public Date getFecinipro() {
        return fecinipro;
    }

    public void setFecinipro(Date fecinipro) {
        this.fecinipro = fecinipro;
    }

    public Date getFecfinpro() {
        return fecfinpro;
    }

    public void setFecfinpro(Date fecfinpro) {
        this.fecfinpro = fecfinpro;
    }

    public Date getFecinibol() {
        return fecinibol;
    }

    public void setFecinibol(Date fecinibol) {
        this.fecinibol = fecinibol;
    }

    public Date getFecfinbol() {
        return fecfinbol;
    }

    public void setFecfinbol(Date fecfinbol) {
        this.fecfinbol = fecfinbol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSuc != null ? codigoSuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.codigoSuc == null && other.codigoSuc != null) || (this.codigoSuc != null && !this.codigoSuc.equals(other.codigoSuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Sucursal[ codigoSuc=" + codigoSuc + " ]";
    }
    
}
