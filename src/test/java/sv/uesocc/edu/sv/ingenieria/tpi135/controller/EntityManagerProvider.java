/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.internal.util.reflection.Whitebox;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;

/**
 *
 * @author zaldivar
 */
public class EntityManagerProvider implements TestRule {

    private EntityManager em;
    private EntityTransaction tx;

    private EntityManagerProvider(String unitName) {
        this.em = Persistence.createEntityManagerFactory(unitName).createEntityManager();

    }

    public final static EntityManagerProvider persistenceUnit(String unitName) {
        return new EntityManagerProvider(unitName);
    }

    public EntityManager em() {
        return this.em;
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                base.evaluate();
                em.clear();
                em.close();
            }

        };
    }
}
