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
    @NamedQuery(name = "Expediente.findByEscolaridad", query = "SELECT e FROM Expediente e WHERE e.escolaridad = :escolaridad"),
    @NamedQuery(name = "Expediente.findByCurp", query = "SELECT e FROM Expediente e WHERE e.curp = :curp"),
    @NamedQuery(name = "Expediente.findByCalle", query = "SELECT e FROM Expediente e WHERE e.calle = :calle"),
    @NamedQuery(name = "Expediente.findByColonia", query = "SELECT e FROM Expediente e WHERE e.colonia = :colonia"),
    @NamedQuery(name = "Expediente.findByCodigo", query = "SELECT e FROM Expediente e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Expediente.findByNoExterior", query = "SELECT e FROM Expediente e WHERE e.noExterior = :noExterior"),
    @NamedQuery(name = "Expediente.findByNoInterior", query = "SELECT e FROM Expediente e WHERE e.noInterior = :noInterior"),
    @NamedQuery(name = "Expediente.findByTelefonoCasa", query = "SELECT e FROM Expediente e WHERE e.telefonoCasa = :telefonoCasa"),
    @NamedQuery(name = "Expediente.findByNombreFam", query = "SELECT e FROM Expediente e WHERE e.nombreFam = :nombreFam"),
    @NamedQuery(name = "Expediente.findByApellidoPaFam", query = "SELECT e FROM Expediente e WHERE e.apellidoPaFam = :apellidoPaFam"),
    @NamedQuery(name = "Expediente.findByApellidoMaFam", query = "SELECT e FROM Expediente e WHERE e.apellidoMaFam = :apellidoMaFam"),
    @NamedQuery(name = "Expediente.findByTelefonoFam", query = "SELECT e FROM Expediente e WHERE e.telefonoFam = :telefonoFam"),
    @NamedQuery(name = "Expediente.findByCorreoFam", query = "SELECT e FROM Expediente e WHERE e.correoFam = :correoFam"),
    @NamedQuery(name = "Expediente.findByCalleFam", query = "SELECT e FROM Expediente e WHERE e.calleFam = :calleFam"),
    @NamedQuery(name = "Expediente.findByColoniaFam", query = "SELECT e FROM Expediente e WHERE e.coloniaFam = :coloniaFam"),
    @NamedQuery(name = "Expediente.findByCodigoFam", query = "SELECT e FROM Expediente e WHERE e.codigoFam = :codigoFam"),
    @NamedQuery(name = "Expediente.findByLocalidad", query = "SELECT e FROM Expediente e WHERE e.localidad = :localidad"),
    @NamedQuery(name = "Expediente.findByLocalidadFam", query = "SELECT e FROM Expediente e WHERE e.localidadFam = :localidadFam"),
    @NamedQuery(name = "Expediente.findBySeguro", query = "SELECT e FROM Expediente e WHERE e.seguro = :seguro"),
    @NamedQuery(name = "Expediente.findBySeguro2", query = "SELECT e FROM Expediente e WHERE e.seguro2 = :seguro2"),
    @NamedQuery(name = "Expediente.findByEnfermedades", query = "SELECT e FROM Expediente e WHERE e.enfermedades = :enfermedades"),
    @NamedQuery(name = "Expediente.findByAlergias", query = "SELECT e FROM Expediente e WHERE e.alergias = :alergias"),
    @NamedQuery(name = "Expediente.findByMedicamentos", query = "SELECT e FROM Expediente e WHERE e.medicamentos = :medicamentos"),
    @NamedQuery(name = "Expediente.findByGastos", query = "SELECT e FROM Expediente e WHERE e.gastos = :gastos"),
    @NamedQuery(name = "Expediente.findByIngresos", query = "SELECT e FROM Expediente e WHERE e.ingresos = :ingresos"),
    @NamedQuery(name = "Expediente.findByTipoCasa", query = "SELECT e FROM Expediente e WHERE e.tipoCasa = :tipoCasa"),
    @NamedQuery(name = "Expediente.findByServicios", query = "SELECT e FROM Expediente e WHERE e.servicios = :servicios"),
    @NamedQuery(name = "Expediente.findByCaracteristicasCasa", query = "SELECT e FROM Expediente e WHERE e.caracteristicasCasa = :caracteristicasCasa"),
    @NamedQuery(name = "Expediente.findByTransporte", query = "SELECT e FROM Expediente e WHERE e.transporte = :transporte"),
    @NamedQuery(name = "Expediente.findByOtros", query = "SELECT e FROM Expediente e WHERE e.otros = :otros")})
