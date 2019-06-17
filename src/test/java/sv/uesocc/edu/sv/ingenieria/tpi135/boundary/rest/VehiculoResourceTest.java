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
import org.mockito.Matchers;
//import static sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.ReservaViajeResourceTest.rv;
//import static sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.ReservaViajeResourceTest.server;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Modelo;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.ControllerExceptionMapper;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.NotFoundMapper;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.WebExceptionMapper;

/**
 *
 * @author gochez
 */
public class VehiculoResourceTest {

    public VehiculoResourceTest() {
    }

    @InjectMocks
    public static VehiculoResource rv = new VehiculoResource();
   // public static InMemoryRestServer server;

    public Client cliente = ClientBuilder.newClient();
    public WebTarget target = cliente.target("http://localhost:8080/tpi135_unigo/ws/vehiculo");

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        //server = InMemoryRestServer.create(rv, ControllerExceptionMapper.class, WebExceptionMapper.class, NotFoundMapper.class);

    }

    @After
    public void tearDown() {
      //  server.close();
    }

    /**
     * Test of VehiculofindAll method, of class VehiculoResource.
     */
    @Test
    public void testVehiculofindAll() {
        System.out.println("VehiculofindAll");
        Response response = target.path("/all").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La respuesta a la petición all de vehiculo es: " + response.getStatusInfo());

    }

    /**
     * Test of VehiculofindRange method, of class VehiculoResource.
     */
//    @Test
//    public void testVehiculofindRange() {
//        System.out.println("VehiculofindRange");
//        int first = 0;
//        int pageSize = 0;
//        VehiculoResource instance = new VehiculoResource();
//        List<Vehiculo> expResult = null;
//        List<Vehiculo> result = instance.VehiculofindRange(first, pageSize);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of Vehiculocount method, of class VehiculoResource.
     */
    @Test
    public void testVehiculocount() {
        System.out.println("Vehiculocount");
        Response response = target.path("/count").request(MediaType.TEXT_PLAIN).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La pretición count de vehiculo fue: " + response.getStatusInfo());

    }

    /**
     * Test of VehiculofindById method, of class VehiculoResource.
     */
    @Test
    public void testVehiculofindById() throws Exception {
        System.out.println("VehiculofindById");
        int id = 1;
        Response response = target.path("/" + id).request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La respuesta a la petición findID de vehiculo fue: " + response.getStatusInfo());
    }

    /**
     * Test of Vehiculocreate method, of class VehiculoResource.
     */
    @Test
    public void testVehiculocreate() throws Exception {
//        System.out.println("Vehiculocreate");
//        Vehiculo vh = new Vehiculo(1);
//        Response response = server.newRequest("/").request().buildPost(Entity.entity(vh, MediaType.APPLICATION_JSON)).invoke();
//        assertNotNull(response);
//        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
//        System.out.println("El valor de la peticion del create de Vehiculo es: " + response.getStatusInfo());
    }

    /**
     * Test of MarcafindAll method, of class VehiculoResource.
     */
    @Test
    public void testMarcafindAll() {
        System.out.println("MarcaFindAll");
        Response response = target.path("/marca/all").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La respuesta a la petición all de marca es: " + response.getStatusInfo());
    }

    @Test
    public void testMarcacount() {
        System.out.println("MarcaCount");
        Response response = target.path("/marca/count").request(MediaType.TEXT_PLAIN).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La pretición count de marca fue: " + response.getStatusInfo());
    }

    /**
     * Test of MarcafindById method, of class VehiculoResource.
     */
    @Test
    public void testMarcafindById() throws Exception {
        System.out.println("MarcafindById");
        String id = "a";
        Response response = target.path("/marca/findbyname/" + id).request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La respuesta a la petición findID de vehiculo fue: " + response.getStatusInfo());
    }

    /**
     * Test of ModelofindAll method, of class VehiculoResource.
     */
    @Test
    public void testModelofindAll() {
       System.out.println("VehiculofindAll");
        Response response = target.path("/marca/modelo/all").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La respuesta a la petición all de modelo es: " + response.getStatusInfo());
    }

    /**
     * Test of ModelofindRange method, of class VehiculoResource.
     */
//    @Test
//    public void testModelofindRange() {
//        System.out.println("ModelofindRange");
//        int first = 0;
//        int pageSize = 0;
//        VehiculoResource instance = new VehiculoResource();
//        List<Modelo> expResult = null;
//        List<Modelo> result = instance.ModelofindRange(first, pageSize);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of Modelocount method, of class VehiculoResource.
     */
    @Test
    public void testModelocount() {
       System.out.println("ModeloCount");
        Response response = target.path("/marca/modelo/count").request(MediaType.TEXT_PLAIN).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La pretición count de modelo fue: " + response.getStatusInfo());
    }

    /**
     * Test of ModelofindById method, of class VehiculoResource.
     */
    @Test
    public void testModelofindById() throws Exception {
        System.out.println("ModelofindById");
        int id = 1;
        Response response = target.path("/marca/modelo/" + id).request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("La respuesta a la petición findID de modelo fue: " + response.getStatusInfo());
    }

}
