/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "origen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Origen.findAll", query = "SELECT o FROM Origen o"),
    @NamedQuery(name = "Origen.findByIdOrigen", query = "SELECT o FROM Origen o WHERE o.idOrigen = :idOrigen"),
    @NamedQuery(name = "Origen.findByOrigen", query = "SELECT o FROM Origen o WHERE o.origen = :origen")})
public class Origen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_origen", nullable = false)
    private Integer idOrigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "origen", nullable = false, length = 100)
    private String origen;
    @OneToMany(mappedBy = "idPadreOrigen")
    private List<Origen> origenList;
    @JoinColumn(name = "id_padre_origen", referencedColumnName = "id_origen")
    @ManyToOne
    private Origen idPadreOrigen;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Origen() {
    }

    public Origen(Integer idOrigen) {
        this.idOrigen = idOrigen;
    }

    public Origen(Integer idOrigen, String origen) {
        this.idOrigen = idOrigen;
        this.origen = origen;
    }

    public Integer getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(Integer idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @XmlTransient
    public List<Origen> getOrigenList() {
        return origenList;
    }

    public void setOrigenList(List<Origen> origenList) {
        this.origenList = origenList;
    }

    public Origen getIdPadreOrigen() {
        return idPadreOrigen;
    }

    public void setIdPadreOrigen(Origen idPadreOrigen) {
        this.idPadreOrigen = idPadreOrigen;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrigen != null ? idOrigen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Origen)) {
            return false;
        }
        Origen other = (Origen) object;
        if ((this.idOrigen == null && other.idOrigen != null) || (this.idOrigen != null && !this.idOrigen.equals(other.idOrigen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.Origen[ idOrigen=" + idOrigen + " ]";
    }
    
}
