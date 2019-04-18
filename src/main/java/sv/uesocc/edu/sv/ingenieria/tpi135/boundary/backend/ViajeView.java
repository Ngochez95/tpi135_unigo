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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.TrayectoriaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ViajeFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Semana;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author zentaury
 */
@Named
@ViewScoped
public class ViajeView extends DefaultGenerator<Viaje> implements Serializable{

    @Inject
    private ViajeFacade viajeFacade;
    
    @Inject
    private TrayectoriaFacade trayectoriaFacade;
    
    @Inject
    private SemanaFacade semanaFacade;
    
    List<Trayectoria> lstTrayectoria;
    List<Semana> lstSemana;
    
    @Override
    protected void inicializarListas() {
        lstTrayectoria = trayectoriaFacade.findAll();
        lstSemana = semanaFacade.findAll();
    }
    
    @Override
    public Viaje crearNuevo() {
        this.registro = new Viaje();
        return registro;
    }
    
    @Override
    protected AbstractFacade<Viaje> getFacade() {
        return this.viajeFacade;
    }
    
     @Override
    public Viaje obtenerRowData(String rowKey) {
        try {
            List<Viaje> registros = (List<Viaje>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (Viaje r : registros) {
                    if (r.getIdViaje().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(Viaje Object) {
        if (Object != null) {
            return Object.getIdViaje();
        }
        return null;

    }
    
     public List<Trayectoria> getLstTrayectoria() {
        return lstTrayectoria;
    }

    public void setLstTrayectoria(List<Trayectoria> lstTrayectoria) {
        this.lstTrayectoria = lstTrayectoria;
    }
    
     public List<Semana> getLstSemana() {
        return lstSemana;
    }

    public void setLstSemana(List<Semana> lstSemana) {
        this.lstSemana = lstSemana;
    }
}
