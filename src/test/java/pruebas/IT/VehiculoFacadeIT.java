/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.IT;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.VehiculoFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
public class VehiculoFacadeIT {

    public VehiculoFacadeIT() {

    }
    private EntityManager em;
    private EntityTransaction et;

    private List<Vehiculo> lvh;

    VehiculoFacade instance = new VehiculoFacade();

    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("pu-test", instance);

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

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testRemove() {
        Vehiculo vh1 = new Vehiculo(1);
        Vehiculo vh2 = new Vehiculo(2);
        facade().create(vh1);
        facade().create(vh2);
        facade().remove(new Vehiculo(1));
        assertEquals(vh2, facade().find(2));
    }

    @Test
    public void testCreate() {
        System.out.println("Create");
        Vehiculo vh1 = new Vehiculo(1);
        facade().create(vh1);
        assertEquals(vh1, facade().find(1));
    }

    @Test
    public void testEdit() {
        System.out.println("Edit");
        Vehiculo vh1 = new Vehiculo(1);
        //facade().getEntityManager().getTransaction().begin();
        facade().edit(vh1);

        Mockito.verify(facade()).edit(vh1);
    }

    @Test
    public void testFind() {
        System.out.println("TestFind");
        facade().create(new Vehiculo(1));
        assertTrue(facade().find(1).equals(new Vehiculo(1)));
    }

    @Test
    public void testFindAll() {
        System.out.println("Test findAll");
        Vehiculo vehiculo1 = new Vehiculo();
        facade().create(vehiculo1);
        lvh = facade().findAll();
        assertEquals(1, lvh.size());

    }

    @Test
    public void testCount() {
        System.out.println("count-IT");
        int result;
        facade().create(new Vehiculo(1));
        result = facade().count();
        assertEquals(1, result);
    }

}
