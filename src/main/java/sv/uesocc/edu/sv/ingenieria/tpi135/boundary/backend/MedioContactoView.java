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
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.MedioContactoFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.UsuarioFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.MedioContacto;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;

/** vamos a probar otra para que veas que si conecta xd
 *
 * @author zentaury
 */
@Named
@ViewScoped
public class MedioContactoView extends DefaultGenerator<MedioContacto> implements Serializable{

   
    
    @Inject
   private MedioContactoFacade medioContactoFacade;
    
    @Inject
    private UsuarioFacade usuariofacade;
    
     List<Usuario> lstUsuarios; 
     
     @Override
    protected void inicializarListas() {
        lstUsuarios = usuariofacade.findByRol();
        
    }
   
   @Override
   public MedioContacto crearNuevo(){
       this.registro = new MedioContacto();
       return registro;
   }
   
   @Override
    protected AbstractFacade<MedioContacto> getFacade() {
        return this.medioContactoFacade;
    }
   
    @Override
    public MedioContacto obtenerRowData(String rowKey) {
        try {
            List<MedioContacto> registros = (List<MedioContacto>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (MedioContacto r : registros) {
                    if (r.getIdMedioContacto().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(MedioContacto Object) {
        if (Object != null) {
            return Object.getIdMedioContacto();
        }
        return null;

    }
    
    @Override
    public void btnGuardarHandler(ActionEvent ae) {
        boolean resultado = false;

        try {

            if (this.registro != null && this.getFacade() != null) {

                System.out.println("metodo sobreescrito" + this.registro.getIdMedioContacto());
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
    
    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }
    
    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
}
