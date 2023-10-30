/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jairi
 */
@Embeddable
public class ExpedientePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idExpediente")
    private int idExpediente;
    @Basic(optional = false)
    @Column(name = "Paciente_idPaciente")
    private int pacienteidPaciente;

    public ExpedientePK() {
    }

    public ExpedientePK(int idExpediente, int pacienteidPaciente) {
        this.idExpediente = idExpediente;
        this.pacienteidPaciente = pacienteidPaciente;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public int getPacienteidPaciente() {
        return pacienteidPaciente;
    }

    public void setPacienteidPaciente(int pacienteidPaciente) {
        this.pacienteidPaciente = pacienteidPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idExpediente;
        hash += (int) pacienteidPaciente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpedientePK)) {
            return false;
        }
        ExpedientePK other = (ExpedientePK) object;
        if (this.idExpediente != other.idExpediente) {
            return false;
        }
        if (this.pacienteidPaciente != other.pacienteidPaciente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "custom.ExpedientePK[ idExpediente=" + idExpediente + ", pacienteidPaciente=" + pacienteidPaciente + " ]";
    }
    
}
