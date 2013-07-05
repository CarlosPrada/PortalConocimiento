/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "proyecto_investigadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoInvestigadores.findAll", query = "SELECT p FROM ProyectoInvestigadores p"),
    @NamedQuery(name = "ProyectoInvestigadores.findByIdProyecto", query = "SELECT p FROM ProyectoInvestigadores p WHERE p.proyectoInvestigadoresPK.idProyecto = :idProyecto"),
    @NamedQuery(name = "ProyectoInvestigadores.findByIdInvestigador", query = "SELECT p FROM ProyectoInvestigadores p WHERE p.proyectoInvestigadoresPK.idInvestigador = :idInvestigador")})
public class ProyectoInvestigadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoInvestigadoresPK proyectoInvestigadoresPK;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol idRol;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;
    @JoinColumn(name = "id_investigador", referencedColumnName = "usuario_investigador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Investigador investigador;

    public ProyectoInvestigadores() {
    }

    public ProyectoInvestigadores(ProyectoInvestigadoresPK proyectoInvestigadoresPK) {
        this.proyectoInvestigadoresPK = proyectoInvestigadoresPK;
    }

    public ProyectoInvestigadores(int idProyecto, String idInvestigador) {
        this.proyectoInvestigadoresPK = new ProyectoInvestigadoresPK(idProyecto, idInvestigador);
    }

    public ProyectoInvestigadoresPK getProyectoInvestigadoresPK() {
        return proyectoInvestigadoresPK;
    }

    public void setProyectoInvestigadoresPK(ProyectoInvestigadoresPK proyectoInvestigadoresPK) {
        this.proyectoInvestigadoresPK = proyectoInvestigadoresPK;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoInvestigadoresPK != null ? proyectoInvestigadoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoInvestigadores)) {
            return false;
        }
        ProyectoInvestigadores other = (ProyectoInvestigadores) object;
        if ((this.proyectoInvestigadoresPK == null && other.proyectoInvestigadoresPK != null) || (this.proyectoInvestigadoresPK != null && !this.proyectoInvestigadoresPK.equals(other.proyectoInvestigadoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProyectoInvestigadores[ proyectoInvestigadoresPK=" + proyectoInvestigadoresPK + " ]";
    }
    
}
