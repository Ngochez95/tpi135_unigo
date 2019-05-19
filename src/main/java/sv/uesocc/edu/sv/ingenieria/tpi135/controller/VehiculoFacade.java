/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    public List<Vehiculo> findActivo(int idReferencia) {
        List<Vehiculo> lista = null;
        try {
            Query consulta = em.createNamedQuery("Vehiculo.findActivo");
            consulta.setParameter("idReferencia", idReferencia);
            lista = consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;

    }
    
        public List<Vehiculo> findAllId(int idVehiculo) {
        List<Vehiculo> lista = null;
        try {
            Query consulta = em.createNamedQuery("Vehiculo.findAllbyId");
//            consulta.setParameter("idVehiculo", idVehiculo);
            lista = consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;

    }




    
}
