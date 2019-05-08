package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.AbstractFacade;

/**
 *
 * @author gochez, zentaury
 * @param <T>
 */
public abstract class DefaultGenerator<T> implements Serializable {
//
//    @Inject
//    SesionDeUsuarioBean sesion;

    protected LazyDataModel<T> modelo;

    protected int TamanioDePagina = 5;

    protected T registro;

    protected boolean mostrandoDetalle;

    protected ACCION accion;
     
    protected abstract AbstractFacade<T> getFacade();
    
    public abstract T obtenerRowData(String rowKey);
    
    public abstract Object obtenerRowKey(T Object);

    @PostConstruct
    protected void inicializar() {
        this.inicializarModelo();
        this.mostrandoDetalle = false;
        this.inicializarListas();
    }

    public abstract T crearNuevo();

    protected void inicializarListas() {

    }
    
    public void loggerForCatch(Exception ex){
         Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
    }

    public List<T> cargarDatos(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        
        try {
            if (getFacade() != null) {
                if (this.modelo != null) {
                    this.modelo.setRowCount(getFacade().count());
                }
                return getFacade().findRange(first, pageSize);
                
            }
        } catch (Exception ex) {
            loggerForCatch(ex);
        }
        return Collections.EMPTY_LIST;
    }
    
    protected boolean inicializarModelo() {
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
                public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    return cargarDatos(first, pageSize, sortField, sortOrder, filters);
                }
            };
            return true;
        } catch (Exception ex) {
            loggerForCatch(ex);
            return false;
        }

    }

    public void cambiarSeleccion(SelectEvent se) {

        if (se.getObject() != null) {
            try {
                this.registro = (T) se.getObject();
                this.mostrandoDetalle = true;
                this.accion = ACCION.EDITAR;
            } catch (Exception ex) {
                loggerForCatch(ex);
            }
        }

    }

    public void btnNuevoHandler(ActionEvent ae) {
        this.crearNuevo();
        this.mostrandoDetalle = true;
        this.accion = ACCION.CREAR;
    }

    public void btnCancelarHandler(ActionEvent ae) {
        this.registro = null;
        this.accion = null;
        this.mostrandoDetalle = false;

    }

    public void btnGuardarHandler(ActionEvent ae) {

        boolean resultado = false;

        try {
            System.out.println("que esta pasando :'v");
            if (this.registro != null && this.getFacade() != null) {
              resultado =this.getFacade().crear(this.registro);
                generarMensaje(ACCION.CREAR, resultado);
                if (resultado) {
                    this.accion = null;
                    this.mostrandoDetalle = false;
                }

            }
        } catch (Exception ex) {
            loggerForCatch(ex);
        }
    }

    public void btnEliminarHandler(ActionEvent ae) {
        try {
            if (this.registro != null && this.getFacade() != null) {
                boolean resultado = this.getFacade().remove(registro);
                this.generarMensaje(ACCION.ELIMINAR, resultado);
                this.registro = null;
                this.accion = null;

            } else {
                this.generarMensaje(ACCION.ELIMINAR, false, "El registro no es valido");
            }
        } catch (Exception ex) {
            loggerForCatch(ex);
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
                this.accion = null;
                boolean resultado = false;
                if (this.getFacade().editar(registro)) {
                    resultado = true;
                }
                this.generarMensaje(ACCION.EDITAR, resultado);
            }
        } catch (Exception ex) {
           
        }
    }

    public void generarMensaje(ACCION accion, boolean resultado) {
        this.generarMensaje(accion, resultado, null);
    }

    public void generarMensaje(ACCION accion, boolean resultado, final String mensajeDetalle) {
        this.generarMensaje(accion, resultado, mensajeDetalle, false);
    }

    public void generarMensaje(ACCION accion, boolean resultado, final String mensajeDetalle, boolean mostrarDetalle) {
        FacesMessage mensaje = new FacesMessage();
        if (mensajeDetalle != null) {
            mensaje.setDetail(mensajeDetalle);
        }
        mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
        this.mostrandoDetalle = false;
        if (!resultado) {
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            this.mostrandoDetalle = true;
        }
        switch (accion) {
            case EDITAR:
                mensaje.setSummary("Error al editar");
                if (resultado) {
                    mensaje.setSummary("Edición Exitosa");
                }
                break;
            case ELIMINAR:
                mensaje.setSummary("Error al eliminar");
                if (resultado) {
                    mensaje.setSummary("Eliminación Exitosa");
                }
                break;
            case CREAR:
                mensaje.setSummary("error");
                if (resultado) {
                    mensaje.setSummary("Creacion Exitosa");
                }
        }
        try {
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } catch (Exception ex) {
            loggerForCatch(ex);
        }
    }

    public enum ACCION {
        CREAR, EDITAR, ELIMINAR;
    }

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

    public boolean isAgregando() {
        return this.accion != null && this.accion.equals(ACCION.CREAR);
    }

    public boolean isEditando() {
        return this.accion != null && !this.accion.equals(ACCION.CREAR);
    }

}
