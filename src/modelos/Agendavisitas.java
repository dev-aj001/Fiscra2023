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
@Table(name = "agendavisitas")
@NamedQueries({
    @NamedQuery(name = "Agendavisitas.findAll", query = "SELECT a FROM Agendavisitas a"),
    @NamedQuery(name = "Agendavisitas.findByIdAgendaVisitas", query = "SELECT a FROM Agendavisitas a WHERE a.idAgendaVisitas = :idAgendaVisitas"),
    @NamedQuery(name = "Agendavisitas.findByFehca", query = "SELECT a FROM Agendavisitas a WHERE a.fehca = :fehca"),
    @NamedQuery(name = "Agendavisitas.findByHora", query = "SELECT a FROM Agendavisitas a WHERE a.hora = :hora"),
    @NamedQuery(name = "Agendavisitas.findByDescripcion", query = "SELECT a FROM Agendavisitas a WHERE a.descripcion = :descripcion")})
public class Agendavisitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAgendaVisitas")
    private Integer idAgendaVisitas;
    @Column(name = "fehca")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fehca;
    @Column(name = "hora")
    private String hora;
    @Column(name = "descripcion")
    private String descripcion;
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

    public Date getFehca() {
        return fehca;
    }

    public void setFehca(Date fehca) {
        this.fehca = fehca;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return new Object[]{getIdAgendaVisitas(),getFehca(),getHora(), getDescripcion(), getPacienteidPaciente().getIdPaciente()};
    }
    
}
