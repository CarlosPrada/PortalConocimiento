package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.ImagenPortal;

/**
 * @author Carlos David Prada Remolina
 * @version 1.0
 * @since 10/10/2013
 */
@Stateless
public class ImagenPortalFacade extends AbstractFacade<ImagenPortal> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenPortalFacade() {
        super(ImagenPortal.class);
    }

    public ImagenPortal buscarImagenPortalPorID(Integer idImagenPortal) {
        try {
            Query query = em.createNamedQuery("ImagenPortal.findByIdImagen");
            query.setParameter("idImagen", idImagenPortal);
            return (ImagenPortal) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
