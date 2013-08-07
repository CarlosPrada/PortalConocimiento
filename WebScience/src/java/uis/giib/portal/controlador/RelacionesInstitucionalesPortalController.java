/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "relacionesInstitucionalesPortalController")
@SessionScoped
public class RelacionesInstitucionalesPortalController implements Serializable {

// en un ListDataModel colocamos todos los proyectos en la DB
    public RelacionesInstitucionalesPortalController() {
        try {
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!");
        }
    }

    //Métodos de navegación
    // usado cuando hacemos click en el menú 
    public String goRelacionesInstitucionales(){
        try {
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!");
        }
        return "/portal/relacionesInstitucionales.xhtml?faces-redirect=true";
    }
}