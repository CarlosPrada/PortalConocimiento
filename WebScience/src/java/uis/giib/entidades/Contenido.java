package uis.giib.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "contenido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contenido.findAll", query = "SELECT c FROM Contenido c"),
    @NamedQuery(name = "Contenido.findByIdPublicacion", query = "SELECT c FROM Contenido c WHERE c.idPublicacion = :idPublicacion")})
public class Contenido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_publicacion")
    private Integer idPublicacion;
    @Basic(optional = false)
    @Size(max = 200)
    @Column(name = "imagen1")
    private String imagen1;
    @Size(max = 200)
    @Column(name = "imagen2")
    private String imagen2;
    @Size(max = 200)
    @Column(name = "imagen3")
    private String imagen3;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(max = 65535)
    @Column(name = "historia")
    private String historia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(max = 65535)
    @Column(name = "razondeser")
    private String razondeser;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(max = 65535)
    @Column(name = "relaciones")
    private String relaciones;

    public Contenido() {
    }

    public Contenido(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
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
        if (!(object instanceof Contenido)) {
            return false;
        }
        Contenido other = (Contenido) object;
        if ((this.idPublicacion == null && other.idPublicacion != null) || (this.idPublicacion != null && !this.idPublicacion.equals(other.idPublicacion))) {
            return false;
        }
        return true;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getRazondeser() {
        return razondeser;
    }

    public void setRazondeser(String razondeser) {
        this.razondeser = razondeser;
    }

    public String getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(String relaciones) {
        this.relaciones = relaciones;
    }
}
