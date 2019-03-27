/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Origen;

/**
 *
 * @author gochez
 */
@Stateless
public class OrigenFacade extends AbstractFacade<Origen> implements OrigenFacadeLocal {

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrigenFacade() {
        super(Origen.class);
    }

    @Override
    public List findRange(int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
