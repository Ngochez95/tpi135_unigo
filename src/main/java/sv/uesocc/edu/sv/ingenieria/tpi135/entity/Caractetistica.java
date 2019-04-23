/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "caractetistica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caractetistica.findAll", query = "SELECT c FROM Caractetistica c"),
    @NamedQuery(name = "Caractetistica.findByIdCaracteristica", query = "SELECT c FROM Caractetistica c WHERE c.idCaracteristica = :idCaracteristica")})
public class Caractetistica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caracteristica", nullable = false)
    private Integer idCaracteristica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaracteristica")
    private List<TipoCaracteristica> tipoCaracteristicaList;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo", nullable = false)
    @ManyToOne(optional = false)
    private Modelo idModelo;

    public Caractetistica() {
    }

    public Caractetistica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    @XmlTransient
    public List<TipoCaracteristica> getTipoCaracteristicaList() {
        return tipoCaracteristicaList;
    }

    public void setTipoCaracteristicaList(List<TipoCaracteristica> tipoCaracteristicaList) {
        this.tipoCaracteristicaList = tipoCaracteristicaList;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracteristica != null ? idCaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caractetistica)) {
            return false;
        }
        Caractetistica other = (Caractetistica) object;
        if ((this.idCaracteristica == null && other.idCaracteristica != null) || (this.idCaracteristica != null && !this.idCaracteristica.equals(other.idCaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica[ idCaracteristica=" + idCaracteristica + " ]";
    }
    
}
