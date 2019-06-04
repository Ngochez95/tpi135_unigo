/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import static sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.CaracteristicaResourceTest.cr;
import static sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.CaracteristicaResourceTest.server;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.ReservaViaje;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.ControllerExceptionMapper;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.NotFoundMapper;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.WebExceptionMapper;

/**
 *
 * @author gochez
 */
public class ReservaViajeResourceTest {

    public ReservaViajeResourceTest() {
    }

    @InjectMocks
    public static ReservaViajeResource rv = new ReservaViajeResource();
    public static InMemoryRestServer server;

    public Client cliente = ClientBuilder.newClient();
    public WebTarget target = cliente.target("http://localhost:8080/tpi135_unigo/ws/reserva");

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        server = InMemoryRestServer.create(rv, ControllerExceptionMapper.class, WebExceptionMapper.class, NotFoundMapper.class);

    }

    @After
    public void tearDown() {
        server.close();
    }

    /**
     * Test of findAll method, of class ReservaViajeResource.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Response response = target.path("/all").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
        System.out.println("LA respuesta de findALL de reserva es " + response.getStatus());
    }

    /**
     * Test of findRange method, of class ReservaViajeResource. //
     */
//    @Test
//    public void testFindRange() {
//        System.out.println("findRange");
//        int first = 0;
//        int pageSize = 0;
//        ReservaViajeResource instance = new ReservaViajeResource();
//        List<ReservaViaje> expResult = null;
//        List<ReservaViaje> result = instance.findRange(first, pageSize);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of count method, of class ReservaViajeResource.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        Response response = target.path("/count").request(MediaType.TEXT_PLAIN).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La respuesta de la petición count a ReservaViaje fue: " + response.getStatus());

    }

    /**
     * Test of findById method, of class ReservaViajeResource.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Response response = target.path("/1").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
        System.out.println("La respuesta de la petición buscar por id de reservaViaje fue: " + response.getStatusInfo());
    }

    /**
     * Test of create method, of class ReservaViajeResource.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ReservaViaje resv = new ReservaViaje(1);
        Response response = server.newRequest("/").request().buildPost(Entity.entity(resv, MediaType.APPLICATION_JSON)).invoke();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("El valor de la peticion del create de ReservaViaje es: " + response.getStatusInfo());
    }

    /**
     * Test of edit method, of class ReservaViajeResource.
     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//         Response response = server.newRequest("/1").request().build.invoke();
//        assertNotNull(response);
//        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
//        System.out.println(response.getStringHeaders());
//    }

    /**
     * Test of delete method, of class ReservaViajeResource.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Response response = server.newRequest("/1").request().buildDelete().invoke();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println(response.getStringHeaders());

    }

}
