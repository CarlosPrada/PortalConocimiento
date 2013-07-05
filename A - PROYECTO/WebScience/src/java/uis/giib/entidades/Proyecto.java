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
import javax.persistence.ManyToOne;
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
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyecto.findByNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "Proyecto.findByDescripcionProyecto", query = "SELECT p FROM Proyecto p WHERE p.descripcionProyecto = :descripcionProyecto"),
    @NamedQuery(name = "Proyecto.findByEstadoProyecto", query = "SELECT p FROM Proyecto p WHERE p.estadoProyecto = :estadoProyecto"),
    @NamedQuery(name = "Proyecto.findByEliminadoProyecto", query = "SELECT p FROM Proyecto p WHERE p.eliminadoProyecto = :eliminadoProyecto"),
    @NamedQuery(name = "Proyecto.findByUsuarioCreacion", query = "SELECT p FROM Proyecto p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "Proyecto.findByFechaCreacion", query = "SELECT p FROM Proyecto p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Proyecto.findByUsuarioEdicion", query = "SELECT p FROM Proyecto p WHERE p.usuarioEdicion = :usuarioEdicion"),
    @NamedQuery(name = "Proyecto.findByFechaEdicion", query = "SELECT p FROM Proyecto p WHERE p.fechaEdicion = :fechaEdicion")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion_proyecto")
    private String descripcionProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_proyecto")
    private char estadoProyecto;
    @Column(name = "eliminado_proyecto")
    private Character eliminadoProyecto;
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
    @JoinColumn(name = "id_tipo_proyecto", referencedColumnName = "id_tipo_proyecto")
    @ManyToOne(optional = false)
    private TipoProyecto idTipoProyecto;
    @JoinColumn(name = "id_linea", referencedColumnName = "id_linea_investigacion")
    @ManyToOne(optional = false)
    private LineaInvestigacion idLinea;
    @JoinColumn(name = "id_estado_proyecto", referencedColumnName = "id_estado_proyecto")
    @ManyToOne(optional = false)
    private EstadoProyecto idEstadoProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<ProyectoInvestigadores> proyectoInvestigadoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<Producto> productoList;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombreProyecto, String descripcionProyecto, char estadoProyecto, String usuarioCreacion, Date fechaCreacion) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.estadoProyecto = estadoProyecto;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public char getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(char estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public Character getEliminadoProyecto() {
        return eliminadoProyecto;
    }

    public void setEliminadoProyecto(Character eliminadoProyecto) {
        this.eliminadoProyecto = eliminadoProyecto;
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

    public TipoProyecto getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(TipoProyecto idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public LineaInvestigacion getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(LineaInvestigacion idLinea) {
        this.idLinea = idLinea;
    }

    public EstadoProyecto getIdEstadoProyecto() {
        return idEstadoProyecto;
    }

    public void setIdEstadoProyecto(EstadoProyecto idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
    }

    @XmlTransient
    public List<ProyectoInvestigadores> getProyectoInvestigadoresList() {
        return proyectoInvestigadoresList;
    }

    public void setProyectoInvestigadoresList(List<ProyectoInvestigadores> proyectoInvestigadoresList) {
        this.proyectoInvestigadoresList = proyectoInvestigadoresList;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}
