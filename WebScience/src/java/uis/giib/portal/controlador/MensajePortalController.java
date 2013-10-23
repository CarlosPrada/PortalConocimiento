package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import uis.giib.entidades.MensajePortal;

/**
 *
 *  * @author Carlos David Prada Remolina  * @version 1.0  * @since 10/10/2013
 */
@Named(value = "mensajePC")
@SessionScoped
public class MensajePortalController implements Serializable {

    //Atributos
    @EJB
    private uis.giib.administrador.dao.MensajePortalFacade ejbMensajePortal;
    private List<MensajePortal> listadoMensajesPortal;

    public MensajePortalController() {
    }

    //Métodos 
    @PostConstruct
    public void listarMensajesPortal() {
        try {
            listadoMensajesPortal = ejbMensajePortal.listarMensajePortal();
        } catch (Exception e) {
            System.out.println("Error al listar mensajes portal");
        }
    }

    //Getters - Setters
    public uis.giib.administrador.dao.MensajePortalFacade getEjbMensajePortal() {
        return ejbMensajePortal;
    }

    public void setEjbMensajePortal(uis.giib.administrador.dao.MensajePortalFacade ejbMensajePortal) {
        this.ejbMensajePortal = ejbMensajePortal;
    }

    public List<MensajePortal> getListadoMensajesPortal() {
        return listadoMensajesPortal;
    }

    public void setListadoMensajesPortal(List<MensajePortal> listadoMensajesPortal) {
        this.listadoMensajesPortal = listadoMensajesPortal;
    }
}
