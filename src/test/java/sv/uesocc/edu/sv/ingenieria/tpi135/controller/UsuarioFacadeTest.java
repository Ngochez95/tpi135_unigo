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

/**
 *
 * @author gochez
 */
public class UsuarioFacadeTest {
    
    public UsuarioFacadeTest() {
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
     * Test of create method, of class UsuarioFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EntityManager em = Mockito.mock(EntityManager.class);
        Usuario medio = new Usuario();
        medio.setIdUsuario(1);
        UsuarioFacade facade = new UsuarioFacade();
        Usuario devolver = new Usuario(1);
        Mockito.when(em.find(Usuario.class, 1)).thenReturn(devolver);
        Whitebox.setInternalState(facade, "em", em);
        facade.create(medio);
        Usuario encontrado = facade.find(1);
        int esperado=0;

        if (encontrado.getIdUsuario() == 1) {
            esperado = encontrado.getIdUsuario();
        }
        facade.create(medio);
        assertEquals(esperado, 1);
    }

    /**
     * Test of edit method, of class UsuarioFacade.
     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        Usuario entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioFacadeLocal instance = (UsuarioFacadeLocal)container.getContext().lookup("java:global/classes/UsuarioFacade");
//        instance.edit(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of remove method, of class UsuarioFacade.
     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        Usuario entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioFacadeLocal instance = (UsuarioFacadeLocal)container.getContext().lookup("java:global/classes/UsuarioFacade");
//        instance.remove(entity);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of find method, of class UsuarioFacade.
     */
    @Test
    public void testFind() throws Exception {
       System.out.println("Método Find");
        EntityManager em = Mockito.mock(EntityManager.class);
        UsuarioFacade cut = new UsuarioFacade();
        Whitebox.setInternalState(cut, "em", em);
        Mockito.when(em.find(Usuario.class, 1)).thenReturn(new Usuario(1));
        Usuario esperado = cut.find(1);
        System.out.println("hola" + esperado.toString());
        assertEquals(new Usuario(1), esperado);
    }

    /**
     * Test of findAll method, of class UsuarioFacade.
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
        UsuarioFacade cut = new UsuarioFacade();
        Whitebox.setInternalState(cut, "em", em);
        int expResult = 0;
        int esperado = cut.findAll().size();

        assertEquals(expResult, esperado);
    }

    /**
     * Test of findRange method, of class UsuarioFacade.
     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioFacadeLocal instance = (UsuarioFacadeLocal)container.getContext().lookup("java:global/classes/UsuarioFacade");
//        List<Usuario> expResult = null;
//        List<Usuario> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of count method, of class UsuarioFacade.
     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsuarioFacadeLocal instance = (UsuarioFacadeLocal)container.getContext().lookup("java:global/classes/UsuarioFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
