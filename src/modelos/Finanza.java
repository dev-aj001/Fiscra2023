/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

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

/**
 *
 * @author jairi
 */
@Entity
@Table(name = "finanza")
@NamedQueries({
    @NamedQuery(name = "Finanza.findAll", query = "SELECT f FROM Finanza f"),
    @NamedQuery(name = "Finanza.findByIdadeudo", query = "SELECT f FROM Finanza f WHERE f.idadeudo = :idadeudo"),
    @NamedQuery(name = "Finanza.findByCuota", query = "SELECT f FROM Finanza f WHERE f.cuota = :cuota"),
    @NamedQuery(name = "Finanza.findByAtraso", query = "SELECT f FROM Finanza f WHERE f.atraso = :atraso")})
public class Finanza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadeudo")
    private Integer idadeudo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cuota")
    private Double cuota;
    @Column(name = "atraso")
    private Integer atraso;
    @JoinColumn(name = "Paciente_idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private Paciente pacienteidPaciente;

    public Finanza() {
    }

    public Finanza(Integer idadeudo) {
        this.idadeudo = idadeudo;
    }

    public Integer getIdadeudo() {
        return idadeudo;
    }

    public void setIdadeudo(Integer idadeudo) {
        this.idadeudo = idadeudo;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public Integer getAtraso() {
        return atraso;
    }

    public void setAtraso(Integer atraso) {
        this.atraso = atraso;
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
        hash += (idadeudo != null ? idadeudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finanza)) {
            return false;
        }
        Finanza other = (Finanza) object;
        if ((this.idadeudo == null && other.idadeudo != null) || (this.idadeudo != null && !this.idadeudo.equals(other.idadeudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Finanza[ idadeudo=" + idadeudo + " ]";
    }
    
    public Object[] toArray(){
        return new Object[] {getCuota(), getAtraso()};
    }
    
}
