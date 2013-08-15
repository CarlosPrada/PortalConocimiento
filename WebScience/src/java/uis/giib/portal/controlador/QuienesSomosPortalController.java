package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.TipoPublicacionFacade;
import uis.giib.entidades.Publicacion;
import uis.giib.entidades.TipoPublicacion;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "quienesSomosPC")
@SessionScoped
public class QuienesSomosPortalController implements Serializable {

    private DataModel<Publicacion> quinesSomos;
    private TipoPublicacion tipoPublicacion;
    private Integer idTipo = new Integer(2);
    @EJB
    private uis.giib.administrador.dao.TipoPublicacionFacade ejbTipoPublicacion;

    // en un ListDataModel colocamos todos los proyectos en la DB
    public void QuienesSomosPortalController() {
        try {
            tipoPublicacion = ejbTipoPublicacion.buscarPublicacionesPorTipo(idTipo);
            quinesSomos = new ListDataModel(tipoPublicacion.getPublicacionList());
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!" + e.getCause());
        }
    }

    //Métodos de navegación
    // usado cuando hacemos click en el menú 
    public String goQuienesSomos() {
        try {
            tipoPublicacion = ejbTipoPublicacion.buscarPublicacionesPorTipo(idTipo);
            quinesSomos = new ListDataModel(tipoPublicacion.getPublicacionList());
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!" + e.getCause());
        }
        return "/portal/quienesSomos.xhtml?faces-redirect=true";
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoPublicacion getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public TipoPublicacionFacade getEjbTipoPublicacion() {
        return ejbTipoPublicacion;
    }

    public void setEjbTipoPublicacion(TipoPublicacionFacade ejbTipoPublicacion) {
        this.ejbTipoPublicacion = ejbTipoPublicacion;
    }

    public DataModel<Publicacion> getQuinesSomos() {
        return quinesSomos;
    }

    public void setQuinesSomos(DataModel<Publicacion> quinesSomos) {
        this.quinesSomos = quinesSomos;
    }    
}
