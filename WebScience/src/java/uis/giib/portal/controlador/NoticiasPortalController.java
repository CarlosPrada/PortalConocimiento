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
import uis.giib.administrador.dao.PublicacionFacade;
import uis.giib.entidades.Publicacion;

/**
 *
 * @author Cristhian Ruiz
 */
@Named(value = "noticiasPortalController")
@SessionScoped
public class NoticiasPortalController implements Serializable {

    private DataModel listadoNoticias;
    private Publicacion publicacionActual;
    // LLama objeto encargado de hacer las consultas a la DB
    @EJB
    private uis.giib.administrador.dao.PublicacionFacade ejbFacade;

    /**
     * Creates a new instance of ProyectoPortalController
     */
    // en un ListDataModel colocamos todos los proyectos en la DB
    public NoticiasPortalController() {

        try {
            listadoNoticias = new ListDataModel(ejbFacade.findAll());
        } catch (Exception e) {
            System.out.println("Error listando Noticias!");
        }
    }

    public String goNoticiasPortalController() {

        try {
            listadoNoticias = new ListDataModel(ejbFacade.findAll());
        } catch (Exception e) {
            System.out.println("Error listando Noticias!");
        }
        return "/portal/noticias.xhtml?faces-redirect=true";
    }

    public DataModel getListadoNoticias() {
        return listadoNoticias;
    }

    public void setListadoNoticias(DataModel listadoNoticias) {
        this.listadoNoticias = listadoNoticias;
    }

    public Publicacion getPublicacionActual() {
        return publicacionActual;
    }

    public void setPublicacionActual(Publicacion publicacionActual) {
        this.publicacionActual = publicacionActual;
    }

    public PublicacionFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(PublicacionFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
}
