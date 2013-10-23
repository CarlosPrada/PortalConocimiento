package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.entidades.Bibliografia;
import uis.giib.entidades.TipoProduccion;

/**
 * @author Carlos David Prada Remolina
 * @author cristhian
 * @version 1.0
 * @since 10/08/2013
 *
 */
@Named(value = "bibliografiaPC")
@SessionScoped
public class BibliografiaPortalController implements Serializable {

    //Atributos     
    private List<Bibliografia> listadoBibliografia;
    private DataModel listaTipoBibliografia;
    @EJB
    private uis.giib.administrador.dao.BibliografiaFacade ejbBibliografia;
    @EJB
    private uis.giib.administrador.dao.TipoProduccionFacade ejbTipoProduccion;

    //Constructor
    public BibliografiaPortalController() {
    }

    /**
     * Redirecciona al usuario a la página de referenciasBibliograficas.xhtml
     * Almacena en una lista los distintos tipos de referencias bibliográficas,
     * así como una lista de las referencias bibliográficas almacenadas y
     * activas en la base de datos. Asigna a cada tipo de referencia
     * bibliográfica su respectiva lista de referencias activas.
     *
     * @return path relativo a la dirección de la página de referenciasBibliograficas.xhtml
     */
    public String goBibliografia() {

        try {
            listaTipoBibliografia = new ListDataModel(ejbTipoProduccion.findAll());
            listadoBibliografia = ejbBibliografia.listarBibliografia();
            Iterator<TipoProduccion> tipoProdIterator = listaTipoBibliografia.iterator();

            while (tipoProdIterator.hasNext()) {
                TipoProduccion tipoProd = tipoProdIterator.next();
                tipoProd.getBibliografiaList().retainAll(listadoBibliografia);
            }

        } catch (Exception e) {
            System.out.println("Error listando la Bibliografóa!" + e.getMessage());
        }

        return "/portal/referenciasBibliograficas.xhtml?faces-redirect=true";
    }

    //Getters - Setters
    public List<Bibliografia> getListadoBibliografia() {
        return listadoBibliografia;
    }

    public void setListadoBibliografia(List<Bibliografia> listadoBibliografia) {
        this.listadoBibliografia = listadoBibliografia;
    }

    public DataModel getListaTipoBibliografia() {
        return listaTipoBibliografia;
    }

    public void setListaTipoBibliografia(DataModel listaTipoBibliografia) {
        this.listaTipoBibliografia = listaTipoBibliografia;
    }

    public uis.giib.administrador.dao.BibliografiaFacade getEjbBibliografia() {
        return ejbBibliografia;
    }

    public void setEjbBibliografia(uis.giib.administrador.dao.BibliografiaFacade ejbBibliografia) {
        this.ejbBibliografia = ejbBibliografia;
    }

    public uis.giib.administrador.dao.TipoProduccionFacade getEjbTipoProduccion() {
        return ejbTipoProduccion;
    }

    public void setEjbTipoProduccion(uis.giib.administrador.dao.TipoProduccionFacade ejbTipoProduccion) {
        this.ejbTipoProduccion = ejbTipoProduccion;
    }
}
