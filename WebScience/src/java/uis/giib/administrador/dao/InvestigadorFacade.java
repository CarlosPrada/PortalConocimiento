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
 * @author Carlos David Prada Remolina
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

    public List<Investigador> listarInvestigadores() {
        try {
            Query query = em.createNamedQuery("Investigador.findInvestigadorByEstado");
            return (List<Investigador>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Investigador buscarPorIDUsuario(String IDUsuario) {
        try {
            Query query = em.createNamedQuery("Investigador.findByUsuarioInvestigador");
            query.setParameter("usuarioInvestigador", IDUsuario);
            return (Investigador) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Investigador> listarBuscador(String buscar) {
        try {
            Query query = em.createNamedQuery("Investigador.findByBuscador");
            query.setParameter("buscar", "%" + buscar + "%");
            return (List<Investigador>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
