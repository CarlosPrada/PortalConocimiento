package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import uis.giib.entidades.LineaInvestigacion;

/**
 *
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/09/2013
 */
@Named(value = "lineasInvestigacionPC")
@SessionScoped
public class LineasInvestigacionPortalController implements Serializable {

    //Atributos
    private List<LineaInvestigacion> listadoLineasInvestigacion;
    private LineaInvestigacion lineasInvestigacionActual;
    @EJB
    private uis.giib.administrador.dao.LineaInvestigacionFacade ejbLineaInvestigacion;

    //Constructor
    public LineasInvestigacionPortalController() {
    }

    /**
     * Redirecciona al usuario a la página de lineasInvestigacion.xhtml Almacena
     * en una lista las Líneas de Investigación activos en la BD.
     *
     * @return Retorna el enlace a lineasInvestigacion.xhtml
     */
    public String goLineasInvestigacion() {
        try {
            listadoLineasInvestigacion = ejbLineaInvestigacion.listarLineaInvestigacion();
        } catch (Exception e) {
            System.out.println("Error listando las Líneas de Investigaión!");
        }
        return "/portal/lineasInvestigacion.xhtml?faces-redirect=true";
    }

    /**
     * Método que redirige al usuario a la página de
     * lineasInvestigacionDetalle.xhtm
     *
     * @param linInvestiga Objeto que contiene la Línea de Investigación
     * investigdor cuyos detalles serán explorados
     * @return Dirección de la página de lineasInvestigacionDetalle.xhtml
     */
    public String goDetallesLineasInvestigacion(LineaInvestigacion linInvestiga) {

        try {
            lineasInvestigacionActual = (LineaInvestigacion) linInvestiga;
        } catch (Exception e) {
            System.out.println("Error Mostrando detalles Linea Investigación!");
        }
        return "/portal/lineasInvestigacionDetalle.xhtml?faces-redirect=true";
    }
    
    //Getters - Setters 
    public List<LineaInvestigacion> getListadoLineasInvestigacion() {
        return listadoLineasInvestigacion;
    }

    public void setListadoLineasInvestigacion(List<LineaInvestigacion> listadoLineasInvestigacion) {
        this.listadoLineasInvestigacion = listadoLineasInvestigacion;
    }

    public LineaInvestigacion getLineasInvestigacionActual() {
        return lineasInvestigacionActual;
    }

    public void setLineasInvestigacionActual(LineaInvestigacion lineasInvestigacionActual) {
        this.lineasInvestigacionActual = lineasInvestigacionActual;
    }

    public uis.giib.administrador.dao.LineaInvestigacionFacade getEjbLineaInvestigacion() {
        return ejbLineaInvestigacion;
    }

    public void setEjbLineaInvestigacion(uis.giib.administrador.dao.LineaInvestigacionFacade ejbLineaInvestigacion) {
        this.ejbLineaInvestigacion = ejbLineaInvestigacion;
    }
}
