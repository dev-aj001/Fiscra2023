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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "registro")
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByIdregistros", query = "SELECT r FROM Registro r WHERE r.idregistros = :idregistros"),
    @NamedQuery(name = "Registro.findByFechaIng", query = "SELECT r FROM Registro r WHERE r.fechaIng = :fechaIng"),
    @NamedQuery(name = "Registro.findByFechaEgr", query = "SELECT r FROM Registro r WHERE r.fechaEgr = :fechaEgr"),
    @NamedQuery(name = "Registro.findByRazonEgr", query = "SELECT r FROM Registro r WHERE r.razonEgr = :razonEgr"),
    @NamedQuery(name = "Registro.findByRazonIng", query = "SELECT r FROM Registro r WHERE r.razonIng = :razonIng")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistros")
    private Integer idregistros;
    @Column(name = "fechaIng")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIng;
    @Column(name = "fechaEgr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEgr;
    @Column(name = "razonEgr")
    private String razonEgr;
    @Column(name = "razonIng")
    private String razonIng;
    @JoinColumn(name = "Paciente_idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private Paciente pacienteidPaciente;

    public Registro() {
    }

    public Registro(Integer idregistros) {
        this.idregistros = idregistros;
    }

    public Integer getIdregistros() {
        return idregistros;
    }

    public void setIdregistros(Integer idregistros) {
        this.idregistros = idregistros;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Date getFechaEgr() {
        return fechaEgr;
    }

    public void setFechaEgr(Date fechaEgr) {
        this.fechaEgr = fechaEgr;
    }

    public String getRazonEgr() {
        return razonEgr;
    }

    public void setRazonEgr(String razonEgr) {
        this.razonEgr = razonEgr;
    }

    public String getRazonIng() {
        return razonIng;
    }

    public void setRazonIng(String razonIng) {
        this.razonIng = razonIng;
    }

    public Paciente getPacienteidPaciente() {
        return pacienteidPaciente;
    }

    public void setPacienteidPaciente(Paciente pacienteidPaciente) {
        this.pacienteidPaciente = pacienteidPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistros != null ? idregistros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idregistros == null && other.idregistros != null) || (this.idregistros != null && !this.idregistros.equals(other.idregistros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Registro[ idregistros=" + idregistros + " ]";
    }
}
