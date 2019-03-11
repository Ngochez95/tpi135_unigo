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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "tipo_medio_contacto", catalog = "tpi2019", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMedioContacto.findAll", query = "SELECT t FROM TipoMedioContacto t"),
    @NamedQuery(name = "TipoMedioContacto.findByIdTipoMedioContacto", query = "SELECT t FROM TipoMedioContacto t WHERE t.idTipoMedioContacto = :idTipoMedioContacto"),
    @NamedQuery(name = "TipoMedioContacto.findByTelefono", query = "SELECT t FROM TipoMedioContacto t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TipoMedioContacto.findByCorreo", query = "SELECT t FROM TipoMedioContacto t WHERE t.correo = :correo"),
    @NamedQuery(name = "TipoMedioContacto.findByFacebook", query = "SELECT t FROM TipoMedioContacto t WHERE t.facebook = :facebook"),
    @NamedQuery(name = "TipoMedioContacto.findByInstagram", query = "SELECT t FROM TipoMedioContacto t WHERE t.instagram = :instagram")})
public class TipoMedioContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_medio_contacto", nullable = false)
    private Integer idTipoMedioContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;
    @Size(max = 100)
    @Column(name = "correo", length = 100)
    private String correo;
    @Size(max = 100)
    @Column(name = "facebook", length = 100)
    private String facebook;
    @Size(max = 100)
    @Column(name = "instagram", length = 100)
    private String instagram;
    @JoinColumn(name = "id_medio_contacto", referencedColumnName = "id_medio_contacto", nullable = false)
    @ManyToOne(optional = false)
    private MedioContacto idMedioContacto;

    public TipoMedioContacto() {
    }

    public TipoMedioContacto(Integer idTipoMedioContacto) {
        this.idTipoMedioContacto = idTipoMedioContacto;
    }

    public TipoMedioContacto(Integer idTipoMedioContacto, String telefono) {
        this.idTipoMedioContacto = idTipoMedioContacto;
        this.telefono = telefono;
    }

    public Integer getIdTipoMedioContacto() {
        return idTipoMedioContacto;
    }

    public void setIdTipoMedioContacto(Integer idTipoMedioContacto) {
        this.idTipoMedioContacto = idTipoMedioContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public MedioContacto getIdMedioContacto() {
        return idMedioContacto;
    }

    public void setIdMedioContacto(MedioContacto idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMedioContacto != null ? idTipoMedioContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMedioContacto)) {
            return false;
        }
        TipoMedioContacto other = (TipoMedioContacto) object;
        if ((this.idTipoMedioContacto == null && other.idTipoMedioContacto != null) || (this.idTipoMedioContacto != null && !this.idTipoMedioContacto.equals(other.idTipoMedioContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoMedioContacto[ idTipoMedioContacto=" + idTipoMedioContacto + " ]";
    }
    
}
