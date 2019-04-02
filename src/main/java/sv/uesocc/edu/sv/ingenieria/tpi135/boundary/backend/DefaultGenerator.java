package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractInterface;

/**
 *
 * @author gochez
 * @param <T>
 */
public abstract class DefaultGenerator<T> implements Serializable {
    
    protected LazyDataModel<T> modelo;

    protected int TamanioDePagina = 5;

    protected T registro;

    protected boolean mostrandoDetalle;
    
    @PostConstruct
    protected void inicializar() {
        this.inicializarModelo();
        this.mostrandoDetalle = false;
        //Este es para cuando la interfaz lleva un combobox
//        this.inicializarListas();
    }

    public abstract T crearNuevo();

    public List<T> cargarDatos(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List salida = null;
        try {
            if (getFacade() != null) {
                salida = getFacade().findRange(first, pageSize);
                if (this.modelo != null) {
                    this.modelo.setRowCount(getFacade().count());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida == null) {
                salida = new ArrayList();
            }
        }
        return salida;
    }

    protected abstract AbstractInterface<T> getFacade();

    public abstract T obtenerRowData(String rowKey);

    public abstract Object obtenerRowKey(T Object);

    protected void inicializarModelo() {
        try {
            this.modelo = new LazyDataModel<T>() {
                @Override
                public T getRowData(String rowKey) {
                    return obtenerRowData(rowKey);
                }

                @Override
                public Object getRowKey(T object) {
                    return obtenerRowKey(object);
                }
                @Override
                public List <T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters){
                    return cargarDatos(first,pageSize, sortField, sortOrder, filters);
                }
            };

        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public void cambiarSeleccion(SelectEvent se) {
        
        if (se.getObject() != null) {
            try {
                this.registro = (T) se.getObject();
                this.mostrandoDetalle = true;
//                this.accion = ACCION.EDITAR;
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

    }

    public void btnNuevoHandler(ActionEvent ae) {
        this.crearNuevo();
        this.mostrandoDetalle = true;
        //this.accion = ACCION.CREAR;
    }

    public void btnCancelarHandler(ActionEvent ae) {
        this.registro = null;
//        this.accion = null;
        this.mostrandoDetalle = false;
        
    }
    
    

    public void btnGuardarHandler(ActionEvent ae) {
        
        boolean resultado = false;
        
        try {
            if (this.registro != null && this.getFacade() != null) {
                /**resultado = **/this.getFacade().create(this.registro);
//                generarMensaje(ACCION.CREAR, resultado);
                if (resultado) {
//                    this.accion = null;
                    this.mostrandoDetalle = false;
                }
                
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void btnEliminarHandler(ActionEvent ae) {
        try {
            if (this.registro != null && this.getFacade() != null) {
                boolean resultado = this.getFacade().remove(registro);
//                this.generarMensaje(ACCION.ELIMINAR, resultado);
                this.registro = null;
//                this.accion = null;
                
            } else {
//                this.generarMensaje(ACCION.ELIMINAR, false, "El registro no es valido");
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void btnModificarHandler(ActionEvent ae) {
        try {
            if (this.registro != null && this.getFacade() != null) {
//                T pivot = this.getFacade().edit(registro);
//                boolean resultado= false;
//                if (pivot != null) {
//                    resultado = true;
//                    this.registro = pivot;
//                }
//                this.generarMensaje(ACCION.EDITAR, resultado);
//                this.accion = null;
                boolean resultado = false;
/**                if (this.getFacade().edit(registro)) {
                    resultado = true; 
                }**/
//                this.generarMensaje(ACCION.EDITAR, resultado);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

//    public void generarMensaje(ACCION accion, boolean resultado) {
//        this.generarMensaje(accion, resultado, null);
//    }
//
//    public void generarMensaje(ACCION accion, boolean resultado, final String mensajeDetalle) {
//        this.generarMensaje(accion, resultado, mensajeDetalle, false);
//    }

//    public void generarMensaje(ACCION accion, boolean resultado, final String mensajeDetalle, boolean mostrarDetalle) {
//        FacesMessage mensaje = new FacesMessage();
//        if (mensajeDetalle != null) {
//            mensaje.setDetail(mensajeDetalle);
//        }
//        mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
//        this.mostrandoDetalle = false;
//        if (!resultado) {
//            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
//            this.mostrandoDetalle = true;
//        }
//        switch (accion) {
//            case EDITAR:
//                mensaje.setSummary(sesion.getMensaje("crud.edit.error"));
//                if (resultado) {
//                mensaje.setSummary(sesion.getMensaje("crud.edit.success"));
//                }
//                break;
//            case ELIMINAR:
//                mensaje.setSummary(sesion.getMensaje("crud.remove.error"));
//                if (resultado) {
//                mensaje.setSummary(sesion.getMensaje("crud.remove.success"));
//                }
//                break;
//            case CREAR:
//                mensaje.setSummary(sesion.getMensaje("crud.create.error"));
//                if (resultado) {
//                mensaje.setSummary(sesion.getMensaje("crud.create.success"));
//                }
//        }
//        try {
//            FacesContext.getCurrentInstance().addMessage(null, mensaje);
//        } catch (Exception ex) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//        }
//    }

//    public enum ACCION {
//        CREAR, EDITAR, ELIMINAR;
//    }

    public LazyDataModel<T> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<T> modelo) {
        this.modelo = modelo;
    }

    public int getTamanioDePagina() {
        return TamanioDePagina;
    }

    public void setTamanioDePagina(int TamanioDePagina) {
        this.TamanioDePagina = TamanioDePagina;
    }

    public T getRegistro() {
        return registro;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }

    public boolean isMostrandoDetalle() {
        return mostrandoDetalle;
    }

    public void setMostrandoDetalle(boolean mostrandoDetalle) {
        this.mostrandoDetalle = mostrandoDetalle;
    }

//    public boolean isAgregando() {
//        return this.accion != null && this.accion.equals(ACCION.CREAR);
//    }
//
//    public boolean isEditando() {
//        return this.accion != null && !this.accion.equals(ACCION.CREAR);
//    }

}