/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s"),
    @NamedQuery(name = "Seccion.findByIdSeccion", query = "SELECT s FROM Seccion s WHERE s.idSeccion = :idSeccion"),
    @NamedQuery(name = "Seccion.findByNombreSeccion", query = "SELECT s FROM Seccion s WHERE s.nombreSeccion = :nombreSeccion"),
    @NamedQuery(name = "Seccion.findByEstadoSeccion", query = "SELECT s FROM Seccion s WHERE s.estadoSeccion = :estadoSeccion"),
    @NamedQuery(name = "Seccion.findByEliminadoSeccion", query = "SELECT s FROM Seccion s WHERE s.eliminadoSeccion = :eliminadoSeccion"),
    @NamedQuery(name = "Seccion.findByUsuarioCreacion", query = "SELECT s FROM Seccion s WHERE s.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "Seccion.findByFechaCreacion", query = "SELECT s FROM Seccion s WHERE s.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Seccion.findByUsuarioEdicion", query = "SELECT s FROM Seccion s WHERE s.usuarioEdicion = :usuarioEdicion"),
    @NamedQuery(name = "Seccion.findByFechaEdicion", query = "SELECT s FROM Seccion s WHERE s.fechaEdicion = :fechaEdicion")})
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seccion")
    private Integer idSeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_seccion")
    private String nombreSeccion;
    @Column(name = "estado_seccion")
    private Character estadoSeccion;
    @Column(name = "eliminado_seccion")
    private Character eliminadoSeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 50)
    @Column(name = "usuario_edicion")
    private String usuarioEdicion;
    @Column(name = "fecha_edicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdicion;
    @OneToMany(mappedBy = "idSeccion")
    private List<Publicacion> publicacionList;

    public Seccion() {
    }

    public Seccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Seccion(Integer idSeccion, String nombreSeccion, String usuarioCreacion, Date fechaCreacion) {
        this.idSeccion = idSeccion;
        this.nombreSeccion = nombreSeccion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public Character getEstadoSeccion() {
        return estadoSeccion;
    }

    public void setEstadoSeccion(Character estadoSeccion) {
        this.estadoSeccion = estadoSeccion;
    }

    public Character getEliminadoSeccion() {
        return eliminadoSeccion;
    }

    public void setEliminadoSeccion(Character eliminadoSeccion) {
        this.eliminadoSeccion = eliminadoSeccion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioEdicion() {
        return usuarioEdicion;
    }

    public void setUsuarioEdicion(String usuarioEdicion) {
        this.usuarioEdicion = usuarioEdicion;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    @XmlTransient
    public List<Publicacion> getPublicacionList() {
        return publicacionList;
    }

    public void setPublicacionList(List<Publicacion> publicacionList) {
        this.publicacionList = publicacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Seccion[ idSeccion=" + idSeccion + " ]";
    }
    
}
