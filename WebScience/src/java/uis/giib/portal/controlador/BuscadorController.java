package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "buscadorC")
@SessionScoped
public class BuscadorController implements Serializable {

    /**
     * Creates a new instance of BuscadorController
     */
    public BuscadorController() {
    }
}
