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
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
public class VehiculoFacadeTest {

    public VehiculoFacadeTest() {
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
     * Test of create method, of class VehiculoFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EntityManager em = Mockito.mock(EntityManager.class);
        Vehiculo medio = new Vehiculo();
        medio.setIdVehiculo(1);
        VehiculoFacade facade = new VehiculoFacade();
        Vehiculo devolver = new Vehiculo(1);
        Mockito.when(em.find(Vehiculo.class, 1)).thenReturn(devolver);
        Whitebox.setInternalState(facade, "em", em);
        facade.create(medio);
        Vehiculo encontrado = facade.find(1);
        int esperado = 0;

        if (encontrado.getIdVehiculo() == 1) {
            esperado = encontrado.getIdVehiculo();
        }
        facade.create(medio);
        assertEquals(esperado, 1);
    }

    /**
     * Test of edit method, of class VehiculoFacade.
     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        Vehiculo entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        VehiculoFacadeLocal instance = (VehiculoFacadeLocal)container.getContext().lookup("java:global/classes/VehiculoFacade");
//        instance.edit(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of remove method, of class VehiculoFacade.
     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        Vehiculo entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        VehiculoFacadeLocal instance = (VehiculoFacadeLocal)container.getContext().lookup("java:global/classes/VehiculoFacade");
//        instance.remove(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of find method, of class VehiculoFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("Método Find");
        EntityManager em = Mockito.mock(EntityManager.class);
        VehiculoFacade cut = new VehiculoFacade();
        Whitebox.setInternalState(cut, "em", em);
        Mockito.when(em.find(Vehiculo.class, 1)).thenReturn(new Vehiculo(1));
        Vehiculo esperado = cut.find(1);
        System.out.println("hola" + esperado.toString());
        assertEquals(new Vehiculo(1), esperado);
    }

    /**
     * Test of findAll method, of class VehiculoFacade.
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
        VehiculoFacade cut = new VehiculoFacade();
        Whitebox.setInternalState(cut, "em", em);
        int expResult = 0;
        int esperado = cut.findAll().size();

        assertEquals(expResult, esperado);
    }

    /**
     * Test of findRange method, of class VehiculoFacade.
     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        VehiculoFacadeLocal instance = (VehiculoFacadeLocal)container.getContext().lookup("java:global/classes/VehiculoFacade");
//        List<Vehiculo> expResult = null;
//        List<Vehiculo> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of count method, of class VehiculoFacade.
     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        VehiculoFacadeLocal instance = (VehiculoFacadeLocal)container.getContext().lookup("java:global/classes/VehiculoFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
