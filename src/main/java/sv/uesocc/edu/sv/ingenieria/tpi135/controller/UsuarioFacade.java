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
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;

/**
 *
 * @author gochez
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "tpi135.proyecto_uniGo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public List<Usuario> findByRol() {
        List<Usuario> lista = null;
        try {
            Query consulta = em.createNamedQuery("Usuario.findByRol");
            lista = consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }

    public List<Usuario> findByNombreUsuario(String nombreUsuario) {
        List<Usuario> lista = null;
        try {
            Query consulta = em.createNamedQuery("Usuario.findByNombreUsuario");
            consulta.setParameter("nombreUsuario", "%" + nombreUsuario + "%");
            consulta.setParameter("nombreUno", "%" + nombreUsuario + "%");
            consulta.setParameter("nombreDos", "%" + nombreUsuario + "%");
            consulta.setParameter("apellidoUno", "%" + nombreUsuario + "%");
            consulta.setParameter("apellidoDos", "%" + nombreUsuario + "%");

            lista = consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }

}
