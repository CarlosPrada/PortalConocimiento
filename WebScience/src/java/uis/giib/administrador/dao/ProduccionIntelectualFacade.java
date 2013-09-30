/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.ProduccionIntelectual;

/**
 *
 * @author Carlos
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
    
}
