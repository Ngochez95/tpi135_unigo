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
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Modelo;

/**
 *
 * @author zentaury
 */
public class ModeloViewTest extends DefaultGeneratorTest<Modelo>{
    
    public ModeloViewTest() {
    }

    @Override
    protected LazyDataModel<Modelo> getLazyDataModel() {
      return new LazyDataModel<Modelo>() {};
    }

    @Override
    protected DefaultGenerator<Modelo> getDefaultGenerator() {
       return new ModeloView();
    }
    
    
    
}
