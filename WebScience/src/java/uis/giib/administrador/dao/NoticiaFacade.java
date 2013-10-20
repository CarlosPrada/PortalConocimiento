package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.Noticia;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Stateless
public class NoticiaFacade extends AbstractFacade<Noticia> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoticiaFacade() {
        super(Noticia.class);
    }

    public List<Noticia> listarNoticias() {
        try {
            Query query = em.createNamedQuery("Noticia.findByEstado");
            return (List<Noticia>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Noticia> listarBuscador(String buscar) {
        try {
            Query query = em.createNamedQuery("Noticia.findByBuscador");
            query.setParameter("buscar", "%" + buscar + "%");
            return (List<Noticia>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
