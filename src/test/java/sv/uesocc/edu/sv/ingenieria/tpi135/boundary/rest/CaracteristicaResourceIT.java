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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoCaracteristica;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.ControllerExceptionMapper;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.NotFoundMapper;
import sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions.WebExceptionMapper;

/**
 *
 * @author gochez
 */
@RunWith(MockitoJUnitRunner.class)
public class CaracteristicaResourceIT {

    public CaracteristicaResourceIT() {
    }
    @InjectMocks
    public static CaracteristicaResource cr = new CaracteristicaResource();
    public static InMemoryRestServer server;

    public Client cliente = ClientBuilder.newClient();
    public WebTarget target = cliente.target("http://localhost:8080/tpi135_unigo/ws/caracteristica");

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        server = InMemoryRestServer.create(cr, ControllerExceptionMapper.class, WebExceptionMapper.class, NotFoundMapper.class);

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
        Response response = target.path("/all").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

    }

    /**
     * Test of CaractetisticafindRange method, of class CaracteristicaResource.
     */
    @Test
    public void testCaractetisticafindRange() {
        System.out.println("CaractetisticafindRange");
        Response response = target.path("/").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("Estado de la peticion findRange caracteristica " + response.getStatus());
    }

    /**
     * Test of Caractetisticacount method, of class CaracteristicaResource.
     */
    @Test
    public void testCaractetisticacount() {
        System.out.println("Caractetisticacount");
        Response response = target.path("/count").request(MediaType.TEXT_PLAIN).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("El valor de la petición de count caracteristica es " + response.getStatusInfo());
    }

    /**
     * Test of CaractetisticafindById method, of class CaracteristicaResource.
     */
    @Test
    public void testCaractetisticafindById() throws Exception {
        System.out.println("CaractetisticafindById");
        Response response = target.path("/1").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("El valor de la petición de findbyID caracteristica es " + response.getStatusInfo());
    }

    /**
     * Test of Caractetisticacreate method, of class CaracteristicaResource.
     */
    @Test
    public void testCaractetisticacreate() throws Exception {
        System.out.println("Caractetisticacreate");
        Caractetistica caracExp = new Caractetistica(1);
        Response response = server.newRequest("/").request().buildPost(Entity.entity(caracExp, MediaType.APPLICATION_JSON)).invoke();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        System.out.println("El valor de la peticion del create de caracteristica es " + response.getStatusInfo());
    }

    /**
     * Test of TipoCaracteristicafindAll method, of class
     * CaracteristicaResource.
     */
    @Test
    public void testTipoCaracteristicafindAll() {
        System.out.println("TipoCaracteristicafindAll");
        Response response = target.path("/caracteristica/tipocaracteristica/all").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    /**
     * Test of TipoCaracteristicacount method, of class CaracteristicaResource.
     */
//    @Test
//    public void testTipoCaracteristicacount() {
//        System.out.println("TipoCaracteristicacount");
//        Response response = target.path("/tipocaracteristica/count").request(MediaType.TEXT_PLAIN).get();
//        assertNotNull(response);
//        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
//        
//    }
    /**
     * Test of TipoCaracteristicafindById method, of class
     * CaracteristicaResource.
     */
    @Test
    public void testTipoCaracteristicafindById() throws Exception {
        System.out.println("TipoCaracteristicafindById");
        Response response = target.path("tipocaracteristica/1").request(MediaType.APPLICATION_JSON).get();
        assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

    }

}
