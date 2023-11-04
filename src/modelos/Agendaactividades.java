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
@Table(name = "agendaactividades")
@NamedQueries({
    @NamedQuery(name = "Agendaactividades.findAll", query = "SELECT a FROM Agendaactividades a"),
    @NamedQuery(name = "Agendaactividades.findByIdAgendaActividades", query = "SELECT a FROM Agendaactividades a WHERE a.idAgendaActividades = :idAgendaActividades"),
    @NamedQuery(name = "Agendaactividades.findByFecha", query = "SELECT a FROM Agendaactividades a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Agendaactividades.findByDescripcion", query = "SELECT a FROM Agendaactividades a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Agendaactividades.findByPrioridad", query = "SELECT a FROM Agendaactividades a WHERE a.prioridad = :prioridad")})
public class Agendaactividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAgendaActividades")
    private Integer idAgendaActividades;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "prioridad")
    private String prioridad;

    public Agendaactividades() {
    }

    public Agendaactividades(Integer idAgendaActividades) {
        this.idAgendaActividades = idAgendaActividades;
    }

    public Integer getIdAgendaActividades() {
        return idAgendaActividades;
    }

    public void setIdAgendaActividades(Integer idAgendaActividades) {
        this.idAgendaActividades = idAgendaActividades;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgendaActividades != null ? idAgendaActividades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendaactividades)) {
            return false;
        }
        Agendaactividades other = (Agendaactividades) object;
        if ((this.idAgendaActividades == null && other.idAgendaActividades != null) || (this.idAgendaActividades != null && !this.idAgendaActividades.equals(other.idAgendaActividades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Agendaactividades[ idAgendaActividades=" + idAgendaActividades + " ]";
    }
    
    public Object[] toArray(){
        return new Object[] {getIdAgendaActividades(), getFecha(), getDescripcion(), getPrioridad()};
    }
    
}
