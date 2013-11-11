package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uis.giib.entidades.TipoProduccion;

/**
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Stateless
public class TipoProduccionFacade extends AbstractFacade<TipoProduccion> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProduccionFacade() {
        super(TipoProduccion.class);
    }
}
