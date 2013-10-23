package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.Contacto;

/**
 *
 *  * @author Carlos David Prada Remolina  * @version 1.0  * @since 10/10/2013
 */
@Stateless
public class ContactoFacade extends AbstractFacade<Contacto> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoFacade() {
        super(Contacto.class);
    }

    public Contacto buscarPorIDContacto(String IDContacto) {
        try {
            Query query = em.createNamedQuery("Contacto.findByIdContacto");
            query.setParameter("idContacto", IDContacto);
            return (Contacto) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
