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
import uis.giib.administrador.dao.LineaInvestigacionFacade;
import uis.giib.entidades.Investigador;

/**
 *
 * @author Carlos
 */
@Named(value = "lineasInvestigacionPortalController")
@SessionScoped
public class LineasInvestigacionPortalController implements Serializable {

    private DataModel listadoLineasInvestigacion;
    
    @EJB
    private uis.giib.administrador.dao.LineaInvestigacionFacade ejbFacade;
   
    public LineasInvestigacionPortalController() {        
        try{
        listadoLineasInvestigacion = new ListDataModel(ejbFacade.findAll());
        }catch(Exception e){
            System.out.println("Error listando las Líneas de Investigaión!");
        }       
    }
    
    //Métodos de navegación
    public String goLineasInvestigacion(){

        try{
        listadoLineasInvestigacion = new ListDataModel(ejbFacade.findAll());        
        }catch(Exception e){
            System.out.println("Error listando las Líneas de Investigaión!");
        }        
        return "/portal/lineasInvestigacion.xhtml?faces-redirect=true";        
    }    

    public DataModel getListadoLineasInvestigacion() {
        return listadoLineasInvestigacion;
    }

    public void setListadoLineasInvestigacion(DataModel listadoLineasInvestigacion) {
        this.listadoLineasInvestigacion = listadoLineasInvestigacion;
    }

    public LineaInvestigacionFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(LineaInvestigacionFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }    
    
}
