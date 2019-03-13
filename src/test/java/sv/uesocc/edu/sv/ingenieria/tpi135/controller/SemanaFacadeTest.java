/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;


import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Semana;

/**
 *
 * @author gochez
 */
public class SemanaFacadeTest {
    
    public SemanaFacadeTest() {
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
     * Test of create method, of class SemanaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EntityManager em = Mockito.mock(EntityManager.class);
        Semana medio = new Semana();
        medio.setIdDia(1);
        SemanaFacade facade = new SemanaFacade();
        Semana devolver = new Semana(1);
        Mockito.when(em.find(Semana.class, 1)).thenReturn(devolver);
        Whitebox.setInternalState(facade, "em", em);
        facade.create(medio);
        Semana encontrado = facade.find(1);
        int esperado=0;

        if (encontrado.getIdDia() == 1) {
            esperado = encontrado.getIdDia();
        }
        facade.create(medio);
        assertEquals(esperado, 1);
    }

    /**
     * Test of edit method, of class SemanaFacade.
     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        Semana entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        SemanaFacadeLocal instance = (SemanaFacadeLocal)container.getContext().lookup("java:global/classes/SemanaFacade");
//        instance.edit(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of remove method, of class SemanaFacade.
     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        Semana entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        SemanaFacadeLocal instance = (SemanaFacadeLocal)container.getContext().lookup("java:global/classes/SemanaFacade");
//        instance.remove(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of find method, of class SemanaFacade.
     */
    @Test
    public void testFind() throws Exception {
       System.out.println("Método Find");
        EntityManager em = Mockito.mock(EntityManager.class);
        SemanaFacade cut = new SemanaFacade();
        Whitebox.setInternalState(cut, "em", em);
        Mockito.when(em.find(Semana.class, 1)).thenReturn(new Semana(1));
        Semana esperado = cut.find(1);
        System.out.println("hola" + esperado.toString());
        assertEquals(new Semana(1), esperado);
    }

    /**
     * Test of findAll method, of class SemanaFacade.
     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        SemanaFacadeLocal instance = (SemanaFacadeLocal)container.getContext().lookup("java:global/classes/SemanaFacade");
//        List<Semana> expResult = null;
//        List<Semana> result = instance.findAll();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of findRange method, of class SemanaFacade.
     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        SemanaFacadeLocal instance = (SemanaFacadeLocal)container.getContext().lookup("java:global/classes/SemanaFacade");
//        List<Semana> expResult = null;
//        List<Semana> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of count method, of class SemanaFacade.
     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        SemanaFacadeLocal instance = (SemanaFacadeLocal)container.getContext().lookup("java:global/classes/SemanaFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
