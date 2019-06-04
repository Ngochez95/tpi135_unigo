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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.TrayectoriaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;

/**
 *
 * @author gochez
 */
@Path("trayectoria")
@RequestScoped
public class TrayectoriaResource {

    @Inject
    protected TrayectoriaFacade trayectoria;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Trayectoria> findAll() {
        if (trayectoria != null) {
            try {
                List<Trayectoria> list = null;
                list = trayectoria.findAll();
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
    public List<Trayectoria> findRange(@DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {

        if (trayectoria != null && first >= 0 && pageSize >= 0) {
            try {
                List<Trayectoria> list = null;
                list = trayectoria.findRange(first, pageSize);
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
        if (trayectoria != null) {
            try {
                return trayectoria.count();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return 0;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Trayectoria findById(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {
        if (trayectoria != null) {
            try {
                Trayectoria registro=null;
                if (id >= 0 && id != null) {
                    registro= trayectoria.find(id);
                    return registro;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new Trayectoria();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Trayectoria create(Trayectoria registro) throws InstantiationException, IllegalAccessException {
        if (trayectoria != null && registro != null) {
            try {
                Trayectoria creado = trayectoria.create(registro);
                if (creado != null) {
                    return creado;
                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new Trayectoria();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Trayectoria edit(Trayectoria registro) {
        if (registro != null && trayectoria != null) {
            try {
                Trayectoria modificado = trayectoria.edit(registro);
                if (modificado != null) {
                    return modificado;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Trayectoria();
    }

    @DELETE
    @Path("{id}")
    public Trayectoria delete(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {

        if (trayectoria != null && id >= 0 && id != null) {
            try {
                Trayectoria buscado = trayectoria.find(id);
                if (buscado != null) {
                    if (trayectoria.remove(buscado)) {
                        return buscado;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

            }
        }
        return new Trayectoria();
    }

}
