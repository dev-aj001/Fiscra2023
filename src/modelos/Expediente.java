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
@Table(name = "expediente")
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e"),
    @NamedQuery(name = "Expediente.findByIdExpediente", query = "SELECT e FROM Expediente e WHERE e.idExpediente = :idExpediente"),
    @NamedQuery(name = "Expediente.findByCurp", query = "SELECT e FROM Expediente e WHERE e.curp = :curp"),
    @NamedQuery(name = "Expediente.findByCallePac", query = "SELECT e FROM Expediente e WHERE e.callePac = :callePac"),
    @NamedQuery(name = "Expediente.findByColPac", query = "SELECT e FROM Expediente e WHERE e.colPac = :colPac"),
    @NamedQuery(name = "Expediente.findByCodiPac", query = "SELECT e FROM Expediente e WHERE e.codiPac = :codiPac"),
    @NamedQuery(name = "Expediente.findByNumExPac", query = "SELECT e FROM Expediente e WHERE e.numExPac = :numExPac"),
    @NamedQuery(name = "Expediente.findByNumInPac", query = "SELECT e FROM Expediente e WHERE e.numInPac = :numInPac"),
    @NamedQuery(name = "Expediente.findByLocaPac", query = "SELECT e FROM Expediente e WHERE e.locaPac = :locaPac"),
    @NamedQuery(name = "Expediente.findByTelCasPac", query = "SELECT e FROM Expediente e WHERE e.telCasPac = :telCasPac"),
    @NamedQuery(name = "Expediente.findByTelCelPac", query = "SELECT e FROM Expediente e WHERE e.telCelPac = :telCelPac"),
    @NamedQuery(name = "Expediente.findByCorrPac", query = "SELECT e FROM Expediente e WHERE e.corrPac = :corrPac"),
    @NamedQuery(name = "Expediente.findByNomFam", query = "SELECT e FROM Expediente e WHERE e.nomFam = :nomFam"),
    @NamedQuery(name = "Expediente.findByApPaFam", query = "SELECT e FROM Expediente e WHERE e.apPaFam = :apPaFam"),
    @NamedQuery(name = "Expediente.findByApMaFam", query = "SELECT e FROM Expediente e WHERE e.apMaFam = :apMaFam"),
    @NamedQuery(name = "Expediente.findByCallFam", query = "SELECT e FROM Expediente e WHERE e.callFam = :callFam"),
    @NamedQuery(name = "Expediente.findByColFam", query = "SELECT e FROM Expediente e WHERE e.colFam = :colFam"),
    @NamedQuery(name = "Expediente.findByCodiFam", query = "SELECT e FROM Expediente e WHERE e.codiFam = :codiFam"),
    @NamedQuery(name = "Expediente.findByNumExFam", query = "SELECT e FROM Expediente e WHERE e.numExFam = :numExFam"),
    @NamedQuery(name = "Expediente.findByNumInFam", query = "SELECT e FROM Expediente e WHERE e.numInFam = :numInFam"),
    @NamedQuery(name = "Expediente.findByLocaFam", query = "SELECT e FROM Expediente e WHERE e.locaFam = :locaFam"),
    @NamedQuery(name = "Expediente.findByTelCasFam", query = "SELECT e FROM Expediente e WHERE e.telCasFam = :telCasFam"),
    @NamedQuery(name = "Expediente.findByTelCelFam", query = "SELECT e FROM Expediente e WHERE e.telCelFam = :telCelFam"),
    @NamedQuery(name = "Expediente.findByCorreFam", query = "SELECT e FROM Expediente e WHERE e.correFam = :correFam"),
    @NamedQuery(name = "Expediente.findBySeguro", query = "SELECT e FROM Expediente e WHERE e.seguro = :seguro"),
    @NamedQuery(name = "Expediente.findBySeguroOtro", query = "SELECT e FROM Expediente e WHERE e.seguroOtro = :seguroOtro"),
    @NamedQuery(name = "Expediente.findBySegAuto", query = "SELECT e FROM Expediente e WHERE e.segAuto = :segAuto"),
    @NamedQuery(name = "Expediente.findBySegVida", query = "SELECT e FROM Expediente e WHERE e.segVida = :segVida"),
    @NamedQuery(name = "Expediente.findBySegHogar", query = "SELECT e FROM Expediente e WHERE e.segHogar = :segHogar"),
    @NamedQuery(name = "Expediente.findByAlergias", query = "SELECT e FROM Expediente e WHERE e.alergias = :alergias"),
    @NamedQuery(name = "Expediente.findByEnfermedades", query = "SELECT e FROM Expediente e WHERE e.enfermedades = :enfermedades"),
    @NamedQuery(name = "Expediente.findByTratamientos", query = "SELECT e FROM Expediente e WHERE e.tratamientos = :tratamientos"),
    @NamedQuery(name = "Expediente.findByGastosTotal", query = "SELECT e FROM Expediente e WHERE e.gastosTotal = :gastosTotal"),
    @NamedQuery(name = "Expediente.findByGastos1", query = "SELECT e FROM Expediente e WHERE e.gastos1 = :gastos1"),
    @NamedQuery(name = "Expediente.findByGastos2", query = "SELECT e FROM Expediente e WHERE e.gastos2 = :gastos2"),
    @NamedQuery(name = "Expediente.findByGastos3", query = "SELECT e FROM Expediente e WHERE e.gastos3 = :gastos3"),
    @NamedQuery(name = "Expediente.findByGastos4", query = "SELECT e FROM Expediente e WHERE e.gastos4 = :gastos4"),
    @NamedQuery(name = "Expediente.findByGastos5", query = "SELECT e FROM Expediente e WHERE e.gastos5 = :gastos5"),
    @NamedQuery(name = "Expediente.findByGastos6", query = "SELECT e FROM Expediente e WHERE e.gastos6 = :gastos6"),
    @NamedQuery(name = "Expediente.findByGastos7", query = "SELECT e FROM Expediente e WHERE e.gastos7 = :gastos7"),
    @NamedQuery(name = "Expediente.findByIngresosTotal", query = "SELECT e FROM Expediente e WHERE e.ingresosTotal = :ingresosTotal"),
    @NamedQuery(name = "Expediente.findByCasaTipo", query = "SELECT e FROM Expediente e WHERE e.casaTipo = :casaTipo"),
    @NamedQuery(name = "Expediente.findByCasaServicios", query = "SELECT e FROM Expediente e WHERE e.casaServicios = :casaServicios")})
