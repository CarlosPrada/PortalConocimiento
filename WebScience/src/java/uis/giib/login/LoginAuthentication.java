/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.login;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import uis.giib.administrador.dao.InvestigadorFacade;
import uis.giib.entidades.Investigador;

/**
 * COntorlador para verificar que los datos usados en la autenticación sean los
 * correctos
 *
 * @author User
 */
@Named(value = "loginAuthentication")
@SessionScoped
public class LoginAuthentication implements Serializable {

    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade investigadorDAO;
    private Investigador usuario;
    private Investigador usuarioAutenticado;
    private boolean loggedIn = false;

    /**
     * Creates a new instance of LoginAuthentication
     */
    public LoginAuthentication() {
        usuario = new Investigador();
        usuarioAutenticado = null;
    }

    private InvestigadorFacade getInvestigadorDAO() {
        return investigadorDAO;
    }

    /**
     * Método que realiza la consulta y verifica que los datos de ID de usuario
     * y Contraseña coincidan.
     *
     * @return Investigador
     */
    public String login() {

        usuarioAutenticado = getInvestigadorDAO().loginAdministrador(getUsuario().getUsuarioInvestigador(), getUsuario().getContrasenaInvestigador());
        //usuarioA utenticado = getInvestigadorDAO().loginAdministrador(getUsuario().getUsuarioInvestigador(), getUsuario().getContrasenaInvestigador(), getUsuario().getIdNivelPermiso().getIdPermiso());

        if (usuarioAutenticado != null) {
            loggedIn = true;
            return "inicio.xhtml?faces-redirect=true";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al iniciar sesión", "Verifique su usuario y contraseña");
            facesContext.addMessage(null, facesMessage);
            return null;
        }
    }

    public String logout() {

        usuario = new Investigador();
        usuarioAutenticado = null;
        loggedIn = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }

    public boolean isValidarUsuarioAdmin() {

        if (usuarioAutenticado.getIdNivelPermiso().getIdPermiso() == 1) {

            return true;
        } else {
            return false;
        }

    }

    /**
     * @return the usuario
     */
    public Investigador getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Investigador usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarioAutenticado
     */
    public Investigador getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    /**
     * @param usuarioAutenticado the usuarioAutenticado to set
     */
    public void setUsuarioAutenticado(Investigador usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
