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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "semana", catalog = "tpi2019", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semana.findAll", query = "SELECT s FROM Semana s"),
    @NamedQuery(name = "Semana.findByIdDia", query = "SELECT s FROM Semana s WHERE s.idDia = :idDia"),
    @NamedQuery(name = "Semana.findByDia", query = "SELECT s FROM Semana s WHERE s.dia = :dia")})
public class Semana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dia", nullable = false)
    private Integer idDia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dia", nullable = false, length = 15)
    private String dia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDia")
    private List<Viaje> viajeList;

    public Semana() {
    }

    public Semana(Integer idDia) {
        this.idDia = idDia;
    }

    public Semana(Integer idDia, String dia) {
        this.idDia = idDia;
        this.dia = dia;
    }

    public Integer getIdDia() {
        return idDia;
    }

    public void setIdDia(Integer idDia) {
        this.idDia = idDia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @XmlTransient
    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDia != null ? idDia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semana)) {
            return false;
        }
        Semana other = (Semana) object;
        if ((this.idDia == null && other.idDia != null) || (this.idDia != null && !this.idDia.equals(other.idDia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.Semana[ idDia=" + idDia + " ]";
    }
    
}
