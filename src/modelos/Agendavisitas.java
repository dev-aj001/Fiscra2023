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
@Table(name = "agendavisitas")
@NamedQueries({
    @NamedQuery(name = "Agendavisitas.findAll", query = "SELECT a FROM Agendavisitas a"),
    @NamedQuery(name = "Agendavisitas.findByIdAgendaVisitas", query = "SELECT a FROM Agendavisitas a WHERE a.idAgendaVisitas = :idAgendaVisitas"),
    @NamedQuery(name = "Agendavisitas.findByTitulo", query = "SELECT a FROM Agendavisitas a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Agendavisitas.findByDescripcion", query = "SELECT a FROM Agendavisitas a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Agendavisitas.findByFecha", query = "SELECT a FROM Agendavisitas a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Agendavisitas.findByHora", query = "SELECT a FROM Agendavisitas a WHERE a.hora = :hora"),
    @NamedQuery(name = "Agendavisitas.findByVisitante", query = "SELECT a FROM Agendavisitas a WHERE a.visitante = :visitante"),
    @NamedQuery(name = "Agendavisitas.findByEstado", query = "SELECT a FROM Agendavisitas a WHERE a.estado = :estado")})
public class Agendavisitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAgendaVisitas")
    private Integer idAgendaVisitas;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    private String hora;
    @Column(name = "visitante")
    private String visitante;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "Paciente_idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private Paciente pacienteidPaciente;

    public Agendavisitas() {
    }

    public Agendavisitas(Integer idAgendaVisitas) {
        this.idAgendaVisitas = idAgendaVisitas;
    }

    public Integer getIdAgendaVisitas() {
        return idAgendaVisitas;
    }

    public void setIdAgendaVisitas(Integer idAgendaVisitas) {
        this.idAgendaVisitas = idAgendaVisitas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idAgendaVisitas != null ? idAgendaVisitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendavisitas)) {
            return false;
        }
        Agendavisitas other = (Agendavisitas) object;
        if ((this.idAgendaVisitas == null && other.idAgendaVisitas != null) || (this.idAgendaVisitas != null && !this.idAgendaVisitas.equals(other.idAgendaVisitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Agendavisitas[ idAgendaVisitas=" + idAgendaVisitas + " ]";
    }
    
    public Object[] toArray() {
        return new Object[]{getIdAgendaVisitas(), getTitulo(),getDescripcion(),getFormatedFecha(), getHora(), getNombrePaciente(), getVisitante(), getEstado()};
    }
    
    private String getFormatedFecha(){
        // Crea un objeto SimpleDateFormat con el formato deseado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");

        // Convierte la fecha a un String con el formato especificado
        return formatoFecha.format(getFecha());
    }
    
    private String getNombrePaciente(){
        return getPacienteidPaciente().getNombre();
    }
}
