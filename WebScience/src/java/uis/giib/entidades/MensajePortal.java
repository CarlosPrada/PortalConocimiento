package uis.giib.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "mensaje_portal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MensajePortal.findAll", query = "SELECT m FROM MensajePortal m"),
    @NamedQuery(name = "MensajePortal.findByIdMensaje", query = "SELECT m FROM MensajePortal m WHERE m.idMensaje = :idMensaje"),
    @NamedQuery(name = "MensajePortal.findByEstado", query = "SELECT m FROM MensajePortal m JOIN m.idEstado mest WHERE mest.idEstado = 1"),
    @NamedQuery(name = "MensajePortal.findByFechaMensaje", query = "SELECT m FROM MensajePortal m WHERE m.fechaMensaje = :fechaMensaje")})
public class MensajePortal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mensaje")
    private Integer idMensaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(max = 65535)
    @Column(name = "contenido_mensaje")
    private String contenidoMensaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_mensaje")
    @Temporal(TemporalType.DATE)
    private Date fechaMensaje;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoGeneral idEstado;

    public MensajePortal() {
    }

    public MensajePortal(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public MensajePortal(Integer idMensaje, String contenidoMensaje, Date fechaMensaje) {
        this.idMensaje = idMensaje;
        this.contenidoMensaje = contenidoMensaje;
        this.fechaMensaje = fechaMensaje;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenidoMensaje) {
        this.contenidoMensaje = contenidoMensaje;
    }

    public Date getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(Date fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
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
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MensajePortal)) {
            return false;
        }
        MensajePortal other = (MensajePortal) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uis.giib.entidades.MensajePortal[ idMensaje=" + idMensaje + " ]";
    }
}
