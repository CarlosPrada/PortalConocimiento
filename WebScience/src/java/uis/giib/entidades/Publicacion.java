/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author Carlos
 */
@Entity
@Table(name = "publicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicacion.findAll", query = "SELECT p FROM Publicacion p"),
    @NamedQuery(name = "Publicacion.findByIdPublicacion", query = "SELECT p FROM Publicacion p WHERE p.idPublicacion = :idPublicacion"),
    @NamedQuery(name = "Publicacion.findByContenidoResumidoPublicacion", query = "SELECT p FROM Publicacion p WHERE p.contenidoResumidoPublicacion = :contenidoResumidoPublicacion"),
    @NamedQuery(name = "Publicacion.findByFechaInicioeventoPublicacion", query = "SELECT p FROM Publicacion p WHERE p.fechaInicioeventoPublicacion = :fechaInicioeventoPublicacion"),
    @NamedQuery(name = "Publicacion.findByFechaFineventoPublicacion", query = "SELECT p FROM Publicacion p WHERE p.fechaFineventoPublicacion = :fechaFineventoPublicacion"),
    @NamedQuery(name = "Publicacion.findByFechaDespublicarPublicacion", query = "SELECT p FROM Publicacion p WHERE p.fechaDespublicarPublicacion = :fechaDespublicarPublicacion"),
    @NamedQuery(name = "Publicacion.findByIdMultimedia", query = "SELECT p FROM Publicacion p WHERE p.idMultimedia = :idMultimedia"),
    @NamedQuery(name = "Publicacion.findByEstadoPublicacion", query = "SELECT p FROM Publicacion p WHERE p.estadoPublicacion = :estadoPublicacion"),
    @NamedQuery(name = "Publicacion.findByEliminadoPublicacion", query = "SELECT p FROM Publicacion p WHERE p.eliminadoPublicacion = :eliminadoPublicacion"),
    @NamedQuery(name = "Publicacion.findByTituloPublicacion", query = "SELECT p FROM Publicacion p WHERE p.tituloPublicacion = :tituloPublicacion")})
public class Publicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_publicacion")
    private Integer idPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contenido_resumido_publicacion")
    private String contenidoResumidoPublicacion;
    @Column(name = "fecha_inicioevento_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioeventoPublicacion;
    @Column(name = "fecha_finevento_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFineventoPublicacion;
    @Column(name = "fecha_despublicar_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaDespublicarPublicacion;
    @Column(name = "id_multimedia")
    private Integer idMultimedia;
    @Column(name = "estado_publicacion")
    private Character estadoPublicacion;
    @Column(name = "eliminado_publicacion")
    private Character eliminadoPublicacion;
    @Column(name = "titulo_publicacion")
    private String tituloPublicacion;
    @Column(name = "contenido_detallado_publicacion")
    private String contenidodetalladoPublicacion;
    @JoinColumn(name = "id_tipo_publicacion", referencedColumnName = "id_tipo_publicacion")
    @ManyToOne
    private TipoPublicacion idTipoPublicacion;
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion")
    @ManyToOne
    private Seccion idSeccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPublicacion")
    private Collection<Recursos> recursosCollection;

    public Publicacion() {
    }

    public Publicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Publicacion(Integer idPublicacion, String contenidoPublicacion) {
        this.idPublicacion = idPublicacion;
        this.contenidoResumidoPublicacion = contenidoPublicacion;
    }
    public String getContenidoResumidoPublicacion() {
        return contenidoResumidoPublicacion;
    }

    public void setContenidoResumidoPublicacion(String contenidoResumidoPublicacion) {
        this.contenidoResumidoPublicacion = contenidoResumidoPublicacion;
    }

    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    public void setTituloPublicacion(String tituloPublicacion) {
        this.tituloPublicacion = tituloPublicacion;
    }

    public String getContenidodetalladoPublicacion() {
        return contenidodetalladoPublicacion;
    }

    public void setContenidodetalladoPublicacion(String contenidodetalladoPublicacion) {
        this.contenidodetalladoPublicacion = contenidodetalladoPublicacion;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getContenidoPublicacion() {
        return contenidoResumidoPublicacion;
    }

    public void setContenidoPublicacion(String contenidoPublicacion) {
        this.contenidoResumidoPublicacion = contenidoPublicacion;
    }

    public Date getFechaInicioeventoPublicacion() {
        return fechaInicioeventoPublicacion;
    }

    public void setFechaInicioeventoPublicacion(Date fechaInicioeventoPublicacion) {
        this.fechaInicioeventoPublicacion = fechaInicioeventoPublicacion;
    }

    public Date getFechaFineventoPublicacion() {
        return fechaFineventoPublicacion;
    }

    public void setFechaFineventoPublicacion(Date fechaFineventoPublicacion) {
        this.fechaFineventoPublicacion = fechaFineventoPublicacion;
    }

    public Date getFechaDespublicarPublicacion() {
        return fechaDespublicarPublicacion;
    }

    public void setFechaDespublicarPublicacion(Date fechaDespublicarPublicacion) {
        this.fechaDespublicarPublicacion = fechaDespublicarPublicacion;
    }

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public Character getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(Character estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public Character getEliminadoPublicacion() {
        return eliminadoPublicacion;
    }

    public void setEliminadoPublicacion(Character eliminadoPublicacion) {
        this.eliminadoPublicacion = eliminadoPublicacion;
    }

    public TipoPublicacion getIdTipoPublicacion() {
        return idTipoPublicacion;
    }

    public void setIdTipoPublicacion(TipoPublicacion idTipoPublicacion) {
        this.idTipoPublicacion = idTipoPublicacion;
    }

    public Seccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Seccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    @XmlTransient
    public Collection<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(Collection<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicacion != null ? idPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacion)) {
            return false;
        }
        Publicacion other = (Publicacion) object;
        if ((this.idPublicacion == null && other.idPublicacion != null) || (this.idPublicacion != null && !this.idPublicacion.equals(other.idPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.Publicacion[ idPublicacion=" + idPublicacion + " ]";
    }
    
}
