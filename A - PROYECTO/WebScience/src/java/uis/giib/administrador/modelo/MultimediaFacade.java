/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uis.giib.entidades.Multimedia;

/**
 *
 * @author User
 */
@Stateless
public class MultimediaFacade extends AbstractFacade<Multimedia> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MultimediaFacade() {
        super(Multimedia.class);
    }
    
}
