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

    public void loggerWarningEntityNull() {
        Logger.getLogger(getClass().getName()).log(Level.WARNING, "EntityManager o Entity son nulos");
        throw new NullPointerException("EntityManager o Entity son nulos");
    }

    public void loggerSevereEntityNull(Exception e) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
    }

    public void sqlExceptionLogger(SQLException sqle) {

    }

    public void mostrarExcepcion(Exception e) {
        System.out.println("excepcion: " + e);
    }

    public void create(T entity) {
        try {
            if (getEntityManager() != null && entity != null) {
                getEntityManager().persist(entity);
            } else {
                loggerWarningEntityNull();
            }
        } catch (Exception e) {
            loggerSevereEntityNull(e);
        }

    }

    public void edit(T entity) {
        try {
            if (getEntityManager() != null && entity != null) {
                getEntityManager().merge(entity);
            } else {
                loggerWarningEntityNull();
            }
        } catch (Exception e) {
            loggerSevereEntityNull(e);
        }

    }

    public void remove(T entity) {
        try {
            if (getEntityManager() != null && entity != null) {
                getEntityManager().remove(getEntityManager().merge(entity));
            } else {
                loggerWarningEntityNull();
            }
        } catch (Exception e) {
            loggerSevereEntityNull(e);
        }

    }

    public T find(Object id) {
        try {
            if (id != null) {
                return getEntityManager().find(entityClass, id);
            }
        } catch (Exception e) {
            mostrarExcepcion(e);
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
            mostrarExcepcion(e);
        }
        return null;
    }

    public List<T> findRange(int[] range) {
        try {
            if (range != null && getEntityManager() != null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                cq.select(cq.from(entityClass));
                javax.persistence.Query q = getEntityManager().createQuery(cq);
                q.setMaxResults(range[1] - range[0] + 1);
                q.setFirstResult(range[0]);
                return q.getResultList();
            }
        } catch (Exception e) {
            mostrarExcepcion(e);
        }
        return null;
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
            mostrarExcepcion(e);
        }
        return 0;

    }

    public Class<T> getEntityClass() {
        try {
            if (getEntityClass() != null) {
                return entityClass;
            }
        } catch (Exception e) {
            mostrarExcepcion(e);
        }
        return null;

    }

}
