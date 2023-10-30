/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jairi
 */
@Entity
@Table(name = "expediente")
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e"),
    @NamedQuery(name = "Expediente.findByIdExpediente", query = "SELECT e FROM Expediente e WHERE e.expedientePK.idExpediente = :idExpediente"),
    @NamedQuery(name = "Expediente.findByDescripcion", query = "SELECT e FROM Expediente e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Expediente.findByPacienteidPaciente", query = "SELECT e FROM Expediente e WHERE e.expedientePK.pacienteidPaciente = :pacienteidPaciente")})
public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExpedientePK expedientePK;
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "Paciente_idPaciente", referencedColumnName = "idPaciente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;

    public Expediente() {
    }

    public Expediente(ExpedientePK expedientePK) {
        this.expedientePK = expedientePK;
    }

    public Expediente(int idExpediente, int pacienteidPaciente) {
        this.expedientePK = new ExpedientePK(idExpediente, pacienteidPaciente);
    }

    public ExpedientePK getExpedientePK() {
        return expedientePK;
    }

    public void setExpedientePK(ExpedientePK expedientePK) {
        this.expedientePK = expedientePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expedientePK != null ? expedientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.expedientePK == null && other.expedientePK != null) || (this.expedientePK != null && !this.expedientePK.equals(other.expedientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "custom.Expediente[ expedientePK=" + expedientePK + " ]";
    }
    
    public Object[] toArray(){
        return new Object[]{this.getExpedientePK(), this.getDescripcion(), this.getPaciente()};
    }
    
}
