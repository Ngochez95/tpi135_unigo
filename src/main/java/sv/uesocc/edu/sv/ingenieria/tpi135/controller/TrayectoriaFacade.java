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
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;

/**
 *
 * @author gochez
 */
@Stateless
public class TrayectoriaFacade extends AbstractFacade<Trayectoria> {

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrayectoriaFacade() {
        super(Trayectoria.class);
    }
    
    public List<Trayectoria> findByReferencia(int idReferencia) {
        List<Trayectoria> lista = null;
        try {
            Query consulta = em.createNamedQuery("Trayectoria.findByReferencia");
            consulta.setParameter("idReferencia", idReferencia);
            lista = consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;

    }


    
}
