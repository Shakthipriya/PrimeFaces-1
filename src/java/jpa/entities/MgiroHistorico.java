/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristobalnicolasfritzherrera
 */
@Entity
@Table(name = "MGIRO_HISTORICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MgiroHistorico.findAll", query = "SELECT m FROM MgiroHistorico m"),
    @NamedQuery(name = "MgiroHistorico.findByFolioGiro", query = "SELECT m FROM MgiroHistorico m WHERE m.mgiroHistoricoPK.folioGiro = :folioGiro"),
    @NamedQuery(name = "MgiroHistorico.findByFolioComp", query = "SELECT m FROM MgiroHistorico m WHERE m.folioComp = :folioComp"),
    @NamedQuery(name = "MgiroHistorico.findByFolioEgre", query = "SELECT m FROM MgiroHistorico m WHERE m.folioEgre = :folioEgre"),
    @NamedQuery(name = "MgiroHistorico.findByTipodoc", query = "SELECT m FROM MgiroHistorico m WHERE m.tipodoc = :tipodoc"),
    @NamedQuery(name = "MgiroHistorico.findByNumedoc", query = "SELECT m FROM MgiroHistorico m WHERE m.numedoc = :numedoc"),
    @NamedQuery(name = "MgiroHistorico.findByRutdestina", query = "SELECT m FROM MgiroHistorico m WHERE m.rutdestina = :rutdestina"),
    @NamedQuery(name = "MgiroHistorico.findByDigdestina", query = "SELECT m FROM MgiroHistorico m WHERE m.digdestina = :digdestina"),
    @NamedQuery(name = "MgiroHistorico.findByRefdestina", query = "SELECT m FROM MgiroHistorico m WHERE m.refdestina = :refdestina"),
    @NamedQuery(name = "MgiroHistorico.findByEstadogiro", query = "SELECT m FROM MgiroHistorico m WHERE m.estadogiro = :estadogiro"),
    @NamedQuery(name = "MgiroHistorico.findBySucdestina", query = "SELECT m FROM MgiroHistorico m WHERE m.sucdestina = :sucdestina"),
    @NamedQuery(name = "MgiroHistorico.findBySucRemite", query = "SELECT m FROM MgiroHistorico m WHERE m.mgiroHistoricoPK.sucRemite = :sucRemite"),
    @NamedQuery(name = "MgiroHistorico.findBySucPagdev", query = "SELECT m FROM MgiroHistorico m WHERE m.sucPagdev = :sucPagdev"),
    @NamedQuery(name = "MgiroHistorico.findByRutRemite", query = "SELECT m FROM MgiroHistorico m WHERE m.rutRemite = :rutRemite"),
    @NamedQuery(name = "MgiroHistorico.findByDigRemite", query = "SELECT m FROM MgiroHistorico m WHERE m.digRemite = :digRemite"),
    @NamedQuery(name = "MgiroHistorico.findByRutCajero", query = "SELECT m FROM MgiroHistorico m WHERE m.rutCajero = :rutCajero"),
    @NamedQuery(name = "MgiroHistorico.findByDigCajero", query = "SELECT m FROM MgiroHistorico m WHERE m.digCajero = :digCajero"),
    @NamedQuery(name = "MgiroHistorico.findByRutcpagdev", query = "SELECT m FROM MgiroHistorico m WHERE m.rutcpagdev = :rutcpagdev"),
    @NamedQuery(name = "MgiroHistorico.findByDigcpagdev", query = "SELECT m FROM MgiroHistorico m WHERE m.digcpagdev = :digcpagdev"),
    @NamedQuery(name = "MgiroHistorico.findByMontoGiro", query = "SELECT m FROM MgiroHistorico m WHERE m.montoGiro = :montoGiro"),
    @NamedQuery(name = "MgiroHistorico.findByCodTarifa", query = "SELECT m FROM MgiroHistorico m WHERE m.codTarifa = :codTarifa"),
    @NamedQuery(name = "MgiroHistorico.findByCoFiGiro", query = "SELECT m FROM MgiroHistorico m WHERE m.coFiGiro = :coFiGiro"),
    @NamedQuery(name = "MgiroHistorico.findByCodllamada", query = "SELECT m FROM MgiroHistorico m WHERE m.codllamada = :codllamada"),
    @NamedQuery(name = "MgiroHistorico.findByValorllama", query = "SELECT m FROM MgiroHistorico m WHERE m.valorllama = :valorllama"),
    @NamedQuery(name = "MgiroHistorico.findByMontoTasa", query = "SELECT m FROM MgiroHistorico m WHERE m.montoTasa = :montoTasa"),
    @NamedQuery(name = "MgiroHistorico.findByFechaGiro", query = "SELECT m FROM MgiroHistorico m WHERE m.fechaGiro = :fechaGiro"),
    @NamedQuery(name = "MgiroHistorico.findByHoraGiro", query = "SELECT m FROM MgiroHistorico m WHERE m.horaGiro = :horaGiro"),
    @NamedQuery(name = "MgiroHistorico.findByFecPagdev", query = "SELECT m FROM MgiroHistorico m WHERE m.fecPagdev = :fecPagdev"),
    @NamedQuery(name = "MgiroHistorico.findByHorPagdev", query = "SELECT m FROM MgiroHistorico m WHERE m.horPagdev = :horPagdev"),
    @NamedQuery(name = "MgiroHistorico.findByObservagir", query = "SELECT m FROM MgiroHistorico m WHERE m.observagir = :observagir"),
    @NamedQuery(name = "MgiroHistorico.findByTipoTrans", query = "SELECT m FROM MgiroHistorico m WHERE m.tipoTrans = :tipoTrans"),
    @NamedQuery(name = "MgiroHistorico.findByEstaComu", query = "SELECT m FROM MgiroHistorico m WHERE m.estaComu = :estaComu"),
    @NamedQuery(name = "MgiroHistorico.findByPtjeGiros", query = "SELECT m FROM MgiroHistorico m WHERE m.ptjeGiros = :ptjeGiros"),
    @NamedQuery(name = "MgiroHistorico.findByIva", query = "SELECT m FROM MgiroHistorico m WHERE m.iva = :iva"),
    @NamedQuery(name = "MgiroHistorico.findByTipodop", query = "SELECT m FROM MgiroHistorico m WHERE m.tipodop = :tipodop"),
    @NamedQuery(name = "MgiroHistorico.findByNumerocaja", query = "SELECT m FROM MgiroHistorico m WHERE m.numerocaja = :numerocaja"),
    @NamedQuery(name = "MgiroHistorico.findByPers", query = "SELECT m FROM MgiroHistorico m WHERE m.pers = :pers"),
    @NamedQuery(name = "MgiroHistorico.findByAxsTps", query = "SELECT m FROM MgiroHistorico m WHERE m.axsTps = :axsTps"),
    @NamedQuery(name = "MgiroHistorico.findByNcajpagdev", query = "SELECT m FROM MgiroHistorico m WHERE m.ncajpagdev = :ncajpagdev"),
    @NamedQuery(name = "MgiroHistorico.findByCodItemow", query = "SELECT m FROM MgiroHistorico m WHERE m.codItemow = :codItemow"),
    @NamedQuery(name = "MgiroHistorico.findByCodCcoow", query = "SELECT m FROM MgiroHistorico m WHERE m.codCcoow = :codCcoow"),
    @NamedQuery(name = "MgiroHistorico.findByCodCiaow", query = "SELECT m FROM MgiroHistorico m WHERE m.codCiaow = :codCiaow"),
    @NamedQuery(name = "MgiroHistorico.findByEstadoCon", query = "SELECT m FROM MgiroHistorico m WHERE m.estadoCon = :estadoCon"),
    @NamedQuery(name = "MgiroHistorico.findByTipRutdes", query = "SELECT m FROM MgiroHistorico m WHERE m.tipRutdes = :tipRutdes")})
