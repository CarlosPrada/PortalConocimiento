/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.controlador;

import java.io.Serializable;
import javax.inject.Inject;
import uis.giib.administrador.controlador.util.LoginAuthentication;


public class AbstractController implements Serializable {

    @Inject
    protected uis.giib.administrador.controlador.util.LoginAuthentication loginAutentication;

     
    public AbstractController() {
    }
    
    public LoginAuthentication getLoginAutentication() {
        return loginAutentication;
    }
       
    public boolean isAuthenticaded(){
        return getLoginAutentication().isLoggedIn();
        
    }
    
    
}
