package uis.giib.administrador.controlador.util;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import uis.giib.administrador.dao.InvestigadorFacade;
import uis.giib.entidades.Investigador;

/**
 * Contorlador para verificar que los datos usados en la autenticación sean los
 * correctos
 *
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Named(value = "loginAuthentication")
@SessionScoped
public class LoginAuthentication implements Serializable {

    //Atributos
    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade investigadorDAO;
    private Investigador usuario;
    private Investigador usuarioAutenticado;
    private boolean loggedIn = false;
    private boolean administrador = false;
    private boolean[] arrayRender = new boolean[8];
    private String fileName;

    /**
     * Constructor LoginAuthentication
     */
    public LoginAuthentication() {
        usuario = new Investigador();
        usuarioAutenticado = null;
    }

    /**
     * Método que realiza la consulta y verifica que los datos de ID de usuario
     * y Contraseña coincidan.
     *
     * @return Investigador
     */
    public String loginAdministracion() {

        ValidarUsuarioAdmnistracion();
        if (usuarioAutenticado != null) {
            loggedIn = true;
            return "inicio.xhtml?faces-redirect=true";
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Usted no cuenta con permisos Suficientes!", "Verifique su usuario y contraseña");
            facesContext.addMessage(null, facesMessage);
            return null;
        }
    }

    /**
     * Método que finaliza la sesión del usuario
     *
     * @return Redirecciona al usuario a la página de index.xhtml
     */
    public String logout() {
        usuario = new Investigador();
        usuarioAutenticado = null;
        loggedIn = false;
        administrador = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/portal/index.xhtml?faces-redirect=true";
    }

    /**
     * Método que realiza la consulta y verifica que los datos de ID de usuario
     * y Contraseña coincidan.
     *
     * @return Investigador
     */
    public void loginPortal() {

        //ValidarUsuarioPortal();
        ValidarUsuarioAdmnistracion();
        if (usuarioAutenticado != null) {
            loggedIn = true;
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o Contraseña incorrectos", "Verifique su usuario y contraseña");
            facesContext.addMessage(null, facesMessage);
        }
    }

    /**
     * Método que finaliza la sesión del usuario
     *
     * @return Redirecciona al usuario a la página de index.xhtml
     */
    public void logoutPortal() {
        usuario = new Investigador();
        usuarioAutenticado = null;
        loggedIn = false;
        administrador = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    /**
     * Método que redirecciona al usuario a editarPerfilUsuario.xhtml
     *
     * @return redireccionamiento a editarPerfilUsuario.xhtml
     */
    public String goEditarPerfil() {
        return "/portal/editarPerfilUsuario.xhtml?faces-redirect=true";
    }

    /**
     * Método que redirecciona al usuario a inicio.xhtml
     *
     * @return redireccionamiento a inicio.xhtml
     */
    public String goAdministracion() {
        return "/administrador/inicio.xhtml?faces-redirect=true";
    }

    /**
     * Método que actualiza los datos del usuario cuando este edita su perfil
     */
    public void update() {
        usuarioAutenticado.setImageInvestigadorPath(fileName);
        try {
            getInvestigadorDAO().edit(usuarioAutenticado);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UsuarioUpdated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    public void ValidarUsuarioPortal() {
        usuarioAutenticado = getInvestigadorDAO().loginAdministrador(getUsuario().getUsuarioInvestigador(), getUsuario().getContrasenaInvestigador());
    }

    /**
     * Método para verificar los permizos de admisnitración del usuario
     * autenticado
     *
     * @return boolean true o false
     */
    public void ValidarUsuarioAdmnistracion() {
        usuarioAutenticado = getInvestigadorDAO().loginAdministrador(getUsuario().getUsuarioInvestigador(), getUsuario().getContrasenaInvestigador());

        if (usuarioAutenticado != null) {

            if (usuarioAutenticado.getIdNivelPermiso().getIdPermiso() == 1) {
                administrador = true;
                this.arrayRender[0] = true;
                this.arrayRender[1] = true;
                this.arrayRender[2] = true;
                this.arrayRender[3] = true;
                this.arrayRender[4] = true;
                this.arrayRender[5] = true;

            } else {
                if (usuarioAutenticado.getIdNivelPermiso().getIdPermiso() == 2) {
                    administrador = true;
                    this.arrayRender[0] = true;
                    this.arrayRender[1] = true;
                    this.arrayRender[2] = true;
                    this.arrayRender[3] = false;
                    this.arrayRender[4] = false;
                    this.arrayRender[5] = false;

                } else {
                    //this.usuarioAutenticado = null;
                    administrador = false;
                    this.arrayRender[0] = false;
                    this.arrayRender[1] = false;
                    this.arrayRender[2] = false;
                    this.arrayRender[3] = false;
                    this.arrayRender[4] = false;
                    this.arrayRender[5] = false;
                }
            }
        }
    }

    // getters - Setters
    /**
     * @return the usuario
     */
    public Investigador getUsuario() {
        return usuario;
    }

    private InvestigadorFacade getInvestigadorDAO() {
        return investigadorDAO;
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

    public boolean[] getArrayRender() {
        return arrayRender;
    }

    public void setArrayRender(boolean[] arrayRender) {
        this.arrayRender = arrayRender;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
