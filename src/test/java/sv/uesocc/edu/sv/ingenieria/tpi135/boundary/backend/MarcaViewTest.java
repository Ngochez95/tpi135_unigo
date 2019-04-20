/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.backend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.LazyDataModel;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;

/**
 *
 * @author zentaury
 */
public class MarcaViewTest extends DefaultGeneratorTest<Marca>{
    
    public MarcaViewTest() {
    }

    @Override
    protected LazyDataModel<Marca> getLazyDataModel() {
        return null;
    }

    @Override
    protected DefaultGenerator<Marca> getDefaultGenerator() {
        return new MarcaView();
    }
    
  
}