public class MgiroHistorico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgiroHistoricoPK mgiroHistoricoPK;
    @Column(name = "FOLIO_COMP")
    private Integer folioComp;
    @Column(name = "FOLIO_EGRE")
    private Integer folioEgre;
    @Size(max = 3)
    @Column(name = "TIPODOC")
    private String tipodoc;
    @Column(name = "NUMEDOC")
    private Integer numedoc;
    @Column(name = "RUTDESTINA")
    private Integer rutdestina;
    @Size(max = 1)
    @Column(name = "DIGDESTINA")
    private String digdestina;
    @Size(max = 50)
    @Column(name = "REFDESTINA")
    private String refdestina;
    @Size(max = 2)
    @Column(name = "ESTADOGIRO")
    private String estadogiro;
    @Size(max = 3)
    @Column(name = "SUCDESTINA")
    private String sucdestina;
    @Size(max = 3)
    @Column(name = "SUC_PAGDEV")
    private String sucPagdev;
    @Column(name = "RUT_REMITE")
    private Integer rutRemite;
    @Size(max = 1)
    @Column(name = "DIG_REMITE")
    private String digRemite;
    @Column(name = "RUT_CAJERO")
    private Integer rutCajero;
    @Size(max = 1)
    @Column(name = "DIG_CAJERO")
    private String digCajero;
    @Column(name = "RUTCPAGDEV")
    private Integer rutcpagdev;
    @Size(max = 1)
    @Column(name = "DIGCPAGDEV")
    private String digcpagdev;
    @Column(name = "MONTO_GIRO")
    private Long montoGiro;
    @Column(name = "COD_TARIFA")
    private Short codTarifa;
    @Column(name = "CO_FI_GIRO")
    private Long coFiGiro;
    @Column(name = "CODLLAMADA")
    private Short codllamada;
    @Column(name = "VALORLLAMA")
    private Long valorllama;
    @Column(name = "MONTO_TASA")
    private Long montoTasa;
    @Column(name = "FECHA_GIRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGiro;
    @Size(max = 8)
    @Column(name = "HORA_GIRO")
    private String horaGiro;
    @Column(name = "FEC_PAGDEV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecPagdev;
    @Size(max = 8)
    @Column(name = "HOR_PAGDEV")
    private String horPagdev;
    @Size(max = 50)
    @Column(name = "OBSERVAGIR")
    private String observagir;
    @Size(max = 2)
    @Column(name = "TIPO_TRANS")
    private String tipoTrans;
    @Size(max = 2)
    @Column(name = "ESTA_COMU")
    private String estaComu;
    @Column(name = "PTJE_GIROS")
    private Long ptjeGiros;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IVA")
    private BigDecimal iva;
    @Size(max = 3)
    @Column(name = "TIPODOP")
    private String tipodop;
    @Size(max = 2)
    @Column(name = "NUMEROCAJA")
    private String numerocaja;
    @Size(max = 5)
    @Column(name = "PERS")
    private String pers;
    @Size(max = 1)
    @Column(name = "AXS_TPS")
    private String axsTps;
    @Size(max = 2)
    @Column(name = "NCAJPAGDEV")
    private String ncajpagdev;
    @Column(name = "COD_ITEMOW")
    private Long codItemow;
    @Size(max = 12)
    @Column(name = "COD_CCOOW")
    private String codCcoow;
    @Size(max = 5)
    @Column(name = "COD_CIAOW")
    private String codCiaow;
    @Size(max = 2)
    @Column(name = "ESTADO_CON")
    private String estadoCon;
    @Size(max = 3)
    @Column(name = "TIP_RUTDES")
    private String tipRutdes;
    @JoinColumn(name = "TIPO_GIRO", referencedColumnName = "TIPO_GIRO")
    @ManyToOne
    private Mtipgiro tipoGiro;

    public MgiroHistorico() {
    }

    public MgiroHistorico(MgiroHistoricoPK mgiroHistoricoPK) {
        this.mgiroHistoricoPK = mgiroHistoricoPK;
    }

    public MgiroHistorico(int folioGiro, String sucRemite) {
        this.mgiroHistoricoPK = new MgiroHistoricoPK(folioGiro, sucRemite);
    }

    public MgiroHistoricoPK getMgiroHistoricoPK() {
        return mgiroHistoricoPK;
    }

    public void setMgiroHistoricoPK(MgiroHistoricoPK mgiroHistoricoPK) {
        this.mgiroHistoricoPK = mgiroHistoricoPK;
    }

    public Integer getFolioComp() {
        return folioComp;
    }

    public void setFolioComp(Integer folioComp) {
        this.folioComp = folioComp;
    }

    public Integer getFolioEgre() {
        return folioEgre;
    }

    public void setFolioEgre(Integer folioEgre) {
        this.folioEgre = folioEgre;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public Integer getNumedoc() {
        return numedoc;
    }

    public void setNumedoc(Integer numedoc) {
        this.numedoc = numedoc;
    }

    public Integer getRutdestina() {
        return rutdestina;
    }

    public void setRutdestina(Integer rutdestina) {
        this.rutdestina = rutdestina;
    }

    public String getDigdestina() {
        return digdestina;
    }

    public void setDigdestina(String digdestina) {
        this.digdestina = digdestina;
    }

    public String getRefdestina() {
        return refdestina;
    }

    public void setRefdestina(String refdestina) {
        this.refdestina = refdestina;
    }

    public String getEstadogiro() {
        return estadogiro;
    }

    public void setEstadogiro(String estadogiro) {
        this.estadogiro = estadogiro;
    }

    public String getSucdestina() {
        return sucdestina;
    }

    public void setSucdestina(String sucdestina) {
        this.sucdestina = sucdestina;
    }

    public String getSucPagdev() {
        return sucPagdev;
    }

    public void setSucPagdev(String sucPagdev) {
        this.sucPagdev = sucPagdev;
    }

    public Integer getRutRemite() {
        return rutRemite;
    }

    public void setRutRemite(Integer rutRemite) {
        this.rutRemite = rutRemite;
    }

    public String getDigRemite() {
        return digRemite;
    }

    public void setDigRemite(String digRemite) {
        this.digRemite = digRemite;
    }

    public Integer getRutCajero() {
        return rutCajero;
    }

    public void setRutCajero(Integer rutCajero) {
        this.rutCajero = rutCajero;
    }

    public String getDigCajero() {
        return digCajero;
    }

    public void setDigCajero(String digCajero) {
        this.digCajero = digCajero;
    }

    public Integer getRutcpagdev() {
        return rutcpagdev;
    }

    public void setRutcpagdev(Integer rutcpagdev) {
        this.rutcpagdev = rutcpagdev;
    }

    public String getDigcpagdev() {
        return digcpagdev;
    }

    public void setDigcpagdev(String digcpagdev) {
        this.digcpagdev = digcpagdev;
    }

    public Long getMontoGiro() {
        return montoGiro;
    }

    public void setMontoGiro(Long montoGiro) {
        this.montoGiro = montoGiro;
    }

    public Short getCodTarifa() {
        return codTarifa;
    }

    public void setCodTarifa(Short codTarifa) {
        this.codTarifa = codTarifa;
    }

    public Long getCoFiGiro() {
        return coFiGiro;
    }

    public void setCoFiGiro(Long coFiGiro) {
        this.coFiGiro = coFiGiro;
    }

    public Short getCodllamada() {
        return codllamada;
    }

    public void setCodllamada(Short codllamada) {
        this.codllamada = codllamada;
    }

    public Long getValorllama() {
        return valorllama;
    }

    public void setValorllama(Long valorllama) {
        this.valorllama = valorllama;
    }

    public Long getMontoTasa() {
        return montoTasa;
    }

    public void setMontoTasa(Long montoTasa) {
        this.montoTasa = montoTasa;
    }

    public Date getFechaGiro() {
        return fechaGiro;
    }

    public void setFechaGiro(Date fechaGiro) {
        this.fechaGiro = fechaGiro;
    }

    public String getHoraGiro() {
        return horaGiro;
    }

    public void setHoraGiro(String horaGiro) {
        this.horaGiro = horaGiro;
    }

    public Date getFecPagdev() {
        return fecPagdev;
    }

    public void setFecPagdev(Date fecPagdev) {
        this.fecPagdev = fecPagdev;
    }

    public String getHorPagdev() {
        return horPagdev;
    }

    public void setHorPagdev(String horPagdev) {
        this.horPagdev = horPagdev;
    }

    public String getObservagir() {
        return observagir;
    }

    public void setObservagir(String observagir) {
        this.observagir = observagir;
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

    public Long getPtjeGiros() {
        return ptjeGiros;
    }

    public void setPtjeGiros(Long ptjeGiros) {
        this.ptjeGiros = ptjeGiros;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public String getTipodop() {
        return tipodop;
    }

    public void setTipodop(String tipodop) {
        this.tipodop = tipodop;
    }

    public String getNumerocaja() {
        return numerocaja;
    }

    public void setNumerocaja(String numerocaja) {
        this.numerocaja = numerocaja;
    }

    public String getPers() {
        return pers;
    }

    public void setPers(String pers) {
        this.pers = pers;
    }

    public String getAxsTps() {
        return axsTps;
    }

    public void setAxsTps(String axsTps) {
        this.axsTps = axsTps;
    }

    public String getNcajpagdev() {
        return ncajpagdev;
    }

    public void setNcajpagdev(String ncajpagdev) {
        this.ncajpagdev = ncajpagdev;
    }

    public Long getCodItemow() {
        return codItemow;
    }

    public void setCodItemow(Long codItemow) {
        this.codItemow = codItemow;
    }

    public String getCodCcoow() {
        return codCcoow;
    }

    public void setCodCcoow(String codCcoow) {
        this.codCcoow = codCcoow;
    }

    public String getCodCiaow() {
        return codCiaow;
    }

    public void setCodCiaow(String codCiaow) {
        this.codCiaow = codCiaow;
    }

    public String getEstadoCon() {
        return estadoCon;
    }

    public void setEstadoCon(String estadoCon) {
        this.estadoCon = estadoCon;
    }

    public String getTipRutdes() {
        return tipRutdes;
    }

    public void setTipRutdes(String tipRutdes) {
        this.tipRutdes = tipRutdes;
    }

    public Mtipgiro getTipoGiro() {
        return tipoGiro;
    }

    public void setTipoGiro(Mtipgiro tipoGiro) {
        this.tipoGiro = tipoGiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mgiroHistoricoPK != null ? mgiroHistoricoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MgiroHistorico)) {
            return false;
        }
        MgiroHistorico other = (MgiroHistorico) object;
        if ((this.mgiroHistoricoPK == null && other.mgiroHistoricoPK != null) || (this.mgiroHistoricoPK != null && !this.mgiroHistoricoPK.equals(other.mgiroHistoricoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MgiroHistorico[ mgiroHistoricoPK=" + mgiroHistoricoPK + " ]";
    }
    
}
