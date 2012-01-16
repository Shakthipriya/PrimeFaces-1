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
@Table(name = "MGIRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mgiro.findAll", query = "SELECT m FROM Mgiro m"),
    @NamedQuery(name = "Mgiro.findByFolioGiro", query = "SELECT m FROM Mgiro m WHERE m.mgiroPK.folioGiro = :folioGiro"),
    @NamedQuery(name = "Mgiro.findByFolioComp", query = "SELECT m FROM Mgiro m WHERE m.folioComp = :folioComp"),
    @NamedQuery(name = "Mgiro.findByFolioEgre", query = "SELECT m FROM Mgiro m WHERE m.folioEgre = :folioEgre"),
    @NamedQuery(name = "Mgiro.findByTipodoc", query = "SELECT m FROM Mgiro m WHERE m.tipodoc = :tipodoc"),
    @NamedQuery(name = "Mgiro.findByNumedoc", query = "SELECT m FROM Mgiro m WHERE m.numedoc = :numedoc"),
    @NamedQuery(name = "Mgiro.findByRutdestina", query = "SELECT m FROM Mgiro m WHERE m.rutdestina = :rutdestina"),
    @NamedQuery(name = "Mgiro.findByDigdestina", query = "SELECT m FROM Mgiro m WHERE m.digdestina = :digdestina"),
    @NamedQuery(name = "Mgiro.findByRefdestina", query = "SELECT m FROM Mgiro m WHERE m.refdestina = :refdestina"),
    @NamedQuery(name = "Mgiro.findByEstadogiro", query = "SELECT m FROM Mgiro m WHERE m.estadogiro = :estadogiro"),
    @NamedQuery(name = "Mgiro.findBySucdestina", query = "SELECT m FROM Mgiro m WHERE m.sucdestina = :sucdestina"),
    @NamedQuery(name = "Mgiro.findBySucRemite", query = "SELECT m FROM Mgiro m WHERE m.mgiroPK.sucRemite = :sucRemite"),
    @NamedQuery(name = "Mgiro.findBySucPagdev", query = "SELECT m FROM Mgiro m WHERE m.sucPagdev = :sucPagdev"),
    @NamedQuery(name = "Mgiro.findByRutRemite", query = "SELECT m FROM Mgiro m WHERE m.rutRemite = :rutRemite"),
    @NamedQuery(name = "Mgiro.findByDigRemite", query = "SELECT m FROM Mgiro m WHERE m.digRemite = :digRemite"),
    @NamedQuery(name = "Mgiro.findByRutCajero", query = "SELECT m FROM Mgiro m WHERE m.rutCajero = :rutCajero"),
    @NamedQuery(name = "Mgiro.findByDigCajero", query = "SELECT m FROM Mgiro m WHERE m.digCajero = :digCajero"),
    @NamedQuery(name = "Mgiro.findByRutcpagdev", query = "SELECT m FROM Mgiro m WHERE m.rutcpagdev = :rutcpagdev"),
    @NamedQuery(name = "Mgiro.findByDigcpagdev", query = "SELECT m FROM Mgiro m WHERE m.digcpagdev = :digcpagdev"),
    @NamedQuery(name = "Mgiro.findByMontoGiro", query = "SELECT m FROM Mgiro m WHERE m.montoGiro = :montoGiro"),
    @NamedQuery(name = "Mgiro.findByCodTarifa", query = "SELECT m FROM Mgiro m WHERE m.codTarifa = :codTarifa"),
    @NamedQuery(name = "Mgiro.findByCoFiGiro", query = "SELECT m FROM Mgiro m WHERE m.coFiGiro = :coFiGiro"),
    @NamedQuery(name = "Mgiro.findByCodllamada", query = "SELECT m FROM Mgiro m WHERE m.codllamada = :codllamada"),
    @NamedQuery(name = "Mgiro.findByValorllama", query = "SELECT m FROM Mgiro m WHERE m.valorllama = :valorllama"),
    @NamedQuery(name = "Mgiro.findByMontoTasa", query = "SELECT m FROM Mgiro m WHERE m.montoTasa = :montoTasa"),
    @NamedQuery(name = "Mgiro.findByFechaGiro", query = "SELECT m FROM Mgiro m WHERE m.fechaGiro = :fechaGiro"),
    @NamedQuery(name = "Mgiro.findByHoraGiro", query = "SELECT m FROM Mgiro m WHERE m.horaGiro = :horaGiro"),
    @NamedQuery(name = "Mgiro.findByFecPagdev", query = "SELECT m FROM Mgiro m WHERE m.fecPagdev = :fecPagdev"),
    @NamedQuery(name = "Mgiro.findByHorPagdev", query = "SELECT m FROM Mgiro m WHERE m.horPagdev = :horPagdev"),
    @NamedQuery(name = "Mgiro.findByObservagir", query = "SELECT m FROM Mgiro m WHERE m.observagir = :observagir"),
    @NamedQuery(name = "Mgiro.findByTipoTrans", query = "SELECT m FROM Mgiro m WHERE m.tipoTrans = :tipoTrans"),
    @NamedQuery(name = "Mgiro.findByEstaComu", query = "SELECT m FROM Mgiro m WHERE m.estaComu = :estaComu"),
    @NamedQuery(name = "Mgiro.findByPtjeGiros", query = "SELECT m FROM Mgiro m WHERE m.ptjeGiros = :ptjeGiros"),
    @NamedQuery(name = "Mgiro.findByIva", query = "SELECT m FROM Mgiro m WHERE m.iva = :iva"),
    @NamedQuery(name = "Mgiro.findByTipodop", query = "SELECT m FROM Mgiro m WHERE m.tipodop = :tipodop"),
    @NamedQuery(name = "Mgiro.findByNumerocaja", query = "SELECT m FROM Mgiro m WHERE m.numerocaja = :numerocaja"),
    @NamedQuery(name = "Mgiro.findByPers", query = "SELECT m FROM Mgiro m WHERE m.pers = :pers"),
    @NamedQuery(name = "Mgiro.findByAxsTps", query = "SELECT m FROM Mgiro m WHERE m.axsTps = :axsTps"),
    @NamedQuery(name = "Mgiro.findByNcajpagdev", query = "SELECT m FROM Mgiro m WHERE m.ncajpagdev = :ncajpagdev"),
    @NamedQuery(name = "Mgiro.findByCodItemow", query = "SELECT m FROM Mgiro m WHERE m.codItemow = :codItemow"),
    @NamedQuery(name = "Mgiro.findByCodCcoow", query = "SELECT m FROM Mgiro m WHERE m.codCcoow = :codCcoow"),
    @NamedQuery(name = "Mgiro.findByCodCiaow", query = "SELECT m FROM Mgiro m WHERE m.codCiaow = :codCiaow"),
    @NamedQuery(name = "Mgiro.findByEstadoCon", query = "SELECT m FROM Mgiro m WHERE m.estadoCon = :estadoCon"),
    @NamedQuery(name = "Mgiro.findByTipRutdes", query = "SELECT m FROM Mgiro m WHERE m.tipRutdes = :tipRutdes"),
    @NamedQuery(name = "Mgiro.findByCodmotdesb", query = "SELECT m FROM Mgiro m WHERE m.codmotdesb = :codmotdesb"),
    @NamedQuery(name = "Mgiro.findByTipoDesb", query = "SELECT m FROM Mgiro m WHERE m.tipoDesb = :tipoDesb"),
    @NamedQuery(name = "Mgiro.findByRutresdesb", query = "SELECT m FROM Mgiro m WHERE m.rutresdesb = :rutresdesb"),
    @NamedQuery(name = "Mgiro.findByDigresdesb", query = "SELECT m FROM Mgiro m WHERE m.digresdesb = :digresdesb"),
    @NamedQuery(name = "Mgiro.findByFechaDesb", query = "SELECT m FROM Mgiro m WHERE m.fechaDesb = :fechaDesb"),
    @NamedQuery(name = "Mgiro.findByHoraDesb", query = "SELECT m FROM Mgiro m WHERE m.horaDesb = :horaDesb"),
    @NamedQuery(name = "Mgiro.findByRestoObsd", query = "SELECT m FROM Mgiro m WHERE m.restoObsd = :restoObsd"),
    @NamedQuery(name = "Mgiro.findByRutdescobg", query = "SELECT m FROM Mgiro m WHERE m.rutdescobg = :rutdescobg"),
    @NamedQuery(name = "Mgiro.findByDigdescobg", query = "SELECT m FROM Mgiro m WHERE m.digdescobg = :digdescobg"),
    @NamedQuery(name = "Mgiro.findByNombre001", query = "SELECT m FROM Mgiro m WHERE m.nombre001 = :nombre001"),
    @NamedQuery(name = "Mgiro.findByNombre002", query = "SELECT m FROM Mgiro m WHERE m.nombre002 = :nombre002"),
    @NamedQuery(name = "Mgiro.findByApPat001", query = "SELECT m FROM Mgiro m WHERE m.apPat001 = :apPat001"),
    @NamedQuery(name = "Mgiro.findByApMat002", query = "SELECT m FROM Mgiro m WHERE m.apMat002 = :apMat002"),
    @NamedQuery(name = "Mgiro.findByTelRed01", query = "SELECT m FROM Mgiro m WHERE m.telRed01 = :telRed01"),
    @NamedQuery(name = "Mgiro.findByTelCel01", query = "SELECT m FROM Mgiro m WHERE m.telCel01 = :telCel01"),
    @NamedQuery(name = "Mgiro.findByPrefijo", query = "SELECT m FROM Mgiro m WHERE m.prefijo = :prefijo")})
