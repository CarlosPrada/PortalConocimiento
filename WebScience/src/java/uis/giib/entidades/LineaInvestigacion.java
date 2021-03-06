/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import java.util.List;
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
 * @author Carlos y Cristhian
 */
@Entity
@Table(name = "linea_investigacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaInvestigacion.findAll", query = "SELECT l FROM LineaInvestigacion l"),
    @NamedQuery(name = "LineaInvestigacion.findByIdLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.idLineaInvestigacion = :idLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByNombreLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.nombreLineaInvestigacion = :nombreLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByDescripcionLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.descripcionLineaInvestigacion = :descripcionLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByEstadoLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.estadoLineaInvestigacion = :estadoLineaInvestigacion"),
    @NamedQuery(name = "LineaInvestigacion.findByEliminadoLineaInvestigacion", query = "SELECT l FROM LineaInvestigacion l WHERE l.eliminadoLineaInvestigacion = :eliminadoLineaInvestigacion")})
//Falta crear consultas arriba de tablas nuevas o cambiadas.
public class LineaInvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_linea_investigacion")
    private Integer idLineaInvestigacion;

    public String getDetallelineadeinvestigacion() {
        return detallelineadeinvestigacion;
    }

    public void setDetallelineadeinvestigacion(String detallelineadeinvestigacion) {
        this.detallelineadeinvestigacion = detallelineadeinvestigacion;
    }
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_linea_investigacion")
    private String nombreLineaInvestigacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_linea_investigacion")
    private String descripcionLineaInvestigacion;
    @Column(name = "detalle_linea_de_investigacion")
    private String detallelineadeinvestigacion;
    @Column(name = "estado_linea_investigacion")
    private Character estadoLineaInvestigacion;
    @Column(name = "imagen_linea_de_investigacion")
    private String imagenLineaInvestigacion;
    @Column(name = "eliminado_linea_investigacion")
    private Character eliminadoLineaInvestigacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaInvestigacion")
    private List<LineasInvestigador> lineasInvestigadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLinea")
    private List<Proyecto> proyectoList;

    public LineaInvestigacion() {
    }

    public LineaInvestigacion(Integer idLineaInvestigacion) {
        this.idLineaInvestigacion = idLineaInvestigacion;
    }

    public LineaInvestigacion(Integer idLineaInvestigacion, String nombreLineaInvestigacion, String descripcionLineaInvestigacion) {
        this.idLineaInvestigacion = idLineaInvestigacion;
        this.nombreLineaInvestigacion = nombreLineaInvestigacion;
        this.descripcionLineaInvestigacion = descripcionLineaInvestigacion;
    }

    public String getImagenLineaInvestigacion() {
        return imagenLineaInvestigacion;
    }

    public void setImagenLineaInvestigacion(String imagenLineaInvestigacion) {
        this.imagenLineaInvestigacion = imagenLineaInvestigacion;
    }

    public List<LineasInvestigador> getLineasInvestigadorList() {
        return lineasInvestigadorList;
    }

    public void setLineasInvestigadorList(List<LineasInvestigador> lineasInvestigadorList) {
        this.lineasInvestigadorList = lineasInvestigadorList;
    }

    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public Integer getIdLineaInvestigacion() {
        return idLineaInvestigacion;
    }

    public void setIdLineaInvestigacion(Integer idLineaInvestigacion) {
        this.idLineaInvestigacion = idLineaInvestigacion;
    }

    public String getNombreLineaInvestigacion() {
        return nombreLineaInvestigacion;
    }

    public void setNombreLineaInvestigacion(String nombreLineaInvestigacion) {
        this.nombreLineaInvestigacion = nombreLineaInvestigacion;
    }

    public String getDescripcionLineaInvestigacion() {
        return descripcionLineaInvestigacion;
    }

    public void setDescripcionLineaInvestigacion(String descripcionLineaInvestigacion) {
        this.descripcionLineaInvestigacion = descripcionLineaInvestigacion;
    }

    public Character getEstadoLineaInvestigacion() {
        return estadoLineaInvestigacion;
    }

    public void setEstadoLineaInvestigacion(Character estadoLineaInvestigacion) {
        this.estadoLineaInvestigacion = estadoLineaInvestigacion;
    }

    public Character getEliminadoLineaInvestigacion() {
        return eliminadoLineaInvestigacion;
    }

    public void setEliminadoLineaInvestigacion(Character eliminadoLineaInvestigacion) {
        this.eliminadoLineaInvestigacion = eliminadoLineaInvestigacion;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaInvestigacion != null ? idLineaInvestigacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaInvestigacion)) {
            return false;
        }
        LineaInvestigacion other = (LineaInvestigacion) object;
        if ((this.idLineaInvestigacion == null && other.idLineaInvestigacion != null) || (this.idLineaInvestigacion != null && !this.idLineaInvestigacion.equals(other.idLineaInvestigacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.LineaInvestigacion[ idLineaInvestigacion=" + idLineaInvestigacion + " ]";
    }
    
}
