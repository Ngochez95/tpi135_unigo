/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Selection;
import javax.swing.text.DefaultEditorKit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;

/**
 *
 * @author gochez, zepeda abrego
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractFacadeT<T> {
    
    
    
    private Class<T> entityClass;

    protected abstract AbstractFacade<T> getFacade();

    protected abstract T getEntity();

    @Mock
    private EntityManager emMock;

    @Before
    public void setUp() {
        T nuevo = getEntity();
        Mockito.when(this.emMock.find(entityClass, 1)).thenReturn(nuevo);
        
        
       
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class AbstractFacade.
     */
//    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        AbstractFacade instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class AbstractFacade.
     */
    @Test
    public void testCreate() {
        T entity = getEntity();
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", emMock);
        instance.create(entity);
        Mockito.verify(emMock).persist(entity);

    }

    /**
     * Test of edit method, of class AbstractFacade.
     */
    @Test
    public void testEdit() {
        T entity = getEntity();
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", emMock);
        instance.edit(entity);
        Mockito.verify(emMock).merge(entity);
    }

    /**
     * Test of remove method, of class AbstractFacade.
     */
    @Test
    public void testRemove() {
        T entity = getEntity();
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", emMock);
        instance.remove(entity);
        Mockito.verify(emMock).remove(emMock.merge(entity));
    }

    /**
     * Test of find method, of class AbstractFacade.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        T entity = getEntity();
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", emMock);
        Whitebox.setInternalState(instance, "entityClass", entityClass);
        Object expResult = entity;
        Object result = instance.find(1);
        System.out.println("esperado: " + entity.toString() + "\nResultado: " + result.toString());
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class AbstractFacade.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        javax.persistence.criteria.CriteriaQuery cq = Mockito.mock(javax.persistence.criteria.CriteriaQuery.class);
        TypedQuery tq = Mockito.mock(TypedQuery.class);
        CriteriaBuilder cbr = Mockito.mock(CriteriaBuilder.class);
        Mockito.when(emMock.getCriteriaBuilder()).thenReturn(cbr);
        Mockito.when(emMock.createQuery(cq)).thenReturn(tq);
        Mockito.when(emMock.getCriteriaBuilder().createQuery()).thenReturn(cq);
        Mockito.when(emMock.createQuery(cq).getResultList()).thenReturn(new ArrayList());
        AbstractFacade<T> cut = getFacade();
        Whitebox.setInternalState(cut, "em", emMock);
        int expResult = 0;
        int esperado = cut.findAll().size();
        assertEquals(expResult, esperado);
    }

    /**
     * Test of findRange method, of class AbstractFacade.
     */
    @Test
    public void testFindRange() throws Exception{
        System.out.println("TestFindRange()");
        javax.persistence.criteria.CriteriaQuery cq = Mockito.mock(javax.persistence.criteria.CriteriaQuery.class);
        TypedQuery tq = Mockito.mock(TypedQuery.class);
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        EntityManager em = Mockito.mock(EntityManager.class);
        Mockito.when(emMock.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(emMock.createQuery(cq)).thenReturn(tq);
        Mockito.when(emMock.getCriteriaBuilder().createQuery()).thenReturn(cq);
        Mockito.when(emMock.createQuery(cq).getResultList()).thenReturn(new ArrayList());
        AbstractFacade<T> cut = getFacade();
        Whitebox.setInternalState(cut, "em", emMock);
        int esperado = 0;
        int[] rango = {0, 100};
        List<T> lista = cut.findRange(rango);
        int resultado = lista.size();
        assertEquals(resultado, esperado);
       
        
        
        
    }

    /**
     * Test of count method, of class AbstractFacade.
     */
//    @Test
    public void testCount() {
        System.out.println("count");
        AbstractFacade instance = null;
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
