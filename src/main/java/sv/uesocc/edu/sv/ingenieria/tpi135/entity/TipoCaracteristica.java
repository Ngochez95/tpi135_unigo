/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "tipo_caracteristica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCaracteristica.findAll", query = "SELECT t FROM TipoCaracteristica t"),
    @NamedQuery(name = "TipoCaracteristica.findByIdTipoCaracteristica", query = "SELECT t FROM TipoCaracteristica t WHERE t.idTipoCaracteristica = :idTipoCaracteristica"),
    @NamedQuery(name = "TipoCaracteristica.findByColor", query = "SELECT t FROM TipoCaracteristica t WHERE t.color = :color"),
    @NamedQuery(name = "TipoCaracteristica.findByAnio", query = "SELECT t FROM TipoCaracteristica t WHERE t.anio = :anio"),
    @NamedQuery(name = "TipoCaracteristica.findByCapacidad", query = "SELECT t FROM TipoCaracteristica t WHERE t.capacidad = :capacidad"),
    @NamedQuery(name = "TipoCaracteristica.findByOtrasCaracteristicas", query = "SELECT t FROM TipoCaracteristica t WHERE t.otrasCaracteristicas = :otrasCaracteristicas")})
public class TipoCaracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_caracteristica", nullable = false)
    private Integer idTipoCaracteristica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "color", nullable = false, length = 15)
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad", nullable = false)
    private int capacidad;
    @Size(max = 100)
    @Column(name = "otras_caracteristicas", length = 100)
    private String otrasCaracteristicas;
    @JoinColumn(name = "id_caracteristica", referencedColumnName = "id_caracteristica", nullable = false)
    @ManyToOne(optional = false)
    private Caractetistica idCaracteristica;

    public TipoCaracteristica() {
    }

    public TipoCaracteristica(Integer idTipoCaracteristica) {
        this.idTipoCaracteristica = idTipoCaracteristica;
    }

    public TipoCaracteristica(Integer idTipoCaracteristica, String color, Date anio, int capacidad) {
        this.idTipoCaracteristica = idTipoCaracteristica;
        this.color = color;
        this.anio = anio;
        this.capacidad = capacidad;
    }

    public Integer getIdTipoCaracteristica() {
        return idTipoCaracteristica;
    }

    public void setIdTipoCaracteristica(Integer idTipoCaracteristica) {
        this.idTipoCaracteristica = idTipoCaracteristica;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getOtrasCaracteristicas() {
        return otrasCaracteristicas;
    }

    public void setOtrasCaracteristicas(String otrasCaracteristicas) {
        this.otrasCaracteristicas = otrasCaracteristicas;
    }

    public Caractetistica getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Caractetistica idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCaracteristica != null ? idTipoCaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCaracteristica)) {
            return false;
        }
        TipoCaracteristica other = (TipoCaracteristica) object;
        if ((this.idTipoCaracteristica == null && other.idTipoCaracteristica != null) || (this.idTipoCaracteristica != null && !this.idTipoCaracteristica.equals(other.idTipoCaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoCaracteristica[ idTipoCaracteristica=" + idTipoCaracteristica + " ]";
    }
    
}
