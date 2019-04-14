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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.TipoMedioContactoFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoMedioContacto;

/**
 *
 * @author zentaury
 */
@Named
@ViewScoped
public class TipoMedioContactoView extends DefaultGenerator<TipoMedioContacto> implements Serializable{

    @Inject
    private TipoMedioContactoFacade tipoMedioContactoFacade;
    
    @Override
    public TipoMedioContacto crearNuevo(){
        this.registro = new TipoMedioContacto();
        return registro;
    }
    
    @Override
    protected AbstractFacade<TipoMedioContacto> getFacade(){
        return this.tipoMedioContactoFacade;
    }
    
    @Override
    public TipoMedioContacto obtenerRowData(String rowKey){
        try{
            List<TipoMedioContacto> registros = (List<TipoMedioContacto>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (TipoMedioContacto r : registros) {
                    if (r.getIdTipoMedioContacto().compareTo(buscado) == 0) {
                        return r;
                    }
                }
            }
        } catch (Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }
    
    @Override
    public Object obtenerRowKey(TipoMedioContacto Object) {
        if (Object != null) {
            return Object.getIdTipoMedioContacto();
        }
        return null;

    }
    @Override
    public void btnGuardarHandler(ActionEvent ae) {
        boolean resultado = false;

        try {

            if (this.registro != null && this.getFacade() != null) {

                System.out.println("metodo sobreescrito" + this.registro.getIdTipoMedioContacto());
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
}