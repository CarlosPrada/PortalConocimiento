package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "contactoPC")
@SessionScoped
public class contactoPortalController implements Serializable {

    // Atributos

    //Constructor
    public contactoPortalController() {
    }

    //Métodos de navegación
    public String goContacto() {

        return "/portal/contacto.xhtml?faces-redirect=true";
    }

}
