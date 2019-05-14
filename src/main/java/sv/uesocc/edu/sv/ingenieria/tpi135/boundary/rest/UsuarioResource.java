/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
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

}
