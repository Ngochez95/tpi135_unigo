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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.TrayectoriaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.UsuarioFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;


/**
 *
 * @author zentaury
 */
@Named
@ViewScoped
public class TrayectoriaView extends DefaultGenerator<Trayectoria> implements Serializable{
    
    @Inject
    private TrayectoriaFacade trayectoriaFacade;
    
    @Inject
    private UsuarioFacade usuarioFacade;
    
    List<Usuario> lstUsuarios;
    List<Trayectoria> lstPadre;
    
    
    
    @Override
    protected void inicializarListas(){
        lstUsuarios = usuarioFacade.findByRol();
        lstPadre = trayectoriaFacade.findAll();
    }

   
    
    @Override
    public Trayectoria crearNuevo() {
        this.registro = new Trayectoria();
        return registro;
    }
    
     @Override
    protected AbstractFacade<Trayectoria> getFacade() {
        return this.trayectoriaFacade;
    }
    
    @Override
    public Trayectoria obtenerRowData(String rowKey) {
        try {
            List<Trayectoria> registros = (List<Trayectoria>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (Trayectoria r : registros) {
                    if (r.getIdTrayectoria().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(Trayectoria Object) {
        if (Object != null) {
            return Object.getIdTrayectoria();
        }
        return null;

    }
    
    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
     public List<Trayectoria> getLstPadre() {
        return lstPadre;
    }

    public void setLstPadre(List<Trayectoria> lstPadre) {
        this.lstPadre = lstPadre;
    }
   
    
}