public class Mgiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MgiroPK mgiroPK;
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
    private Long rutdestina;
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
    private Long rutRemite;
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
    @Column(name = "CODMOTDESB")
    private Integer codmotdesb;
    @Size(max = 2)
    @Column(name = "TIPO_DESB")
    private String tipoDesb;
    @Column(name = "RUTRESDESB")
    private Long rutresdesb;
    @Size(max = 1)
    @Column(name = "DIGRESDESB")
    private String digresdesb;
    @Column(name = "FECHA_DESB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesb;
    @Size(max = 8)
    @Column(name = "HORA_DESB")
    private String horaDesb;
    @Size(max = 200)
    @Column(name = "RESTO_OBSD")
    private String restoObsd;
    @Column(name = "RUTDESCOBG")
    private Long rutdescobg;
    @Size(max = 1)
    @Column(name = "DIGDESCOBG")
    private String digdescobg;
    @Size(max = 30)
    @Column(name = "NOMBRE_001")
    private String nombre001;
    @Size(max = 30)
    @Column(name = "NOMBRE_002")
    private String nombre002;
    @Size(max = 30)
    @Column(name = "AP_PAT_001")
    private String apPat001;
    @Size(max = 30)
    @Column(name = "AP_MAT_002")
    private String apMat002;
    @Size(max = 15)
    @Column(name = "TEL_RED_01")
    private String telRed01;
    @Size(max = 15)
    @Column(name = "TEL_CEL_01")
    private String telCel01;
    @Size(max = 3)
    @Column(name = "PREFIJO")
    private String prefijo;
    @JoinColumn(name = "TIPO_GIRO", referencedColumnName = "TIPO_GIRO")
    @ManyToOne
    private Mtipgiro tipoGiro;

    public Mgiro() {
    }

    public Mgiro(MgiroPK mgiroPK) {
        this.mgiroPK = mgiroPK;
    }

    public Mgiro(int folioGiro, String sucRemite) {
        this.mgiroPK = new MgiroPK(folioGiro, sucRemite);
    }

    public MgiroPK getMgiroPK() {
        return mgiroPK;
    }

    public void setMgiroPK(MgiroPK mgiroPK) {
        this.mgiroPK = mgiroPK;
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

    public Long getRutdestina() {
        return rutdestina;
    }

    public void setRutdestina(Long rutdestina) {
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

    public Long getRutRemite() {
        return rutRemite;
    }

    public void setRutRemite(Long rutRemite) {
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

    public Integer getCodmotdesb() {
        return codmotdesb;
    }

    public void setCodmotdesb(Integer codmotdesb) {
        this.codmotdesb = codmotdesb;
    }

    public String getTipoDesb() {
        return tipoDesb;
    }

    public void setTipoDesb(String tipoDesb) {
        this.tipoDesb = tipoDesb;
    }

    public Long getRutresdesb() {
        return rutresdesb;
    }

    public void setRutresdesb(Long rutresdesb) {
        this.rutresdesb = rutresdesb;
    }

    public String getDigresdesb() {
        return digresdesb;
    }

    public void setDigresdesb(String digresdesb) {
        this.digresdesb = digresdesb;
    }

    public Date getFechaDesb() {
        return fechaDesb;
    }

    public void setFechaDesb(Date fechaDesb) {
        this.fechaDesb = fechaDesb;
    }

    public String getHoraDesb() {
        return horaDesb;
    }

    public void setHoraDesb(String horaDesb) {
        this.horaDesb = horaDesb;
    }

    public String getRestoObsd() {
        return restoObsd;
    }

    public void setRestoObsd(String restoObsd) {
        this.restoObsd = restoObsd;
    }

    public Long getRutdescobg() {
        return rutdescobg;
    }

    public void setRutdescobg(Long rutdescobg) {
        this.rutdescobg = rutdescobg;
    }

    public String getDigdescobg() {
        return digdescobg;
    }

    public void setDigdescobg(String digdescobg) {
        this.digdescobg = digdescobg;
    }

    public String getNombre001() {
        return nombre001;
    }

    public void setNombre001(String nombre001) {
        this.nombre001 = nombre001;
    }

    public String getNombre002() {
        return nombre002;
    }

    public void setNombre002(String nombre002) {
        this.nombre002 = nombre002;
    }

    public String getApPat001() {
        return apPat001;
    }

    public void setApPat001(String apPat001) {
        this.apPat001 = apPat001;
    }

    public String getApMat002() {
        return apMat002;
    }

    public void setApMat002(String apMat002) {
        this.apMat002 = apMat002;
    }

    public String getTelRed01() {
        return telRed01;
    }

    public void setTelRed01(String telRed01) {
        this.telRed01 = telRed01;
    }

    public String getTelCel01() {
        return telCel01;
    }

    public void setTelCel01(String telCel01) {
        this.telCel01 = telCel01;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
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
        hash += (mgiroPK != null ? mgiroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mgiro)) {
            return false;
        }
        Mgiro other = (Mgiro) object;
        if ((this.mgiroPK == null && other.mgiroPK != null) || (this.mgiroPK != null && !this.mgiroPK.equals(other.mgiroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Mgiro[ mgiroPK=" + mgiroPK + " ]";
    }
    
}
