package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.Bibliografia;

/**
 *
 * @author Carlos David Prada Remolina  
 * @version 1.0 
 * since 10/08/2013
 */
@Stateless
public class BibliografiaFacade extends AbstractFacade<Bibliografia> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BibliografiaFacade() {
        super(Bibliografia.class);
    }
    /**
     * 
     * @return 
     */

    public List<Bibliografia> listarBibliografia() {
        try {
            Query query = em.createNamedQuery("Bibliografia.findBibliografiaByEstado");
            return (List<Bibliografia>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Bibliografia> listarBuscador(String buscar) {
        try {
            Query query = em.createNamedQuery("Bibliografia.findBibliografiaByBuscador");
            query.setParameter("buscar","%" + buscar + "%" );
            return (List<Bibliografia>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
