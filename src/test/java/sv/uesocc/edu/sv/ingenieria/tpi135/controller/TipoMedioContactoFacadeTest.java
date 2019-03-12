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
import org.mockito.Mockito;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoMedioContacto;

/**
 *
 * @author gochez
 */
public class TipoMedioContactoFacadeTest {

    public TipoMedioContactoFacadeTest() {
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
     * Test of create method, of class TipoMedioContactoFacade.
     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        TipoMedioContacto entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TipoMedioContactoFacadeLocal instance = (TipoMedioContactoFacadeLocal)container.getContext().lookup("java:global/classes/TipoMedioContactoFacade");
//        instance.create(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class TipoMedioContactoFacade.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        TipoMedioContacto entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TipoMedioContactoFacadeLocal instance = (TipoMedioContactoFacadeLocal)container.getContext().lookup("java:global/classes/TipoMedioContactoFacade");
//        instance.edit(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class TipoMedioContactoFacade.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        TipoMedioContacto entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TipoMedioContactoFacadeLocal instance = (TipoMedioContactoFacadeLocal)container.getContext().lookup("java:global/classes/TipoMedioContactoFacade");
//        instance.remove(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of find method, of class TipoMedioContactoFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("Método Find");
        EntityManager em = Mockito.mock(EntityManager.class);
        TipoMedioContactoFacade cut = new TipoMedioContactoFacade();
        cut.em = em;
        Mockito.when(em.find(TipoMedioContacto.class, 1)).thenReturn(new TipoMedioContacto(1));
        TipoMedioContacto esperado = cut.find(1);
        System.out.println("hola"+esperado.toString());
        assertEquals(new TipoMedioContacto(1), esperado);

    }

    /**
     * Test of findAll method, of class TipoMedioContactoFacade.
     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TipoMedioContactoFacadeLocal instance = (TipoMedioContactoFacadeLocal) container.getContext().lookup("java:global/classes/TipoMedioContactoFacade");
//        List<TipoMedioContacto> expResult = null;
//        List<TipoMedioContacto> result = instance.findAll();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findRange method, of class TipoMedioContactoFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TipoMedioContactoFacadeLocal instance = (TipoMedioContactoFacadeLocal)container.getContext().lookup("java:global/classes/TipoMedioContactoFacade");
//        List<TipoMedioContacto> expResult = null;
//        List<TipoMedioContacto> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class TipoMedioContactoFacade.
//     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TipoMedioContactoFacadeLocal instance = (TipoMedioContactoFacadeLocal)container.getContext().lookup("java:global/classes/TipoMedioContactoFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
