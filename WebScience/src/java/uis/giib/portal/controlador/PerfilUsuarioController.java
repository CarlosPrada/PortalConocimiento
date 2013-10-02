package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import uis.giib.entidades.Investigador;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "perfilUsuarioC")
@SessionScoped
public class PerfilUsuarioController implements Serializable {

    //Atributos
    private Investigador investigadorActual;

    //Constructor
    public PerfilUsuarioController() {
    }

    //Métodos de Navegación
    public String goEditarPerfil(Investigador investigador) {

        try {
            investigadorActual = investigador;
        } catch (Exception e) {
            System.out.println("Error Mostrando detalles Investigador!");
        }
        return "/portal/editarPerfilUsuario.xhtml?faces-redirect=true";
    }

    //Getters - Setters
    public Investigador getInvestigadorActual() {
        return investigadorActual;
    }

    public void setInvestigadorActual(Investigador investigadorActual) {
        this.investigadorActual = investigadorActual;
    }
}
