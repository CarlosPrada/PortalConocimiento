package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import uis.giib.entidades.Investigador;

/**
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Named(value = "perfilUsuarioC")
@SessionScoped
public class PerfilUsuarioController implements Serializable {

    //Atributos
    private Investigador usuarioActual;

    //Constructor
    public PerfilUsuarioController() {
    }

    /**
     * Redirecciona al usuario a la página de editarPerfilUsuario.xhtml 
     *
     * @return Retorna el enlace a editarPerfilUsuario.xhtml
     */
    public String goEditarPerfil(Investigador investigador) {

        try {
            usuarioActual = investigador;
        } catch (Exception e) {
            System.out.println("Error Mostrando detalles Investigador!");
        }
        return "/portal/editarPerfilUsuario.xhtml?faces-redirect=true";
    }

    //Getters - Setters
    public Investigador getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Investigador usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}
