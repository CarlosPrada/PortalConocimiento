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
import uis.giib.entidades.HerramientaSoftware;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.LineaInvestigacion;
import uis.giib.entidades.Noticia;
import uis.giib.entidades.ProduccionIntelectual;
import uis.giib.entidades.Proyecto;

/**
 *
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Named(value = "buscadorPC")
@SessionScoped
public class BuscadorController implements Serializable {

    //ATRIBUTOS
    private String buscar;
    private List<Bibliografia> listaBibliografia;
    private List<HerramientaSoftware> listaHerramientaSoftware;
    private List<Investigador> listaInvestigador;
    private List<LineaInvestigacion> listaLineaInvestigacion;
    private List<Noticia> listaNoticia;
    private List<ProduccionIntelectual> listaProduccionIntelectual;
    private List<Proyecto> listaProyecto;
    private boolean renderBibliografia = true;
    private boolean renderHerramientaSoftware = true;
    private boolean renderInvestigador = true;
    private boolean renderLineaInvestigacion = true;
    private boolean renderNoticia = true;
    private boolean renderProduccionIntelectual = true;
    private boolean renderProyecto = true;
    @EJB
    private uis.giib.administrador.dao.BibliografiaFacade ejbBibliografia;
    @EJB
    private uis.giib.administrador.dao.HerramientaSoftwareFacade ejbHerramientaSoftware;
    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade ejbInvestigador;
    @EJB
    private uis.giib.administrador.dao.LineaInvestigacionFacade ejbLineaInvestigacion;
    @EJB
    private uis.giib.administrador.dao.NoticiaFacade ejbNoticia;
    @EJB
    private uis.giib.administrador.dao.ProduccionIntelectualFacade ejbProduccionIntelectual;
    @EJB
    private uis.giib.administrador.dao.ProyectoFacade ejbProyecto;

    //CONSTRURCTOR
    public BuscadorController() {
    }

    //MÉTODOS DE NAVEGACIÓN
    public String goResultadoBusqueda() {

        try {
            listaBibliografia = ejbBibliografia.listarBuscador(buscar);
            listaHerramientaSoftware = ejbHerramientaSoftware.listarBuscador(buscar);
            listaInvestigador = ejbInvestigador.listarBuscador(buscar);
            listaLineaInvestigacion = ejbLineaInvestigacion.listarBuscador(buscar);
            listaNoticia = ejbNoticia.listarBuscador(buscar);
            listaProduccionIntelectual = ejbProduccionIntelectual.listarBuscador(buscar);
            listaProyecto = ejbProyecto.listarBuscador(buscar);

//            renderBibliografia = listaBibliografia.isEmpty();
//            renderHerramientaSoftware = listaHerramientaSoftware.isEmpty();
//            renderInvestigador= listaInvestigador.isEmpty();
//            renderLineaInvestigacion = listaLineaInvestigacion.isEmpty();
//            renderNoticia = listaNoticia.isEmpty();
//            renderProduccionIntelectual = listaProduccionIntelectual.isEmpty();
//            renderProyecto = listaProyecto.isEmpty();


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

    public List<HerramientaSoftware> getListaHerramientaSoftware() {
        return listaHerramientaSoftware;
    }

    public void setListaHerramientaSoftware(List<HerramientaSoftware> listaHerramientaSoftware) {
        this.listaHerramientaSoftware = listaHerramientaSoftware;
    }

    public List<Investigador> getListaInvestigador() {
        return listaInvestigador;
    }

    public void setListaInvestigador(List<Investigador> listaInvestigador) {
        this.listaInvestigador = listaInvestigador;
    }

    public List<LineaInvestigacion> getListaLineaInvestigacion() {
        return listaLineaInvestigacion;
    }

    public void setListaLineaInvestigacion(List<LineaInvestigacion> listaLineaInvestigacion) {
        this.listaLineaInvestigacion = listaLineaInvestigacion;
    }

    public List<Noticia> getListaNoticia() {
        return listaNoticia;
    }

    public void setListaNoticia(List<Noticia> listaNoticia) {
        this.listaNoticia = listaNoticia;
    }

    public List<ProduccionIntelectual> getListaProduccionIntelectual() {
        return listaProduccionIntelectual;
    }

    public void setListaProduccionIntelectual(List<ProduccionIntelectual> listaProduccionIntelectual) {
        this.listaProduccionIntelectual = listaProduccionIntelectual;
    }

    public List<Proyecto> getListaProyecto() {
        return listaProyecto;
    }

    public void setListaProyecto(List<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }

    public uis.giib.administrador.dao.BibliografiaFacade getEjbBibliografia() {
        return ejbBibliografia;
    }

    public void setEjbBibliografia(uis.giib.administrador.dao.BibliografiaFacade ejbBibliografia) {
        this.ejbBibliografia = ejbBibliografia;
    }

    public uis.giib.administrador.dao.HerramientaSoftwareFacade getEjbHerramientaSoftware() {
        return ejbHerramientaSoftware;
    }

    public void setEjbHerramientaSoftware(uis.giib.administrador.dao.HerramientaSoftwareFacade ejbHerramientaSoftware) {
        this.ejbHerramientaSoftware = ejbHerramientaSoftware;
    }

    public uis.giib.administrador.dao.InvestigadorFacade getEjbInvestigador() {
        return ejbInvestigador;
    }

    public void setEjbInvestigador(uis.giib.administrador.dao.InvestigadorFacade ejbInvestigador) {
        this.ejbInvestigador = ejbInvestigador;
    }

    public uis.giib.administrador.dao.LineaInvestigacionFacade getEjbLineaInvestigacion() {
        return ejbLineaInvestigacion;
    }

    public void setEjbLineaInvestigacion(uis.giib.administrador.dao.LineaInvestigacionFacade ejbLineaInvestigacion) {
        this.ejbLineaInvestigacion = ejbLineaInvestigacion;
    }

    public uis.giib.administrador.dao.NoticiaFacade getEjbNoticia() {
        return ejbNoticia;
    }

    public void setEjbNoticia(uis.giib.administrador.dao.NoticiaFacade ejbNoticia) {
        this.ejbNoticia = ejbNoticia;
    }

    public uis.giib.administrador.dao.ProduccionIntelectualFacade getEjbProduccionIntelectual() {
        return ejbProduccionIntelectual;
    }

    public void setEjbProduccionIntelectual(uis.giib.administrador.dao.ProduccionIntelectualFacade ejbProduccionIntelectual) {
        this.ejbProduccionIntelectual = ejbProduccionIntelectual;
    }

    public uis.giib.administrador.dao.ProyectoFacade getEjbProyecto() {
        return ejbProyecto;
    }

    public void setEjbProyecto(uis.giib.administrador.dao.ProyectoFacade ejbProyecto) {
        this.ejbProyecto = ejbProyecto;
    }

    public boolean isRenderBibliografia() {
        return renderBibliografia;
    }

    public void setRenderBibliografia(boolean renderBibliografia) {
        this.renderBibliografia = renderBibliografia;
    }

    public boolean isRenderHerramientaSoftware() {
        return renderHerramientaSoftware;
    }

    public void setRenderHerramientaSoftware(boolean renderHerramientaSoftware) {
        this.renderHerramientaSoftware = renderHerramientaSoftware;
    }

    public boolean isRenderInvestigador() {
        return renderInvestigador;
    }

    public void setRenderInvestigador(boolean renderInvestigador) {
        this.renderInvestigador = renderInvestigador;
    }

    public boolean isRenderLineaInvestigacion() {
        return renderLineaInvestigacion;
    }

    public void setRenderLineaInvestigacion(boolean renderLineaInvestigacion) {
        this.renderLineaInvestigacion = renderLineaInvestigacion;
    }

    public boolean isRenderNoticia() {
        return renderNoticia;
    }

    public void setRenderNoticia(boolean renderNoticia) {
        this.renderNoticia = renderNoticia;
    }

    public boolean isRenderProduccionIntelectual() {
        return renderProduccionIntelectual;
    }

    public void setRenderProduccionIntelectual(boolean renderProduccionIntelectual) {
        this.renderProduccionIntelectual = renderProduccionIntelectual;
    }

    public boolean isRenderProyecto() {
        return renderProyecto;
    }

    public void setRenderProyecto(boolean renderProyecto) {
        this.renderProyecto = renderProyecto;
    }
}
