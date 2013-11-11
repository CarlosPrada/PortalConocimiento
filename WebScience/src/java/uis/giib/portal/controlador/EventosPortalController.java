package uis.giib.portal.controlador;

import java.io.Serializable;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import uis.giib.entidades.Evento;

/**
 * @author Carlos David Prada Remolina  
 * @version 1.0  
 * @since 20/07/2013
 */
@Named(value = "eventosPC")
@SessionScoped
public class EventosPortalController implements Serializable {

    //Atributos
    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    private DataModel listadoEvento;
    @EJB
    private uis.giib.administrador.dao.EventoFacade ejbEvento;

    //Constructor
    public EventosPortalController() {
    }

    /**
     * Redirecciona al usuario a la página de eventos.xhtml
     * Almacena en una lista los eventos activos en la BD.
     * 
     * @return Retorna el enlace a eventos.xhtml
     */
    public String goEventos() {

        try {
            listadoEvento = new ListDataModel(ejbEvento.listarEventosPorEstado());
            Iterator<Evento> eveIterator = listadoEvento.iterator();
            eventModel = new DefaultScheduleModel();
            while (eveIterator.hasNext()) {
                Evento eve = eveIterator.next();
                eventModel.addEvent(new DefaultScheduleEvent(eve.getNombreEvento(), eve.getFechaInicio(), eve.getFechaFin()));
            }
        } catch (Exception e) {
            System.out.println("Error listando EVENTOS!" + e.getLocalizedMessage() + " " + e.getMessage());
        }

        return "/portal/eventos.xhtml?faces-redirect=true";
    }

    //Getters - Setters
    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public DataModel getListadoEvento() {
        return listadoEvento;
    }

    public void setListadoEvento(DataModel listadoEvento) {
        this.listadoEvento = listadoEvento;
    }

    public uis.giib.administrador.dao.EventoFacade getEjbEvento() {
        return ejbEvento;
    }

    public void setEjbEvento(uis.giib.administrador.dao.EventoFacade ejbEvento) {
        this.ejbEvento = ejbEvento;
    }
}