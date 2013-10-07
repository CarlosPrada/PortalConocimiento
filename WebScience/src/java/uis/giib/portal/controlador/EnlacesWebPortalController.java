package uis.giib.portal.controlador;

import java.io.Serializable;
import javax.annotation.PostConstruct;
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
    private EnlacesWeb enlaceWeb;
    private EnlacesWeb enlacesPie[] = new EnlacesWeb[6];
    private EnlacesWeb enlacesRedesSociales[] = new EnlacesWeb[2];
    private Integer idAulaVirtual = new Integer(1);
    @EJB
    private uis.giib.administrador.dao.EnlacesWebFacade ejbEnlacesWeb;

    //Constructor    
    public EnlacesWebPortalController() {
    }

    // Métodos 
    /**
     * Consulta el registro de la base de datos correspondiente al Aula Virtual
     *
     * @return Retorna el enlace al Aula Virtual
     */
    public String enlaceAulaVirtual() {
        try {
            enlaceWeb = ejbEnlacesWeb.buscarEnlaceWebPorID(idAulaVirtual);
        } catch (Exception e) {
            System.out.println("Error consultando el enlace Aula Virtual!" + e.getMessage());
        }
        return enlaceWeb.getEnlace();
    }

    @PostConstruct
    public void cargarEnlaces() {

        enlacesPie[0] = obtenerEnlace(4);
        enlacesPie[1] = obtenerEnlace(5);
        enlacesPie[2] = obtenerEnlace(6);
        enlacesPie[3] = obtenerEnlace(7);
        enlacesPie[4] = obtenerEnlace(8);
        enlacesPie[5] = obtenerEnlace(9);
        enlacesRedesSociales[0] = obtenerEnlace(2);
        enlacesRedesSociales[1] = obtenerEnlace(3);
    }

    public EnlacesWeb obtenerEnlace(int ID) {
        enlaceWeb = ejbEnlacesWeb.buscarEnlaceWebPorID(ID);
        return enlaceWeb;
    }

    //Getters - Setters
    public EnlacesWeb getEnlaceWeb() {
        return enlaceWeb;
    }

    public void setEnlaceWeb(EnlacesWeb enlaceWeb) {
        this.enlaceWeb = enlaceWeb;
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

    public EnlacesWeb[] getEnlacesPie() {
        return enlacesPie;
    }

    public void setEnlacesPie(EnlacesWeb[] enlacesPie) {
        this.enlacesPie = enlacesPie;
    }

    public EnlacesWeb[] getEnlacesRedesSociales() {
        return enlacesRedesSociales;
    }

    public void setEnlacesRedesSociales(EnlacesWeb[] enlacesRedesSociales) {
        this.enlacesRedesSociales = enlacesRedesSociales;
    }    
}
