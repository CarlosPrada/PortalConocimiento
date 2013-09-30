package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.entidades.Noticia;

/**
 *
 * @author Cristhian Ruiz
 * @author Carlos David Prada Remolina
 */
@Named(value = "noticiasPC")
@SessionScoped
public class NoticiasPortalController implements Serializable {

    //Atributos
    private List<Noticia> listadoNoticias;
    @EJB
    private uis.giib.administrador.dao.NoticiaFacade ejbNoticia;

    //Constructor
    public NoticiasPortalController() {
    }

    //Métodos de Navegación
    public String goNoticiasPortalController() {
        try {
            listadoNoticias = ejbNoticia.listarNoticias();
        } catch (Exception e) {
            System.out.println("Error al listar noticias");
        }
        return "/portal/noticias.xhtml?faces-redirect=true";
    }

    //Getters - Setters
    public List<Noticia> getListadoNoticias() {
        return listadoNoticias;
    }

    public void setListadoNoticias(List<Noticia> listadoNoticias) {
        this.listadoNoticias = listadoNoticias;
    }

    public uis.giib.administrador.dao.NoticiaFacade getEjbNoticia() {
        return ejbNoticia;
    }

    public void setEjbNoticia(uis.giib.administrador.dao.NoticiaFacade ejbNoticia) {
        this.ejbNoticia = ejbNoticia;
    }
}
