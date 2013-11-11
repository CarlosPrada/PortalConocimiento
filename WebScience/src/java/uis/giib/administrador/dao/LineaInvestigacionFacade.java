package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.LineaInvestigacion;

/**
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Stateless
public class LineaInvestigacionFacade extends AbstractFacade<LineaInvestigacion> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaInvestigacionFacade() {
        super(LineaInvestigacion.class);
    }

    public List<LineaInvestigacion> listarLineaInvestigacion() {
        try {
            Query query = em.createNamedQuery("LineaInvestigacion.findLineaInvestigacionByEstado");
            return (List<LineaInvestigacion>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<LineaInvestigacion> listarBuscador(String buscar) {
        try {
            Query query = em.createNamedQuery("LineaInvestigacion.findByBuscador");
            query.setParameter("buscar", "%" + buscar + "%");
            return (List<LineaInvestigacion>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
