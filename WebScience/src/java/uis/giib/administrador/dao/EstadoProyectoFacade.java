/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.EstadoProyecto;
import uis.giib.entidades.TipoPublicacion;

/**
 *
 * @author Carlos Humberto
 */
@Stateless
public class EstadoProyectoFacade extends AbstractFacade<EstadoProyecto> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoProyectoFacade() {
        super(EstadoProyecto.class);
    }
    
        public TipoPublicacion buscarProyectosPorEstado(Integer idEstado) {
        try {
            Query query = em.createNamedQuery("EstadoProyecto.findByIdEstadoProyecto");
            query.setParameter("idEstado", idEstado);
            return (TipoPublicacion)query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
