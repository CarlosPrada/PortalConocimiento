/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import uis.giib.entidades.LineasInvestigador;

/**
 *
 * @author Carlos Humberto
 */
@Named(value = "investigadorPortalController")
@SessionScoped
public class InvestigadorPortalController implements Serializable {

    private DataModel listadoInvestigadores;
    private DataModel listaTiposInvestigador;
    private DataModel listaLineasInvestigador;
    private Investigador investigadorActual;
    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade ejbFacade;
    
    @EJB
    private uis.giib.administrador.dao.TipoInvestigadorFacade ejbFacadeTipoInvestigador;
    
    @EJB
    private uis.giib.administrador.dao.LineasInvestigadorFacade ejbFacadeLineasInvestigador;
    
    /**
     * Creates a new instance of InvestigadorPortalController
     */
    public InvestigadorPortalController() {
        
        try{
        listadoInvestigadores = new ListDataModel(ejbFacade.findAll());
        listaTiposInvestigador = new ListDataModel(ejbFacadeTipoInvestigador.findAll());
        listaLineasInvestigador = new ListDataModel(ejbFacadeLineasInvestigador.findAll());
        }catch(Exception e){
            System.out.println("Error listando investitadores!");
        }        
    }
    
    //Métodos de navegación
    public String goInvestigadores(){

        try{
        listadoInvestigadores = new ListDataModel(ejbFacade.findAll());
        listaTiposInvestigador = new ListDataModel(ejbFacadeTipoInvestigador.findAll());     
        listaLineasInvestigador = new ListDataModel(ejbFacadeLineasInvestigador.findAll());
        }catch(Exception e){
            System.out.println("Error listando investitadores!");
        }        
        return "/portal/investigadores.xhtm?faces-redirect=truel";        
    }    
    public String goDetallesInvestigador(Investigador inv){
        
        investigadorActual = (Investigador) inv;
        return "/portal/investigadoresDetalle.xhtml?faces-redirect=true";        
    }
    
    // Getters/Setters

    public DataModel getListaLineasInvestigador() {
        return listaLineasInvestigador;
    }

    public void setListaLineasInvestigador(DataModel listaLineasInvestigador) {
        this.listaLineasInvestigador = listaLineasInvestigador;
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
        return ejbFacade;
    }

    public void setEjbFacade(InvestigadorFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public uis.giib.administrador.dao.LineasInvestigadorFacade getEjbFacadeLineasInvestigador() {
        return ejbFacadeLineasInvestigador;
    }

    public void setEjbFacadeLineasInvestigador(uis.giib.administrador.dao.LineasInvestigadorFacade ejbFacadeLineasInvestigador) {
        this.ejbFacadeLineasInvestigador = ejbFacadeLineasInvestigador;
    }    
}
