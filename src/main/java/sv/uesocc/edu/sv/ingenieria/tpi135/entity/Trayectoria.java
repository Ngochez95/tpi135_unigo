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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "trayectoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trayectoria.findAll", query = "SELECT t FROM Trayectoria t"),
    @NamedQuery(name = "Trayectoria.findByIdTrayectoria", query = "SELECT t FROM Trayectoria t WHERE t.idTrayectoria = :idTrayectoria"),
    @NamedQuery(name = "Trayectoria.findByReferencia", query = "SELECT t FROM Trayectoria t WHERE t.referencia = :referencia"),
    @NamedQuery(name = "Trayectoria.findByTarifa", query = "SELECT t FROM Trayectoria t WHERE t.tarifa = :tarifa")})
public class Trayectoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trayectoria", nullable = false)
    private Integer idTrayectoria;
    @Size(max = 50)
    @Column(name = "referencia", length = 50)
    private String referencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarifa", nullable = false)
    private double tarifa;
    @OneToMany(mappedBy = "padre")
    private List<Trayectoria> trayectoriaList;
    @JoinColumn(name = "padre", referencedColumnName = "id_trayectoria")
    @ManyToOne
    private Trayectoria padre;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrayectoria")
    private List<Viaje> viajeList;

    public Trayectoria() {
    }

    public Trayectoria(Integer idTrayectoria) {
        this.idTrayectoria = idTrayectoria;
    }

    public Trayectoria(Integer idTrayectoria, double tarifa) {
        this.idTrayectoria = idTrayectoria;
        this.tarifa = tarifa;
    }

    public Integer getIdTrayectoria() {
        return idTrayectoria;
    }

    public void setIdTrayectoria(Integer idTrayectoria) {
        this.idTrayectoria = idTrayectoria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    @XmlTransient
    public List<Trayectoria> getTrayectoriaList() {
        return trayectoriaList;
    }

    public void setTrayectoriaList(List<Trayectoria> trayectoriaList) {
        this.trayectoriaList = trayectoriaList;
    }

    public Trayectoria getPadre() {
        return padre;
    }

    public void setPadre(Trayectoria padre) {
        this.padre = padre;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idTrayectoria != null ? idTrayectoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trayectoria)) {
            return false;
        }
        Trayectoria other = (Trayectoria) object;
        if ((this.idTrayectoria == null && other.idTrayectoria != null) || (this.idTrayectoria != null && !this.idTrayectoria.equals(other.idTrayectoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria[ idTrayectoria=" + idTrayectoria + " ]";
    }
    
}
