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
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;

/**
 *
 * @author gochez
 */
public class CaractetisticaFacadeTest extends AbstractFacadeT<Caractetistica>{

    @Override
    protected AbstractFacade<Caractetistica> getFacade() {
        return new CaractetisticaFacade();
    }

    @Override
    protected Caractetistica getEntity() {
        return new Caractetistica(1);
    }
    
  
    
}
