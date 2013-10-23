package uis.giib.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *  * @author Carlos David Prada Remolina  * @version 1.0  * @since 10/10/2013
 */
@Entity
@Table(name = "herramienta_software")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HerramientaSoftware.findAll", query = "SELECT h FROM HerramientaSoftware h"),
    @NamedQuery(name = "HerramientaSoftware.findByIdHerramienta", query = "SELECT h FROM HerramientaSoftware h WHERE h.idHerramienta = :idHerramienta"),
    @NamedQuery(name = "HerramientaSoftware.findByNombreHerramienta", query = "SELECT h FROM HerramientaSoftware h WHERE h.nombreHerramienta = :nombreHerramienta"),
    @NamedQuery(name = "HerramientaSoftware.findByUrlHerramienta", query = "SELECT h FROM HerramientaSoftware h WHERE h.urlHerramienta = :urlHerramienta"),
    @NamedQuery(name = "HerramientaSoftware.findByBuscador", query = "SELECT hers FROM HerramientaSoftware hers WHERE hers.descripcionHerramienta LIKE :buscar OR hers.nombreHerramienta LIKE :buscar"),
    @NamedQuery(name = "HerramientaSoftware.findByDescripcionHerramienta", query = "SELECT h FROM HerramientaSoftware h WHERE h.descripcionHerramienta = :descripcionHerramienta"),
    @NamedQuery(name = "HerramientaSoftware.findHerramientaSoftwareByEstado", query = "SELECT hs FROM HerramientaSoftware hs JOIN hs.idEstado hsest WHERE hsest.idEstado = 1"),
    @NamedQuery(name = "HerramientaSoftware.findByImagenHerramienta", query = "SELECT h FROM HerramientaSoftware h WHERE h.imagenHerramienta = :imagenHerramienta")})
public class HerramientaSoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_herramienta")
    private Integer idHerramienta;
    @Basic(optional = false)
    @NotNull
    @Size(  max = 200)
    @Column(name = "nombre_herramienta")
    private String nombreHerramienta;
    @Basic(optional = false)
    @NotNull
    @Size(  max = 800)
    @Column(name = "url_herramienta")
    private String urlHerramienta;
    @Basic(optional = false)
    @NotNull
    @Size(  max = 1000)
    @Column(name = "descripcion_herramienta")
    private String descripcionHerramienta;
    @Size(max = 500)
    @Column(name = "imagen_herramienta")
    private String imagenHerramienta;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoGeneral idEstado;

    public HerramientaSoftware() {
    }

    public HerramientaSoftware(Integer idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public HerramientaSoftware(Integer idHerramienta, String nombreHerramienta, String urlHerramienta, String descripcionHerramienta) {
        this.idHerramienta = idHerramienta;
        this.nombreHerramienta = nombreHerramienta;
        this.urlHerramienta = urlHerramienta;
        this.descripcionHerramienta = descripcionHerramienta;
    }

    public Integer getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(Integer idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public String getUrlHerramienta() {
        return urlHerramienta;
    }

    public void setUrlHerramienta(String urlHerramienta) {
        this.urlHerramienta = urlHerramienta;
    }

    public String getDescripcionHerramienta() {
        return descripcionHerramienta;
    }

    public void setDescripcionHerramienta(String descripcionHerramienta) {
        this.descripcionHerramienta = descripcionHerramienta;
    }

    public String getImagenHerramienta() {
        return imagenHerramienta;
    }

    public void setImagenHerramienta(String imagenHerramienta) {
        this.imagenHerramienta = imagenHerramienta;
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
        hash += (idHerramienta != null ? idHerramienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HerramientaSoftware)) {
            return false;
        }
        HerramientaSoftware other = (HerramientaSoftware) object;
        if ((this.idHerramienta == null && other.idHerramienta != null) || (this.idHerramienta != null && !this.idHerramienta.equals(other.idHerramienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.HerramientaSoftware[ idHerramienta=" + idHerramienta + " ]";
    }
}
