package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.InvestigadorFacade;
import uis.giib.administrador.dao.TipoInvestigadorFacade;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.LineasInvestigador;
//import uis.giib.entidades.LineasInvestigador;

/**
 *
 * @author Carlos Humberto
 */
@Named(value = "investigadorPortalController")
@SessionScoped
public class InvestigadorPortalController implements Serializable {
//atributos
    private DataModel listadoInvestigadores;
    private DataModel listaTiposInvestigador;
    private DataModel listaLineasInvestigador;
    private DataModel lineasInvestigadorList;
    private Investigador investigadorActual;
    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade ejbFacade;    
    @EJB
    private uis.giib.administrador.dao.TipoInvestigadorFacade ejbFacadeTipoInvestigador;    
    @EJB
    private uis.giib.administrador.dao.LineasInvestigadorFacade ejbFacadeLineasInvestigador;
    //constructor
    public InvestigadorPortalController() {
        
        try{
        listadoInvestigadores = new ListDataModel(ejbFacade.findAll());
        listaTiposInvestigador = new ListDataModel(ejbFacadeTipoInvestigador.findAll());
        //listaLineasInvestigador = (List<LineasInvestigador>) new ListDataModel(ejbFacadeLineasInvestigador.findAll());
        //listaLineasInvestigador = new ListDataModel(ejbFacadeLineasInvestigador.findAll());
        }catch(Exception e){
            System.out.println("Error listando investitadores!");
        }        
    }
    
    //Métodos de navegación
    public String goInvestigadores(){

        try{
        listadoInvestigadores = new ListDataModel(ejbFacade.findAll());
        listaTiposInvestigador = new ListDataModel(ejbFacadeTipoInvestigador.findAll());     
        //listaLineasInvestigador = (List<LineasInvestigador>) new ListDataModel(ejbFacadeLineasInvestigador.findAll());
        //listaLineasInvestigador = new ListDataModel(ejbFacadeLineasInvestigador.findAll());
        }catch(Exception e){
            System.out.println("Error listando investitadores!");
        }        
        return "/portal/investigadores.xhtm?faces-redirect=truel";        
    }    
    public String goDetallesInvestigador(Investigador inv){
        
        try{
        investigadorActual = (Investigador) inv;
        lineasInvestigadorList = new ListDataModel(investigadorActual.getLineasInvestigadorList());
        
        
        //listaLineasInvestigador = new ListDataModel(investigadorActual.getLineasInvestigacionList());
        
        //listaLineasInvestigador = new ListDataModel(ejbFacadeLineasInvestigador.findAll());
        
        //listaLineasInvestigador = (List<LineasInvestigador>) new ListDataModel(ejbFacadeLineasInvestigador.findAll());
        //investigadorActual.setLineasInvestigadorList((List<LineasInvestigador>) listaLineasInvestigador);
        }catch(Exception e){
            System.out.println("Error Mostrando detalles Investigador!");
        }       
        return "/portal/investigadoresDetalle.xhtml?faces-redirect=true";        
    }

    // Getters/Setters
    /* public List<LineasInvestigador> getListaLineasInvestigador() {
    return listaLineasInvestigador;
    }
    public void setListaLineasInvestigador(List<LineasInvestigador> listaLineasInvestigador) {
    this.listaLineasInvestigador = listaLineasInvestigador;
    }*/
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

    public DataModel getLineasInvestigadorList() {
        return lineasInvestigadorList;
    }

    public void setLineasInvestigadorList(DataModel lineasInvestigadorList) {
        this.lineasInvestigadorList = lineasInvestigadorList;
    }
    
}
