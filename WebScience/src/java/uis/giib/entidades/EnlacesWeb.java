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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Entity
@Table(name = "enlaces_web")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnlacesWeb.findAll", query = "SELECT e FROM EnlacesWeb e"),
    @NamedQuery(name = "EnlacesWeb.findByNombreEnlace", query = "SELECT e FROM EnlacesWeb e WHERE e.nombreEnlace = :nombreEnlace"),
    @NamedQuery(name = "EnlacesWeb.findByEnlace", query = "SELECT e FROM EnlacesWeb e WHERE e.enlace = :enlace"),
    @NamedQuery(name = "EnlacesWeb.findByIdEnlace", query = "SELECT e FROM EnlacesWeb e WHERE e.idEnlace = :idEnlace"),
    @NamedQuery(name = "EnlacesWeb.findByDescripcion", query = "SELECT e FROM EnlacesWeb e WHERE e.descripcion = :descripcion")})
public class EnlacesWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre_enlace")
    private String nombreEnlace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "enlace")
    private String enlace;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enlace")
    private Integer idEnlace;
    @Size(max = 800)
    @Column(name = "descripcion")
    private String descripcion;

    public EnlacesWeb() {
    }

    public EnlacesWeb(Integer idEnlace) {
        this.idEnlace = idEnlace;
    }

    public EnlacesWeb(Integer idEnlace, String nombreEnlace, String enlace) {
        this.idEnlace = idEnlace;
        this.nombreEnlace = nombreEnlace;
        this.enlace = enlace;
    }

    public String getNombreEnlace() {
        return nombreEnlace;
    }

    public void setNombreEnlace(String nombreEnlace) {
        this.nombreEnlace = nombreEnlace;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Integer getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(Integer idEnlace) {
        this.idEnlace = idEnlace;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnlace != null ? idEnlace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnlacesWeb)) {
            return false;
        }
        EnlacesWeb other = (EnlacesWeb) object;
        if ((this.idEnlace == null && other.idEnlace != null) || (this.idEnlace != null && !this.idEnlace.equals(other.idEnlace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.EnlacesWeb[ idEnlace=" + idEnlace + " ]";
    }
}
