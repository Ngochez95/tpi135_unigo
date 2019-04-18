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
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ModeloFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Modelo;

/**
 *
 * @author gochez
 */
@Named
@ViewScoped
public class CaracteristicaView extends DefaultGenerator<Caractetistica> implements Serializable {

    @Inject
    private CaractetisticaFacade caracteristicafacade;
    
    @Inject
    private ModeloFacade modelofacade;
    
    List<Modelo> lstmodelo;

    @Override
    protected void inicializarListas() {
        lstmodelo= modelofacade.findAll();
    }
    
    

    @Override
    public Caractetistica crearNuevo() {
        this.registro = new Caractetistica();
        return registro;

    }

    @Override
    protected AbstractFacade<Caractetistica> getFacade() {
        return this.caracteristicafacade;
    }

    @Override
    public Caractetistica obtenerRowData(String rowKey) {
        try {
            List<Caractetistica> registros = (List<Caractetistica>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (Caractetistica r : registros) {
                    if (r.getIdCaracteristica().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(Caractetistica Object) {
        if (Object != null) {
            return Object.getIdCaracteristica();
        }
        return null;

    }

    public List<Modelo> getLstmodelo() {
        return lstmodelo;
    }

    public void setLstmodelo(List<Modelo> lstmodelo) {
        this.lstmodelo = lstmodelo;
    }
    
    

}
