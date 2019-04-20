/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.backend;

import javax.faces.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.LazyDataModel;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Rol;

/**
 *
 * @author zentaury
 */
public class RolViewTest extends DefaultGeneratorTest<Rol>{
    
    public RolViewTest() {
    }

    @Override
    protected LazyDataModel<Rol> getLazyDataModel() {
        return new LazyDataModel<Rol>() {};
    }

    @Override
    protected DefaultGenerator<Rol> getDefaultGenerator() {
       return new RolView();
    }
    
   
    
}
