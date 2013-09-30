package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.EnlacesWeb;

/**
 * @author Carlos David Prada Remolina
 * @author cristhian ruiz
 */
@Stateless
public class EnlacesWebFacade extends AbstractFacade<EnlacesWeb> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnlacesWebFacade() {
        super(EnlacesWeb.class);
    }

    public EnlacesWeb buscarEnlaceWebPorID(Integer idEnlaceWeb) {
        try {
            Query query = em.createNamedQuery("EnlacesWeb.findByIdEnlace");
            query.setParameter("idEnlace", idEnlaceWeb);
            return (EnlacesWeb) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }   
}
