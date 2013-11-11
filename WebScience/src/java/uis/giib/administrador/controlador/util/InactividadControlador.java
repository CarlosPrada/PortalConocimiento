package uis.giib.administrador.controlador.util;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 15/10/2013
 */
@ManagedBean(name = "idleBean")
public class InactividadControlador implements Serializable {

    /**
     * Método para cerrar la sesión y advertir al usuario acerca de su periodo
     * de inactividad.
     *
     * @throws IOException
     */
    public void activeListener() throws IOException {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Bienvenido",
                "¡Ha vuelto! Le estamos esperando"));

        FacesContext.getCurrentInstance().getExternalContext().redirect("/Giib/portal/index.jsf");
    }

    /**
     * Método para cerrar la sesión y advertir al usuario acerca de su periodo
     * de inactividad.
     *
     * @throws IOException
     */
    public void logoutListener() throws IOException {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Se ha perdido la sesión",
                "Se ha perdido la sesión"));
    }
}
