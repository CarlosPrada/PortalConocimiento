package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.ProduccionIntelectual;

/**
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Stateless
public class ProduccionIntelectualFacade extends AbstractFacade<ProduccionIntelectual> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduccionIntelectualFacade() {
        super(ProduccionIntelectual.class);
    }

    public List<ProduccionIntelectual> listarProduccionIntelectual() {
        try {
            Query query = em.createNamedQuery("ProduccionIntelectual.findBibliografiaByEstado");
            return (List<ProduccionIntelectual>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<ProduccionIntelectual> listarBuscador(String buscar) {
        try {
            Query query = em.createNamedQuery("ProduccionIntelectual.findByBuscador");
            query.setParameter("buscar", "%" + buscar + "%");
            return (List<ProduccionIntelectual>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
