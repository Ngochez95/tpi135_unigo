/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.ReservaViaje;

/**
 *
 * @author gochez
 */
public class ReservaViajeFacadeTest extends AbstractFacadeT<ReservaViaje>{

    @Override
    protected AbstractFacade<ReservaViaje> getFacade() {
        return new ReservaViajeFacade();
    }

    @Override
    protected ReservaViaje getEntity() {
        return new ReservaViaje(1);
                
    }
    
    
    
}
