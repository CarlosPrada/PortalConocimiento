package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.HerramientaSoftware;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Stateless
public class HerramientaSoftwareFacade extends AbstractFacade<HerramientaSoftware> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HerramientaSoftwareFacade() {
        super(HerramientaSoftware.class);
    }

    public List<HerramientaSoftware> listarHerramientaSoftware() {
        try {
            Query query = em.createNamedQuery("HerramientaSoftware.findHerramientaSoftwareByEstado");
            return (List<HerramientaSoftware>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<HerramientaSoftware> listarBuscador(String buscar) {
        try {
            Query query = em.createNamedQuery("HerramientaSoftware.findByBuscador");
            query.setParameter("buscar", "%" + buscar + "%");
            return (List<HerramientaSoftware>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
