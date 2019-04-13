/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.MarcaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.UsuarioFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.VehiculoFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
@Named
@ViewScoped
public class VehiculoView extends DefaultGenerator<Vehiculo> implements Serializable {

    @Inject
    private VehiculoFacade vehiculofacade;

    @Inject
    private MarcaFacade marcafacade;

    @Inject
    private UsuarioFacade usuariofacade;

    List<Marca> marcasvehiculos;
    List<Usuario> lstUsuarios;

    @Override
    protected void inicializarListas() {
        marcasvehiculos = marcafacade.findAll();
        lstUsuarios = usuariofacade.findAll();
        
    }

    @Override
    public Vehiculo crearNuevo() {
        this.registro = new Vehiculo();
        return registro;
    }

    @Override
    protected AbstractFacade<Vehiculo> getFacade() {
        return this.vehiculofacade;
    }

    @Override
    public Vehiculo obtenerRowData(String rowKey) {
        try {
            List<Vehiculo> registros = (List<Vehiculo>) this.modelo.getWrappedData();
            if (registros != null && !registros.isEmpty()) {
                Integer buscado = Integer.parseInt(rowKey);
                for (Vehiculo r : registros) {
                    if (r.getIdVehiculo().compareTo(buscado) == 0) {
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
    public Object obtenerRowKey(Vehiculo Object) {
        if (Object != null) {
            return Object.getIdVehiculo();
        }
        return null;

    }

    public List<Marca> getMarcasvehiculos() {
        return marcasvehiculos;
    }

    public void setMarcasvehiculos(List<Marca> marcasvehiculos) {
        this.marcasvehiculos = marcasvehiculos;
    }

    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

}
