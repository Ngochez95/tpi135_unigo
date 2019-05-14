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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.TrayectoriaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;

/**
 *
 * @author gochez
 */
@Path("trayectoria")
@RequestScoped
public class TrayectoriaResource extends AbstractResource<Trayectoria> implements Serializable {

    @Inject
    protected TrayectoriaFacade trayectoria;

    public TrayectoriaResource() {
        super(Trayectoria.class);
    }

    @Override
    protected AbstractFacade<Trayectoria> getFacade() {
        return trayectoria;
    }

    @Override
    protected Trayectoria crearNuevo() {
        return new Trayectoria();

    }

}
