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
import uis.giib.entidades.Publicacion;
import uis.giib.entidades.TipoPublicacion;

/**
 *
 * @author Carlos Humberto
 */
@Stateless
public class TipoPublicacionFacade extends AbstractFacade<TipoPublicacion> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPublicacionFacade() {
        super(TipoPublicacion.class);
    }
    
    public Publicacion findByNombreTipoPublicacion(String nombreTipoPublicacion) {

        try {
            Query query = em.createNamedQuery("TipoPublicacion.findByNombreTipoPublicacion");
            query.setParameter("nombreTipoPublicacion", nombreTipoPublicacion);
            return (Publicacion) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public TipoPublicacion buscarPublicacionesPorTipo(Integer idTipoPublicacion) {
        try {
            Query query = em.createNamedQuery("TipoPublicacion.findByIdTipoPublicacion");
            query.setParameter("idTipoPublicacion", idTipoPublicacion);
            return (TipoPublicacion)query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
