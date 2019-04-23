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
public class UsuarioFacadeTest extends AbstractFacadeT<Usuario> {

    @Override
    protected AbstractFacade<Usuario> getFacade() {
        return new UsuarioFacade();
    }

    @Override
    protected Usuario getEntity() {
        return new Usuario(1);
    }

    @Mock
    private EntityManager em;

    @Before
    public void inicializar() {
        List<Vehiculo> ls = new ArrayList<>();
        Query q = Mockito.mock(Query.class);
        Mockito.when(em.createNamedQuery("Usuario.findByRol")).thenReturn(q);
        Mockito.when(q.getResultList()).thenReturn(ls);
    }

    @Test
    public void testFindByRol() {
        UsuarioFacade cut = new UsuarioFacade();
        Whitebox.setInternalState(cut, "em", em);
        assertEquals(new ArrayList(), cut.findByRol());
    }

}
