/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Modelo;

/**
 *
 * @author gochez
 */
@Stateless
public class ModeloFacade extends AbstractFacade<Modelo> {

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloFacade() {
        super(Modelo.class);
    }

    public List<Modelo> findModelo(int idMarca) {
        List<Modelo> lista = null;
        try {
            Query query = em.createNamedQuery("Modelo.findModeloByMarca");
            query.setParameter("idM", idMarca);
            lista = query.getResultList();

        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }
    
    public List<Modelo> findById(int idMarca, int idModelo){
        List<Modelo> list= null;
        try {
            Query query = em.createNamedQuery("Modelo.findById");
            query.setParameter("idMarca", idMarca);
            query.setParameter("idModelo", idModelo);
            list=query.getResultList();
            if (!list.isEmpty()) {
                return list;
            }
        } catch (Exception e) {
            throw e;
        }
        return new ArrayList<>();
    }

}
