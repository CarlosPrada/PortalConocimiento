package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Cristhian Ruiz
 * @author Carlos David Prada Remolina
 */
@Named(value = "noticiasPC")
@SessionScoped
public class NoticiasPortalController implements Serializable {

    //Atributos
    private DataModel listadoNoticias;
    @EJB
    private uis.giib.administrador.dao.NoticiaFacade ejbNoticia;

    public NoticiasPortalController() {

        /*try {

         tipoContenido = ejbFacade.buscarContenidoPorTipo(idTipo);
         listadoNoticias = new ListDataModel(tipoContenido.getContenidoList());
         } catch (Exception e) {
         System.out.println("Error listando Noticias!");
         }*/
    }

    public String goNoticiasPortalController() {

        try {
            listadoNoticias = new ListDataModel(ejbNoticia.findAll());
        } catch (Exception e) {
            System.out.println("Error al listar noticias");
        }

        return "/portal/noticias.xhtml?faces-redirect=true";
    }

    public DataModel getListadoNoticias() {
        return listadoNoticias;
    }

    public void setListadoNoticias(DataModel listadoNoticias) {
        this.listadoNoticias = listadoNoticias;
    }
}
