/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;

/**
 *
 * @author gochez & Zepeda Abrego
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();



    public void loggerSevere(Exception e){
         Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
    }
  
    public T create(T entity) {
        T salida = null;
        try {
           
            if (getEntityManager() != null && entity != null) {
                getEntityManager().persist(entity);
                salida = entity;
            }
        } catch (Exception e) {
            loggerSevere(e);
        }
        return salida;
    }



    public T edit(T entity) {
        T salida = null;
        try {
            EntityManager em = getEntityManager();
            if (em != null && entity != null) {
                em.merge(entity);
                salida = entity;
            }
        } catch (Exception e) {
            loggerSevere(e);
        }
        return salida;
    }

    public boolean crear(T entity) {
        try {
            getEntityManager().persist(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editar(T entity) {
        try {
            getEntityManager().merge(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(T entity) {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public T find(Object id) {
        try {
            if (id != null) {
                return getEntityManager().find(entityClass, id);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List<T> findAll() {
        try {
            if (getEntityManager() != null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                cq.select(cq.from(entityClass));
                return getEntityManager().createQuery(cq).getResultList();
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List<T> findRange(int desde, int hasta) throws EJBException{
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(hasta);
        q.setFirstResult(desde);
        return q.getResultList();
    }

    public int count() {
        try {
            if (getEntityManager() != null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
                cq.select(getEntityManager().getCriteriaBuilder().count(rt));
                javax.persistence.Query q = getEntityManager().createQuery(cq);
                return ((Long) q.getSingleResult()).intValue();
            }
        } catch (Exception e) {
            throw e;
        }
        return 0;

    }

}
