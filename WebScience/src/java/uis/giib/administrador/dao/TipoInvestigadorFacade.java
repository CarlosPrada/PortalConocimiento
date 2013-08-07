/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uis.giib.entidades.TipoInvestigador;

/**
 *
 * @author Carlos Humberto
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
    
}
