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
 * @author Carlos
 */
@Named(value = "administradorPC")
@SessionScoped
public class AdministradorPortalController implements Serializable {

    /**
     * Creates a new instance of AdministradorPortalController
     */
    public AdministradorPortalController() {
    }
    
    public String goAdministrar(){
        try{
        }catch(Exception e){
            System.out.println("Error administrador");
        }        
        return "/administrador/index.xhtml?faces-redirect=truel";        
    }    
    
    
}
