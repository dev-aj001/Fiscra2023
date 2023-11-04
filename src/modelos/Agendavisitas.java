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
@Table(name = "agendavisitas")
@NamedQueries({
    @NamedQuery(name = "Agendavisitas.findAll", query = "SELECT a FROM Agendavisitas a"),
    @NamedQuery(name = "Agendavisitas.findByIdAgendaVisitas", query = "SELECT a FROM Agendavisitas a WHERE a.idAgendaVisitas = :idAgendaVisitas"),
    @NamedQuery(name = "Agendavisitas.findByFehca", query = "SELECT a FROM Agendavisitas a WHERE a.fehca = :fehca"),
    @NamedQuery(name = "Agendavisitas.findByDescripcion", query = "SELECT a FROM Agendavisitas a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Agendavisitas.findByAgendaVisitascol", query = "SELECT a FROM Agendavisitas a WHERE a.agendaVisitascol = :agendaVisitascol")})
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
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "AgendaVisitascol")
    private String agendaVisitascol;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAgendaVisitascol() {
        return agendaVisitascol;
    }

    public void setAgendaVisitascol(String agendaVisitascol) {
        this.agendaVisitascol = agendaVisitascol;
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
        return new Object[]{getIdAgendaVisitas(),getFehca(),getDescripcion(),getAgendaVisitascol()};
    }
    
}
