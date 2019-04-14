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
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.MarcaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;

/**
 *
 * @author gochez
 */
@Named
@ViewScoped
public class MarcaView extends DefaultGenerator<Marca> implements Serializable {

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
    public Object obtenerRowKey(Marca Object) {
        if (Object != null) {
            return Object.getIdMarca();
        }
        return null;

    }

////    @Override
////    public void btnGuardarHandler(ActionEvent ae) {
////        boolean resultado = false;
////
////        try {
////
////            if (this.registro != null && this.getFacade() != null) {
//////              resultado = 
////                System.out.println("metodo sobreescrito" + this.registro.getMarca());
////                this.getFacade().create(this.registro);
////                generarMensaje(ACCION.CREAR, resultado);
////                if (resultado) {
////                    this.accion = null;
////                    this.mostrandoDetalle = false;
////                }
////
////            }
////        } catch (Exception ex) {
////            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
////        }
////    }


  

//    private String mensaje;
//    private List<Vehiculo> vhlist;
//    private List vhlistOne;
//    private Marca marca;
//
//    @Inject
//    private MarcaFacade marcaFacade;
//
//    @Inject
//    private VehiculoFacade vhFacade;
//
//    @PostConstruct
//    public void init() {
//        marca = new Marca();
//        llenarListavh();
//
//    }
//
//    public List llenarListavh() {
//        vhlist = new ArrayList<>();
//        vhlistOne = new ArrayList<>();
//
//        vhlist = vhFacade.findAll();
//        for (int i = 0; i < vhlist.size(); i++) {
//            vhlistOne.add(vhlist.get(i).getIdVehiculo());
//        }
//        return vhlistOne;
//    }
//
//    @Override
//    public Marca crearNuevo() {
//        this.registro = new Marca();
//        return registro;
//    }
//
//    @Override
//    protected AbstractFacade<Marca> getFacade() {
//        return this.marcaFacade;
//    }
//
//    @Override
//    public Marca obtenerRowData(String rowKey) {
//        try {
//            List<Marca> registros = (List<Marca>) this.modelo.getWrappedData();
//            if (registros != null && !registros.isEmpty()) {
//                Integer buscado = Integer.parseInt(rowKey);
//                for (Marca r : registros) {
//                    if (r.getIdMarca().compareTo(buscado) == 0) {
//                        return r;
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//        }
//        return null;
//    }
//
//    @Override
//    public Object obtenerRowKey(Marca object) {
//        if (object != null) {
//            return object.getIdMarca();
//        }
//        return null;
//    }
//
//    private void crearMensaje(String header, String message, boolean exito) {
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(exito ? FacesMessage.SEVERITY_INFO : FacesMessage.SEVERITY_ERROR, header, message));
//
//    }
//
//    public void crearMarca() {
//        try {
//            this.marca.setIdMarca(marcaFacade.count() + 1);
////          this.marca.setIdVehiculo(new Vehiculo(2));
//            marcaFacade.crear(marca);
//        } catch (Exception e) {
//        }
//
//    }
//
//    public String getMensaje() {
//        return "provando" + mensaje;
//    }
//
//    public void setMensaje(String mensaje) {
//        this.mensaje = mensaje;
//    }
//
//    public List<Vehiculo> getVhlist() {
//        return vhlist;
//    }
//
//    public void setVhlist(List<Vehiculo> vhlist) {
//        this.vhlist = vhlist;
//    }
//
//    public List<Vehiculo> getVhlistOne() {
//        return vhlistOne;
//    }
//
//    public void setVhlistOne(List<Vehiculo> vhlistOne) {
//        this.vhlistOne = vhlistOne;
//    }
//
//    public Marca getMarca() {
//        return marca;
//    }
//
//    public void setMarca(Marca marca) {
//        this.marca = marca;
//    }
}
