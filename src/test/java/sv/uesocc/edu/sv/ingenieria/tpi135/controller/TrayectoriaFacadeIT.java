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
import static org.junit.Assert.*;
import org.junit.Rule;
import static sv.uesocc.edu.sv.ingenieria.tpi135.controller.EntityManagerProvider.persistenceUnit;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;

/**
 *
 * @author gochez
 */
public class TrayectoriaFacadeIT extends AbstractFacadeINT<Trayectoria> {

    @Rule
    public EntityManagerProvider emProvider = persistenceUnit("pu-test");

    public TrayectoriaFacadeIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of loggerSevere method, of class TrayectoriaFacade.
     */
    //@Test
    public void testFindByReferencia() throws Exception {
        System.out.println("findByReferencia");
        int idReferencia = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TrayectoriaFacade instance = (TrayectoriaFacade) container.getContext().lookup("java:global/classes/TrayectoriaFacade");
        List<Trayectoria> expResult = null;
        List<Trayectoria> result = instance.findByReferencia(idReferencia);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Override
    protected AbstractFacade<Trayectoria> getFacade() {
        return new TrayectoriaFacade();
    }

    @Override
    protected EntityManager getEntityManager() {
        return emProvider.em();
    }

    @Override
    protected Trayectoria getEntity() {
        return new Trayectoria(1);
    }

}
