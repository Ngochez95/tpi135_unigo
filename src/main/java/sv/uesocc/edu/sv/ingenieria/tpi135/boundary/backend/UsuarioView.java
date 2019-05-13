/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.backend;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.RolFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.UsuarioFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Rol;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;

/**
 *
 * @author zentaury
 */
@Named
@ViewScoped
public class UsuarioView extends DefaultGenerator<Usuario> implements Serializable{

    @Inject
    private UsuarioFacade usuarioFacade;
    
    @Inject
    private RolFacade rolFacade;
    
    List<Rol> lstRol;
    
    @Override
    protected void inicializarListas() {
        lstRol = rolFacade.findAll();
        
    }
    
    @Override
    public Usuario crearNuevo() {
        this.registro = new Usuario();
        return registro;
    }
    
    @Override
    protected AbstractFacade<Usuario> getFacade() {
        return this.usuarioFacade;
    }
    
    @Override
    public Usuario obtenerRowData(String rowKey) {
        try {
            List<Usuario> registros = (List<Usuario>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (Usuario r : registros) {
                    if (r.getIdUsuario().compareTo(buscado) == 0) {
                        return r;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }
    
    @Override
    public Object obtenerRowKey(Usuario Object) {
        if (Object != null) {
            return Object.getIdUsuario();
        }
        return null;

    }
    
    public List<Rol> getLstRol() {
        return lstRol;
    }

    public void setLstRol(List<Rol> lstRol) {
        this.lstRol = lstRol;
    }
    
     
    
}
