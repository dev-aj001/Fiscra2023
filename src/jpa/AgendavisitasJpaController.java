/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;
import modelos.Agendavisitas;
import modelos.Paciente;

/**
 *
 * @author jairi
 */
public class AgendavisitasJpaController implements Serializable {

    public AgendavisitasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Agendavisitas agendavisitas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente pacienteidPaciente = agendavisitas.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente = em.getReference(pacienteidPaciente.getClass(), pacienteidPaciente.getIdPaciente());
                agendavisitas.setPacienteidPaciente(pacienteidPaciente);
            }
            em.persist(agendavisitas);
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getAgendavisitasList().add(agendavisitas);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agendavisitas agendavisitas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agendavisitas persistentAgendavisitas = em.find(Agendavisitas.class, agendavisitas.getIdAgendaVisitas());
            Paciente pacienteidPacienteOld = persistentAgendavisitas.getPacienteidPaciente();
            Paciente pacienteidPacienteNew = agendavisitas.getPacienteidPaciente();
            if (pacienteidPacienteNew != null) {
                pacienteidPacienteNew = em.getReference(pacienteidPacienteNew.getClass(), pacienteidPacienteNew.getIdPaciente());
                agendavisitas.setPacienteidPaciente(pacienteidPacienteNew);
            }
            agendavisitas = em.merge(agendavisitas);
            if (pacienteidPacienteOld != null && !pacienteidPacienteOld.equals(pacienteidPacienteNew)) {
                pacienteidPacienteOld.getAgendavisitasList().remove(agendavisitas);
                pacienteidPacienteOld = em.merge(pacienteidPacienteOld);
            }
            if (pacienteidPacienteNew != null && !pacienteidPacienteNew.equals(pacienteidPacienteOld)) {
                pacienteidPacienteNew.getAgendavisitasList().add(agendavisitas);
                pacienteidPacienteNew = em.merge(pacienteidPacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = agendavisitas.getIdAgendaVisitas();
                if (findAgendavisitas(id) == null) {
                    throw new NonexistentEntityException("The agendavisitas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agendavisitas agendavisitas;
            try {
                agendavisitas = em.getReference(Agendavisitas.class, id);
                agendavisitas.getIdAgendaVisitas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agendavisitas with id " + id + " no longer exists.", enfe);
            }
            Paciente pacienteidPaciente = agendavisitas.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getAgendavisitasList().remove(agendavisitas);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            em.remove(agendavisitas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Agendavisitas> findAgendavisitasEntities() {
        return findAgendavisitasEntities(true, -1, -1);
    }

    public List<Agendavisitas> findAgendavisitasEntities(int maxResults, int firstResult) {
        return findAgendavisitasEntities(false, maxResults, firstResult);
    }

    private List<Agendavisitas> findAgendavisitasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agendavisitas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Agendavisitas findAgendavisitas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agendavisitas.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgendavisitasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agendavisitas> rt = cq.from(Agendavisitas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
