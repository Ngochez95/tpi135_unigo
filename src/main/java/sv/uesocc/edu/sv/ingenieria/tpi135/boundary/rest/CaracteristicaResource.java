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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.CaractetisticaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;

/**
 *
 * @author gochez
 */
@Path("caracteristica")
@RequestScoped
public class CaracteristicaResource extends AbstractResource<Caractetistica> implements Serializable{

   @Inject
   protected CaractetisticaFacade caracteristica;

  public CaracteristicaResource() {
        super(Caractetistica.class
        );
    }
    @Override
    protected AbstractFacade<Caractetistica> getFacade() {
        return caracteristica;
    }

    @Override
    protected Caractetistica crearNuevo() {
        return new Caractetistica();
    }
    
}
