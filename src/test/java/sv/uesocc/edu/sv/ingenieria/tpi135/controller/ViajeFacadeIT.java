/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.powermock.reflect.Whitebox;
import static sv.uesocc.edu.sv.ingenieria.tpi135.controller.EntityManagerProvider.persistenceUnit;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author gochez
 */
public class ViajeFacadeIT extends AbstractFacadeINT<Viaje> {

    public ViajeFacadeIT() {
    }

    @Rule
    public EntityManagerProvider emProvider = persistenceUnit("pu-test");

    @Test
    public void testFindByConductor() throws Exception {
        System.out.println("findByConductor");
        int idUsuario = 0;
        ViajeFacade instance = new ViajeFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        List<Viaje> result = instance.findByConductor(idUsuario);
        assertEquals(0, result.size());
    }

    /**
     * Test of findByDia method, of class ViajeFacade.
     */
    @Test
    public void testFindByDia() throws Exception {
        System.out.println("findByDia");
        int dia = 0;
        ViajeFacade instance = new ViajeFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        List<Viaje> result = instance.findByDia(dia);
        assertEquals(0, result.size());
    }

    /**
     * Test of findxCiudadOrigen method, of class ViajeFacade.
     */
     @Test
    public void testFindxCiudadOrigen() throws Exception {
        System.out.println("findxCiudadOrigen");
        ViajeFacade instance = new ViajeFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        List<Viaje> result = instance.findxCiudadOrigen();
        assertNotNull(result);
    }

    @Override
    protected AbstractFacade<Viaje> getFacade() {
        return new ViajeFacade();
    }

    @Override
    protected EntityManager getEntityManager() {
        return emProvider.em();
    }

    @Override
    protected Viaje getEntity() {
        return new Viaje(1);
    }

}
