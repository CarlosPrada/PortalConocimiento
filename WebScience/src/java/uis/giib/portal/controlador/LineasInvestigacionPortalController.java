/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.LineaInvestigacionFacade;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.LineaInvestigacion;
import uis.giib.entidades.LineasInvestigador;

/**
 *
 * @author Carlos
 */
@Named(value = "lineasInvestigacionPortalController")
@SessionScoped
public class LineasInvestigacionPortalController implements Serializable {

    private DataModel listadoLineasInvestigacion;
    private LineaInvestigacion   lineasInvestigacionActual;
    @EJB
    private uis.giib.administrador.dao.LineaInvestigacionFacade ejbFacade;
//consyructor

    public LineasInvestigacionPortalController() {
        try {
            listadoLineasInvestigacion = new ListDataModel(ejbFacade.findAll());
        } catch (Exception e) {
            System.out.println("Error listando las Líneas de Investigaión!");
        }
    }

    public LineaInvestigacion getLineasInvestigacionActual() {
        return lineasInvestigacionActual;
    }

    public void setLineasInvestigacionActual(LineaInvestigacion lineasInvestigacionActual) {
        this.lineasInvestigacionActual = lineasInvestigacionActual;
    }

    //Métodos de navegación
    public String goLineasInvestigacion() {

        try {
            listadoLineasInvestigacion = new ListDataModel(ejbFacade.findAll());
        } catch (Exception e) {
            System.out.println("Error listando las Líneas de Investigaión!");
        }
        return "/portal/lineasInvestigacion.xhtml?faces-redirect=true";
    }

    public String goDetallesLineasInvestigacion(LineaInvestigacion linInvestiga) {

        try {
            lineasInvestigacionActual = (LineaInvestigacion) linInvestiga;
        } catch (Exception e) {
            System.out.println("Error Mostrando detalles Lineas Investigacion!");
        }
        return "/portal/lineasInvestigacionDetalle.xhtml?faces-redirect=true";
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
