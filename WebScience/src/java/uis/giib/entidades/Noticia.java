package uis.giib.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "noticia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticia.findAll", query = "SELECT n FROM Noticia n"),
    @NamedQuery(name = "Noticia.findByIdNoticia", query = "SELECT n FROM Noticia n WHERE n.idNoticia = :idNoticia"),
    @NamedQuery(name = "Noticia.findByEstado", query = "SELECT noti FROM Noticia noti JOIN noti.idEstado notest WHERE notest.idEstado = 1"),
    @NamedQuery(name = "Noticia.findByFechaPublicacionNoticia", query = "SELECT n FROM Noticia n WHERE n.fechaPublicacionNoticia = :fechaPublicacionNoticia")})
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_noticia")
    private Integer idNoticia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "titulo_noticia")
    private String tituloNoticia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "contenido_noticia")
    private String contenidoNoticia;
    @Column(name = "fecha_publicacion_noticia")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacionNoticia;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoGeneral idEstado;

    public Noticia() {
    }

    public Noticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Noticia(Integer idNoticia, String tituloNoticia, String contenidoNoticia) {
        this.idNoticia = idNoticia;
        this.tituloNoticia = tituloNoticia;
        this.contenidoNoticia = contenidoNoticia;
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getContenidoNoticia() {
        return contenidoNoticia;
    }

    public void setContenidoNoticia(String contenidoNoticia) {
        this.contenidoNoticia = contenidoNoticia;
    }

    public Date getFechaPublicacionNoticia() {
        return fechaPublicacionNoticia;
    }

    public void setFechaPublicacionNoticia(Date fechaPublicacionNoticia) {
        this.fechaPublicacionNoticia = fechaPublicacionNoticia;
    }

    public EstadoGeneral getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoGeneral idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNoticia != null ? idNoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.idNoticia == null && other.idNoticia != null) || (this.idNoticia != null && !this.idNoticia.equals(other.idNoticia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.Noticia[ idNoticia=" + idNoticia + " ]";
    }
}
