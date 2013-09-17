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
import uis.giib.entidades.Investigador;

/**
 *
 * @author Carlos Humberto
 */
@Stateless
public class InvestigadorFacade extends AbstractFacade<Investigador> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvestigadorFacade() {
        super(Investigador.class);
    }

    
    public Investigador loginAdministrador(String user, String password) {

        try {
            Query query = em.createNamedQuery("Investigador.findByLoginParameters");
            query.setParameter("usuarioInvestigador", user);
            query.setParameter("contrasenaInvestigador", password);
            return (Investigador) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }  
    
    public List<Investigador> findByIdEstado(Integer idEstado) {

        try {
            Query query = em.createNamedQuery("Investigador.findByIdEstado");
            query.setParameter("idEstado", idEstado);
            return (List<Investigador>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("Error en la consulta findByIdEstado!" + e.getLocalizedMessage());
            return null;
        }
    }    
}
