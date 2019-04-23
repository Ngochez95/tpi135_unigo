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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.internal.util.reflection.Whitebox;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author gochez
 */
public class ViajeFacadeTest extends AbstractFacadeT<Viaje> {

    @Mock
    private EntityManager em;

    @Before
    public void inicializar() {
        List<Viaje> ls = new ArrayList<>();
        Query q = Mockito.mock(Query.class);
        IllegalArgumentException ex = Mockito.mock(IllegalArgumentException.class);
        Mockito.when(em.createNamedQuery("Viaje.findByConductor")).thenReturn(q);
        Mockito.when(q.setParameter("idUsuario", 1)).thenReturn(q);
        Mockito.when(q.getResultList()).thenReturn(ls);
        Mockito.when(em.createNamedQuery("Viaje.FindByDia")).thenReturn(q);
        Mockito.when(q.setParameter("dia", 1)).thenReturn(q);
        Mockito.when(q.getResultList()).thenReturn(ls);
        Mockito.when(em.createNamedQuery("Viaje.BuscarxCuidadOrigen")).thenReturn(q);
        Mockito.when(q.getResultList()).thenReturn(ls);

        //Mockito.when(em.createNamedQuery("Viaje.findByConductor")).thenThrow(IllegalAccessException.class);
        // Mockito.when(em.createNamedQuery("Viaje.FindByDia")).thenThrow(IllegalAccessException.class);
        //Mockito.when(em.createNamedQuery("Viaje.BuscarxCuidadOrigen")).thenThrow(IllegalAccessException.class);
    }

    @Override
    protected AbstractFacade<Viaje> getFacade() {
        return new ViajeFacade();
    }

    @Override
    protected Viaje getEntity() {
        return new Viaje(1);
    }

    @Test
    public void testFindByConductor() {
        System.out.println("TestFindByConductor");
        ViajeFacade cut = new ViajeFacade();
        Whitebox.setInternalState(cut, "em", em);
        assertEquals(new ArrayList(), cut.findByConductor(0));
    }

    @Test
    public void testfindByDia() {
        System.out.println("findByDia()");
        ViajeFacade cut = new ViajeFacade();
        Whitebox.setInternalState(cut, "em", em);
        assertEquals(new ArrayList(), cut.findByDia(0));
    }

    @Test
    public void testFindxCiudadOrigen() {
        System.out.println("findByDia()");
        ViajeFacade cut = new ViajeFacade();
        Whitebox.setInternalState(cut, "em", em);
        assertEquals(new ArrayList(), cut.findxCiudadOrigen());

    }

}
