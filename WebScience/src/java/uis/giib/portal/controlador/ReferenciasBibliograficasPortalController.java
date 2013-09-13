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
import uis.giib.administrador.dao.TipoContenidoFacade;
import uis.giib.entidades.Contenido;
import uis.giib.entidades.TipoContenido;

/**
 *
 * @author cristhian
 */
@Named(value = "ReferenciasBibliograficasPortalController")
@SessionScoped
public class ReferenciasBibliograficasPortalController implements Serializable {

    private DataModel<Contenido> ReferenciasBibliograficas;
    private TipoContenido tipoContenido;
    private Integer idTipo = new Integer(7);
    @EJB
    private uis.giib.administrador.dao.TipoContenidoFacade ejbTipoContenido;

    //Constructor
    public void ReferenciasBibliograficasPortalController() {
        
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            ReferenciasBibliograficas = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error de ReferenciasBibliograficas!" + e.getCause());
        }
    //Métodos de navegación
    // usado cuando hacemos click en el menú 
   
    }
    public String goReferenciasBibliograficas (){
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
           ReferenciasBibliograficas = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error de Referencias Bibliograficas!" + e.getCause());
        }
        return "/portal/referenciasBibliograficas.xhtml?faces-redirect=true";
    }

    public DataModel<Contenido> getReferenciasBibliograficas() {
        return ReferenciasBibliograficas;
    }

    public void setReferenciasBibliograficas(DataModel<Contenido> ReferenciasBibliograficas) {
        this.ReferenciasBibliograficas = ReferenciasBibliograficas;
    }

    public TipoContenido getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(TipoContenido tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoContenidoFacade getEjbTipoContenido() {
        return ejbTipoContenido;
    }

    public void setEjbTipoContenido(TipoContenidoFacade ejbTipoContenido) {
        this.ejbTipoContenido = ejbTipoContenido;
    }

}
