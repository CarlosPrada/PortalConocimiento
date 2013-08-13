package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.TipoPublicacionFacade;
import uis.giib.entidades.Publicacion;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "quienesSomosPC")
@SessionScoped
public class QuienesSomosPortalController implements Serializable {
    
    @ManagedProperty("#{param.param}")
    private Integer idTipoPublicacion;
    
    private DataModel pubHistoria;
    @EJB
    private uis.giib.administrador.dao.TipoPublicacionFacade ejbPublicacion;

    // en un ListDataModel colocamos todos los proyectos en la DB
    @PostConstruct
    public void QuienesSomosPortalController(Integer idTipoPublicacion) {
        try {
       //     pubHistoria = new ListDataModel((List) ejbPublicacion.findByIdTipoPublicacion(idTipoPublicacion)) ; 
    
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!");
        }
    }

    //Métodos de navegación
    // usado cuando hacemos click en el menú 
    public String goQuienesSomos(Integer idTipoPublicacion) {
        try {            
         //    pubHistoria = new ListDataModel((List) ejbPublicacion.findByIdTipoPublicacion(idTipoPublicacion)); 
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!");
        }
        return "/portal/quienesSomos.xhtml?faces-redirect=true";
    }
    
    public Integer getIdTipoPublicacion() {
        return idTipoPublicacion;
    }

    public void setIdTipoPublicacion(Integer idTipoPublicacion) {
        this.idTipoPublicacion = idTipoPublicacion;
    }

    public DataModel getPubHistoria() {
        return pubHistoria;
    }

    public void setPubHistoria(DataModel pubHistoria) {
        this.pubHistoria = pubHistoria;
    }

    public TipoPublicacionFacade getEjbPublicacion() {
        return ejbPublicacion;
    }

    public void setEjbPublicacion(TipoPublicacionFacade ejbPublicacion) {
        this.ejbPublicacion = ejbPublicacion;
    }
}
