package uis.giib.portal.controlador;

import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import uis.giib.administrador.dao.TipoPublicacionFacade;
import uis.giib.entidades.Publicacion;
import uis.giib.entidades.TipoPublicacion;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "eventosPC")
@SessionScoped
public class EventosPortalController implements Serializable {

    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    //private List<TipoPublicacion> listadoPublicacionEvento;
    private List<Publicacion> listadoPublicacionEventos;
    private TipoPublicacion tipoPublicacion;
    
    private Integer hhh = new Integer(1);
    
    @EJB
    private uis.giib.administrador.dao.TipoPublicacionFacade ejbFacade;

    public EventosPortalController() {
        try {
            eventModel = new DefaultScheduleModel();
            tipoPublicacion = (TipoPublicacion) (List<TipoPublicacion>) new ListDataModel((List) ejbFacade.findByIdTipoPublicacion(hhh));
            listadoPublicacionEventos = tipoPublicacion.getPublicacionList();
            //if(listadoPublicacionEventos.isEmpty()){
           // }
           
            for (Iterator<Publicacion> it = listadoPublicacionEventos.iterator(); it.hasNext();) {
                Publicacion i = it.next();
                eventModel.addEvent(new DefaultScheduleEvent(i.getContenidoPublicacion(), i.getFechaInicioeventoPublicacion(), i.getFechaFineventoPublicacion()));
            }
        } catch (Exception e) {
            System.out.println("Error listando investitadores!");
        }
    }

    //Métodos de navegación
    public String goEventos() {

        try {
            /*eventModel = new DefaultScheduleModel();
             listadoPublicacionEvento =  (List<Publicacion>) new ListDataModel((List) ejbFacade.findByNombreTipoPublicacion("Evento")); 
             for (Iterator<Publicacion> it = listadoPublicacionEvento.iterator(); it.hasNext();) {
             Publicacion i = it.next();
             eventModel.addEvent(new DefaultScheduleEvent(i.getContenidoPublicacion(), i.getFechaInicioeventoPublicacion(), i.getFechaFineventoPublicacion()));*/
            eventModel = new DefaultScheduleModel();
            tipoPublicacion = (TipoPublicacion) (List<TipoPublicacion>) new ListDataModel((List) ejbFacade.findByIdTipoPublicacion(1));
            listadoPublicacionEventos = tipoPublicacion.getPublicacionList();
            for (Iterator<Publicacion> it = listadoPublicacionEventos.iterator(); it.hasNext();) {
                Publicacion i = it.next();
                eventModel.addEvent(new DefaultScheduleEvent(i.getContenidoPublicacion(), i.getFechaInicioeventoPublicacion(), i.getFechaFineventoPublicacion()));            }
        } catch (Exception e) {
            System.out.println("Error listando investitadores!");
        }
        return "/portal/eventos.xhtml?faces-redirect=true";
    }
/*
    public List<TipoPublicacion> getListadoPublicacionEvento() {
        return listadoPublicacionEvento;
    }

    public void setListadoPublicacionEvento(List<TipoPublicacion> listadoPublicacionEvento) {
        this.listadoPublicacionEvento = listadoPublicacionEvento;
    }
*/
    public List<Publicacion> getListadoPublicacionEventos() {
        return listadoPublicacionEventos;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public TipoPublicacionFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setListadoPublicacionEventos(List<Publicacion> listadoPublicacionEventos) {
        this.listadoPublicacionEventos = listadoPublicacionEventos;
    }

    public TipoPublicacion getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTp(TipoPublicacion tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    /* public List<Publicacion> getListadoPublicacionEvento() {
     return listadoPublicacionEvento;
     }

     public void setListadoPublicacionEvento(List<Publicacion> listadoPublicacionEvento) {
     this.listadoPublicacionEvento = listadoPublicacionEvento;
     }

     public TipoPublicacionFacade getEjbFacade() {
     return ejbFacade;
     }*/
    public void setEjbFacade(TipoPublicacionFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }
        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
