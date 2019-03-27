/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author gochez
 */
@Stateless
public class ViajeFacade extends AbstractFacade<Viaje> implements ViajeFacadeLocal {

    private List<Viaje> lista = null;

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViajeFacade() {
        super(Viaje.class);
    }

    @Override
    public List<Viaje> findByConductor(int idUsuario) {
        try {
            Query consulta = em.createNamedQuery("Viaje.findByConductor");
            consulta.setParameter("idUsuario", idUsuario);
            lista = consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;

    }

    @Override
    public List findRange(int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
