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

//    public void create(T entity) {
//        getEntityManager().persist(entity);
//    }

    
    //y asi como lo tenes no los has provado con docker? bien el mismo problema me daba subi los cambios pues, voy a ver :v es un gran chingo de cambios que asaber si estan buenos ya vas a ver 
    public T create(T entity) {
        T salida = null;
        try {
            //EntityManager em = getEntityManager();
            if (getEntityManager() != null && entity != null) {
                getEntityManager().persist(entity);
                salida = entity;
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }

//    public void edit(T entity) {
//        getEntityManager().merge(entity);
//    }

    public T edit(T entity) {
        T salida = null;
        try {
            EntityManager em = getEntityManager();
            if (em != null && entity != null) {
                em.merge(entity);
                salida = entity;
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
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
        }
        return null;
    }

    public List<T> findRange(int desde, int hasta) {
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
        }
        return 0;

    }

}
