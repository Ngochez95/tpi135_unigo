/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.backend;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.LazyDataModel;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;

/**
 *
 * @author zentaury
 */
public class TrayectoriaViewTest extends DefaultGeneratorTest<Trayectoria>{
    
    public TrayectoriaViewTest() {
    }

    @Override
    protected LazyDataModel<Trayectoria> getLazyDataModel() {
        return new LazyDataModel<Trayectoria>() {};
    }

    @Override
    protected DefaultGenerator<Trayectoria> getDefaultGenerator() {
        return new TrayectoriaView();
    }
    
  
}
