/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jairi
 */
@Entity
@Table(name = "familiar")
@NamedQueries({
    @NamedQuery(name = "Familiar.findAll", query = "SELECT f FROM Familiar f"),
    @NamedQuery(name = "Familiar.findByIdFamilar", query = "SELECT f FROM Familiar f WHERE f.idFamilar = :idFamilar"),
    @NamedQuery(name = "Familiar.findByApellidoMa", query = "SELECT f FROM Familiar f WHERE f.apellidoMa = :apellidoMa"),
    @NamedQuery(name = "Familiar.findByApellidoPa", query = "SELECT f FROM Familiar f WHERE f.apellidoPa = :apellidoPa"),
    @NamedQuery(name = "Familiar.findByCorreoE", query = "SELECT f FROM Familiar f WHERE f.correoE = :correoE"),
    @NamedQuery(name = "Familiar.findByCp", query = "SELECT f FROM Familiar f WHERE f.cp = :cp"),
    @NamedQuery(name = "Familiar.findByDireccion", query = "SELECT f FROM Familiar f WHERE f.direccion = :direccion"),
    @NamedQuery(name = "Familiar.findByFechaNac", query = "SELECT f FROM Familiar f WHERE f.fechaNac = :fechaNac"),
    @NamedQuery(name = "Familiar.findByNombre", query = "SELECT f FROM Familiar f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Familiar.findBySexo", query = "SELECT f FROM Familiar f WHERE f.sexo = :sexo"),
    @NamedQuery(name = "Familiar.findByTelefono1", query = "SELECT f FROM Familiar f WHERE f.telefono1 = :telefono1"),
    @NamedQuery(name = "Familiar.findByTelefono2", query = "SELECT f FROM Familiar f WHERE f.telefono2 = :telefono2")})
public class Familiar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFamilar")
    private Integer idFamilar;
    @Column(name = "apellidoMa")
    private String apellidoMa;
    @Column(name = "apellidoPa")
    private String apellidoPa;
    @Column(name = "correoE")
    private String correoE;
    @Column(name = "CP")
    private String cp;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefono1")
    private String telefono1;
    @Column(name = "telefono2")
    private String telefono2;

    public Familiar() {
    }

    public Familiar(Integer idFamilar) {
        this.idFamilar = idFamilar;
    }

    public Integer getIdFamilar() {
        return idFamilar;
    }

    public void setIdFamilar(Integer idFamilar) {
        this.idFamilar = idFamilar;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilar != null ? idFamilar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familiar)) {
            return false;
        }
        Familiar other = (Familiar) object;
        if ((this.idFamilar == null && other.idFamilar != null) || (this.idFamilar != null && !this.idFamilar.equals(other.idFamilar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Familiar[ idFamilar=" + idFamilar + " ]";
    }
    
}
