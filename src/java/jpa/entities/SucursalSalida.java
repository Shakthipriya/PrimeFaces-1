/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author cristobalnicolasfritzherrera
 */
public class SucursalSalida {
     private int folioGiro;
    private Integer folioComprob;
    private String estadoGiro;
    private String sucursalRemite;
    private String sucursalDestina;
    private String sucursalPagDev;
    private Long rutRemite;
    private String digRemite;


    private Long montoGiro;
    private Integer boleta;
    private Long costoFijoGiro;
    private Date fechaGiro;
    private String horaGiro;
    private Date fechaPagDev;
    private String horaPagDev;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    
    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public Integer getBoleta() {
        return boleta;
    }

    public void setBoleta(Integer boleta) {
        this.boleta = boleta;
    }

    public Long getCostoFijoGiro() {
        return costoFijoGiro;
    }

    public void setCostoFijoGiro(Long costoFijoGiro) {
        this.costoFijoGiro = costoFijoGiro;
    }

    public String getEstadoGiro() {
       // jsf.EstadoGiroController.class().estadoGiro();
        return estadoGiro;
    }

    public void setEstadoGiro(String estadoGiro) {
        this.estadoGiro = estadoGiro;
    }

    public String getFechaGiro() {
        try{
        return f.format(fechaGiro);
        }
        catch(Exception e)
        {
        return "";
        }
        //return fechaGiro;
    }

    public void setFechaGiro(Date fechaGiro) {
        this.fechaGiro = fechaGiro;
    }

    public String getFechaPagDev() {
        try{
        return f.format(fechaPagDev);
       }
        catch(Exception e)
        {
        return "";
        }
        //return fechaPagDev;
    }

    public void setFechaPagDev(Date fechaPagDev) {
        this.fechaPagDev = fechaPagDev;
    }

    public Integer getFolioComprob() {
        return folioComprob;
    }

    public void setFolioComprob(Integer folioComprob) {
        this.folioComprob = folioComprob;
    }

    public int getFolioGiro() {
        return folioGiro;
    }

    public void setFolioGiro(int folioGiro) {
        this.folioGiro = folioGiro;
    }

    public String getHoraGiro() {
        return horaGiro;
    }

    public void setHoraGiro(String horaGiro) {
        this.horaGiro = horaGiro;
    }

    public String getHoraPagDev() {
        return horaPagDev;
    }

    public void setHoraPagDev(String horaPagDev) {
        this.horaPagDev = horaPagDev;
    }

    public Long getMontoGiro() {
        return montoGiro;
    }

    public void setMontoGiro(Long montoGiro) {
        this.montoGiro = montoGiro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getRutRemite() {
        return rutRemite;
    }

    public void setRutRemite(Long rutRemite) {
        this.rutRemite = rutRemite;
    }

    public String getSucursalDestina() {
        return sucursalDestina;
    }

    public void setSucursalDestina(String sucursalDestina) {
        this.sucursalDestina = sucursalDestina;
    }

    public String getSucursalPagDev() {
        return sucursalPagDev;
    }

    public void setSucursalPagDev(String sucursalPagDev) {
        this.sucursalPagDev = sucursalPagDev;
    }

    public String getSucursalRemite() {
        return sucursalRemite;
    }

    public void setSucursalRemite(String sucursalRemite) {
        this.sucursalRemite = sucursalRemite;
    }
    
    public String getDigRemite() {
        return digRemite;
    }

    public void setDigRemite(String digRemite) {
        this.digRemite = digRemite;
    }
    public SucursalSalida(int folioGiro, Integer folioComprob, String estadoGiro, String sucursalRemite, String sucursalDestina, String sucursalPagDev, Long rutRemite, String digRemite, Long montoGiro, Integer boleta, Long costoFijoGiro, Date fechaGiro, String horaGiro, Date fechaPagDev, String horaPagDev, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.folioGiro = folioGiro;
        this.folioComprob = folioComprob;
        this.estadoGiro = estadoGiro;
        this.sucursalRemite = sucursalRemite;
        this.sucursalDestina = sucursalDestina;
        this.sucursalPagDev = sucursalPagDev;
        this.rutRemite = rutRemite;
        this.digRemite = digRemite;
        this.montoGiro = montoGiro;
        this.boleta = boleta;
        this.costoFijoGiro = costoFijoGiro;
        this.fechaGiro = fechaGiro;
        this.horaGiro = horaGiro;
        this.fechaPagDev = fechaPagDev;
        this.horaPagDev = horaPagDev;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
}
