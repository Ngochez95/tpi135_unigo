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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.UsuarioFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;

/**
 *
 * @author gochez
 */
@Path("usuario")
@RequestScoped
public class UsuarioResource extends AbstractResource<Usuario> implements Serializable {

    @Inject
    protected UsuarioFacade usuario;

    public UsuarioResource() {
        super(Usuario.class);
    }

    @Override
    protected AbstractFacade<Usuario> getFacade() {
        return usuario;
    }

    @Override
    protected Usuario crearNuevo() {
        return new Usuario();
    }

    @GET
    @Path("finduser/{username}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Response findByNombreUsuarioLike(
            @PathParam("username") String nombreUsuario
    ) {
        if (usuario != null) {
            try {
                List<Usuario> list = null;
                list = usuario.findByNombreUsuario(nombreUsuario);
                if (list != null && !list.isEmpty()) {
                    JsonArrayBuilder ab = Json.createArrayBuilder();
                    for (Usuario us : list) {
                        ab.add(Json.createObjectBuilder()
                                .add("idUsuario", us.getIdUsuario())
                                .add("nombreUsuario", us.getNombreUsuario())
                                .add("nombreUno", us.getNombreUno())
                                .add("nombreDos", us.getNombreDos())
                                .add("apellidoUno", us.getApellidoUno())
                                .add("apellidoDos", us.getApellidoDos())
                        );

                    }
                    return Response.ok(ab.build()).build();
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

        }
        return Response.status(Response.Status.NOT_FOUND).header("filter-not-found", nombreUsuario).build();
    }

}
