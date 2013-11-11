package uis.giib.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Entity
@Table(name = "imagen_portal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImagenPortal.findAll", query = "SELECT i FROM ImagenPortal i"),
    @NamedQuery(name = "ImagenPortal.findByIdImagen", query = "SELECT i FROM ImagenPortal i WHERE i.idImagen = :idImagen"),
    @NamedQuery(name = "ImagenPortal.findByNombreImagen", query = "SELECT i FROM ImagenPortal i WHERE i.nombreImagen = :nombreImagen"),
    @NamedQuery(name = "ImagenPortal.findByDescripcionImagen", query = "SELECT i FROM ImagenPortal i WHERE i.descripcionImagen = :descripcionImagen")})
public class ImagenPortal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_imagen")
    private Integer idImagen;
    @Size(max = 500)
    @Column(name = "nombre_imagen")
    private String nombreImagen;
    @Size(max = 800)
    @Column(name = "descripcion_imagen")
    private String descripcionImagen;

    public ImagenPortal() {
    }

    public ImagenPortal(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getDescripcionImagen() {
        return descripcionImagen;
    }

    public void setDescripcionImagen(String descripcionImagen) {
        this.descripcionImagen = descripcionImagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagen != null ? idImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagenPortal)) {
            return false;
        }
        ImagenPortal other = (ImagenPortal) object;
        if ((this.idImagen == null && other.idImagen != null) || (this.idImagen != null && !this.idImagen.equals(other.idImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.ImagenPortal[ idImagen=" + idImagen + " ]";
    }
}
