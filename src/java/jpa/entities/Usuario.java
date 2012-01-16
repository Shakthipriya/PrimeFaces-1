/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuCodigo", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.usuCodigo = :usuCodigo"),
    @NamedQuery(name = "Usuario.findByUsuNombre", query = "SELECT u FROM Usuario u WHERE u.usuNombre = :usuNombre"),
    @NamedQuery(name = "Usuario.findByUsuFechacreacion", query = "SELECT u FROM Usuario u WHERE u.usuFechacreacion = :usuFechacreacion"),
    @NamedQuery(name = "Usuario.findByUsuFechainiciovigencia", query = "SELECT u FROM Usuario u WHERE u.usuFechainiciovigencia = :usuFechainiciovigencia"),
    @NamedQuery(name = "Usuario.findByUsuFechafinvigencia", query = "SELECT u FROM Usuario u WHERE u.usuFechafinvigencia = :usuFechafinvigencia"),
    @NamedQuery(name = "Usuario.findByUsuClave", query = "SELECT u FROM Usuario u WHERE u.usuClave = :usuClave"),
    @NamedQuery(name = "Usuario.findByUsuEstado", query = "SELECT u FROM Usuario u WHERE u.usuEstado = :usuEstado"),
    @NamedQuery(name = "Usuario.findByUsuEssupervisor", query = "SELECT u FROM Usuario u WHERE u.usuEssupervisor = :usuEssupervisor"),
    @NamedQuery(name = "Usuario.findByPerCodigo", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.perCodigo = :perCodigo")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Size(max = 100)
    @Column(name = "USU_NOMBRE")
    private String usuNombre;
    @Column(name = "USU_FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechacreacion;
    @Column(name = "USU_FECHAINICIOVIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechainiciovigencia;
    @Column(name = "USU_FECHAFINVIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFechafinvigencia;
    @Size(max = 16)
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @Column(name = "USU_ESTADO")
    private Character usuEstado;
    @Column(name = "USU_ESSUPERVISOR")
    private Character usuEssupervisor;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(String usuCodigo, BigInteger perCodigo) {
        this.usuarioPK = new UsuarioPK(usuCodigo, perCodigo);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public Date getUsuFechacreacion() {
        return usuFechacreacion;
    }

    public void setUsuFechacreacion(Date usuFechacreacion) {
        this.usuFechacreacion = usuFechacreacion;
    }

    public Date getUsuFechainiciovigencia() {
        return usuFechainiciovigencia;
    }

    public void setUsuFechainiciovigencia(Date usuFechainiciovigencia) {
        this.usuFechainiciovigencia = usuFechainiciovigencia;
    }

    public Date getUsuFechafinvigencia() {
        return usuFechafinvigencia;
    }

    public void setUsuFechafinvigencia(Date usuFechafinvigencia) {
        this.usuFechafinvigencia = usuFechafinvigencia;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Character getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Character usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Character getUsuEssupervisor() {
        return usuEssupervisor;
    }

    public void setUsuEssupervisor(Character usuEssupervisor) {
        this.usuEssupervisor = usuEssupervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPK != null ? usuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioPK == null && other.usuarioPK != null) || (this.usuarioPK != null && !this.usuarioPK.equals(other.usuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Usuario[ usuarioPK=" + usuarioPK + " ]";
    }
    
}
