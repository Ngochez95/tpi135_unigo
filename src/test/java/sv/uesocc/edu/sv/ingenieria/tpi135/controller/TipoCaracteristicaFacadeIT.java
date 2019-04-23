/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import static sv.uesocc.edu.sv.ingenieria.tpi135.controller.EntityManagerProvider.persistenceUnit;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoCaracteristica;

/**
 *
 * @author gochez
 */
public class TipoCaracteristicaFacadeIT extends AbstractFacadeINT<TipoCaracteristica>{
    
    @Rule
    public EntityManagerProvider emProvider = persistenceUnit("pu-test");
    
    public TipoCaracteristicaFacadeIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loggerSevere method, of class TipoCaracteristicaFacade.
     */

    @Override
    protected AbstractFacade<TipoCaracteristica> getFacade() {
        return new TipoCaracteristicaFacade();
    }

    @Override
    protected EntityManager getEntityManager() {
        return emProvider.em();
    }

    @Override
    protected TipoCaracteristica getEntity() {
        return new TipoCaracteristica(1);
    }
    
}
