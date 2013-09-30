package uis.giib.portal.controlador;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import uis.giib.entidades.EnlacesWeb;

/**
 *
 * @author Carlos David Prada Remolina crisyhian ruiz
 */
@Named(value = "enlacesWebPC")
@SessionScoped
public class EnlacesWebPortalController implements Serializable {

    // Atributos
    private EnlacesWeb enlacesWeb;
    private Integer idAulaVirtual = new Integer(1);
    @EJB
    private uis.giib.administrador.dao.EnlacesWebFacade ejbEnlacesWeb;

    //Constructor    
    public EnlacesWebPortalController() {        
    }

    // Métodos 
    public String enlaceAulaVirtual() {
        try {
            enlacesWeb = ejbEnlacesWeb.buscarEnlaceWebPorID(idAulaVirtual);
        } catch (Exception e) {
            System.out.println("Error consultando el enlace Aula Virtual!" + e.getMessage());
        }
        //return enlacesWeb.getEnlace();
        return enlacesWeb.getEnlace();
    }

    public void enlaceWebPageUIS() {
        enlacesWeb = ejbEnlacesWeb.buscarEnlaceWebPorID(1);
    }

    //Getters - Setters
    public EnlacesWeb getEnlacesWeb() {
        return enlacesWeb;
    }

    public void setEnlacesWeb(EnlacesWeb enlacesWeb) {
        this.enlacesWeb = enlacesWeb;
    }

    public Integer getIdAulaVirtual() {
        return idAulaVirtual;
    }

    public void setIdAulaVirtual(Integer idAulaVirtual) {
        this.idAulaVirtual = idAulaVirtual;
    }

    public uis.giib.administrador.dao.EnlacesWebFacade getEjbEnlacesWeb() {
        return ejbEnlacesWeb;
    }

    public void setEjbEnlacesWeb(uis.giib.administrador.dao.EnlacesWebFacade ejbEnlacesWeb) {
        this.ejbEnlacesWeb = ejbEnlacesWeb;
    }
}
