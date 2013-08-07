/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tipo_publicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPublicacion.findAll", query = "SELECT t FROM TipoPublicacion t"),
    @NamedQuery(name = "TipoPublicacion.findByIdTipoPublicacion", query = "SELECT t FROM TipoPublicacion t WHERE t.idTipoPublicacion = :idTipoPublicacion"),
    @NamedQuery(name = "TipoPublicacion.findByNombreTipoPublicacion", query = "SELECT t FROM TipoPublicacion t WHERE t.nombreTipoPublicacion = :nombreTipoPublicacion")})
public class TipoPublicacion implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_tipo_publicacion")
    private String nombreTipoPublicacion;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_publicacion")
    private Integer idTipoPublicacion;
    @OneToMany(mappedBy = "idTipoPublicacion")
    private List<Publicacion> publicacionList;

    public TipoPublicacion() {
    }

    public TipoPublicacion(Integer idTipoPublicacion) {
        this.idTipoPublicacion = idTipoPublicacion;
    }

    public TipoPublicacion(Integer idTipoPublicacion, String nombreTipoPublicacion) {
        this.idTipoPublicacion = idTipoPublicacion;
        this.nombreTipoPublicacion = nombreTipoPublicacion;
    }

    public Integer getIdTipoPublicacion() {
        return idTipoPublicacion;
    }

    public void setIdTipoPublicacion(Integer idTipoPublicacion) {
        this.idTipoPublicacion = idTipoPublicacion;
    }

    public String getNombreTipoPublicacion() {
        return nombreTipoPublicacion;
    }

    public void setNombreTipoPublicacion(String nombreTipoPublicacion) {
        this.nombreTipoPublicacion = nombreTipoPublicacion;
    }

    @XmlTransient
    public List<Publicacion> getPublicacionList() {
        return publicacionList;
    }

    public void setPublicacionList(List<Publicacion> publicacionList) {
        this.publicacionList = publicacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPublicacion != null ? idTipoPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPublicacion)) {
            return false;
        }
        TipoPublicacion other = (TipoPublicacion) object;
        if ((this.idTipoPublicacion == null && other.idTipoPublicacion != null) || (this.idTipoPublicacion != null && !this.idTipoPublicacion.equals(other.idTipoPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.TipoPublicacion[ idTipoPublicacion=" + idTipoPublicacion + " ]";
    }    
}
