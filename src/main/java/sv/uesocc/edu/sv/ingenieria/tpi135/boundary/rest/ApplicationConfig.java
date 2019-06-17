/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rcarlos
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.CORSFilter.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.ViajeResource.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.VehiculoResource.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.CaracteristicaResource.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.ReservaViajeResource.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.TrayectoriaResource.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.UsuarioResource.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.ModeloResource.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.MarcaResource.class);
        resources.add(sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest.OrigenResource.class);

        return resources;
    }

}
