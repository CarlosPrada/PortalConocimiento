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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "investigador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investigador.findAll", query = "SELECT i FROM Investigador i"),
    @NamedQuery(name = "Investigador.findByUsuarioInvestigador", query = "SELECT i FROM Investigador i WHERE i.usuarioInvestigador = :usuarioInvestigador"),
    @NamedQuery(name = "Investigador.findByContrasenaInvestigador", query = "SELECT i FROM Investigador i WHERE i.contrasenaInvestigador = :contrasenaInvestigador"),
    @NamedQuery(name = "Investigador.findByNombreInvestigador", query = "SELECT i FROM Investigador i WHERE i.nombreInvestigador = :nombreInvestigador"),
    @NamedQuery(name = "Investigador.findByTelefonoInvestigador", query = "SELECT i FROM Investigador i WHERE i.telefonoInvestigador = :telefonoInvestigador"),
    @NamedQuery(name = "Investigador.findByCelularInvestigador", query = "SELECT i FROM Investigador i WHERE i.celularInvestigador = :celularInvestigador"),
    @NamedQuery(name = "Investigador.findByCorreoInvestigador", query = "SELECT i FROM Investigador i WHERE i.correoInvestigador = :correoInvestigador"),
    @NamedQuery(name = "Investigador.findByGeneroInvestigador", query = "SELECT i FROM Investigador i WHERE i.generoInvestigador = :generoInvestigador"),
    @NamedQuery(name = "Investigador.findByCvlacInvestigador", query = "SELECT i FROM Investigador i WHERE i.cvlacInvestigador = :cvlacInvestigador"),
    @NamedQuery(name = "Investigador.findByEstadoInvestigador", query = "SELECT i FROM Investigador i WHERE i.estadoInvestigador = :estadoInvestigador"),
    @NamedQuery(name = "Investigador.findByEliminadoInvestigador", query = "SELECT i FROM Investigador i WHERE i.eliminadoInvestigador = :eliminadoInvestigador"),
    @NamedQuery(name = "Investigador.findByUsuarioCreacion", query = "SELECT i FROM Investigador i WHERE i.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "Investigador.findByFechaCreacion", query = "SELECT i FROM Investigador i WHERE i.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Investigador.findByUsuarioEdicion", query = "SELECT i FROM Investigador i WHERE i.usuarioEdicion = :usuarioEdicion"),
    @NamedQuery(name = "Investigador.findByFechaEdicion", query = "SELECT i FROM Investigador i WHERE i.fechaEdicion = :fechaEdicion")})
