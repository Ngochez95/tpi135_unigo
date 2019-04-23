/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author rcarlos
 */
public abstract class AbstractFacadeINT<T> {

    protected abstract AbstractFacade<T> getFacade();

    protected abstract EntityManager getEntityManager();

    protected abstract T getEntity();

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        //getEntityManager().close();
    }

  @Test
    public void testCrear() throws Exception {
        T entity = getEntity();
        AbstractFacade<T> instance = getFacade();
        //System.out.println("create: " + entity.toString());
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        boolean result = instance.crear(entity);
        //assertEquals(1, instance.findAll().size());
        assertTrue(result);
    }

    @Test
    public void testCreate() throws Exception {
        T entity = getEntity();
        AbstractFacade<T> instance = getFacade();
        //System.out.println("crear " + entity.toString());
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        T expResult = getEntity();
        T result = instance.create(entity);
        assertEquals(expResult, result);
    }

    @Test
    public void testEdit() throws Exception {
        T entity = getEntity();
        //System.out.println("edit " + entity.toString());
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        boolean expResult = true;
        boolean result = instance.editar(entity);
        assertEquals(expResult, result);
    }

    @Test
    public void testEditar() throws Exception {
        T entity = null;
        System.out.println("editar " + entity);
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        T expResult = null;
        T result = instance.edit(entity);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemove() throws Exception {
        T nueva = getEntity();
        //System.out.println("remove " + nueva.toString());
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        instance.create(nueva);
        boolean expResult = true;
        boolean result = instance.remove(nueva);
        assertEquals(expResult, result);
    }

    //@Test
    public void testFind() throws Exception {
        //System.out.println("find");
        Object id = 1;
        T entity = getEntity();
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        instance.create(entity);
        T expResult = entity;
        T result = instance.findAll().get(0);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindAll() throws Exception {
        //System.out.println("findAll");
        T entity = getEntity();
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        List<T> result = instance.findAll();
        assertEquals(0, result.size());
    }
    
    //@Test
    public void testFindRange() throws Exception {
        //System.out.println("findRange");
        int first = 0;
        int pageSize = 1;
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        List<T> result = instance.findRange(first, pageSize);
        assertEquals(0, result.size());
    }
    
    @Test
    public void testCount() throws Exception {
        //System.out.println("count");
        AbstractFacade<T> instance = getFacade();
        Whitebox.setInternalState(instance, "em", getEntityManager());
        instance.getEntityManager().getTransaction().begin();
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
    }
}
