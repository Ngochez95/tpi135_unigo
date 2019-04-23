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
import static sv.uesocc.edu.sv.ingenieria.tpi135.controller.EntityManagerProvider.persistenceUnit;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author gochez
 */
public class ViajeFacadeIT extends AbstractFacadeINT<Viaje>{
    
    public ViajeFacadeIT() {
    }
    
     @Rule
    public EntityManagerProvider emProvider = persistenceUnit("pu-test");
    
   
   // @Test
    public void testFindByConductor() throws Exception {
        System.out.println("findByConductor");
        int idUsuario = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ViajeFacade instance = (ViajeFacade)container.getContext().lookup("java:global/classes/ViajeFacade");
        List<Viaje> expResult = null;
        List<Viaje> result = instance.findByConductor(idUsuario);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByDia method, of class ViajeFacade.
     */
   /// @Test
    public void testFindByDia() throws Exception {
        System.out.println("findByDia");
        int dia = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ViajeFacade instance = (ViajeFacade)container.getContext().lookup("java:global/classes/ViajeFacade");
        List<Viaje> expResult = null;
        List<Viaje> result = instance.findByDia(dia);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findxCiudadOrigen method, of class ViajeFacade.
     */
   // @Test
    public void testFindxCiudadOrigen() throws Exception {
        System.out.println("findxCiudadOrigen");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ViajeFacade instance = (ViajeFacade)container.getContext().lookup("java:global/classes/ViajeFacade");
        List<Viaje> expResult = null;
        List<Viaje> result = instance.findxCiudadOrigen();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
