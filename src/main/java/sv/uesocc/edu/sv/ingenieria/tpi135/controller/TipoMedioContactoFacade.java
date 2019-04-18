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
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoMedioContacto;

/**
 *
 * @author gochez
 */
@Stateless
public class TipoMedioContactoFacade extends AbstractFacade<TipoMedioContacto>{

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMedioContactoFacade() {
        super(TipoMedioContacto.class);
    }


    
}
