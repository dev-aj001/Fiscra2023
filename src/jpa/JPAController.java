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
import modelos.Agendaactividades;
import modelos.Agendavisitas;
import modelos.Familiar;
import modelos.Finanza;
//import modelos.Expediente;
//import modelos.ExpedientePK;
import modelos.Paciente;
import modelos.Usuario;

/**
 *
 * @author jairi
 */
public class JPAController {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FiscraPU");
    
    PacienteJpaController pacienteJPA = new PacienteJpaController(emf);
    UsuarioJpaController usuarioJPA = new UsuarioJpaController(emf);
    AgendaactividadesJpaController agendaJPA = new AgendaactividadesJpaController(emf);
    AgendavisitasJpaController agendavJPA = new AgendavisitasJpaController(emf);
    FamiliarJpaController familiarJPA = new FamiliarJpaController(emf);
    FinanzaJpaController finanzaJPA = new FinanzaJpaController(emf);
    
    //ExpedienteJpaController expedienteJPA = new ExpedienteJpaController(emf);
    
    public void Agendavisitas(Agendavisitas agendaV) {
        agendavJPA.create(agendaV);
    }
    
    public void Familar (Familiar familiar) {
        familiarJPA.create(familiar);
    }
    public void registraragenda(Agendaactividades agenda){
        agendaJPA.create(agenda);
    }
    
      public void eliminaragenda(Integer id) throws NonexistentEntityException{
        agendaJPA.destroy(id);
    }
  
        public void modificaragenda(Agendaactividades agenda) throws Exception{
        agendaJPA.edit(agenda);
    } 
    
    public void registaragendav(Agendavisitas agendav){
        agendavJPA.create(agendav);
    }
    
    public void modificaragendav(Agendavisitas agendav) throws Exception{
        agendavJPA.edit(agendav);
    }
    
    public void eliminaragendav(Integer id) throws NonexistentEntityException{
        agendavJPA.destroy(id);
    }
    
    public List<Agendaactividades> getListAgendaactividades(){
        return agendaJPA.findAgendaactividadesEntities();  
    }
    
    public List<Agendavisitas> getListAgendavisitas(){
        return agendavJPA.findAgendavisitasEntities();
        
    }
    
    public List<Finanza> getListFinanzas(){
        return finanzaJPA.findFinanzaEntities();
    }
    
    public int getCountAgendaactividades(){
        return agendaJPA.getAgendaactividadesCount();
    }
    
    public int getCountAgendavisitas(){
        return agendavJPA.getAgendavisitasCount();
    }
    
    public Agendaactividades getAgendaactividades(int id){
        return agendaJPA.findAgendaactividades(id);
    }
     
     public Agendavisitas getAgendavisitas(int id){
        return agendavJPA.findAgendavisitas(id);
    }

   
    
    public void registrarFamiliar(Familiar familiar){
        familiarJPA.create(familiar);
    }
    
    public void eliminarFamiliar(Integer id) throws NonexistentEntityException{
        familiarJPA.destroy(id);
    }
    
    public void modificarFamiliar(Familiar familiar) throws Exception{
        familiarJPA.edit(familiar);
    }    
    
    public List<Familiar> getListaFamiliar(){
        return familiarJPA.findFamiliarEntities();
    }    
    
    
    public int getCountFamiliar(){
        return familiarJPA.getFamiliarCount();
    }
    
    
    public Familiar getFamiliar(int id){
        return familiarJPA.findFamiliar(id);
    }
    
    ////////////////////
    
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
    
    
    public void registrarUsuario(Usuario usuario){
        try {
            usuarioJPA.create(usuario);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public void eliminarUsuario(Integer id){
        try {
            usuarioJPA.destroy(id);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public void modificarUsuario(Usuario usuario){
        try {
            usuarioJPA.edit(usuario);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
    
    public int conteoDeUsuario(){
        try {
            return usuarioJPA.getUsuarioCount();
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return 0;
        }
    }
    
    public List<Usuario> getListaUsuarios(){
        try {
            return usuarioJPA.findUsuarioEntities();
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return null;
        }
    }
    
    public Usuario getUsuario(int id){
        try {
            return usuarioJPA.findUsuario(id);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            return null;
        }
    }
    
    
    
//    public void registrarExpediente(Expediente expediente){
//        try {
//            expedienteJPA.create(expediente);
//        } catch (Exception ex) {
//            System.out.println("error: " + ex.getMessage());
//        }
//    }
//    
//    public void eliminarExpediente(ExpedientePK id){
//        try {
//            expedienteJPA.destroy(id);
//        } catch (Exception ex) {
//            System.out.println("error: " + ex.getMessage());
//        }
//    }
//    
//    public void modificarExpediente(Expediente expediente){
//        try {
//            expedienteJPA.edit(expediente);
//        } catch (Exception ex) {
//            System.out.println("error: " + ex.getMessage());
//        }
//    }
//    
//    public int conteoDeExpedientes(){
//        try {
//            return expedienteJPA.getExpedienteCount();
//        } catch (Exception ex) {
//            System.out.println("error: " + ex.getMessage());
//            return 0;
//        }
//    }
//    
//    public List<Expediente> getListaExpedientes(){
//        try {
//            return expedienteJPA.findExpedienteEntities();
//        } catch (Exception ex) {
//            System.out.println("error: " + ex.getMessage());
//            return null;
//        }
//    }
//    
//    public Expediente getExpediente(ExpedientePK id){
//        try {
//            return expedienteJPA.findExpediente(id);
//        } catch (Exception ex) {
//            System.out.println("error: " + ex.getMessage());
//            return null;
//        }
//    }
}
