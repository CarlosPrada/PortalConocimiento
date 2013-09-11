package uis.giib.portal.controlador;

import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import uis.giib.administrador.dao.TipoContenidoFacade;
import uis.giib.entidades.Contenido;
import uis.giib.entidades.TipoContenido;

/**
 *
 * @author Carlos David Prada Remolina Y CRIS
 */
@Named(value = "eventosPC")
@SessionScoped
public class EventosPortalController implements Serializable {

    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    private DataModel<Contenido> listadoContenidoEventos;
    private TipoContenido TipoContenido;
    private Integer idTipo = new Integer(4);
    @EJB
    private uis.giib.administrador.dao.TipoContenidoFacade ejbFacade;

    public EventosPortalController() {
        try {
            TipoContenido = ejbFacade.buscarContenidoPorTipo(idTipo);
            listadoContenidoEventos = new ListDataModel(TipoContenido.getContenidoList());
            Iterator<Contenido> it = listadoContenidoEventos.iterator();
            eventModel = new DefaultScheduleModel();
            while (it.hasNext()) {
                Contenido i = it.next();
                eventModel.addEvent(new DefaultScheduleEvent(i.getTitulo(), i.getFechaInicioevento(), i.getFechaFinevento()));
            }
        } catch (Exception e) {
            System.out.println("Error listando investitadores!" + e.getLocalizedMessage());
        }
    }

    //Métodos de navegación
    public String goEventos() {

        try {
            TipoContenido = ejbFacade.buscarContenidoPorTipo(idTipo);
            listadoContenidoEventos = new ListDataModel(TipoContenido.getContenidoList());
            Iterator<Contenido> it = listadoContenidoEventos.iterator();
            eventModel = new DefaultScheduleModel();
            while (it.hasNext()) {
                Contenido i = it.next();
                eventModel.addEvent(new DefaultScheduleEvent(i.getTitulo(), i.getFechaInicioevento(), i.getFechaFinevento()));
            }
        } catch (Exception e) {
            System.out.println("Error listando investitadores!" + e.getMessage());
        }
        return "/portal/eventos.xhtml?faces-redirect=true";
    }
   
    public DataModel<Contenido> getListadoPublicacionEventos() {
        return listadoContenidoEventos;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public TipoContenidoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setListadoPublicacionEventos(DataModel<Contenido> listadoPublicacionEventos) {
        this.listadoContenidoEventos = listadoPublicacionEventos;
    }

    public TipoContenido getTipoPublicacion() {
        return TipoContenido;
    }

    public void setTp(TipoContenido tipoPublicacion) {
        this.TipoContenido = tipoPublicacion;
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

    public void setEjbFacade(TipoContenidoFacade ejbFacade) {
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
