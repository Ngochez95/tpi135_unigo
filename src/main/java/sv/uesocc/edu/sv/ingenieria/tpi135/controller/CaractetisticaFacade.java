/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;

/**
 *
 * @author Zepeda Abrego, Juan Carlos
 */
@Stateless
public class CaractetisticaFacade extends AbstractFacade<Caractetistica> implements CaractetisticaFacadeLocal {

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaractetisticaFacade() {
        super(Caractetistica.class);
    }
    
}
