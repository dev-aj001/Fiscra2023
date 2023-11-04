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
import modelos.Agendaactividades;

/**
 *
 * @author jairi
 */
public class AgendaactividadesJpaController implements Serializable {

    public AgendaactividadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Agendaactividades agendaactividades) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agendaactividades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agendaactividades agendaactividades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agendaactividades = em.merge(agendaactividades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = agendaactividades.getIdAgendaActividades();
                if (findAgendaactividades(id) == null) {
                    throw new NonexistentEntityException("The agendaactividades with id " + id + " no longer exists.");
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
            Agendaactividades agendaactividades;
            try {
                agendaactividades = em.getReference(Agendaactividades.class, id);
                agendaactividades.getIdAgendaActividades();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agendaactividades with id " + id + " no longer exists.", enfe);
            }
            em.remove(agendaactividades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Agendaactividades> findAgendaactividadesEntities() {
        return findAgendaactividadesEntities(true, -1, -1);
    }

    public List<Agendaactividades> findAgendaactividadesEntities(int maxResults, int firstResult) {
        return findAgendaactividadesEntities(false, maxResults, firstResult);
    }

    private List<Agendaactividades> findAgendaactividadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agendaactividades.class));
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

    public Agendaactividades findAgendaactividades(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agendaactividades.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgendaactividadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agendaactividades> rt = cq.from(Agendaactividades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
