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
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.MarcaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;

/**
 *
 * @author gochez
 */
@Path("marca")
@RequestScoped
public class MarcaResource {

    @Inject
    protected MarcaFacade marca;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Marca> RangeMarca(@DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {
        if (marca != null && first >= 0 && pageSize >= 0) {
            try {
                List<Marca> list = null;
                list = marca.findRange(first, pageSize);
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Marca MarcaById(
            @PathParam("id") Integer idMarca) {
        if (idMarca != null && idMarca >= 0) {
            Marca registro;
            registro = marca.find(idMarca);
            if (registro != null) {
                return registro;
            }
        }
        return new Marca();
    }

}
