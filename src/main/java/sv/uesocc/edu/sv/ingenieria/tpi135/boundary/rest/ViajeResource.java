/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.SemanaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ViajeFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Semana;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author zentaury
 */
@Path("viaje")
@RequestScoped
public class ViajeResource {

    @Inject
    protected ViajeFacade viaje;

    @Inject
    protected SemanaFacade semana;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Viaje> findAll() {
        if (viaje != null) {
            try {
                List<Viaje> list = null;
                list = viaje.findAll();
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
    public List<Viaje> findRange(@DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {

        if (viaje != null && first >= 0 && pageSize >= 0) {
            try {
                List<Viaje> list = null;
                list = viaje.findRange(first, pageSize);
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
        if (viaje != null) {
            try {
                return viaje.count();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return 0;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Viaje> findById(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {
        if (viaje != null) {
            try {
                List<Viaje> list = null;
                if (id >= 0 && id != null) {
                    list = (List<Viaje>) viaje.find(id);
                    return list;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new ArrayList<>();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Viaje create(Viaje registro) throws InstantiationException, IllegalAccessException {
        if (viaje != null && registro != null) {
            try {
                Viaje creado = viaje.create(registro);
                if (creado != null) {
                    return creado;
                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new Viaje();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Viaje edit(Viaje registro) {
        if (registro != null && viaje != null) {
            try {
                Viaje modificado = viaje.edit(registro);
                if (modificado != null) {
                    return modificado;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Viaje();
    }

    @DELETE
    @Path("{id}")
    public Viaje delete(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {

        if (viaje != null && id >= 0 && id != null) {
            try {
                Viaje buscado = viaje.find(id);
                if (buscado != null) {
                    if (viaje.remove(buscado)) {
                        return buscado;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

            }
        }
        return new Viaje();
    }

    @GET
    @Path("/semana")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Semana> SemanafindRange(@DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {

        if (semana != null && first >= 0 && pageSize >= 0) {
            try {
                List<Semana> list = null;
                list = semana.findRange(first, pageSize);
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
    @Path("/semana/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer Semanacount() {
        if (semana != null) {
            try {
                return semana.count();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return 0;
    }

    @GET
    @Path("/semana/all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Semana> SemanafindAll() {
        if (semana != null) {
            try {
                List<Semana> list = null;
                list = semana.findAll();
                if (list != null) {
                    return list;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new ArrayList<>();
    }

}
