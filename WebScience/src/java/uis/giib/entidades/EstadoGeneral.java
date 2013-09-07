/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "estado_general")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoGeneral.findAll", query = "SELECT e FROM EstadoGeneral e"),
    @NamedQuery(name = "EstadoGeneral.findByIdEstado", query = "SELECT e FROM EstadoGeneral e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EstadoGeneral.findByNombreEstado", query = "SELECT e FROM EstadoGeneral e WHERE e.nombreEstado = :nombreEstado")})
public class EstadoGeneral implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private Collection<Seccion> seccionCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Integer idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre_estado")
    private String nombreEstado;

    public EstadoGeneral() {
    }

    public EstadoGeneral(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoGeneral(Integer idEstado, String nombreEstado) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoGeneral)) {
            return false;
        }
        EstadoGeneral other = (EstadoGeneral) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.EstadoGeneral[ idEstado=" + idEstado + " ]";
    }

    @XmlTransient
    public Collection<Seccion> getSeccionCollection() {
        return seccionCollection;
    }

    public void setSeccionCollection(Collection<Seccion> seccionCollection) {
        this.seccionCollection = seccionCollection;
    }
    
}
