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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.OrigenFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Origen;

/**
 *
 * @author gochez
 */
@Path("origen")
@RequestScoped
public class OrigenResource extends AbstractResource<Origen> implements Serializable{

    
    @Inject
    protected OrigenFacade origen;

    public OrigenResource() {
        super(Origen.class);
    }
    
    @Override
    protected AbstractFacade<Origen> getFacade() {
       return origen;
    }

    @Override
    protected Origen crearNuevo() {
        return new Origen();
    }
    
}