public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExpediente")
    private Integer idExpediente;
    @Column(name = "curp")
    private String curp;
    @Column(name = "callePac")
    private String callePac;
    @Column(name = "colPac")
    private String colPac;
    @Column(name = "CodiPac")
    private String codiPac;
    @Column(name = "numExPac")
    private String numExPac;
    @Column(name = "numInPac")
    private String numInPac;
    @Column(name = "LocaPac")
    private String locaPac;
    @Column(name = "telCasPac")
    private String telCasPac;
    @Column(name = "telCelPac")
    private String telCelPac;
    @Column(name = "corrPac")
    private String corrPac;
    @Column(name = "nomFam")
    private String nomFam;
    @Column(name = "apPaFam")
    private String apPaFam;
    @Column(name = "apMaFam")
    private String apMaFam;
    @Column(name = "callFam")
    private String callFam;
    @Column(name = "colFam")
    private String colFam;
    @Column(name = "codiFam")
    private String codiFam;
    @Column(name = "numExFam")
    private String numExFam;
    @Column(name = "numInFam")
    private String numInFam;
    @Column(name = "locaFam")
    private String locaFam;
    @Column(name = "telCasFam")
    private String telCasFam;
    @Column(name = "telCelFam")
    private String telCelFam;
    @Column(name = "correFam")
    private String correFam;
    @Column(name = "seguro")
    private Integer seguro;
    @Column(name = "seguroOtro")
    private String seguroOtro;
    @Column(name = "segAuto")
    private Integer segAuto;
    @Column(name = "segVida")
    private Integer segVida;
    @Column(name = "segHogar")
    private Integer segHogar;
    @Column(name = "alergias")
    private String alergias;
    @Column(name = "enfermedades")
    private String enfermedades;
    @Column(name = "tratamientos")
    private String tratamientos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gastosTotal")
    private Float gastosTotal;
    @Column(name = "gastos1")
    private Float gastos1;
    @Column(name = "gastos2")
    private Float gastos2;
    @Column(name = "gastos3")
    private Float gastos3;
    @Column(name = "gastos4")
    private Float gastos4;
    @Column(name = "gastos5")
    private Float gastos5;
    @Column(name = "gastos6")
    private Float gastos6;
    @Column(name = "gastos7")
    private Float gastos7;
    @Column(name = "ingresosTotal")
    private Float ingresosTotal;
    @Column(name = "casaTipo")
    private String casaTipo;
    @Column(name = "casaServicios")
    private String casaServicios;
    @JoinColumn(name = "Paciente_idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private Paciente pacienteidPaciente;

    public Expediente() {
    }

    public Expediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public Integer getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCallePac() {
        return callePac;
    }

    public void setCallePac(String callePac) {
        this.callePac = callePac;
    }

    public String getColPac() {
        return colPac;
    }

    public void setColPac(String colPac) {
        this.colPac = colPac;
    }

    public String getCodiPac() {
        return codiPac;
    }

    public void setCodiPac(String codiPac) {
        this.codiPac = codiPac;
    }

    public String getNumExPac() {
        return numExPac;
    }

    public void setNumExPac(String numExPac) {
        this.numExPac = numExPac;
    }

    public String getNumInPac() {
        return numInPac;
    }

    public void setNumInPac(String numInPac) {
        this.numInPac = numInPac;
    }

    public String getLocaPac() {
        return locaPac;
    }

    public void setLocaPac(String locaPac) {
        this.locaPac = locaPac;
    }

    public String getTelCasPac() {
        return telCasPac;
    }

    public void setTelCasPac(String telCasPac) {
        this.telCasPac = telCasPac;
    }

    public String getTelCelPac() {
        return telCelPac;
    }

    public void setTelCelPac(String telCelPac) {
        this.telCelPac = telCelPac;
    }

    public String getCorrPac() {
        return corrPac;
    }

    public void setCorrPac(String corrPac) {
        this.corrPac = corrPac;
    }

    public String getNomFam() {
        return nomFam;
    }

    public void setNomFam(String nomFam) {
        this.nomFam = nomFam;
    }

    public String getApPaFam() {
        return apPaFam;
    }

    public void setApPaFam(String apPaFam) {
        this.apPaFam = apPaFam;
    }

    public String getApMaFam() {
        return apMaFam;
    }

    public void setApMaFam(String apMaFam) {
        this.apMaFam = apMaFam;
    }

    public String getCallFam() {
        return callFam;
    }

    public void setCallFam(String callFam) {
        this.callFam = callFam;
    }

    public String getColFam() {
        return colFam;
    }

    public void setColFam(String colFam) {
        this.colFam = colFam;
    }

    public String getCodiFam() {
        return codiFam;
    }

    public void setCodiFam(String codiFam) {
        this.codiFam = codiFam;
    }

    public String getNumExFam() {
        return numExFam;
    }

    public void setNumExFam(String numExFam) {
        this.numExFam = numExFam;
    }

    public String getNumInFam() {
        return numInFam;
    }

    public void setNumInFam(String numInFam) {
        this.numInFam = numInFam;
    }

    public String getLocaFam() {
        return locaFam;
    }

    public void setLocaFam(String locaFam) {
        this.locaFam = locaFam;
    }

    public String getTelCasFam() {
        return telCasFam;
    }

    public void setTelCasFam(String telCasFam) {
        this.telCasFam = telCasFam;
    }

    public String getTelCelFam() {
        return telCelFam;
    }

    public void setTelCelFam(String telCelFam) {
        this.telCelFam = telCelFam;
    }

    public String getCorreFam() {
        return correFam;
    }

    public void setCorreFam(String correFam) {
        this.correFam = correFam;
    }

    public Integer getSeguro() {
        return seguro;
    }

    public void setSeguro(Integer seguro) {
        this.seguro = seguro;
    }

    public String getSeguroOtro() {
        return seguroOtro;
    }

    public void setSeguroOtro(String seguroOtro) {
        this.seguroOtro = seguroOtro;
    }

    public Integer getSegAuto() {
        return segAuto;
    }

    public void setSegAuto(Integer segAuto) {
        this.segAuto = segAuto;
    }

    public Integer getSegVida() {
        return segVida;
    }

    public void setSegVida(Integer segVida) {
        this.segVida = segVida;
    }

    public Integer getSegHogar() {
        return segHogar;
    }

    public void setSegHogar(Integer segHogar) {
        this.segHogar = segHogar;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    public Float getGastosTotal() {
        return gastosTotal;
    }

    public void setGastosTotal(Float gastosTotal) {
        this.gastosTotal = gastosTotal;
    }

    public Float getGastos1() {
        return gastos1;
    }

    public void setGastos1(Float gastos1) {
        this.gastos1 = gastos1;
    }

    public Float getGastos2() {
        return gastos2;
    }

    public void setGastos2(Float gastos2) {
        this.gastos2 = gastos2;
    }

    public Float getGastos3() {
        return gastos3;
    }

    public void setGastos3(Float gastos3) {
        this.gastos3 = gastos3;
    }

    public Float getGastos4() {
        return gastos4;
    }

    public void setGastos4(Float gastos4) {
        this.gastos4 = gastos4;
    }

    public Float getGastos5() {
        return gastos5;
    }

    public void setGastos5(Float gastos5) {
        this.gastos5 = gastos5;
    }

    public Float getGastos6() {
        return gastos6;
    }

    public void setGastos6(Float gastos6) {
        this.gastos6 = gastos6;
    }

    public Float getGastos7() {
        return gastos7;
    }

    public void setGastos7(Float gastos7) {
        this.gastos7 = gastos7;
    }

    public Float getIngresosTotal() {
        return ingresosTotal;
    }

    public void setIngresosTotal(Float ingresosTotal) {
        this.ingresosTotal = ingresosTotal;
    }

    public String getCasaTipo() {
        return casaTipo;
    }

    public void setCasaTipo(String casaTipo) {
        this.casaTipo = casaTipo;
    }

    public String getCasaServicios() {
        return casaServicios;
    }

    public void setCasaServicios(String casaServicios) {
        this.casaServicios = casaServicios;
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
        hash += (idExpediente != null ? idExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.idExpediente == null && other.idExpediente != null) || (this.idExpediente != null && !this.idExpediente.equals(other.idExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Expediente[ idExpediente=" + idExpediente + " ]";
    }
    
}
