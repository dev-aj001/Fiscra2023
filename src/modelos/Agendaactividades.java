/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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

    @Column(name = "hora")
    private String hora;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "prioridad")
    private Integer prioridad;

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
        return new Object[] {getIdAgendaActividades(), getTitulo(), getDescripcion(), getFormatedFecha(), getPrioridad()};
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    private String getFormatedFecha(){
        // Crea un objeto SimpleDateFormat con el formato deseado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");

        // Convierte la fecha a un String con el formato especificado
        return formatoFecha.format(getFecha());
    }


    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
