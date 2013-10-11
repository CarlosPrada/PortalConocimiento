package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import uis.giib.entidades.Contenido;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "quienesSomosPC")
@SessionScoped
public class QuienesSomosPortalController implements Serializable {

    //Atributos
    private List<Contenido> quinesSomos;
    @EJB
    private uis.giib.administrador.dao.ContenidoFacade ejbContenido;

    // Constructor
    public void QuienesSomosPortalController() {
    }

    //Métodos de navegación
    public String goQuienesSomos() {
        try {
            quinesSomos = ejbContenido.findAll();
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!" + e.getCause());
        }
        return "/portal/quienesSomos.xhtml?faces-redirect=true";
    }

    //Getters - Setters 
    public List<Contenido> getQuinesSomos() {
        return quinesSomos;
    }

    public void setQuinesSomos(List<Contenido> quinesSomos) {
        this.quinesSomos = quinesSomos;
    }

    public uis.giib.administrador.dao.ContenidoFacade getEjbContenido() {
        return ejbContenido;
    }

    public void setEjbContenido(uis.giib.administrador.dao.ContenidoFacade ejbContenido) {
        this.ejbContenido = ejbContenido;
    }
}
