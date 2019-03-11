/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "reserva_viaje", catalog = "tpi2019", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaViaje.findAll", query = "SELECT r FROM ReservaViaje r"),
    @NamedQuery(name = "ReservaViaje.findByIdReserva", query = "SELECT r FROM ReservaViaje r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "ReservaViaje.findByNumReservas", query = "SELECT r FROM ReservaViaje r WHERE r.numReservas = :numReservas")})
public class ReservaViaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva", nullable = false)
    private Integer idReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_reservas", nullable = false)
    private int numReservas;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_viaje", referencedColumnName = "id_viaje", nullable = false)
    @ManyToOne(optional = false)
    private Viaje idViaje;

    public ReservaViaje() {
    }

    public ReservaViaje(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public ReservaViaje(Integer idReserva, int numReservas) {
        this.idReserva = idReserva;
        this.numReservas = numReservas;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public int getNumReservas() {
        return numReservas;
    }

    public void setNumReservas(int numReservas) {
        this.numReservas = numReservas;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Viaje getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Viaje idViaje) {
        this.idViaje = idViaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaViaje)) {
            return false;
        }
        ReservaViaje other = (ReservaViaje) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.ReservaViaje[ idReserva=" + idReserva + " ]";
    }
    
}
