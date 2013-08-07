/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyecto.findByNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "Proyecto.findByDescripcionResumidaProyecto", query = "SELECT p FROM Proyecto p WHERE p.descripcionResumidaProyecto = :descripcionResumidaProyecto"),
    @NamedQuery(name = "Proyecto.findByEstadoProyecto", query = "SELECT p FROM Proyecto p WHERE p.estadoProyecto = :estadoProyecto"),
    @NamedQuery(name = "Proyecto.findByEliminadoProyecto", query = "SELECT p FROM Proyecto p WHERE p.eliminadoProyecto = :eliminadoProyecto")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion_resumida_proyecto")
    private String descripcionResumidaProyecto;
    @Column(name = "estado_proyecto")
    private Character estadoProyecto;
    @Column(name = "eliminado_proyecto")
    private Character eliminadoProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_detallada_proyecto")
    private String descripcionDetalladaProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "objetivos_proyecto")
    private String objetivosProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "resultados_proyecto")
    private String resultadosProyecto;
    @JoinColumn(name = "id_tipo_proyecto", referencedColumnName = "id_tipo_proyecto")
    @ManyToOne(optional = false)
    private TipoProyecto idTipoProyecto;
    @JoinColumn(name = "id_estado_proyecto", referencedColumnName = "id_estado_proyecto")
    @ManyToOne(optional = false)
    private EstadoProyecto idEstadoProyecto;
    @JoinColumn(name = "id_linea", referencedColumnName = "id_linea_investigacion")
    @ManyToOne(optional = false)
    private LineaInvestigacion idLinea;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombreProyecto, String descripcionResumidaProyecto, String descripcionDetalladaProyecto, String objetivosProyecto, String resultadosProyecto) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionResumidaProyecto = descripcionResumidaProyecto;
        this.descripcionDetalladaProyecto = descripcionDetalladaProyecto;
        this.objetivosProyecto = objetivosProyecto;
        this.resultadosProyecto = resultadosProyecto;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionResumidaProyecto() {
        return descripcionResumidaProyecto;
    }

    public void setDescripcionResumidaProyecto(String descripcionResumidaProyecto) {
        this.descripcionResumidaProyecto = descripcionResumidaProyecto;
    }

    public Character getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(Character estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public Character getEliminadoProyecto() {
        return eliminadoProyecto;
    }

    public void setEliminadoProyecto(Character eliminadoProyecto) {
        this.eliminadoProyecto = eliminadoProyecto;
    }

    public String getDescripcionDetalladaProyecto() {
        return descripcionDetalladaProyecto;
    }

    public void setDescripcionDetalladaProyecto(String descripcionDetalladaProyecto) {
        this.descripcionDetalladaProyecto = descripcionDetalladaProyecto;
    }

    public String getObjetivosProyecto() {
        return objetivosProyecto;
    }

    public void setObjetivosProyecto(String objetivosProyecto) {
        this.objetivosProyecto = objetivosProyecto;
    }

    public String getResultadosProyecto() {
        return resultadosProyecto;
    }

    public void setResultadosProyecto(String resultadosProyecto) {
        this.resultadosProyecto = resultadosProyecto;
    }

    public TipoProyecto getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(TipoProyecto idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public EstadoProyecto getIdEstadoProyecto() {
        return idEstadoProyecto;
    }

    public void setIdEstadoProyecto(EstadoProyecto idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
    }

    public LineaInvestigacion getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(LineaInvestigacion idLinea) {
        this.idLinea = idLinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}
