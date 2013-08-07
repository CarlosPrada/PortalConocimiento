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
@Table(name = "produccion_intelectual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduccionIntelectual.findAll", query = "SELECT p FROM ProduccionIntelectual p"),
    @NamedQuery(name = "ProduccionIntelectual.findByIdProduccion", query = "SELECT p FROM ProduccionIntelectual p WHERE p.idProduccion = :idProduccion"),
    @NamedQuery(name = "ProduccionIntelectual.findByNombreProduccion", query = "SELECT p FROM ProduccionIntelectual p WHERE p.nombreProduccion = :nombreProduccion"),
    @NamedQuery(name = "ProduccionIntelectual.findByAgnoProduccion", query = "SELECT p FROM ProduccionIntelectual p WHERE p.agnoProduccion = :agnoProduccion"),
    @NamedQuery(name = "ProduccionIntelectual.findByEstadoProduccion", query = "SELECT p FROM ProduccionIntelectual p WHERE p.estadoProduccion = :estadoProduccion")})
public class ProduccionIntelectual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produccion")
    private Integer idProduccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre_produccion")
    private String nombreProduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agno_produccion")
    private int agnoProduccion;
    @Lob
    @Size(max = 65535)
    @Column(name = "referencia_produccion")
    private String referenciaProduccion;
    @Column(name = "estado_produccion")
    private Character estadoProduccion;
    @JoinColumn(name = "id_tipo_produccion", referencedColumnName = "id_tipo_produccion")
    @ManyToOne(optional = false)
    private TipoProduccion idTipoProduccion;
    @JoinColumn(name = "id_autor_produccion", referencedColumnName = "usuario_investigador")
    @ManyToOne(optional = false)
    private Investigador idAutorProduccion;

    public ProduccionIntelectual() {
    }

    public ProduccionIntelectual(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public ProduccionIntelectual(Integer idProduccion, String nombreProduccion, int agnoProduccion) {
        this.idProduccion = idProduccion;
        this.nombreProduccion = nombreProduccion;
        this.agnoProduccion = agnoProduccion;
    }

    public Integer getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public String getNombreProduccion() {
        return nombreProduccion;
    }

    public void setNombreProduccion(String nombreProduccion) {
        this.nombreProduccion = nombreProduccion;
    }

    public int getAgnoProduccion() {
        return agnoProduccion;
    }

    public void setAgnoProduccion(int agnoProduccion) {
        this.agnoProduccion = agnoProduccion;
    }

    public String getReferenciaProduccion() {
        return referenciaProduccion;
    }

    public void setReferenciaProduccion(String referenciaProduccion) {
        this.referenciaProduccion = referenciaProduccion;
    }

    public Character getEstadoProduccion() {
        return estadoProduccion;
    }

    public void setEstadoProduccion(Character estadoProduccion) {
        this.estadoProduccion = estadoProduccion;
    }

    public TipoProduccion getIdTipoProduccion() {
        return idTipoProduccion;
    }

    public void setIdTipoProduccion(TipoProduccion idTipoProduccion) {
        this.idTipoProduccion = idTipoProduccion;
    }

    public Investigador getIdAutorProduccion() {
        return idAutorProduccion;
    }

    public void setIdAutorProduccion(Investigador idAutorProduccion) {
        this.idAutorProduccion = idAutorProduccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduccion != null ? idProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduccionIntelectual)) {
            return false;
        }
        ProduccionIntelectual other = (ProduccionIntelectual) object;
        if ((this.idProduccion == null && other.idProduccion != null) || (this.idProduccion != null && !this.idProduccion.equals(other.idProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.ProduccionIntelectual[ idProduccion=" + idProduccion + " ]";
    }
    
}
