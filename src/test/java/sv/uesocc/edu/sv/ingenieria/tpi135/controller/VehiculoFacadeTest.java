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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
public class VehiculoFacadeTest extends AbstractFacadeT<Vehiculo> {

    @Override
    protected AbstractFacade<Vehiculo> getFacade() {
        return new VehiculoFacade();
    }

    @Override
    protected Vehiculo getEntity() {
        return new Vehiculo(1);
    }
    
    @Mock
    private EntityManager em;
    
    @Before
    public void inicializar(){
        List<Vehiculo> ls = new ArrayList<>();
        Query q = Mockito.mock(Query.class);
        Mockito.when(em.createNamedQuery("Vehiculo.findActivo")).thenReturn(q);
        Mockito.when(q.setParameter("idReferencia", 1)).thenReturn(q);
        Mockito.when(q.getResultList()).thenReturn(ls);
    }
    
    
    
    @Test
    public void testFindActivo(){
        VehiculoFacade cut = new VehiculoFacade();
        Whitebox.setInternalState(cut, "em", em);
        assertEquals(new ArrayList(), cut.findActivo(0));
        
    }
    
}
