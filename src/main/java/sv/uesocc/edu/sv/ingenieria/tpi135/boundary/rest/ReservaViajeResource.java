/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ReservaViajeFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.ReservaViaje;

/**
 *
 * @author gochez
 */
@Path("reserva")
@RequestScoped
public class ReservaViajeResource {

    @Inject
    protected ReservaViajeFacade reserva_viaje;
@GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<ReservaViaje> findAll() {
        if (reserva_viaje != null) {
            try {
                List<ReservaViaje> list = null;
                list = reserva_viaje.findAll();
                if (list != null) {
                    return list;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new ArrayList<>();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<ReservaViaje> findRange(@DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {

        if (reserva_viaje != null && first >= 0 && pageSize >= 0) {
            try {
                List<ReservaViaje> list = null;
                list = reserva_viaje.findRange(first, pageSize);
                if (list != null) {
                    return list;
                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new ArrayList<>();

    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer count() {
        if (reserva_viaje != null) {
            try {
                return reserva_viaje.count();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return 0;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ReservaViaje findById(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {
        if (reserva_viaje != null) {
            try {
               
                ReservaViaje registro= null;
                if (id >= 0 && id != null) {
                    registro = reserva_viaje.find(id);
                    return registro;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new ReservaViaje();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ReservaViaje create(ReservaViaje registro) throws InstantiationException, IllegalAccessException {
        if (reserva_viaje != null && registro != null) {
            try {
                ReservaViaje creado = reserva_viaje.create(registro);
                if (creado != null) {
                    return creado;
                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new ReservaViaje();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public ReservaViaje edit(ReservaViaje registro) {
        if (registro != null && reserva_viaje != null) {
            try {
                ReservaViaje modificado = reserva_viaje.edit(registro);
                if (modificado != null) {
                    return modificado;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new ReservaViaje();
    }

    @DELETE
    @Path("{id}")
    public ReservaViaje delete(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {

        if (reserva_viaje != null && id >= 0 && id != null) {
            try {
                ReservaViaje buscado = reserva_viaje.find(id);
                if (buscado != null) {
                    if (reserva_viaje.remove(buscado)) {
                        return buscado;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

            }
        }
        return new ReservaViaje();
    }
    
}
