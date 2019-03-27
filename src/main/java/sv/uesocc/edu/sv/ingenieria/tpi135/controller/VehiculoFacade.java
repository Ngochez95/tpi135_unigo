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
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    @Override
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

    @Override
    public List<Vehiculo> findByCaracteristicas(Date anio, int capacidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findRange(int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