public class Expediente implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gastos")
    private Double gastos;
    @Column(name = "ingresos")
    private Double ingresos;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExpediente")
    private Integer idExpediente;
    @Column(name = "escolaridad")
    private String escolaridad;
    @Column(name = "CURP")
    private String curp;
    @Column(name = "calle")
    private String calle;
    @Column(name = "colonia")
    private String colonia;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "noExterior")
    private String noExterior;
    @Column(name = "NoInterior")
    private String noInterior;
    @Column(name = "telefonoCasa")
    private String telefonoCasa;
    @Column(name = "nombreFam")
    private String nombreFam;
    @Column(name = "apellidoPaFam")
    private String apellidoPaFam;
    @Column(name = "apellidoMaFam")
    private String apellidoMaFam;
    @Column(name = "telefonoFam")
    private String telefonoFam;
    @Column(name = "correoFam")
    private String correoFam;
    @Column(name = "calleFam")
    private String calleFam;
    @Column(name = "coloniaFam")
    private String coloniaFam;
    @Column(name = "codigoFam")
    private String codigoFam;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "localidadFam")
    private String localidadFam;
    @Column(name = "seguro")
    private String seguro;
    @Column(name = "seguro2")
    private String seguro2;
    @Column(name = "enfermedades")
    private String enfermedades;
    @Column(name = "alergias")
    private String alergias;
    @Column(name = "medicamentos")
    private String medicamentos;
    @Column(name = "tipoCasa")
    private String tipoCasa;
    @Column(name = "servicios")
    private String servicios;
    @Column(name = "caracteristicasCasa")
    private String caracteristicasCasa;
    @Column(name = "transporte")
    private String transporte;
    @Column(name = "otros")
    private String otros;
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

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getNoInterior() {
        return noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getNombreFam() {
        return nombreFam;
    }

    public void setNombreFam(String nombreFam) {
        this.nombreFam = nombreFam;
    }

    public String getApellidoPaFam() {
        return apellidoPaFam;
    }

    public void setApellidoPaFam(String apellidoPaFam) {
        this.apellidoPaFam = apellidoPaFam;
    }

    public String getApellidoMaFam() {
        return apellidoMaFam;
    }

    public void setApellidoMaFam(String apellidoMaFam) {
        this.apellidoMaFam = apellidoMaFam;
    }

    public String getTelefonoFam() {
        return telefonoFam;
    }

    public void setTelefonoFam(String telefonoFam) {
        this.telefonoFam = telefonoFam;
    }

    public String getCorreoFam() {
        return correoFam;
    }

    public void setCorreoFam(String correoFam) {
        this.correoFam = correoFam;
    }

    public String getCalleFam() {
        return calleFam;
    }

    public void setCalleFam(String calleFam) {
        this.calleFam = calleFam;
    }

    public String getColoniaFam() {
        return coloniaFam;
    }

    public void setColoniaFam(String coloniaFam) {
        this.coloniaFam = coloniaFam;
    }

    public String getCodigoFam() {
        return codigoFam;
    }

    public void setCodigoFam(String codigoFam) {
        this.codigoFam = codigoFam;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getLocalidadFam() {
        return localidadFam;
    }

    public void setLocalidadFam(String localidadFam) {
        this.localidadFam = localidadFam;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getSeguro2() {
        return seguro2;
    }

    public void setSeguro2(String seguro2) {
        this.seguro2 = seguro2;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }


    public String getTipoCasa() {
        return tipoCasa;
    }

    public void setTipoCasa(String tipoCasa) {
        this.tipoCasa = tipoCasa;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getCaracteristicasCasa() {
        return caracteristicasCasa;
    }

    public void setCaracteristicasCasa(String caracteristicasCasa) {
        this.caracteristicasCasa = caracteristicasCasa;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
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

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }

    public Double getIngresos() {
        return ingresos;
    }

    public void setIngresos(Double ingresos) {
        this.ingresos = ingresos;
    }
    
}
