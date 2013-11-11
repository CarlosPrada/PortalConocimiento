package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.TipoInvestigador;

/**
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Stateless
public class TipoInvestigadorFacade extends AbstractFacade<TipoInvestigador> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoInvestigadorFacade() {
        super(TipoInvestigador.class);
    }

    public List<TipoInvestigador> listarInvestigadores() {
        try {
            Query query = em.createNamedQuery("TipoInvestigador.findInvestigadorByEstado");
            return (List<TipoInvestigador>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
