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
import java.util.stream.Collectors;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.MarcaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ModeloFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Modelo;

/**
 *
 * @author gochez
 */
@Named
@ViewScoped
public class ModeloView extends DefaultGenerator<Modelo> implements Serializable {

    /**
     * Creates a new instance of ModeloView
     */
    @Inject
    ModeloFacade modelofacade;
    
    @Inject
    MarcaFacade marcafacade;
    
    private List<Marca> ltsMarcas;

    public ModeloView() {
    }

    @Override
    public Modelo crearNuevo() {
        this.registro = new Modelo();
        return registro;
    }

    @Override
    protected void inicializarListas() {
        ltsMarcas= marcafacade.findAll();
    }
    
    

    @Override
    protected AbstractFacade<Modelo> getFacade() {
        return this.modelofacade;
    }

    @Override
    public Modelo obtenerRowData(String rowKey) {
   
      return this.modelo.getWrappedData().stream().filter(r->r.getIdModelo().toString().equalsIgnoreCase(rowKey)).collect(Collectors.toList()).get(0);
        

    }

    @Override
    public Object obtenerRowKey(Modelo Object) {
        if (Object != null) {
            return Object.getIdModelo();
        }
        return null;

    }

    public List<Marca> getLtsMarcas() {
        return ltsMarcas;
    }

    public void setLtsMarcas(List<Marca> ltsMarcas) {
        this.ltsMarcas = ltsMarcas;
    }

    
    
}
