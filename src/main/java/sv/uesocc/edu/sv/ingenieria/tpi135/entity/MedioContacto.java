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
@Table(name = "medio_contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioContacto.findAll", query = "SELECT m FROM MedioContacto m"),
    @NamedQuery(name = "MedioContacto.findByIdMedioContacto", query = "SELECT m FROM MedioContacto m WHERE m.idMedioContacto = :idMedioContacto")})
public class MedioContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio_contacto", nullable = false)
    private Integer idMedioContacto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedioContacto")
    private List<TipoMedioContacto> tipoMedioContactoList;

    public MedioContacto() {
    }

    public MedioContacto(Integer idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public Integer getIdMedioContacto() {
        return idMedioContacto;
    }

    public void setIdMedioContacto(Integer idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<TipoMedioContacto> getTipoMedioContactoList() {
        return tipoMedioContactoList;
    }

    public void setTipoMedioContactoList(List<TipoMedioContacto> tipoMedioContactoList) {
        this.tipoMedioContactoList = tipoMedioContactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedioContacto != null ? idMedioContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioContacto)) {
            return false;
        }
        MedioContacto other = (MedioContacto) object;
        if ((this.idMedioContacto == null && other.idMedioContacto != null) || (this.idMedioContacto != null && !this.idMedioContacto.equals(other.idMedioContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.MedioContacto[ idMedioContacto=" + idMedioContacto + " ]";
    }
    
}
