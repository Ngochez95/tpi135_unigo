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
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.MarcaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;

/**
 *
 * @author rcarlossh
 */
@Named
@ViewScoped
public class MarcaView extends DefaultGenerator<Marca> implements Serializable {

    private String mensaje;
    
    @Inject
    private MarcaFacade marcaFacade;

    @Override
    public Marca crearNuevo() {
        this.registro = new Marca();
        return registro;
    }

    @Override
    protected AbstractFacade<Marca> getFacade() {
        return this.marcaFacade;
    }

    @Override
    public Marca obtenerRowData(String rowKey) {
        try {
            List<Marca> registros = (List<Marca>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (Marca r : registros) {
                    if (r.getIdMarca().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(Marca object) {
        if (object != null) {
            return object.getIdMarca();
        }
        return null;
    }

    public String getMensaje() {
        return "provando"+mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    

}
