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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.SemanaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Semana;

/**
 *
 * @author zentaury
 */
@Named
@ViewScoped
public class SemanaView extends DefaultGenerator<Semana> implements Serializable{

    @Inject
    private SemanaFacade semanaFacade;
    
    @Override
    public Semana crearNuevo() {
        this.registro = new Semana();
        return registro;
    }
    
    @Override
    protected AbstractFacade<Semana> getFacade() {
        return this.semanaFacade;
    }
    
     @Override
    public Semana obtenerRowData(String rowKey) {
        try {
            List<Semana> registros = (List<Semana>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (Semana r : registros) {
                    if (r.getIdDia().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(Semana Object) {
        if (Object != null) {
            return Object.getIdDia();
        }
        return null;

    }
    
}
