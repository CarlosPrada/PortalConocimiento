package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.Proyecto;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Stateless
public class ProyectoFacade extends AbstractFacade<Proyecto> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }

    public List<Proyecto> listarProyecto() {
        try {
            Query query = em.createNamedQuery("Proyecto.findByEstado");
            return (List<Proyecto>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }

    }
}
