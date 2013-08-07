/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
            pubHistoria = new ListDataModel((List) ejbPublicacion.findByIdTipoPublicacion(idTipoPublicacion)) ; 
            
             
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!");
        }
    }

    //Métodos de navegación
    // usado cuando hacemos click en el menú 
    public String goQuienesSomos(Integer idTipoPublicacion) {
        try {
             pubHistoria = new ListDataModel((List) ejbPublicacion.findByIdTipoPublicacion(idTipoPublicacion)); 
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!");
        }
        return "/portal/quienesSomos.xhtml?faces-redirect=true";
    }
}
