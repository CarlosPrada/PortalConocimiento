package uis.giib.portal.controlador;

import java.io.Serializable;
import java.util.Calendar;

import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Carlos David Prada Remolina Y CRIS
 */
@Named(value = "eventosPC")
@SessionScoped
public class EventosPortalController implements Serializable {

    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();

    //Constructor
    public EventosPortalController() {
        /*try {
         TipoContenido = ejbFacade.buscarContenidoPorTipo(idTipo);
         listadoContenidoEventos = new ListDataModel(TipoContenido.getContenidoList());
         Iterator<Contenido> it = listadoContenidoEventos.iterator();
         eventModel = new DefaultScheduleModel();
         while (it.hasNext()) {
         Contenido i = it.next();
         eventModel.addEvent(new DefaultScheduleEvent(i.getTitulo(), i.getFechaInicioevento(), i.getFechaFinevento()));
         }
         } catch (Exception e) {
         System.out.println("Error listando investitadores!" + e.getLocalizedMessage() + " " + e.getMessage());
         }*/
    }

    //Métodos de navegación
    public String goEventos() {

        return "/portal/eventos.xhtml?faces-redirect=true";
    }

    //Getters - Setters
    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    //PrimeFaces
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1);    //set random day of month  

        return date.getTime();
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
