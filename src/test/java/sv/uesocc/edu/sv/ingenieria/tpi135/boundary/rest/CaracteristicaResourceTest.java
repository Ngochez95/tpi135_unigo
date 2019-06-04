/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.CaractetisticaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoCaracteristica;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.ControllerException;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.NotFoundMapper;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.WebExceptionMapper;

/**
 *
 * @author gochez
 */
@RunWith(MockitoJUnitRunner.class)
public class CaracteristicaResourceTest {

    public CaracteristicaResourceTest() {
    }

    @InjectMocks
    public static CaracteristicaResource cr = new CaracteristicaResource();
    public static InMemoryRestServer server;
    public final Caractetistica caracteristica = new Caractetistica(1);
    Integer id = 1;

    @Mock
    CaractetisticaFacade crf;
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    public Client cliente = ClientBuilder.newClient();
    public WebTarget target = cliente.target("http://localhost:8080/tpi135_unigo/ws/");

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        server = InMemoryRestServer.create(cr, ControllerException.class, WebExceptionMapper.class, NotFoundMapper.class);
    }

    @After
    public void tearDown() {
        server.close();

    }

    /**
     * Test of CaractetisticafindAll method, of class CaracteristicaResource.
     */
    @Test
    public void testCaractetisticafindAll() {
        System.out.println("CaractetisticafindAll");
        List<Caractetistica> lista = new ArrayList<>();
        List<Caractetistica> lista2 = new ArrayList<>();
        lista.add(caracteristica);
        lista.add(new Caractetistica(2));
        Mockito.when(this.crf.findAll()).thenReturn(lista);
        Response response = server.newRequest("caracteristica/all").request().buildGet().invoke();
        Assert.assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//        lista2 = response.readEntity(new GenericType<List<Caractetistica>>() {
//        });
//        assertEquals(lista2.size(), 2);
//        assertEquals(lista2.get(0).getIdCaracteristica(), id);

    }

    /**
     * Test of CaractetisticafindRange method, of class CaracteristicaResource.
     */
//    @Test
//    public void testCaractetisticafindRange() {
//        System.out.println("CaractetisticafindRange");
//        int first = 0;
//        int pageSize = 0;
//        CaracteristicaResource instance = new CaracteristicaResource();
//        List<Caractetistica> expResult = null;
//        List<Caractetistica> result = instance.CaractetisticafindRange(first, pageSize);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Caractetisticacount method, of class CaracteristicaResource.
//     */
//    @Test
//    public void testCaractetisticacount() {
//        System.out.println("Caractetisticacount");
//        CaracteristicaResource instance = new CaracteristicaResource();
//        Integer expResult = null;
//        Integer result = instance.Caractetisticacount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of CaractetisticafindById method, of class CaracteristicaResource.
//     */
//    @Test
//    public void testCaractetisticafindById() throws Exception {
//        System.out.println("CaractetisticafindById");
//        Integer id = null;
//        CaracteristicaResource instance = new CaracteristicaResource();
//        Caractetistica expResult = null;
//        Caractetistica result = instance.CaractetisticafindById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Caractetisticacreate method, of class CaracteristicaResource.
//     */
//    @Test
//    public void testCaractetisticacreate() throws Exception {
//        System.out.println("Caractetisticacreate");
//        Caractetistica registro = null;
//        CaracteristicaResource instance = new CaracteristicaResource();
//        Caractetistica expResult = null;
//        Caractetistica result = instance.Caractetisticacreate(registro);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of TipoCaracteristicafindAll method, of class
//     * CaracteristicaResource.
//     */
//    @Test
//    public void testTipoCaracteristicafindAll() {
//        System.out.println("TipoCaracteristicafindAll");
//        CaracteristicaResource instance = new CaracteristicaResource();
//        List<TipoCaracteristica> expResult = null;
//        List<TipoCaracteristica> result = instance.TipoCaracteristicafindAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of TipoCaracteristicafindRange method, of class
//     * CaracteristicaResource.
//     */
//    @Test
//    public void testTipoCaracteristicafindRange() {
//        System.out.println("TipoCaracteristicafindRange");
//        int first = 0;
//        int pageSize = 0;
//        CaracteristicaResource instance = new CaracteristicaResource();
//        List<TipoCaracteristica> expResult = null;
//        List<TipoCaracteristica> result = instance.TipoCaracteristicafindRange(first, pageSize);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of TipoCaracteristicacount method, of class CaracteristicaResource.
//     */
//    @Test
//    public void testTipoCaracteristicacount() {
//        System.out.println("TipoCaracteristicacount");
//        CaracteristicaResource instance = new CaracteristicaResource();
//        Integer expResult = null;
//        Integer result = instance.TipoCaracteristicacount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of TipoCaracteristicafindById method, of class
//     * CaracteristicaResource.
//     */
//    @Test
//    public void testTipoCaracteristicafindById() throws Exception {
//        System.out.println("TipoCaracteristicafindById");
//        Integer id = null;
//        CaracteristicaResource instance = new CaracteristicaResource();
//        TipoCaracteristica expResult = null;
//        TipoCaracteristica result = instance.TipoCaracteristicafindById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
