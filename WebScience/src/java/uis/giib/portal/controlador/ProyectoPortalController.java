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
import uis.giib.entidades.Proyecto;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "proyectoPortalController")
@SessionScoped
public class ProyectoPortalController implements Serializable {

    private DataModel listadoProyectos;
    private DataModel listaTiposProyecto;
    private Proyecto proyectoActual;
    
    // LLama objeto encargado de hacer las consultas a la DB
    @EJB
    private uis.giib.administrador.dao.ProyectoFacade ejbFacade;
    
    @EJB
    private uis.giib.administrador.dao.TipoProyectoFacade ejbTipoProyectoFacade;
    
    // en un ListDataModel colocamos todos los proyectos en la DB
    public ProyectoPortalController() {
        
        try{
        listadoProyectos = new ListDataModel(ejbFacade.findAll());
        listaTiposProyecto = new ListDataModel(ejbTipoProyectoFacade.findAll());
        }catch(Exception e){
            System.out.println("Error listando Proyectos!");
        }        
    }
    
    //Métodos de navegación
    // usado cuando hacemos click en el menú 
    
    public String goProyectos(){

        try{
        listadoProyectos = new ListDataModel(ejbFacade.findAll());
        listaTiposProyecto = new ListDataModel(ejbTipoProyectoFacade.findAll());
        }catch(Exception e){
            System.out.println("Error listando proyectos!");
        }        
        return "/portal/proyectosInvestigacion.xhtml?faces-redirect=true";    
        // 
    }
    
    public String goDetallesProyecto(Proyecto proyecto){
        
        proyectoActual = (Proyecto) proyecto;
        return "/portal/proyectoDetalle.xhtml?faces-redirect=true";
     }

    public DataModel getListadoProyectos() {
        return listadoProyectos;
    }

    public void setListadoProyectos(DataModel listadoProyectos) {
        this.listadoProyectos = listadoProyectos;
    }

    public Proyecto getProyectoActual() {
        return proyectoActual;
    }

    public void setProyectoActual(Proyecto proyectoActual) {
        this.proyectoActual = proyectoActual;
    }

    public uis.giib.administrador.dao.ProyectoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(uis.giib.administrador.dao.ProyectoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public DataModel getListaTiposProyecto() {
        return listaTiposProyecto;
    }

    public void setListaTiposProyecto(DataModel listaTiposProyecto) {
        this.listaTiposProyecto = listaTiposProyecto;
    }
    
}
