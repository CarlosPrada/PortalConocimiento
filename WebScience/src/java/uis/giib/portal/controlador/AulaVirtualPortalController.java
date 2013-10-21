package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;



/**
 * @author Carlos David Prada Remolina
 * @author cristhian ruiz
 */
@Named(value = "AulaVirtualesPortalController")
@SessionScoped
public class AulaVirtualPortalController implements Serializable {

    //Atributos

    // Constructor
    public AulaVirtualPortalController() {
    }
    //Métodos de navegación
    public String goAulaVirtual() {
        try {
        } catch (Exception e) {
            System.out.println("Error de AulaVirtual!" + e.getCause());
        }
        return "/portal/aulaVirtual.xhtml?faces-redirect=true";
    }   
}
