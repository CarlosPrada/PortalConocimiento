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
import uis.giib.entidades.Proyecto;
import uis.giib.entidades.TipoPublicacion;

/**
 *
 * @author Carlos Humberto
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
    
            public Proyecto buscarProyectosPorEstado(Integer idEstado) {
        try {
            Query query = em.createNamedQuery("Proyecto.findByIdEstadoProyecto");
            query.setParameter("idEstado", idEstado);
            return (Proyecto)query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
