/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static sv.uesocc.edu.sv.ingenieria.tpi135.controller.EntityManagerProvider.persistenceUnit;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;


/**
 *
 * @author gochez
 */
public class VehiculoFacadeIT extends AbstractFacadeINT<Vehiculo> {

    @Rule
    public EntityManagerProvider emProvider = persistenceUnit("pu-test");
    public VehiculoFacadeIT() {

    }

    @Override
    protected AbstractFacade<Vehiculo> getFacade() {
        return new VehiculoFacade();
    }

    @Override
    protected EntityManager getEntityManager() {
        return emProvider.em();
      }

    @Override
    protected Vehiculo getEntity() {
        return new Vehiculo();
        }
    

}
