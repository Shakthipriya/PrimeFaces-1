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
@Table(name = "MUSUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musuarios.findAll", query = "SELECT m FROM Musuarios m"),
    @NamedQuery(name = "Musuarios.findByRutUsuario", query = "SELECT m FROM Musuarios m WHERE m.rutUsuario = :rutUsuario"),
    @NamedQuery(name = "Musuarios.findByNombreUsuario", query = "SELECT m FROM Musuarios m WHERE m.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Musuarios.findByEmailUsuario", query = "SELECT m FROM Musuarios m WHERE m.emailUsuario = :emailUsuario"),
    @NamedQuery(name = "Musuarios.findByUsuarioOracle", query = "SELECT m FROM Musuarios m WHERE m.usuarioOracle = :usuarioOracle"),
    @NamedQuery(name = "Musuarios.findByRolStfUsuario", query = "SELECT m FROM Musuarios m WHERE m.rolStfUsuario = :rolStfUsuario")})
public class Musuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "RUT_USUARIO")
    private String rutUsuario;
    @Size(max = 40)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Size(max = 40)
    @Column(name = "EMAIL_USUARIO")
    private String emailUsuario;
    @Size(max = 30)
    @Column(name = "USUARIO_ORACLE")
    private String usuarioOracle;
    @Size(max = 2)
    @Column(name = "ROL_STF_USUARIO")
    private String rolStfUsuario;

    public Musuarios() {
    }

    public Musuarios(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getUsuarioOracle() {
        return usuarioOracle;
    }

    public void setUsuarioOracle(String usuarioOracle) {
        this.usuarioOracle = usuarioOracle;
    }

    public String getRolStfUsuario() {
        return rolStfUsuario;
    }

    public void setRolStfUsuario(String rolStfUsuario) {
        this.rolStfUsuario = rolStfUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutUsuario != null ? rutUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musuarios)) {
            return false;
        }
        Musuarios other = (Musuarios) object;
        if ((this.rutUsuario == null && other.rutUsuario != null) || (this.rutUsuario != null && !this.rutUsuario.equals(other.rutUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Musuarios[ rutUsuario=" + rutUsuario + " ]";
    }
    
}
