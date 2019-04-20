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
import static org.mockito.Mockito.*;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import sun.applet.AppletViewer;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;

/**
 *
 * @author gochez, zepeda abrego
 * @param <T>
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractFacadeT<T> {

    private Class<T> entityClass;

    protected abstract AbstractFacade<T> getFacade();

    protected abstract T getEntity();

    private final CriteriaBuilder CB = mock(CriteriaBuilder.class);
    private final CriteriaQuery CQ = mock(CriteriaQuery.class);
    private final TypedQuery q = mock(TypedQuery.class);
    javax.persistence.criteria.Root<T> rt = Mockito.mock(javax.persistence.criteria.Root.class);

    @Mock
    private EntityManager emMock;
    AbstractFacade<T> instance = getFacade();
    T entity;

    @Before
    public void setUp() {
        entity = getEntity();

        Whitebox.setInternalState(instance, "em", emMock);
        T nuevo = getEntity();
        Mockito.when(this.emMock.find(entityClass, 1)).thenReturn(nuevo);
        Mockito.when(emMock.getCriteriaBuilder()).thenReturn(CB);
        Mockito.when(emMock.createQuery(CQ)).thenReturn(q);
        Mockito.when(emMock.getCriteriaBuilder().createQuery()).thenReturn(CQ);
        Mockito.when(emMock.createQuery(CQ).getResultList()).thenReturn(new ArrayList());
        when(CQ.from(entityClass)).thenReturn(rt);
        Mockito.when(emMock.createQuery(CQ).getSingleResult()).thenReturn(new Long(1));
        Whitebox.setInternalState(instance, "entityClass", entityClass);
        //Quitar el 1, declararlo para recibir una primarykey.
        //la variable nuevo, introducirlo dentro del .when() meter el getEntity con la variable nuevo.

    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testReturnsLoggers(){
        
    }

    /**
     * Test of create method, of class AbstractFacade.
     */
    @Test
    public void testCreate() {
        instance.create(entity);
        Mockito.verify(emMock).persist(entity);
    }

    /**
     * Test of edit method, of class AbstractFacade.
     */
    @Test
    public void testEdit() {
        System.out.println("testEdit");
        instance.edit(entity);
        Mockito.verify(emMock).merge(entity);
    }

    /**
     * Test of remove method, of class AbstractFacade.
     */
    @Test
    public void testRemove() {
        System.out.println("testRemove()");
        instance.remove(entity);
        Mockito.verify(emMock).remove(emMock.merge(entity));
    }

    /**
     * Test of find method, of class AbstractFacade.
     */
    @Test
    public void testFind() {
        System.out.println("testFind()");
        Object expResult = entity;
        Object result = instance.find(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class AbstractFacade.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        int expResult = 0;
        int esperado = instance.findAll().size();
        assertEquals(expResult, esperado);
    }

    /**
     * Test of findRange method, of class AbstractFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("TestFindRange()");
        int esperado = 0;
        int esperadio2 =2;
        List<T> lista = instance.findRange(esperado, esperadio2);
        int resultado = lista.size();
        assertEquals(resultado, esperado);
    }

    /**
     * Test of count method, of class AbstractFacade.
     */
    @Test
    public void testCount() {
        System.out.println("TestCount()");
        TypedQuery tq = Mockito.mock(TypedQuery.class);
        int resultado = instance.count();
        assertEquals(1, resultado);

    }

}
