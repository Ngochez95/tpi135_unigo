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
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.OrigenFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.UsuarioFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Origen;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;

/**
 *
 * @author zentaury
 */
@Named
@ViewScoped
public class OrigenView extends DefaultGenerator<Origen> implements Serializable{
    
    @Inject
    private OrigenFacade origenFacade;
    
    @Inject
    private UsuarioFacade usuarioFacade;
    
    List<Origen> lstOrigenPadre;
    List<Usuario> lstUsuario;
    

    @Override
    protected void inicializarListas() {
        lstOrigenPadre = origenFacade.findAll();
        lstUsuario = usuarioFacade.findAll();
        
    }
    
    @Override
    public Origen crearNuevo(){
        this.registro = new Origen();
        return registro;
    }
    
    @Override
    protected AbstractFacade<Origen> getFacade(){
        return this.origenFacade;
    }
    
     @Override
    public Origen obtenerRowData(String rowKey) {
        try {
            List<Origen> registros = (List<Origen>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (Origen r : registros) {
                    if (r.getIdOrigen().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(Origen Object) {
        if (Object != null) {
            return Object.getIdOrigen();
        }
        return null;

    }
    
    @Override
    public void btnGuardarHandler(ActionEvent ae) {
        boolean resultado = false;

        try {

            if (this.registro != null && this.getFacade() != null) {

                System.out.println("metodo sobreescrito" + this.registro.getOrigen());
                this.getFacade().create(this.registro);
                generarMensaje(ACCION.CREAR, resultado);
                if (resultado) {
                    this.accion = null;
                    this.mostrandoDetalle = false;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public List<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public List<Origen> getLstOrigenPadre() {
        return lstOrigenPadre;
    }

    public void setLstOrigenPadre(List<Origen> lstOrigenPadre) {
        this.lstOrigenPadre = lstOrigenPadre;
    }

}
