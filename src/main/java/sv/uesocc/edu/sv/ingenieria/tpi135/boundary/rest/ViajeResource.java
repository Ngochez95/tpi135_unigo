/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ViajeFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author zentaury
 */

@Path("viaje")
@RequestScoped
public class ViajeResource extends AbstractResource<Viaje> implements Serializable {

    /**
     * Creates a new instance of ViajeResource
     */
    @Inject
    protected ViajeFacade viajefd;

    public ViajeResource() {
        super(Viaje.class
        );
    }

    @Override
    protected Viaje crearNuevo() {
        return new Viaje();
    }

    @Override
    protected AbstractFacade getFacade() {
        return viajefd;
    }

}
