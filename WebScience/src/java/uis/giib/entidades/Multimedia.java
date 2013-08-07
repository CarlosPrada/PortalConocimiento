/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "multimedia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multimedia.findAll", query = "SELECT m FROM Multimedia m"),
    @NamedQuery(name = "Multimedia.findByIdMultimedia", query = "SELECT m FROM Multimedia m WHERE m.idMultimedia = :idMultimedia"),
    @NamedQuery(name = "Multimedia.findByNombreMultimedia", query = "SELECT m FROM Multimedia m WHERE m.nombreMultimedia = :nombreMultimedia"),
    @NamedQuery(name = "Multimedia.findByUrlTipoMultimedia", query = "SELECT m FROM Multimedia m WHERE m.urlTipoMultimedia = :urlTipoMultimedia"),
    @NamedQuery(name = "Multimedia.findByEstadoMultimedia", query = "SELECT m FROM Multimedia m WHERE m.estadoMultimedia = :estadoMultimedia"),
    @NamedQuery(name = "Multimedia.findByEliminadoMultimedia", query = "SELECT m FROM Multimedia m WHERE m.eliminadoMultimedia = :eliminadoMultimedia")})
public class Multimedia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_multimedia")
    private Integer idMultimedia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_multimedia")
    private String nombreMultimedia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "url_tipo_multimedia")
    private String urlTipoMultimedia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_multimedia")
    private char estadoMultimedia;
    @Column(name = "eliminado_multimedia")
    private Character eliminadoMultimedia;
    @OneToMany(mappedBy = "idMultimedia")
    private Collection<Recursos> recursosCollection;
    @JoinColumn(name = "id_tipo_multimedia", referencedColumnName = "id_tipo_multimedia")
    @ManyToOne(optional = false)
    private TipoMultimedia idTipoMultimedia;

    public Multimedia() {
    }

    public Multimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public Multimedia(Integer idMultimedia, String nombreMultimedia, String urlTipoMultimedia, char estadoMultimedia) {
        this.idMultimedia = idMultimedia;
        this.nombreMultimedia = nombreMultimedia;
        this.urlTipoMultimedia = urlTipoMultimedia;
        this.estadoMultimedia = estadoMultimedia;
    }

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public String getNombreMultimedia() {
        return nombreMultimedia;
    }

    public void setNombreMultimedia(String nombreMultimedia) {
        this.nombreMultimedia = nombreMultimedia;
    }

    public String getUrlTipoMultimedia() {
        return urlTipoMultimedia;
    }

    public void setUrlTipoMultimedia(String urlTipoMultimedia) {
        this.urlTipoMultimedia = urlTipoMultimedia;
    }

    public char getEstadoMultimedia() {
        return estadoMultimedia;
    }

    public void setEstadoMultimedia(char estadoMultimedia) {
        this.estadoMultimedia = estadoMultimedia;
    }

    public Character getEliminadoMultimedia() {
        return eliminadoMultimedia;
    }

    public void setEliminadoMultimedia(Character eliminadoMultimedia) {
        this.eliminadoMultimedia = eliminadoMultimedia;
    }

    @XmlTransient
    public Collection<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(Collection<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
    }

    public TipoMultimedia getIdTipoMultimedia() {
        return idTipoMultimedia;
    }

    public void setIdTipoMultimedia(TipoMultimedia idTipoMultimedia) {
        this.idTipoMultimedia = idTipoMultimedia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMultimedia != null ? idMultimedia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multimedia)) {
            return false;
        }
        Multimedia other = (Multimedia) object;
        if ((this.idMultimedia == null && other.idMultimedia != null) || (this.idMultimedia != null && !this.idMultimedia.equals(other.idMultimedia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.Multimedia[ idMultimedia=" + idMultimedia + " ]";
    }
    
}
