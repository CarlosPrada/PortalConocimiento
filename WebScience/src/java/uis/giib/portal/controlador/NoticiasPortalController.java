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
import uis.giib.administrador.dao.TipoPublicacionFacade;
import uis.giib.entidades.Publicacion;
import uis.giib.entidades.TipoPublicacion;

/**
 *
 * @author Cristhian Ruiz
 */
@Named(value = "noticiasPC")
@SessionScoped
public class NoticiasPortalController implements Serializable {

    private DataModel<Publicacion> listadoNoticias;
    private TipoPublicacion tipoPublicacion;
    private Publicacion publicacionActual;
        private Integer idTipo = new Integer(6);

    
    // LLama objeto encargado de hacer las consultas a la DB
    @EJB
    private uis.giib.administrador.dao.TipoPublicacionFacade ejbFacade;

    /**
     * Creates a new instance of ProyectoPortalController
     */
    // en un ListDataModel colocamos todos los proyectos en la DB
    public NoticiasPortalController() {

        try {
       
            tipoPublicacion = ejbFacade.buscarPublicacionesPorTipo(idTipo);
            listadoNoticias = new ListDataModel(tipoPublicacion.getPublicacionList());
        } catch (Exception e) {
            System.out.println("Error listando Noticias!");
        }
    }

    public String goNoticiasPortalController() {
        try {
             tipoPublicacion = ejbFacade.buscarPublicacionesPorTipo(idTipo);
            listadoNoticias = new ListDataModel(tipoPublicacion.getPublicacionList());
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

    public TipoPublicacion getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public TipoPublicacionFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(TipoPublicacionFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

   

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
}
