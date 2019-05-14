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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ReservaViajeFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.ReservaViaje;

/**
 *
 * @author gochez
 */
@Path("reserva")
@RequestScoped
public class ReservaViajeResource extends AbstractResource<ReservaViaje> implements Serializable{

    @Inject
    protected ReservaViajeFacade reserva_viaje;

    public ReservaViajeResource() {
        super(ReservaViaje.class);
    }
    
    @Override
    protected AbstractFacade<ReservaViaje> getFacade() {
        return reserva_viaje;

    }

    @Override
    protected ReservaViaje crearNuevo() {
        return new ReservaViaje();
    }
    
}
