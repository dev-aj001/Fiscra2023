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
import modelos.Paciente;
import modelos.Registro;

/**
 *
 * @author jairi
 */
public class RegistroJpaController implements Serializable {

    public RegistroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registro registro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente pacienteidPaciente = registro.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente = em.getReference(pacienteidPaciente.getClass(), pacienteidPaciente.getIdPaciente());
                registro.setPacienteidPaciente(pacienteidPaciente);
            }
            em.persist(registro);
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getRegistroList().add(registro);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registro registro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Registro persistentRegistro = em.find(Registro.class, registro.getIdregistros());
            Paciente pacienteidPacienteOld = persistentRegistro.getPacienteidPaciente();
            Paciente pacienteidPacienteNew = registro.getPacienteidPaciente();
            if (pacienteidPacienteNew != null) {
                pacienteidPacienteNew = em.getReference(pacienteidPacienteNew.getClass(), pacienteidPacienteNew.getIdPaciente());
                registro.setPacienteidPaciente(pacienteidPacienteNew);
            }
            registro = em.merge(registro);
            if (pacienteidPacienteOld != null && !pacienteidPacienteOld.equals(pacienteidPacienteNew)) {
                pacienteidPacienteOld.getRegistroList().remove(registro);
                pacienteidPacienteOld = em.merge(pacienteidPacienteOld);
            }
            if (pacienteidPacienteNew != null && !pacienteidPacienteNew.equals(pacienteidPacienteOld)) {
                pacienteidPacienteNew.getRegistroList().add(registro);
                pacienteidPacienteNew = em.merge(pacienteidPacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registro.getIdregistros();
                if (findRegistro(id) == null) {
                    throw new NonexistentEntityException("The registro with id " + id + " no longer exists.");
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
            Registro registro;
            try {
                registro = em.getReference(Registro.class, id);
                registro.getIdregistros();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registro with id " + id + " no longer exists.", enfe);
            }
            Paciente pacienteidPaciente = registro.getPacienteidPaciente();
            if (pacienteidPaciente != null) {
                pacienteidPaciente.getRegistroList().remove(registro);
                pacienteidPaciente = em.merge(pacienteidPaciente);
            }
            em.remove(registro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registro> findRegistroEntities() {
        return findRegistroEntities(true, -1, -1);
    }

    public List<Registro> findRegistroEntities(int maxResults, int firstResult) {
        return findRegistroEntities(false, maxResults, firstResult);
    }

    private List<Registro> findRegistroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registro.class));
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

    public Registro findRegistro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registro.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registro> rt = cq.from(Registro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
