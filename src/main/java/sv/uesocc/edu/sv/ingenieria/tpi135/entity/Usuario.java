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
import javax.persistence.ManyToMany;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombreUno", query = "SELECT u FROM Usuario u WHERE u.nombreUno = :nombreUno"),
    @NamedQuery(name = "Usuario.findByNombreDos", query = "SELECT u FROM Usuario u WHERE u.nombreDos = :nombreDos"),
    @NamedQuery(name = "Usuario.findByApellidoUno", query = "SELECT u FROM Usuario u WHERE u.apellidoUno = :apellidoUno"),
    @NamedQuery(name = "Usuario.findByApellidoDos", query = "SELECT u FROM Usuario u WHERE u.apellidoDos = :apellidoDos"),
    @NamedQuery(name = "Usuario.findByIdRol", query = "SELECT u FROM Usuario u WHERE u.idRol = :idRol"),
    @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT DISTINCT u FROM Usuario u WHERE UPPER(u.nombreUsuario) LIKE UPPER(:nombreUsuario) OR UPPER(u.nombreUno) LIKE UPPER(:nombreUno) OR UPPER(u.nombreDos) LIKE UPPER(:nombreDos) OR UPPER(u.apellidoUno) LIKE UPPER(:apellidoUno) OR UPPER(u.apellidoDos) LIKE UPPER(:apellidoDos)"),
    @NamedQuery(name = "Usuario.findByRol", query = "SELECT s from Usuario as s WHERE s.idRol='1'"),
    @NamedQuery(name = "Usuario.findByContrasenia", query = "SELECT u FROM Usuario u WHERE u.contrasenia = :contrasenia")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_uno", nullable = false, length = 25)
    private String nombreUno;
    @Size(max = 25)
    @Column(name = "nombre_dos", length = 25)
    private String nombreDos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "apellido_uno", nullable = false, length = 25)
    private String apellidoUno;
    @Size(max = 25)
    @Column(name = "apellido_dos", length = 25)
    private String apellidoDos;
    @Basic(optional = false)
    @Column(name = "id_rol", nullable = false)
    private int idRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_usuario", nullable = false, length = 40)
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "contrasenia", nullable = false, length = 30)
    private String contrasenia;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Rol> rolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<MedioContacto> medioContactoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Origen> origenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Vehiculo> vehiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ReservaViaje> reservaViajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Trayectoria> trayectoriaList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombreUno, String apellidoUno, int idRol, String nombreUsuario, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombreUno = nombreUno;
        this.apellidoUno = apellidoUno;
        this.idRol = idRol;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUno() {
        return nombreUno;
    }

    public void setNombreUno(String nombreUno) {
        this.nombreUno = nombreUno;
    }

    public String getNombreDos() {
        return nombreDos;
    }

    public void setNombreDos(String nombreDos) {
        this.nombreDos = nombreDos;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<MedioContacto> getMedioContactoList() {
        return medioContactoList;
    }

    public void setMedioContactoList(List<MedioContacto> medioContactoList) {
        this.medioContactoList = medioContactoList;
    }

    @XmlTransient
    public List<Origen> getOrigenList() {
        return origenList;
    }

    public void setOrigenList(List<Origen> origenList) {
        this.origenList = origenList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<ReservaViaje> getReservaViajeList() {
        return reservaViajeList;
    }

    public void setReservaViajeList(List<ReservaViaje> reservaViajeList) {
        this.reservaViajeList = reservaViajeList;
    }

    @XmlTransient
    public List<Trayectoria> getTrayectoriaList() {
        return trayectoriaList;
    }

    public void setTrayectoriaList(List<Trayectoria> trayectoriaList) {
        this.trayectoriaList = trayectoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.uesocc.edu.sv.ingenieria.tpi135.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
