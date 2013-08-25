/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.entidades.Publicacion;

/**
 *
 * @author Carlos
 */
@Named(value = "publicacionesPC")
@SessionScoped
public class PublicacionesPortalController implements Serializable {

    private DataModel listadoPublicaciones;
    private Publicacion publicacionActual;
    
    // LLama objeto encargado de hacer las consultas a la DB
    @EJB
    private uis.giib.administrador.dao.PublicacionFacade ejbFacade;
    /**
     * Creates a new instance of ProyectoPortalController
     */
    
    // en un ListDataModel colocamos todos los proyectos en la DB
    public PublicacionesPortalController() {
        
        try{
        listadoPublicaciones = new ListDataModel(ejbFacade.findAll());
        }catch(Exception e){
            System.out.println("Error listando Publicaciones!");
        }        
    }
    
    //Métodos de navegación
    // usado cuando hacemos click en el menú 
    
    public String goPublicaciones(){

        try{
        listadoPublicaciones = new ListDataModel(ejbFacade.findAll());
        }catch(Exception e){
            System.out.println("Error listando Publicaciones!");
        }        
        return "/portal/publicaciones.xhtml?faces-redirect=true";        
    }
    
    public String goDetallesPublicacion(){
        
        publicacionActual = (Publicacion) getListadoPublicaciones().getRowData();
        return "/portal/publicacionesDetalle.xhtml?faces-redirect=true";
     }

    public DataModel getListadoPublicaciones() {
        return listadoPublicaciones;
    }

    public void setListadoPublicaciones(DataModel listadoPublicaciones) {
        this.listadoPublicaciones = listadoPublicaciones;
    }

    public Publicacion getPublicacionActual() {
        return publicacionActual;
    }

    public void setPublicacionActual(Publicacion publicacionActual) {
        this.publicacionActual = publicacionActual;
    }

    public uis.giib.administrador.dao.PublicacionFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(uis.giib.administrador.dao.PublicacionFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
    
    
}
