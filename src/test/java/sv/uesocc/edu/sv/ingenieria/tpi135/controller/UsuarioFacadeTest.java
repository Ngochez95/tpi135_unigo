/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;

/**
 *
 * @author gochez
 */
public class UsuarioFacadeTest extends AbstractFacadeT<Usuario> {

    @Override
    protected AbstractFacade<Usuario> getFacade() {
        return new UsuarioFacade();
    }

    @Override
    protected Usuario getEntity() {
        return new Usuario(1);
    }
    
    
    
}