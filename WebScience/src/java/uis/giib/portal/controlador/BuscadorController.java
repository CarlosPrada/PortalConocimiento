package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ToggleEvent;
import uis.giib.entidades.Bibliografia;
import uis.giib.entidades.Evento;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "buscadorPC")
@SessionScoped
public class BuscadorController implements Serializable {

    //ATRIBUTOS
    private String buscar;
    private List<Bibliografia> listaBibliografia;
    private List<Evento> listaEvento;
    @EJB
    private uis.giib.administrador.dao.BibliografiaFacade ejbBibliografia;
    @EJB
    private uis.giib.administrador.dao.EventoFacade ejbEvento;

    //CONSTRURCTOR
    public BuscadorController() {
    }

    //MÉTODOS DE NAVEGACIÓN
    public String goResultadoBusqueda() {

        try {
            listaBibliografia = ejbBibliografia.listarBuscador(buscar);
            listaEvento = ejbEvento.listarBuscador(buscar);

        } catch (Exception e) {
            System.out.println("Error listando resultados de la busqueda!" + e.getMessage());
        }
        return "/portal/resultadoBusqueda.xhtml?faces-redirect=true";
    }

    //PANEL ACTIONS
    public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fieldset Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //GETTERS - SETTERS

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public List<Bibliografia> getListaBibliografia() {
        return listaBibliografia;
    }

    public void setListaBibliografia(List<Bibliografia> listaBibliografia) {
        this.listaBibliografia = listaBibliografia;
    }

    public List<Evento> getListaEvento() {
        return listaEvento;
    }

    public void setListaEvento(List<Evento> listaEvento) {
        this.listaEvento = listaEvento;
    }

    public uis.giib.administrador.dao.BibliografiaFacade getEjbBibliografia() {
        return ejbBibliografia;
    }

    public void setEjbBibliografia(uis.giib.administrador.dao.BibliografiaFacade ejbBibliografia) {
        this.ejbBibliografia = ejbBibliografia;
    }

    public uis.giib.administrador.dao.EventoFacade getEjbEvento() {
        return ejbEvento;
    }

    public void setEjbEvento(uis.giib.administrador.dao.EventoFacade ejbEvento) {
        this.ejbEvento = ejbEvento;
    }

    
}
