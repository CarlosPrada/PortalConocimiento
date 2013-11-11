package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import uis.giib.entidades.ImagenPortal;

/**
 *
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Named(value = "imagenPC")
@SessionScoped
public class imagenPortalController implements Serializable {

    //Atributos
    @EJB
    private uis.giib.administrador.dao.ImagenPortalFacade ejbImagenPortal;
    private ImagenPortal imagenSlider[] = new ImagenPortal[4];
    private ImagenPortal imagen;

    //Contructor
    public imagenPortalController() {
    }

    /**
     * Método que guarda las imágenes consultadas para que estas sean mostradas
     * en el slider
     */
    @PostConstruct
    public void cargarEnlaces() {
        imagenSlider[0] = obtenerImgen(1);
        imagenSlider[1] = obtenerImgen(2);
        imagenSlider[2] = obtenerImgen(3);
        imagenSlider[3] = obtenerImgen(4);
    }

    /**
     * Método que obtiene una imágen almacenadas en la DB según un ID
     *
     * @param ID Id de la imagen a consultar en la DB
     * @return Imagen de la DB
     */
    public ImagenPortal obtenerImgen(int ID) {
        imagen = ejbImagenPortal.buscarImagenPortalPorID(ID);
        return imagen;
    }

    //Getters - Setters
    public uis.giib.administrador.dao.ImagenPortalFacade getEjbImagenPortal() {
        return ejbImagenPortal;
    }

    public void setEjbImagenPortal(uis.giib.administrador.dao.ImagenPortalFacade ejbImagenPortal) {
        this.ejbImagenPortal = ejbImagenPortal;
    }

    public ImagenPortal[] getImagenSlider() {
        return imagenSlider;
    }

    public void setImagenSlider(ImagenPortal[] imagenSlider) {
        this.imagenSlider = imagenSlider;
    }

    public ImagenPortal getImagen() {
        return imagen;
    }

    public void setImagen(ImagenPortal imagen) {
        this.imagen = imagen;
    }
}