public class Investigador implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "informacion_investigador")
    private String informacionInvestigador;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuario_investigador")
    private String usuarioInvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contrasena_investigador")
    private String contrasenaInvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_investigador")
    private String nombreInvestigador;
    @Size(max = 15)
    @Column(name = "telefono_investigador")
    private String telefonoInvestigador;
    @Size(max = 10)
    @Column(name = "celular_investigador")
    private String celularInvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo_investigador")
    private String correoInvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "genero_investigador")
    private String generoInvestigador;
    @Size(max = 100)
    @Column(name = "cvlac_investigador")
    private String cvlacInvestigador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_investigador")
    private char estadoInvestigador;
    @Column(name = "eliminado_investigador")
    private Character eliminadoInvestigador;
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
    @ManyToMany(mappedBy = "investigadorList")
    private List<LineaInvestigacion> lineaInvestigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigador")
    private List<ProyectoInvestigadores> proyectoInvestigadoresList;
    @JoinColumn(name = "id_nivel_permiso", referencedColumnName = "id_permiso")
    @ManyToOne(optional = false)
    private Permiso idNivelPermiso;
    @JoinColumn(name = "id_tipo_investigador", referencedColumnName = "id_tipo_investigador")
    @ManyToOne(optional = false)
    private TipoInvestigador idTipoInvestigador;

    public Investigador() {
    }

    public Investigador(String usuarioInvestigador) {
        this.usuarioInvestigador = usuarioInvestigador;
    }

    public Investigador(String usuarioInvestigador, String contrasenaInvestigador, String nombreInvestigador, String correoInvestigador, String generoInvestigador, char estadoInvestigador, String usuarioCreacion, Date fechaCreacion) {
        this.usuarioInvestigador = usuarioInvestigador;
        this.contrasenaInvestigador = contrasenaInvestigador;
        this.nombreInvestigador = nombreInvestigador;
        this.correoInvestigador = correoInvestigador;
        this.generoInvestigador = generoInvestigador;
        this.estadoInvestigador = estadoInvestigador;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioInvestigador() {
        return usuarioInvestigador;
    }

    public void setUsuarioInvestigador(String usuarioInvestigador) {
        this.usuarioInvestigador = usuarioInvestigador;
    }

    public String getContrasenaInvestigador() {
        return contrasenaInvestigador;
    }

    public void setContrasenaInvestigador(String contrasenaInvestigador) {
        this.contrasenaInvestigador = contrasenaInvestigador;
    }

    public String getNombreInvestigador() {
        return nombreInvestigador;
    }

    public void setNombreInvestigador(String nombreInvestigador) {
        this.nombreInvestigador = nombreInvestigador;
    }

    public String getTelefonoInvestigador() {
        return telefonoInvestigador;
    }

    public void setTelefonoInvestigador(String telefonoInvestigador) {
        this.telefonoInvestigador = telefonoInvestigador;
    }

    public String getCelularInvestigador() {
        return celularInvestigador;
    }

    public void setCelularInvestigador(String celularInvestigador) {
        this.celularInvestigador = celularInvestigador;
    }

    public String getCorreoInvestigador() {
        return correoInvestigador;
    }

    public void setCorreoInvestigador(String correoInvestigador) {
        this.correoInvestigador = correoInvestigador;
    }

    public String getGeneroInvestigador() {
        return generoInvestigador;
    }

    public void setGeneroInvestigador(String generoInvestigador) {
        this.generoInvestigador = generoInvestigador;
    }

    public String getCvlacInvestigador() {
        return cvlacInvestigador;
    }

    public void setCvlacInvestigador(String cvlacInvestigador) {
        this.cvlacInvestigador = cvlacInvestigador;
    }

    public char getEstadoInvestigador() {
        return estadoInvestigador;
    }

    public void setEstadoInvestigador(char estadoInvestigador) {
        this.estadoInvestigador = estadoInvestigador;
    }

    public Character getEliminadoInvestigador() {
        return eliminadoInvestigador;
    }

    public void setEliminadoInvestigador(Character eliminadoInvestigador) {
        this.eliminadoInvestigador = eliminadoInvestigador;
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
    public List<LineaInvestigacion> getLineaInvestigacionList() {
        return lineaInvestigacionList;
    }

    public void setLineaInvestigacionList(List<LineaInvestigacion> lineaInvestigacionList) {
        this.lineaInvestigacionList = lineaInvestigacionList;
    }

    @XmlTransient
    public List<ProyectoInvestigadores> getProyectoInvestigadoresList() {
        return proyectoInvestigadoresList;
    }

    public void setProyectoInvestigadoresList(List<ProyectoInvestigadores> proyectoInvestigadoresList) {
        this.proyectoInvestigadoresList = proyectoInvestigadoresList;
    }

    public Permiso getIdNivelPermiso() {
        return idNivelPermiso;
    }

    public void setIdNivelPermiso(Permiso idNivelPermiso) {
        this.idNivelPermiso = idNivelPermiso;
    }

    public TipoInvestigador getIdTipoInvestigador() {
        return idTipoInvestigador;
    }

    public void setIdTipoInvestigador(TipoInvestigador idTipoInvestigador) {
        this.idTipoInvestigador = idTipoInvestigador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioInvestigador != null ? usuarioInvestigador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investigador)) {
            return false;
        }
        Investigador other = (Investigador) object;
        if ((this.usuarioInvestigador == null && other.usuarioInvestigador != null) || (this.usuarioInvestigador != null && !this.usuarioInvestigador.equals(other.usuarioInvestigador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Investigador[ usuarioInvestigador=" + usuarioInvestigador + " ]";
    }

    public String getInformacionInvestigador() {
        return informacionInvestigador;
    }

    public void setInformacionInvestigador(String informacionInvestigador) {
        this.informacionInvestigador = informacionInvestigador;
    }
    
}
