/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractInterface;
/**
 *
 * @author gochez & zepeda abrego
 */
public abstract class AbstractResource<T> implements Serializable {

    protected abstract AbstractInterface<T> getFacade();
    
    protected abstract T crearNuevo();

    protected T entity;

    private Class<T> entityClass;

    public AbstractResource(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<T> findAll() {
        if (getFacade() != null) {
            try {
                List<T> list = null;
                list = getFacade().findAll();
                if (list != null) {
                    return list;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new ArrayList<>();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<T> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize
    ) {
        if (getFacade() != null && first >= 0 && pageSize >= 0) {
            try {
                List salida = null;
                salida = getFacade().findRange(first, pageSize);
                if (salida != null) {
                    return salida;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new ArrayList<>();
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        if (getFacade() != null) {
            try {
                return getFacade().count();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return 0;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public T findById(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {
        if (getFacade() != null && id != null && id > 0) {
            try {
                T reg = getFacade().find(id);
                if (reg != null) {
                    return reg;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return crearNuevo();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public T create(T registro) throws InstantiationException, IllegalAccessException {
        if (getFacade() != null && registro != null) {
            try {
                T r = getFacade().crear(registro);
                if (r != null) {
                    return r;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return crearNuevo();
    }
    
    //se le borraron validaciones porque accedia al atributo id que esdiferente en cada entidad
    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public T edit(T registro) {
        if (getFacade() != null) {
            if (registro != null) {
                try {
                    T r = getFacade().editar(registro);
                    if (r != null) {
                        return r;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return crearNuevo();
    }    

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public T delete(
            @PathParam("id") Integer id
    ) throws InstantiationException, IllegalAccessException {
        if (getFacade() != null && id != null && id > 0) {
            try {
                T reg = getFacade().find(id);
                if(reg != null){
                    if (getFacade().remove(reg)) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return crearNuevo();
    }    
    
}
