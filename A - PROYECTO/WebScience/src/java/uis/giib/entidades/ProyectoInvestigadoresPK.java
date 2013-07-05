/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Embeddable
public class ProyectoInvestigadoresPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proyecto")
    private int idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_investigador")
    private String idInvestigador;

    public ProyectoInvestigadoresPK() {
    }

    public ProyectoInvestigadoresPK(int idProyecto, String idInvestigador) {
        this.idProyecto = idProyecto;
        this.idInvestigador = idInvestigador;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getIdInvestigador() {
        return idInvestigador;
    }

    public void setIdInvestigador(String idInvestigador) {
        this.idInvestigador = idInvestigador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProyecto;
        hash += (idInvestigador != null ? idInvestigador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoInvestigadoresPK)) {
            return false;
        }
        ProyectoInvestigadoresPK other = (ProyectoInvestigadoresPK) object;
        if (this.idProyecto != other.idProyecto) {
            return false;
        }
        if ((this.idInvestigador == null && other.idInvestigador != null) || (this.idInvestigador != null && !this.idInvestigador.equals(other.idInvestigador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProyectoInvestigadoresPK[ idProyecto=" + idProyecto + ", idInvestigador=" + idInvestigador + " ]";
    }
    
}
