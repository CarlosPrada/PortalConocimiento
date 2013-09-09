
package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "herramientasSoftwarePC")
@SessionScoped
public class HerramientasSoftwarePortalController implements Serializable {

    public HerramientasSoftwarePortalController() {
    }
    
    //Métodos de navegación
    public String goHerramientasSoftware(){       
        return "/portal/herramientasSoftware.xhtm?faces-redirect=truel";        
    }    
    
}
