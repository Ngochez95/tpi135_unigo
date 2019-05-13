/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.backend;

import java.util.List;
import javax.faces.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.LazyDataModel;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Origen;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;

/**
 *
 * @author zentaury
 */
public class OrigenViewTest extends DefaultGeneratorTest<Origen>{
    
    public OrigenViewTest() {
    }

    @Override
    protected LazyDataModel<Origen> getLazyDataModel() {
       return new LazyDataModel<Origen>() {};
    }

    @Override
    protected DefaultGenerator<Origen> getDefaultGenerator() {
       return new OrigenView();
    }
    
   
    
}
