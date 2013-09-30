package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.TipoInvestigador;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "investigadorPC")
@SessionScoped
public class InvestigadorPortalController implements Serializable {

    //Atributos
    private List<Investigador> listadoInvestigador;
    private DataModel listaTiposInvestigador;
    private Investigador investigadorActual;
    @EJB
    private uis.giib.administrador.dao.TipoInvestigadorFacade ejbTipoInvestigador;
    @EJB
    private uis.giib.administrador.dao.InvestigadorFacade ejbInvestigador;

    //constructor
    public InvestigadorPortalController() {
    }

    //Métodos de navegación
    /**
     * Método que redirige al usuario a la página de investigadores.xhtml
     *
     * @return Dirección de la página de investigadores.xhtml
     */
    public String goInvestigadores() {

        try {
            listaTiposInvestigador = new ListDataModel(ejbTipoInvestigador.findAll());
            listadoInvestigador = ejbInvestigador.listarInvestigadores();
            Iterator<TipoInvestigador> tipoInvIterator = listaTiposInvestigador.iterator();

            while (tipoInvIterator.hasNext()) {
                TipoInvestigador tipoInv = tipoInvIterator.next();
                tipoInv.getInvestigadorList().retainAll(listadoInvestigador);
            }

        } catch (Exception e) {
            System.out.println("Error listando investitadores GoInvestigador!" + e.getLocalizedMessage() + " " + e.getMessage());
        }
        return "/portal/investigadores.xhtm?faces-redirect=truel";
    }

    /**
     * Método que redirige al usuario a la página de investigadoresDetalle.xhtml
     *
     * @param investigador: Objeto que contiene el investigdor cuyos detalles
     * serán explorados
     * @return Dirección de la página de investigadoresDetalle.xhtml
     */
    public String goDetallesInvestigador(Investigador investigador) {

        try {
            investigadorActual = (Investigador) investigador;
        } catch (Exception e) {
            System.out.println("Error Mostrando detalles Investigador!");
        }
        return "/portal/investigadoresDetalle.xhtml?faces-redirect=true";
    }

    // Getters - Setters   
    public List<Investigador> getListadoInvestigador() {
        return listadoInvestigador;
    }

    public void setListadoInvestigador(List<Investigador> listadoInvestigador) {
        this.listadoInvestigador = listadoInvestigador;
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

    public uis.giib.administrador.dao.TipoInvestigadorFacade getEjbTipoInvestigador() {
        return ejbTipoInvestigador;
    }

    public void setEjbTipoInvestigador(uis.giib.administrador.dao.TipoInvestigadorFacade ejbTipoInvestigador) {
        this.ejbTipoInvestigador = ejbTipoInvestigador;
    }

    public uis.giib.administrador.dao.InvestigadorFacade getEjbInvestigador() {
        return ejbInvestigador;
    }

    public void setEjbInvestigador(uis.giib.administrador.dao.InvestigadorFacade ejbInvestigador) {
        this.ejbInvestigador = ejbInvestigador;
    }
}
