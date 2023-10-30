/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;
import modelos.Expediente;
import modelos.ExpedientePK;
import modelos.Paciente;

/**
 *
 * @author jairi
 */
public class JPAController {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FiscraPU");
    
    PacienteJpaController pacienteJPA = new PacienteJpaController(emf);
    ExpedienteJpaController expedienteJPA = new ExpedienteJpaController(emf);
    
    public void registrarPaciente(Paciente paciente){
        try {
            pacienteJPA.create(paciente);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public void eliminarPaciente(Integer id){
        try {
            pacienteJPA.destroy(id);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public void modificarPaciente(Paciente paciente){
        try {
            pacienteJPA.edit(paciente);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public int conteoDePacientes(){
        try {
            return pacienteJPA.getPacienteCount();
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return 0;
        }
    }
    
    public List<Paciente> getListaPacientes(){
        try {
            return pacienteJPA.findPacienteEntities();
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return null;
        }
    }
    
    public Paciente getPaciente(int id){
        try {
            return pacienteJPA.findPaciente(id);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return null;
        }
    }
    
    public void registrarExpediente(Expediente expediente){
        try {
            expedienteJPA.create(expediente);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public void eliminarExpediente(ExpedientePK id){
        try {
            expedienteJPA.destroy(id);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public void modificarExpediente(Expediente expediente){
        try {
            expedienteJPA.edit(expediente);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public int conteoDeExpedientes(){
        try {
            return expedienteJPA.getExpedienteCount();
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return 0;
        }
    }
    
    public List<Expediente> getListaExpedientes(){
        try {
            return expedienteJPA.findExpedienteEntities();
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return null;
        }
    }
    
    public Expediente getExpediente(ExpedientePK id){
        try {
            return expedienteJPA.findExpediente(id);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return null;
        }
    }
}
