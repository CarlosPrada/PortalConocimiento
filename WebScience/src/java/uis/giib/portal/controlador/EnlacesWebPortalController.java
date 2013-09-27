package uis.giib.portal.controlador;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import uis.giib.entidades.EnlacesWeb;

/**
 *
 * @author Carlos Prada - crisyhian ruiz
 */
@Named(value = "enlacesWebPC")
@SessionScoped
public class EnlacesWebPortalController implements Serializable {

    // Atributos
    private EnlacesWeb enlacesWeb;
    //private Integer idTipo = new Integer(4);
    @EJB
    private uis.giib.administrador.dao.EnlacesWebFacade ejbEnlacesWeb;

    //Constructor
    public EnlacesWebPortalController() {
        enlacesWeb = ejbEnlacesWeb.buscarEnlaceWebPorID(1);
    }

    // Métodos de navegación
    @PostConstruct
    public void enlaceWebPageUIS() {

        enlacesWeb = ejbEnlacesWeb.buscarEnlaceWebPorID(1);
    }

    //Getters - Setters
    public EnlacesWeb getEnlacesWeb() {
        return enlacesWeb;
    }

    public void setEnlacesWeb(EnlacesWeb enlacesWeb) {
        this.enlacesWeb = enlacesWeb;
    }

    public uis.giib.administrador.dao.EnlacesWebFacade getEjbEnlacesWeb() {
        return ejbEnlacesWeb;
    }

    public void setEjbEnlacesWeb(uis.giib.administrador.dao.EnlacesWebFacade ejbEnlacesWeb) {
        this.ejbEnlacesWeb = ejbEnlacesWeb;
    }
}
