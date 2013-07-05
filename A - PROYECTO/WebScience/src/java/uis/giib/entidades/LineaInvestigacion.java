/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "linea_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaInvestigacion.findAll", query = "SELECT l FROM LineaInvestigacion l"),
    @NamedQuery(name = "LineaInvestigacion.findByIdLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.idLineaInvestigacion = :idLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByNombreLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.nombreLineaInvestigacion = :nombreLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByDescripcionLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.descripcionLineaInvestigacion = :descripcionLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByEstadoLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.estadoLineaInvestigacion = :estadoLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByEliminadoLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.eliminadoLineaInvestigacion = :eliminadoLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByUsuarioCreacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "LineaInvestigacion.findByFechaCreacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "LineaInvestigacion.findByUsuarioEdicion", query = "SELECT l FROM LineaInvestigacion l WHERE l.usuarioEdicion = :usuarioEdicion"),
    @NamedQuery(name = "LineaInvestigacion.findByFechaEdicion", query = "SELECT l FROM LineaInvestigacion l WHERE l.fechaEdicion = :fechaEdicion")})
public class LineaInvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_linea_investigacion")
    private Integer idLineaInvestigacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_linea_investigacion")
    private String nombreLineaInvestigacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion_linea_investigacion")
    private String descripcionLineaInvestigacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_linea_investigacion")
    private char estadoLineaInvestigacion;
    @Column(name = "eliminado_linea_investigacion")
    private Character eliminadoLineaInvestigacion;
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
    @JoinTable(name = "lineas_investigador", joinColumns = {
        @JoinColumn(name = "id_linea_investigacion", referencedColumnName = "id_linea_investigacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_investigador", referencedColumnName = "usuario_investigador")})
    @ManyToMany
    private List<Investigador> investigadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLinea")
    private List<Proyecto> proyectoList;

    public LineaInvestigacion() {
    }

    public LineaInvestigacion(Integer idLineaInvestigacion) {
        this.idLineaInvestigacion = idLineaInvestigacion;
    }

    public LineaInvestigacion(Integer idLineaInvestigacion, String nombreLineaInvestigacion, String descripcionLineaInvestigacion, char estadoLineaInvestigacion, String usuarioCreacion, Date fechaCreacion) {
        this.idLineaInvestigacion = idLineaInvestigacion;
        this.nombreLineaInvestigacion = nombreLineaInvestigacion;
        this.descripcionLineaInvestigacion = descripcionLineaInvestigacion;
        this.estadoLineaInvestigacion = estadoLineaInvestigacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdLineaInvestigacion() {
        return idLineaInvestigacion;
    }

    public void setIdLineaInvestigacion(Integer idLineaInvestigacion) {
        this.idLineaInvestigacion = idLineaInvestigacion;
    }

    public String getNombreLineaInvestigacion() {
        return nombreLineaInvestigacion;
    }

    public void setNombreLineaInvestigacion(String nombreLineaInvestigacion) {
        this.nombreLineaInvestigacion = nombreLineaInvestigacion;
    }

    public String getDescripcionLineaInvestigacion() {
        return descripcionLineaInvestigacion;
    }

    public void setDescripcionLineaInvestigacion(String descripcionLineaInvestigacion) {
        this.descripcionLineaInvestigacion = descripcionLineaInvestigacion;
    }

    public char getEstadoLineaInvestigacion() {
        return estadoLineaInvestigacion;
    }

    public void setEstadoLineaInvestigacion(char estadoLineaInvestigacion) {
        this.estadoLineaInvestigacion = estadoLineaInvestigacion;
    }

    public Character getEliminadoLineaInvestigacion() {
        return eliminadoLineaInvestigacion;
    }

    public void setEliminadoLineaInvestigacion(Character eliminadoLineaInvestigacion) {
        this.eliminadoLineaInvestigacion = eliminadoLineaInvestigacion;
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
    public List<Investigador> getInvestigadorList() {
        return investigadorList;
    }

    public void setInvestigadorList(List<Investigador> investigadorList) {
        this.investigadorList = investigadorList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaInvestigacion != null ? idLineaInvestigacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaInvestigacion)) {
            return false;
        }
        LineaInvestigacion other = (LineaInvestigacion) object;
        if ((this.idLineaInvestigacion == null && other.idLineaInvestigacion != null) || (this.idLineaInvestigacion != null && !this.idLineaInvestigacion.equals(other.idLineaInvestigacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.LineaInvestigacion[ idLineaInvestigacion=" + idLineaInvestigacion + " ]";
    }
    
}
