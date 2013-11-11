package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.MensajePortal;

/**
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Stateless
public class MensajePortalFacade extends AbstractFacade<MensajePortal> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajePortalFacade() {
        super(MensajePortal.class);
    }

    public List<MensajePortal> listarMensajePortal() {
        try {
            Query query = em.createNamedQuery("MensajePortal.findByEstado");
            return (List<MensajePortal>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
