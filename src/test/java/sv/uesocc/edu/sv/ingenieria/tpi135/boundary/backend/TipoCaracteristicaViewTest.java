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
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoCaracteristica;

/**
 *
 * @author zentaury
 */
public class TipoCaracteristicaViewTest extends DefaultGeneratorTest<TipoCaracteristica>{
    
    public TipoCaracteristicaViewTest() {
    }

    @Override
    protected LazyDataModel<TipoCaracteristica> getLazyDataModel() {
        return new LazyDataModel<TipoCaracteristica>() {};
    }

    @Override
    protected DefaultGenerator<TipoCaracteristica> getDefaultGenerator() {
        return new TipoCaracteristicaView();
    }
    
   
    
}
