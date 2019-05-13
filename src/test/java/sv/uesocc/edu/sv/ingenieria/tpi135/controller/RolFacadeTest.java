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
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Rol;

/**
 *
 * @author gochez
 */
public class RolFacadeTest extends AbstractFacadeT<Rol>{

    @Override
    protected AbstractFacade<Rol> getFacade() {
        return new RolFacade();
    }

    @Override
    protected Rol getEntity() {
        return new Rol(1);
    }
    
    
    
}
