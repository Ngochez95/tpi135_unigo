/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;

/**
 *
 * @author gochez
 */
public class TrayectoriaFacadeTest {

    public TrayectoriaFacadeTest() {
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
     * Test of create method, of class TrayectoriaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EntityManager em = Mockito.mock(EntityManager.class);
        Trayectoria medio = new Trayectoria();
        medio.setIdTrayectoria(1);
        TrayectoriaFacade facade = new TrayectoriaFacade();
        Trayectoria devolver = new Trayectoria(1);
        Mockito.when(em.find(Trayectoria.class, 1)).thenReturn(devolver);
        Whitebox.setInternalState(facade, "em", em);
        facade.create(medio);
        Trayectoria encontrado = facade.find(1);
        int esperado = 0;

        if (encontrado.getIdTrayectoria() == 1) {
            esperado = encontrado.getIdTrayectoria();
        }
        facade.create(medio);
        assertEquals(esperado, 1);
    }

    /**
     * Test of edit method, of class TrayectoriaFacade.
     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        Trayectoria entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TrayectoriaFacadeLocal instance = (TrayectoriaFacadeLocal)container.getContext().lookup("java:global/classes/TrayectoriaFacade");
//        instance.edit(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of remove method, of class TrayectoriaFacade.
     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        Trayectoria entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TrayectoriaFacadeLocal instance = (TrayectoriaFacadeLocal)container.getContext().lookup("java:global/classes/TrayectoriaFacade");
//        instance.remove(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of find method, of class TrayectoriaFacade.
     */
    @Test
    public void testFind() throws Exception {

        System.out.println("Método Find");
        EntityManager em = Mockito.mock(EntityManager.class);
        TrayectoriaFacade cut = new TrayectoriaFacade();
        Whitebox.setInternalState(cut, "em", em);
        Mockito.when(em.find(Trayectoria.class, 1)).thenReturn(new Trayectoria(1));
        Trayectoria esperado = cut.find(1);
        System.out.println("hola" + esperado.toString());
        assertEquals(new Trayectoria(1), esperado);

    }

    /**
     * Test of findAll method, of class TrayectoriaFacade.
     */
    @Test
    public void testFindAll() throws Exception {
 System.out.println("findAll");
        EntityManager em = Mockito.mock(EntityManager.class);
        javax.persistence.criteria.CriteriaQuery cq = Mockito.mock(javax.persistence.criteria.CriteriaQuery.class);
        TypedQuery tq = Mockito.mock(TypedQuery.class);
        CriteriaBuilder cbr = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(em.getCriteriaBuilder()).thenReturn(cbr);
        Mockito.when(em.createQuery(cq)).thenReturn(tq);
        Mockito.when(em.getCriteriaBuilder().createQuery()).thenReturn(cq);
        Mockito.when(em.createQuery(cq).getResultList()).thenReturn(new ArrayList());
        TrayectoriaFacade cut = new TrayectoriaFacade();
        Whitebox.setInternalState(cut, "em", em);
        int expResult = 0;
        int esperado = cut.findAll().size();

        assertEquals(expResult, esperado);
    }

    /**
     * Test of findRange method, of class TrayectoriaFacade.
     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TrayectoriaFacadeLocal instance = (TrayectoriaFacadeLocal)container.getContext().lookup("java:global/classes/TrayectoriaFacade");
//        List<Trayectoria> expResult = null;
//        List<Trayectoria> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of count method, of class TrayectoriaFacade.
     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        TrayectoriaFacadeLocal instance = (TrayectoriaFacadeLocal)container.getContext().lookup("java:global/classes/TrayectoriaFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
