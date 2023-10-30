/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelos.Expediente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;
import modelos.Paciente;

/**
 *
 * @author jairi
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        if (paciente.getExpedienteCollection() == null) {
            paciente.setExpedienteCollection(new ArrayList<Expediente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Expediente> attachedExpedienteCollection = new ArrayList<Expediente>();
            for (Expediente expedienteCollectionExpedienteToAttach : paciente.getExpedienteCollection()) {
                expedienteCollectionExpedienteToAttach = em.getReference(expedienteCollectionExpedienteToAttach.getClass(), expedienteCollectionExpedienteToAttach.getExpedientePK());
                attachedExpedienteCollection.add(expedienteCollectionExpedienteToAttach);
            }
            paciente.setExpedienteCollection(attachedExpedienteCollection);
            em.persist(paciente);
            for (Expediente expedienteCollectionExpediente : paciente.getExpedienteCollection()) {
                Paciente oldPacienteOfExpedienteCollectionExpediente = expedienteCollectionExpediente.getPaciente();
                expedienteCollectionExpediente.setPaciente(paciente);
                expedienteCollectionExpediente = em.merge(expedienteCollectionExpediente);
                if (oldPacienteOfExpedienteCollectionExpediente != null) {
                    oldPacienteOfExpedienteCollectionExpediente.getExpedienteCollection().remove(expedienteCollectionExpediente);
                    oldPacienteOfExpedienteCollectionExpediente = em.merge(oldPacienteOfExpedienteCollectionExpediente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getIdPaciente());
            Collection<Expediente> expedienteCollectionOld = persistentPaciente.getExpedienteCollection();
            Collection<Expediente> expedienteCollectionNew = paciente.getExpedienteCollection();
            List<String> illegalOrphanMessages = null;
            for (Expediente expedienteCollectionOldExpediente : expedienteCollectionOld) {
                if (!expedienteCollectionNew.contains(expedienteCollectionOldExpediente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Expediente " + expedienteCollectionOldExpediente + " since its paciente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Expediente> attachedExpedienteCollectionNew = new ArrayList<Expediente>();
            for (Expediente expedienteCollectionNewExpedienteToAttach : expedienteCollectionNew) {
                expedienteCollectionNewExpedienteToAttach = em.getReference(expedienteCollectionNewExpedienteToAttach.getClass(), expedienteCollectionNewExpedienteToAttach.getExpedientePK());
                attachedExpedienteCollectionNew.add(expedienteCollectionNewExpedienteToAttach);
            }
            expedienteCollectionNew = attachedExpedienteCollectionNew;
            paciente.setExpedienteCollection(expedienteCollectionNew);
            paciente = em.merge(paciente);
            for (Expediente expedienteCollectionNewExpediente : expedienteCollectionNew) {
                if (!expedienteCollectionOld.contains(expedienteCollectionNewExpediente)) {
                    Paciente oldPacienteOfExpedienteCollectionNewExpediente = expedienteCollectionNewExpediente.getPaciente();
                    expedienteCollectionNewExpediente.setPaciente(paciente);
                    expedienteCollectionNewExpediente = em.merge(expedienteCollectionNewExpediente);
                    if (oldPacienteOfExpedienteCollectionNewExpediente != null && !oldPacienteOfExpedienteCollectionNewExpediente.equals(paciente)) {
                        oldPacienteOfExpedienteCollectionNewExpediente.getExpedienteCollection().remove(expedienteCollectionNewExpediente);
                        oldPacienteOfExpedienteCollectionNewExpediente = em.merge(oldPacienteOfExpedienteCollectionNewExpediente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getIdPaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getIdPaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Expediente> expedienteCollectionOrphanCheck = paciente.getExpedienteCollection();
            for (Expediente expedienteCollectionOrphanCheckExpediente : expedienteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Expediente " + expedienteCollectionOrphanCheckExpediente + " in its expedienteCollection field has a non-nullable paciente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
