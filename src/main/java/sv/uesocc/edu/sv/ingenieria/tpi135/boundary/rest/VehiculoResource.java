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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.VehiculoFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
@Path("vehiculo")
@RequestScoped
public class VehiculoResource extends AbstractResource<Vehiculo> implements Serializable{

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
    
}
