package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "indexPC")
@SessionScoped
public class IndexPortalController implements Serializable {

    
    // Constructor
    public IndexPortalController() {        
        try{     
        }catch(Exception e){
            System.out.println("Error de Index!");
        }        
    }
    
    //Métodos de navegación  
    public String goIndex(){
        try{       
        }catch(Exception e){
            System.out.println("Error de Index!");
        }        
        return "/portal/index.xhtml?faces-redirect=true";    
    }        
}
