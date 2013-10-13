package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import uis.giib.entidades.HerramientaSoftware;

/**
 *
 * @author Carlos David Prada Remolina
 * @author cristhian ruiz
 */
@Named(value = "herramientasSoftwarePC")
@SessionScoped
public class HerramientasSoftwarePortalController implements Serializable {

    // Atributos
    private List<HerramientaSoftware> listadoHerramientaSoftware;
    @EJB
    private uis.giib.administrador.dao.HerramientaSoftwareFacade ejbHerramientaSoftware;

    //Constructor
    public HerramientasSoftwarePortalController() {
    }

    //Métodos de navegación
    public String goHerramientasSoftware() {
        try {
            listadoHerramientaSoftware = ejbHerramientaSoftware.listarHerramientaSoftware();
        } catch (Exception e) {
            System.out.println("Error de HerramientasSoftware!" + e.getCause());
        }
        return "/portal/herramientasSoftware.xhtml?faces-redirect=true";
    }

    // Getters - Setters
    public List<HerramientaSoftware> getListadoHerramientaSoftware() {
        return listadoHerramientaSoftware;
    }

    public void setListadoHerramientaSoftware(List<HerramientaSoftware> listadoHerramientaSoftware) {
        this.listadoHerramientaSoftware = listadoHerramientaSoftware;
    }

    public uis.giib.administrador.dao.HerramientaSoftwareFacade getEjbHerramientaSoftware() {
        return ejbHerramientaSoftware;
    }

    public void setEjbHerramientaSoftware(uis.giib.administrador.dao.HerramientaSoftwareFacade ejbHerramientaSoftware) {
        this.ejbHerramientaSoftware = ejbHerramientaSoftware;
    }
}
