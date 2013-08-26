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
import uis.giib.administrador.dao.ProyectoFacade;
import uis.giib.administrador.dao.TipoProyectoFacade;
import uis.giib.entidades.LineaInvestigacion;
import uis.giib.entidades.Proyecto;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "proyectoPC")
@SessionScoped
public class ProyectoPortalController implements Serializable {

    //Atributos
    private DataModel listadoProyectos;
    private DataModel listaTiposProyecto;
    private DataModel estadoProyectoList;
    private Proyecto proyectoActual;
    private LineaInvestigacion lineaInvestigacion;
    //private Integer idTipo = new Integer(1);
    // LLama objeto encargado de hacer las consultas a la DB
    @EJB
    private uis.giib.administrador.dao.ProyectoFacade ejbProyectoFacade;
    @EJB
    private uis.giib.administrador.dao.TipoProyectoFacade ejbTipoProyectoFacade;
    @EJB
    private uis.giib.administrador.dao.EstadoProyectoFacade ejbEstadoProyectoFacade;

    // Contructor
    public ProyectoPortalController() {

        try {
            listadoProyectos = new ListDataModel(ejbProyectoFacade.findAll());
            //listadoProyectos = new ListDataModel((List) ejbProyectoFacade.buscarProyectosPorEstado(idTipo));
            listaTiposProyecto = new ListDataModel(ejbTipoProyectoFacade.findAll());
            estadoProyectoList = new ListDataModel(ejbEstadoProyectoFacade.findAll());
        } catch (Exception e) {
            System.out.println("Error listando Proyectos!");
        }
    }

    //Métodos de navegación
    public String goProyectos() {

        try {
            //listadoProyectos = new ListDataModel((List) ejbProyectoFacade.buscarProyectosPorEstado(idTipo));
            listaTiposProyecto = new ListDataModel(ejbTipoProyectoFacade.findAll());
            estadoProyectoList = new ListDataModel(ejbEstadoProyectoFacade.findAll());
        } catch (Exception e) {
            System.out.println("Error listando proyectos!");
        }
        return "/portal/proyecto.xhtml?faces-redirect=true";
    }

    public String goDetallesProyecto(Proyecto proyecto) {

        try {
            proyectoActual = (Proyecto) proyecto;
        } catch (Exception e) {
            System.out.println("Error listando proyectos!");
        }
        return "/portal/proyectoDetalle.xhtml?faces-redirect=true";
    }

    //Getters - Setters     
    public DataModel getListadoProyectos() {
        return listadoProyectos;
    }

    public void setListadoProyectos(DataModel listadoProyectos) {
        this.listadoProyectos = listadoProyectos;
    }

    public DataModel getListaTiposProyecto() {
        return listaTiposProyecto;
    }

    public void setListaTiposProyecto(DataModel listaTiposProyecto) {
        this.listaTiposProyecto = listaTiposProyecto;
    }

    public Proyecto getProyectoActual() {
        return proyectoActual;
    }

    public void setProyectoActual(Proyecto proyectoActual) {
        this.proyectoActual = proyectoActual;
    }

    public ProyectoFacade getEjbFacade() {
        return ejbProyectoFacade;
    }

    public void setEjbFacade(ProyectoFacade ejbFacade) {
        this.ejbProyectoFacade = ejbFacade;
    }

    public TipoProyectoFacade getEjbTipoProyectoFacade() {
        return ejbTipoProyectoFacade;
    }

    public void setEjbTipoProyectoFacade(TipoProyectoFacade ejbTipoProyectoFacade) {
        this.ejbTipoProyectoFacade = ejbTipoProyectoFacade;
    }

    public DataModel getEstadoProyectoList() {
        return estadoProyectoList;
    }

    public void setEstadoProyectoList(DataModel estadoProyectoList) {
        this.estadoProyectoList = estadoProyectoList;
    }

    public uis.giib.administrador.dao.ProyectoFacade getEjbProyectoFacade() {
        return ejbProyectoFacade;
    }

    public void setEjbProyectoFacade(uis.giib.administrador.dao.ProyectoFacade ejbProyectoFacade) {
        this.ejbProyectoFacade = ejbProyectoFacade;
    }

    public uis.giib.administrador.dao.EstadoProyectoFacade getEjbEstadoProyectoFacade() {
        return ejbEstadoProyectoFacade;
    }

    public void setEjbEstadoProyectoFacade(uis.giib.administrador.dao.EstadoProyectoFacade ejbEstadoProyectoFacade) {
        this.ejbEstadoProyectoFacade = ejbEstadoProyectoFacade;
    }

    public LineaInvestigacion getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }
}
