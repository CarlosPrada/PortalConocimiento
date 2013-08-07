/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "investigador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investigador.findAll", query = "SELECT i FROM Investigador i"),
    @NamedQuery(name = "Investigador.findByUsuarioInvestigador", query = "SELECT i FROM Investigador i WHERE i.usuarioInvestigador = :usuarioInvestigador"),
    @NamedQuery(name = "Investigador.findByContrasenaInvestigador", query = "SELECT i FROM Investigador i WHERE i.contrasenaInvestigador = :contrasenaInvestigador"),
    @NamedQuery(name = "Investigador.findByLoginParameters", query = "SELECT i FROM Investigador i WHERE i.usuarioInvestigador = :usuarioInvestigador AND i.contrasenaInvestigador = :contrasenaInvestigador"),
    @NamedQuery(name = "Investigador.findByTituloInvestigador", query = "SELECT i FROM Investigador i WHERE i.tituloInvestigador = :tituloInvestigador")})
public class Investigador implements Serializable {
    @Size(max = 255)
    @Column(name = "image_investigador_path")
    private String imageInvestigadorPath;
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
    @Size(min = 1, max = 30)
    @Column(name = "nombre_investigador")
    private String nombreInvestigador;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "informacion_investigador")
    private String informacionInvestigador;
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
    @Column(name = "estado_investigador")
    private Character estadoInvestigador;
    @Column(name = "eliminado_investigador")
    private Character eliminadoInvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido_investigador")
    private String apellidoInvestigador;
    @Size(max = 100)
    @Column(name = "titulo_Investigador")
    private String tituloInvestigador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigador")
    private List<LineasInvestigador> lineasInvestigadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "investigador")
    private List<ProyectoInvestigadores> proyectoInvestigadoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutorProduccion")
    private List<ProduccionIntelectual> produccionIntelectualList;
    @JoinColumn(name = "id_tipo_investigador", referencedColumnName = "id_tipo_investigador")
    @ManyToOne(optional = false)
    private TipoInvestigador idTipoInvestigador;
    @JoinColumn(name = "id_nivel_permiso", referencedColumnName = "id_permiso")
    @ManyToOne(optional = false)
    private Permiso idNivelPermiso;

    public Investigador() {
    }

    public Investigador(String usuarioInvestigador) {
        this.usuarioInvestigador = usuarioInvestigador;
    }

    public Investigador(String usuarioInvestigador, String contrasenaInvestigador, String nombreInvestigador, String informacionInvestigador, String correoInvestigador, String generoInvestigador, String apellidoInvestigador) {
        this.usuarioInvestigador = usuarioInvestigador;
        this.contrasenaInvestigador = contrasenaInvestigador;
        this.nombreInvestigador = nombreInvestigador;
        this.informacionInvestigador = informacionInvestigador;
        this.correoInvestigador = correoInvestigador;
        this.generoInvestigador = generoInvestigador;
        this.apellidoInvestigador = apellidoInvestigador;
    }

    public String getImageInvestigadorPath() {
        return imageInvestigadorPath;
    }

    public void setImageInvestigadorPath(String imageInvestigadorPath) {
        this.imageInvestigadorPath = imageInvestigadorPath;
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

    public String getInformacionInvestigador() {
        return informacionInvestigador;
    }

    public void setInformacionInvestigador(String informacionInvestigador) {
        this.informacionInvestigador = informacionInvestigador;
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

    public Character getEstadoInvestigador() {
        return estadoInvestigador;
    }

    public void setEstadoInvestigador(Character estadoInvestigador) {
        this.estadoInvestigador = estadoInvestigador;
    }

    public Character getEliminadoInvestigador() {
        return eliminadoInvestigador;
    }

    public void setEliminadoInvestigador(Character eliminadoInvestigador) {
        this.eliminadoInvestigador = eliminadoInvestigador;
    }

    public String getApellidoInvestigador() {
        return apellidoInvestigador;
    }

    public void setApellidoInvestigador(String apellidoInvestigador) {
        this.apellidoInvestigador = apellidoInvestigador;
    }

    public String getTituloInvestigador() {
        return tituloInvestigador;
    }

    public void setTituloInvestigador(String tituloInvestigador) {
        this.tituloInvestigador = tituloInvestigador;
    }

    @XmlTransient
    public List<LineasInvestigador> getLineasInvestigadorList() {
        return lineasInvestigadorList;
    }

    public void setLineasInvestigadorList(List<LineasInvestigador> lineasInvestigadorList) {
        this.lineasInvestigadorList = lineasInvestigadorList;
    }

    @XmlTransient
    public List<ProyectoInvestigadores> getProyectoInvestigadoresList() {
        return proyectoInvestigadoresList;
    }

    public void setProyectoInvestigadoresList(List<ProyectoInvestigadores> proyectoInvestigadoresList) {
        this.proyectoInvestigadoresList = proyectoInvestigadoresList;
    }

    @XmlTransient
    public List<ProduccionIntelectual> getProduccionIntelectualList() {
        return produccionIntelectualList;
    }

    public void setProduccionIntelectualList(List<ProduccionIntelectual> produccionIntelectualList) {
        this.produccionIntelectualList = produccionIntelectualList;
    }   

    public TipoInvestigador getIdTipoInvestigador() {
        return idTipoInvestigador;
    }

    public void setIdTipoInvestigador(TipoInvestigador idTipoInvestigador) {
        this.idTipoInvestigador = idTipoInvestigador;
    }

    public Permiso getIdNivelPermiso() {
        return idNivelPermiso;
    }

    public void setIdNivelPermiso(Permiso idNivelPermiso) {
        this.idNivelPermiso = idNivelPermiso;
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
        return "uis.giib.entidades.Investigador[ usuarioInvestigador=" + usuarioInvestigador + " ]";
    }
    
}
