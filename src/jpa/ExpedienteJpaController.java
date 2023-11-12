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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;
import modelos.Expediente;
import modelos.Paciente;

/**
 *
 * @author jairi
 */
public class ExpedienteJpaController implements Serializable {

    public ExpedienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    

    public void create(Expediente expediente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente pacienteidPaciente = expediente.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente = em.getReference(pacienteidPaciente.getClass(), pacienteidPaciente.getIdPaciente());
                expediente.setPacienteidPaciente(pacienteidPaciente);
            }
            em.persist(expediente);
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getExpedienteList().add(expediente);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Expediente expediente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Expediente persistentExpediente = em.find(Expediente.class, expediente.getIdExpediente());
            Paciente pacienteidPacienteOld = persistentExpediente.getPacienteidPaciente();
            Paciente pacienteidPacienteNew = expediente.getPacienteidPaciente();
            if (pacienteidPacienteNew != null) {
                pacienteidPacienteNew = em.getReference(pacienteidPacienteNew.getClass(), pacienteidPacienteNew.getIdPaciente());
                expediente.setPacienteidPaciente(pacienteidPacienteNew);
            }
            expediente = em.merge(expediente);
            if (pacienteidPacienteOld != null && !pacienteidPacienteOld.equals(pacienteidPacienteNew)) {
                pacienteidPacienteOld.getExpedienteList().remove(expediente);
                pacienteidPacienteOld = em.merge(pacienteidPacienteOld);
            }
            if (pacienteidPacienteNew != null && !pacienteidPacienteNew.equals(pacienteidPacienteOld)) {
                pacienteidPacienteNew.getExpedienteList().add(expediente);
                pacienteidPacienteNew = em.merge(pacienteidPacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = expediente.getIdExpediente();
                if (findExpediente(id) == null) {
                    throw new NonexistentEntityException("The expediente with id " + id + " no longer exists.");
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
            Expediente expediente;
            try {
                expediente = em.getReference(Expediente.class, id);
                expediente.getIdExpediente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The expediente with id " + id + " no longer exists.", enfe);
            }
            Paciente pacienteidPaciente = expediente.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getExpedienteList().remove(expediente);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            em.remove(expediente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Expediente> findExpedienteEntities() {
        return findExpedienteEntities(true, -1, -1);
    }

    public List<Expediente> findExpedienteEntities(int maxResults, int firstResult) {
        return findExpedienteEntities(false, maxResults, firstResult);
    }

    private List<Expediente> findExpedienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Expediente.class));
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
    
//  private List<Expediente> findExpedienteBy() {
//        EntityManager em = getEntityManager();
//        try {
//            if (all) {
//                TypedQuery<Expediente> query = em.createNamedQuery("Expediente.findBy", Expediente.class);
//                return query.getResultList();
//            } else {
//                TypedQuery<Expediente> query = em.createNamedQuery("Expediente.findAll", Expediente.class);
//                query.setMaxResults(maxResults);
//                query.setFirstResult(firstResult);
//                return query.getResultList();
//            }
//        } finally {
//            em.close();
//        }
//  }


    public Expediente findExpediente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Expediente.class, id);
        } finally {
            em.close();
        }
    }

    public int getExpedienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Expediente> rt = cq.from(Expediente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
