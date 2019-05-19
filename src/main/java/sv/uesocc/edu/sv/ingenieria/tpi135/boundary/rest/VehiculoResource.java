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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.VehiculoFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
@Path("vehiculo")
@RequestScoped
public class VehiculoResource extends AbstractResource<Vehiculo> implements Serializable {

    @Inject
    protected VehiculoFacade vehiculo;

    public VehiculoResource() {
        super(Vehiculo.class
        );
    }

    @Override
    protected AbstractFacade<Vehiculo> getFacade() {
        return vehiculo;
    }

    @Override
    protected Vehiculo crearNuevo() {

        return new Vehiculo();

    }

    @GET
    @Path("findallid/{idbuscado}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Response FindAllByID(
            @PathParam("idbuscado") int id
    ) {

        if (vehiculo != null) {
            try {
                List<Vehiculo> list = null;
                list = vehiculo.findAllId(id);
                if (list != null && !list.isEmpty()) {
                    JsonArrayBuilder ab = Json.createArrayBuilder();
                    for (Vehiculo vh : list) {
                        ab.add(Json.createObjectBuilder()
                                .add("idVehiculo", vh.getIdVehiculo())
                                .add("Marca", vh.getIdMarca().getMarca())
                               // .add("Modelo", vh.getIdMarca().getModeloList().get(id).getModelo())
//                                .add("Capacidad", vh.getIdMarca().getModeloList().get(id).getCaractetisticaList().get(id).getTipoCaracteristicaList().get(id).getCapacidad())
//                                .add("Color", vh.getIdMarca().getModeloList().get(id).getCaractetisticaList().get(id).getTipoCaracteristicaList().get(id).getColor())
//                                .add("Anio", vh.getIdMarca().getModeloList().get(id).getCaractetisticaList().get(id).getTipoCaracteristicaList().get(id).getAnio().getDate())
                        );
                        //.add("marca", vh.getIdMarca().getMarca()));
                    }
                    return Response.ok(ab.build()).build();

                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("filter-not-found", id).build();
    }

}
