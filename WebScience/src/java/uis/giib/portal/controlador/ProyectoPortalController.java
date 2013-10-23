package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.entidades.EstadoProyecto;
import uis.giib.entidades.Proyecto;

/**
 *
 *  * @author Carlos David Prada Remolina  * @version 1.0  * @since 10/10/2013
 */
@Named(value = "proyectoPC")
@SessionScoped
public class ProyectoPortalController implements Serializable {

    //Atributos
    private List<Proyecto> listadoProyectos;
    private DataModel listadoEstadoProyecto;
    private Proyecto proyectoActual;
    @EJB
    private uis.giib.administrador.dao.ProyectoFacade ejbProyecto;
    @EJB
    private uis.giib.administrador.dao.EstadoProyectoFacade ejbEstadoProyecto;

    // Contructor
    public ProyectoPortalController() {
    }

    //Métodos de navegación
    public String goProyectos() {
        try {
            listadoEstadoProyecto = new ListDataModel(ejbEstadoProyecto.findAll());
            listadoProyectos = ejbProyecto.listarProyecto();
            Iterator<EstadoProyecto> estProIterator = listadoEstadoProyecto.iterator();

            while (estProIterator.hasNext()) {
                EstadoProyecto estPro = estProIterator.next();
                estPro.getProyectoList().retainAll(listadoProyectos);
            }
        } catch (Exception e) {
            System.out.println("Error listando Proyectos!" + e.getLocalizedMessage() + " " + e.getMessage());
        }
        return "/portal/proyecto.xhtml?faces-redirect=true";
    }

    public String goDetallesProyecto(Proyecto proyecto) {

        try {
            proyectoActual = (Proyecto) proyecto;
        } catch (Exception e) {
            System.out.println("Error listando proyectos!");
        }
        return "/portal/proyectoDetalle.xhtml?faces-redirect=true";
    }
    //Getters - Setters  

    public List<Proyecto> getListadoProyectos() {
        return listadoProyectos;
    }

    public void setListadoProyectos(List<Proyecto> listadoProyectos) {
        this.listadoProyectos = listadoProyectos;
    }

    public DataModel getListadoEstadoProyecto() {
        return listadoEstadoProyecto;
    }

    public void setListadoEstadoProyecto(DataModel listadoEstadoProyecto) {
        this.listadoEstadoProyecto = listadoEstadoProyecto;
    }

    public Proyecto getProyectoActual() {
        return proyectoActual;
    }

    public void setProyectoActual(Proyecto proyectoActual) {
        this.proyectoActual = proyectoActual;
    }

    public uis.giib.administrador.dao.ProyectoFacade getEjbProyecto() {
        return ejbProyecto;
    }

    public void setEjbProyecto(uis.giib.administrador.dao.ProyectoFacade ejbProyecto) {
        this.ejbProyecto = ejbProyecto;
    }

    public uis.giib.administrador.dao.EstadoProyectoFacade getEjbEstadoProyecto() {
        return ejbEstadoProyecto;
    }

    public void setEjbEstadoProyecto(uis.giib.administrador.dao.EstadoProyectoFacade ejbEstadoProyecto) {
        this.ejbEstadoProyecto = ejbEstadoProyecto;
    }
}
