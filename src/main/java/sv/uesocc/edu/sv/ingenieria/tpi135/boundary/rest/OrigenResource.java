/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.OrigenFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Origen;

/**
 *
 * @author gochez
 */
@Path("origen")
@RequestScoped
public class OrigenResource extends AbstractResource<Origen> implements Serializable {

    @Inject
    protected OrigenFacade origen;

    public OrigenResource() {
        super(Origen.class);
    }

    @Override
    protected AbstractFacade<Origen> getFacade() {
        return origen;
    }

    @Override
    protected Origen crearNuevo() {
        return new Origen();
    }

    @GET
    @Path("findbyname/{origenbuscado}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Response findByNombreLike(
            @PathParam("origenbuscado") String nombre
    ) {

        if (origen != null) {
            try {
                List<Origen> list = null;
                list = origen.findbynombre(nombre);
                if (list != null && !list.isEmpty()) {
                    JsonArrayBuilder ab = Json.createArrayBuilder();
                    for (Origen org : list) {
                        ab.add(Json.createObjectBuilder()
                                .add("idOrigen", org.getIdOrigen())
                                .add("origen", org.getOrigen()));
                    }
                    return Response.ok(ab.build()).build();

                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("filter-not-found", nombre).build();
    }

}
