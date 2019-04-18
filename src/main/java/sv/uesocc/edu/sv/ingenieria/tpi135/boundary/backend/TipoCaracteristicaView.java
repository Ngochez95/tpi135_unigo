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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.CaractetisticaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.TipoCaracteristicaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoCaracteristica;

/**
 *
 * @author gochez
 */
@Named
@ViewScoped
public class TipoCaracteristicaView extends DefaultGenerator<TipoCaracteristica> implements Serializable {

    @Inject
    private TipoCaracteristicaFacade tipocaracteristicafacade;
    @Inject
    private CaractetisticaFacade caracteristicafacade;
    List<Caractetistica> lstcaracteristica;

    @Override
    public TipoCaracteristica crearNuevo() {
        this.registro = new TipoCaracteristica();
        return registro;
    }

    @Override
    protected void inicializarListas() {
        lstcaracteristica=caracteristicafacade.findAll();
    }
    
    

    @Override
    protected AbstractFacade<TipoCaracteristica> getFacade() {
        return this.tipocaracteristicafacade;
    }

    @Override
    public TipoCaracteristica obtenerRowData(String rowKey) {
        try {
            List<TipoCaracteristica> registros = (List<TipoCaracteristica>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (TipoCaracteristica r : registros) {
                    if (r.getIdTipoCaracteristica().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(TipoCaracteristica Object) {
        if (Object != null) {
            return Object.getIdTipoCaracteristica();
        }
        return null;
    }

    public List<Caractetistica> getLstcaracteristica() {
        return lstcaracteristica;
    }

    public void setLstcaracteristica(List<Caractetistica> lstcaracteristica) {
        this.lstcaracteristica = lstcaracteristica;
    }

    
    
}
