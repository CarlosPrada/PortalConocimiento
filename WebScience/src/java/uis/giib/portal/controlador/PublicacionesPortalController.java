package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.entidades.ProduccionIntelectual;
import uis.giib.entidades.TipoProduccion;

/**
 *
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Named(value = "publicacionesPC")
@SessionScoped
public class PublicacionesPortalController implements Serializable {

    //Atributos
    private List<ProduccionIntelectual> listadoProduccionIntelectual;
    private DataModel listaTipoProduccion;
    @EJB
    private uis.giib.administrador.dao.ProduccionIntelectualFacade ejbProduccionIntelectual;
    @EJB
    private uis.giib.administrador.dao.TipoProduccionFacade ejbTipoProduccion;

    //Constructor
    public PublicacionesPortalController() {
    }

    /**
     * Redirecciona al usuario a la página publicaciones.xhtml Almacena en una
     * lista los distintos Tipos de Produccion Intelectual de la BD, Así como
     * una lista de la Produccion Intelectual activa en la BD. Asigna a cada
     * Tipo de Produccion Intelectual su respectiva lista de Produccion
     * Intelectual
     *
     * @return Retorna el enlace a publicaciones.xhtml
     */
    public String goPublicaciones() {

        try {
            listaTipoProduccion = new ListDataModel(ejbTipoProduccion.findAll());
            listadoProduccionIntelectual = ejbProduccionIntelectual.listarProduccionIntelectual();
            Iterator<TipoProduccion> tipoProdIterator = listaTipoProduccion.iterator();

            while (tipoProdIterator.hasNext()) {
                TipoProduccion tipoProd = tipoProdIterator.next();
                tipoProd.getProduccionIntelectualList().retainAll(listadoProduccionIntelectual);
            }

        } catch (Exception e) {
            System.out.println("Error listando la producción intelectual!" + e.getMessage());
        }
        return "/portal/publicaciones.xhtml?faces-redirect=true";
    }
    
    //Getters - Setters
    public List<ProduccionIntelectual> getListadoProduccionIntelectual() {
        return listadoProduccionIntelectual;
    }

    public void setListadoProduccionIntelectual(List<ProduccionIntelectual> listadoProduccionIntelectual) {
        this.listadoProduccionIntelectual = listadoProduccionIntelectual;
    }

    public DataModel getListaTipoProduccion() {
        return listaTipoProduccion;
    }

    public void setListaTipoProduccion(DataModel listaTipoProduccion) {
        this.listaTipoProduccion = listaTipoProduccion;
    }

    public uis.giib.administrador.dao.ProduccionIntelectualFacade getEjbProduccionIntelectual() {
        return ejbProduccionIntelectual;
    }

    public void setEjbProduccionIntelectual(uis.giib.administrador.dao.ProduccionIntelectualFacade ejbProduccionIntelectual) {
        this.ejbProduccionIntelectual = ejbProduccionIntelectual;
    }

    public uis.giib.administrador.dao.TipoProduccionFacade getEjbTipoProduccion() {
        return ejbTipoProduccion;
    }

    public void setEjbTipoProduccion(uis.giib.administrador.dao.TipoProduccionFacade ejbTipoProduccion) {
        this.ejbTipoProduccion = ejbTipoProduccion;
    }
}
