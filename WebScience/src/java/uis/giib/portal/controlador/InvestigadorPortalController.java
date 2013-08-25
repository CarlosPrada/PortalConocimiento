package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.InvestigadorFacade;
import uis.giib.administrador.dao.TipoInvestigadorFacade;
import uis.giib.entidades.Investigador;



/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "investigadorPC")
@SessionScoped
public class InvestigadorPortalController implements Serializable {

    //Atributos
    
    private DataModel listadoInvestigadores;
    private DataModel listaTiposInvestigador;
    private Investigador investigadorActual;
    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade ejbFacadeInvestigador;    
    @EJB
    private uis.giib.administrador.dao.TipoInvestigadorFacade ejbFacadeTipoInvestigador;    

    //constructor
    public InvestigadorPortalController() {
        
        try{
        listadoInvestigadores = new ListDataModel(ejbFacadeInvestigador.findAll());
        listaTiposInvestigador = new ListDataModel(ejbFacadeTipoInvestigador.findAll());
        }catch(Exception e){
            System.out.println("Error listando investitadores!");
        }        
    }
    
    //Métodos de navegación
    
    /**Método que redirige al usuario a la página de investigadores.xhtml
     * 
     * @return Dirección de la página de investigadores.xhtml
     */
    public String goInvestigadores(){

        try{
        listadoInvestigadores = new ListDataModel(ejbFacadeInvestigador.findAll());
        listaTiposInvestigador = new ListDataModel(ejbFacadeTipoInvestigador.findAll()); 
        }catch(Exception e){
            System.out.println("Error listando investitadores!");
        }        
        return "/portal/investigadores.xhtm?faces-redirect=truel";        
    }    
    
    /**Método que redirige al usuario a la página de investigadoresDetalle.xhtml
     * 
     * @param investigador: Objeto que contiene el investigdor cuyos detalles serán explorados
     * @return Dirección de la página de investigadoresDetalle.xhtml
     */    
    public String goDetallesInvestigador(Investigador investigador){
        
        try{
        investigadorActual = (Investigador) investigador;
        }catch(Exception e){
            System.out.println("Error Mostrando detalles Investigador!");
        }       
        return "/portal/investigadoresDetalle.xhtml?faces-redirect=true";        
    }

    // Getters - Setters

    public InvestigadorFacade getEjbFacadeInvestigador() {
        return ejbFacadeInvestigador;
    }

    public void setEjbFacadeInvestigador(InvestigadorFacade ejbFacadeInvestigador) {
        this.ejbFacadeInvestigador = ejbFacadeInvestigador;
    }

    public TipoInvestigadorFacade getEjbFacadeTipoInvestigador() {
        return ejbFacadeTipoInvestigador;
    }

    public void setEjbFacadeTipoInvestigador(TipoInvestigadorFacade ejbFacadeTipoInvestigador) {
        this.ejbFacadeTipoInvestigador = ejbFacadeTipoInvestigador;
    }

    public DataModel getListadoInvestigadores() {
        return listadoInvestigadores;
    }

    public void setListadoInvestigadores(DataModel listadoInvestigadores) {
        this.listadoInvestigadores = listadoInvestigadores;
    }

    public DataModel getListaTiposInvestigador() {
        return listaTiposInvestigador;
    }

    public void setListaTiposInvestigador(DataModel listaTiposInvestigador) {
        this.listaTiposInvestigador = listaTiposInvestigador;
    }
    
    public Investigador getInvestigadorActual() {
        return investigadorActual;
    }

    public void setInvestigadorActual(Investigador investigadorActual) {
        this.investigadorActual = investigadorActual;
    }

    public InvestigadorFacade getEjbFacade() {
        return ejbFacadeInvestigador;
    }

    public void setEjbFacade(InvestigadorFacade ejbFacade) {
        this.ejbFacadeInvestigador = ejbFacade;
    }    
}
