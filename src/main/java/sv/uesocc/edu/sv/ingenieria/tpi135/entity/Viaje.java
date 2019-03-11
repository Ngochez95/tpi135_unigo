/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "viaje", catalog = "tpi2019", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v"),
    @NamedQuery(name = "Viaje.findByIdViaje", query = "SELECT v FROM Viaje v WHERE v.idViaje = :idViaje"),
    @NamedQuery(name = "Viaje.findByHoraLlegada", query = "SELECT v FROM Viaje v WHERE v.horaLlegada = :horaLlegada"),
    @NamedQuery(name = "Viaje.findByHoraSalida", query = "SELECT v FROM Viaje v WHERE v.horaSalida = :horaSalida")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_viaje", nullable = false)
    private Integer idViaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_llegada", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaLlegada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_salida", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idViaje")
    private List<ReservaViaje> reservaViajeList;
    @JoinColumn(name = "id_dia", referencedColumnName = "id_dia", nullable = false)
    @ManyToOne(optional = false)
    private Semana idDia;
    @JoinColumn(name = "id_trayectoria", referencedColumnName = "id_trayectoria", nullable = false)
    @ManyToOne(optional = false)
    private Trayectoria idTrayectoria;

    public Viaje() {
    }

    public Viaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Viaje(Integer idViaje, Date horaLlegada, Date horaSalida) {
        this.idViaje = idViaje;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    @XmlTransient
    public List<ReservaViaje> getReservaViajeList() {
        return reservaViajeList;
    }

    public void setReservaViajeList(List<ReservaViaje> reservaViajeList) {
        this.reservaViajeList = reservaViajeList;
    }

    public Semana getIdDia() {
        return idDia;
    }

    public void setIdDia(Semana idDia) {
        this.idDia = idDia;
    }

    public Trayectoria getIdTrayectoria() {
        return idTrayectoria;
    }

    public void setIdTrayectoria(Trayectoria idTrayectoria) {
        this.idTrayectoria = idTrayectoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViaje != null ? idViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.idViaje == null && other.idViaje != null) || (this.idViaje != null && !this.idViaje.equals(other.idViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje[ idViaje=" + idViaje + " ]";
    }
    
}
