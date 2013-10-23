package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 01/10/2013
 */
@Named(value = "indexPC")
@SessionScoped
public class IndexPortalController implements Serializable {

    // Constructor
    public IndexPortalController() {
    }

    /**
     * Redirecciona al usuario a la página de index.xhtml
     *
     * @return Retorna el enlace al index.xhtml
     */
    public String goIndex() {
        try {
        } catch (Exception e) {
            System.out.println("Error de Index!");
        }
        return "/portal/index.xhtml?faces-redirect=true";
    }
}
