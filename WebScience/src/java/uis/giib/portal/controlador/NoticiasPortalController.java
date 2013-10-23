package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import uis.giib.entidades.Noticia;

/**
 *
 * @author Cristhian Ruiz
 *  * @author Carlos David Prada Remolina  * @version 1.0  * @since 10/10/2013
 */
@Named(value = "noticiasPC")
@SessionScoped
public class NoticiasPortalController implements Serializable {

    //Atributos
    @EJB
    private uis.giib.administrador.dao.NoticiaFacade ejbNoticia;
    private List<Noticia> listadoNoticias;

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
    
    @PostConstruct
    public void inicializacion(){
        listadoNoticias = ejbNoticia.listarNoticias();
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
