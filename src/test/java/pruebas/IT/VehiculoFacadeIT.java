/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.IT;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.VehiculoFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
public class VehiculoFacadeIT {
  
    public VehiculoFacadeIT(){
    
    }
    
    VehiculoFacade vh = new VehiculoFacade();
    
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("pu-test", vh);
    

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    public AbstractFacade facade(){
        return emp.getFacade();
    }
    
    @Test
    public void testDelete() {
        Vehiculo vh1 = new Vehiculo(1);
        Vehiculo vh2 = new Vehiculo(2);
        //facade().getEntityManager().getTransaction().begin();
        facade().create(vh1);
        facade().create(vh2);
        facade().remove(new Vehiculo(1));
        assertEquals(vh2, facade().find(2));
    }

  

    @After
    public void tearDown() {

    }
    
    
}
