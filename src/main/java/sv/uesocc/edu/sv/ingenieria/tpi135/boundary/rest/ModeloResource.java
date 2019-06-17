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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ModeloFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Modelo;

@Path("marca/{idmarca}/modelo")
@RequestScoped
public class ModeloResource {

    @Inject
    protected ModeloFacade modelo;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Modelo> ModeloByMarca(
            @PathParam("idmarca") Integer idmarca
           ) {

        if (modelo != null && idmarca >= 0 ) {
            try {
                List<Modelo> list = null;
                list = modelo.findModelo(idmarca);
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
        @Path("/{idmodelo}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Modelo> ModeloById(
            @PathParam("idmarca") Integer idmarca,
            @PathParam("idmodelo") Integer idmodelo
            )
            {

        if (modelo != null && idmarca >= 0 ) {
            try {
                List<Modelo> list = null;
                list = modelo.findById(idmarca, idmodelo);
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
