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
     * @return Investigador
     */
    public String login() {

        usuarioAutenticado = getInvestigadorDAO().loginAdministrador(getUsuario().getUsuarioInvestigador(), getUsuario().getContrasenaInvestigador());

        if (usuarioAutenticado != null) {
            loggedIn = true;
            return "inicio.xhtml?faces-redirect=true";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al iniciar sesión","Verifique su usuario y contraseña");
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
