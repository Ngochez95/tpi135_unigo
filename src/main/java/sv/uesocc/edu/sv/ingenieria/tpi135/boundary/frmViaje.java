/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractInterface;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ViajeFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ViajeFacadeLocal;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author zentaury
 */
@Named(value = "frmViaje")
@ViewScoped
public class frmViaje extends AbstractResource<Viaje> implements Serializable {

    /**
     * Creates a new instance of frmViaje
     */
    @EJB
    private ViajeFacadeLocal viajefd;

    public frmViaje() {
        super(Viaje.class
        );
    }

    @Override
    protected Viaje crearNuevo() {
        return new Viaje();
    }

    @Override
    protected AbstractInterface getFacade() {
        return viajefd;
    }

}
