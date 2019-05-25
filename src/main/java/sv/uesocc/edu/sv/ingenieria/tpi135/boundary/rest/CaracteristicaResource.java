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
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.CaractetisticaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.TipoCaracteristicaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoCaracteristica;

/**
 *
 * @author gochez
 */
@Path("caracteristica")
@RequestScoped
public class CaracteristicaResource {

    @Inject
    protected CaractetisticaFacade caracteristica;
    @Inject
    protected TipoCaracteristicaFacade tipocaracteristica;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Caractetistica> CaractetisticafindAll() {
        if (caracteristica != null) {
            try {
                List<Caractetistica> list = null;
                list = caracteristica.findAll();
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
    public List<Caractetistica> CaractetisticafindRange(@DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {

        if (caracteristica != null && first >= 0 && pageSize >= 0) {
            try {
                List<Caractetistica> list = null;
                list = caracteristica.findRange(first, pageSize);
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
    public Integer Caractetisticacount() {
        if (caracteristica != null) {
            try {
                return caracteristica.count();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return 0;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Caractetistica CaractetisticafindById(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {
        if (caracteristica != null) {
            try {
                Caractetistica registro;
                List<Caractetistica> list = null;
                if (id >= 0 && id != null) {
                    registro = caracteristica.find(id);
                    return registro;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new Caractetistica();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Caractetistica Caractetisticacreate(Caractetistica registro) throws InstantiationException, IllegalAccessException {
        if (caracteristica != null && registro != null) {
            try {
                Caractetistica creado = caracteristica.create(registro);
                if (creado != null) {
                    return creado;
                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new Caractetistica();
    }

    @GET
    @Path("/caracteristica/tipocaracteristica/all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<TipoCaracteristica> TipoCaracteristicafindAll() {
        if (tipocaracteristica != null) {
            try {
                List<TipoCaracteristica> list = null;
                list = tipocaracteristica.findAll();
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
    @Path("/tipocaracteristica")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<TipoCaracteristica> TipoCaracteristicafindRange(@DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {

        if (tipocaracteristica != null && first >= 0 && pageSize >= 0) {
            try {
                List<TipoCaracteristica> list = null;
                list = tipocaracteristica.findRange(first, pageSize);
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
    @Path("/tipocaracteristica/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer TipoCaracteristicacount() {
        if (tipocaracteristica != null) {
            try {
                return tipocaracteristica.count();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return 0;
    }

    @GET
    @Path("/tipocaracteristica/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public TipoCaracteristica TipoCaracteristicafindById(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {
        if (tipocaracteristica != null) {
            try {
                TipoCaracteristica registro;
                if (id >= 0 && id != null) {
                    registro = tipocaracteristica.find(id);
                    return registro;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new TipoCaracteristica();
    }

}
