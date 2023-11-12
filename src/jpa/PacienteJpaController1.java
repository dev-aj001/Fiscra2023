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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;
import modelos.Agendavisitas;
import modelos.Finanza;
import modelos.Paciente;
import modelos.Registro;

/**
 *
 * @author jairi
 */
public class PacienteJpaController1 implements Serializable {

    public PacienteJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        if (paciente.getExpedienteList() == null) {
            paciente.setExpedienteList(new ArrayList<Expediente>());
        }
        if (paciente.getAgendavisitasList() == null) {
            paciente.setAgendavisitasList(new ArrayList<Agendavisitas>());
        }
        if (paciente.getFinanzaList() == null) {
            paciente.setFinanzaList(new ArrayList<Finanza>());
        }
        if (paciente.getRegistroList() == null) {
            paciente.setRegistroList(new ArrayList<Registro>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Expediente> attachedExpedienteList = new ArrayList<Expediente>();
            for (Expediente expedienteListExpedienteToAttach : paciente.getExpedienteList()) {
                expedienteListExpedienteToAttach = em.getReference(expedienteListExpedienteToAttach.getClass(), expedienteListExpedienteToAttach.getIdExpediente());
                attachedExpedienteList.add(expedienteListExpedienteToAttach);
            }
            paciente.setExpedienteList(attachedExpedienteList);
            List<Agendavisitas> attachedAgendavisitasList = new ArrayList<Agendavisitas>();
            for (Agendavisitas agendavisitasListAgendavisitasToAttach : paciente.getAgendavisitasList()) {
                agendavisitasListAgendavisitasToAttach = em.getReference(agendavisitasListAgendavisitasToAttach.getClass(), agendavisitasListAgendavisitasToAttach.getIdAgendaVisitas());
                attachedAgendavisitasList.add(agendavisitasListAgendavisitasToAttach);
            }
            paciente.setAgendavisitasList(attachedAgendavisitasList);
            List<Finanza> attachedFinanzaList = new ArrayList<Finanza>();
            for (Finanza finanzaListFinanzaToAttach : paciente.getFinanzaList()) {
                finanzaListFinanzaToAttach = em.getReference(finanzaListFinanzaToAttach.getClass(), finanzaListFinanzaToAttach.getIdadeudo());
                attachedFinanzaList.add(finanzaListFinanzaToAttach);
            }
            paciente.setFinanzaList(attachedFinanzaList);
            List<Registro> attachedRegistroList = new ArrayList<Registro>();
            for (Registro registroListRegistroToAttach : paciente.getRegistroList()) {
                registroListRegistroToAttach = em.getReference(registroListRegistroToAttach.getClass(), registroListRegistroToAttach.getIdregistros());
                attachedRegistroList.add(registroListRegistroToAttach);
            }
            paciente.setRegistroList(attachedRegistroList);
            em.persist(paciente);
            for (Expediente expedienteListExpediente : paciente.getExpedienteList()) {
                Paciente oldPacienteidPacienteOfExpedienteListExpediente = expedienteListExpediente.getPacienteidPaciente();
                expedienteListExpediente.setPacienteidPaciente(paciente);
                expedienteListExpediente = em.merge(expedienteListExpediente);
                if (oldPacienteidPacienteOfExpedienteListExpediente != null) {
                    oldPacienteidPacienteOfExpedienteListExpediente.getExpedienteList().remove(expedienteListExpediente);
                    oldPacienteidPacienteOfExpedienteListExpediente = em.merge(oldPacienteidPacienteOfExpedienteListExpediente);
                }
            }
            for (Agendavisitas agendavisitasListAgendavisitas : paciente.getAgendavisitasList()) {
                Paciente oldPacienteidPacienteOfAgendavisitasListAgendavisitas = agendavisitasListAgendavisitas.getPacienteidPaciente();
                agendavisitasListAgendavisitas.setPacienteidPaciente(paciente);
                agendavisitasListAgendavisitas = em.merge(agendavisitasListAgendavisitas);
                if (oldPacienteidPacienteOfAgendavisitasListAgendavisitas != null) {
                    oldPacienteidPacienteOfAgendavisitasListAgendavisitas.getAgendavisitasList().remove(agendavisitasListAgendavisitas);
                    oldPacienteidPacienteOfAgendavisitasListAgendavisitas = em.merge(oldPacienteidPacienteOfAgendavisitasListAgendavisitas);
                }
            }
            for (Finanza finanzaListFinanza : paciente.getFinanzaList()) {
                Paciente oldPacienteidPacienteOfFinanzaListFinanza = finanzaListFinanza.getPacienteidPaciente();
                finanzaListFinanza.setPacienteidPaciente(paciente);
                finanzaListFinanza = em.merge(finanzaListFinanza);
                if (oldPacienteidPacienteOfFinanzaListFinanza != null) {
                    oldPacienteidPacienteOfFinanzaListFinanza.getFinanzaList().remove(finanzaListFinanza);
                    oldPacienteidPacienteOfFinanzaListFinanza = em.merge(oldPacienteidPacienteOfFinanzaListFinanza);
                }
            }
            for (Registro registroListRegistro : paciente.getRegistroList()) {
                Paciente oldPacienteidPacienteOfRegistroListRegistro = registroListRegistro.getPacienteidPaciente();
                registroListRegistro.setPacienteidPaciente(paciente);
                registroListRegistro = em.merge(registroListRegistro);
                if (oldPacienteidPacienteOfRegistroListRegistro != null) {
                    oldPacienteidPacienteOfRegistroListRegistro.getRegistroList().remove(registroListRegistro);
                    oldPacienteidPacienteOfRegistroListRegistro = em.merge(oldPacienteidPacienteOfRegistroListRegistro);
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
            List<Expediente> expedienteListOld = persistentPaciente.getExpedienteList();
            List<Expediente> expedienteListNew = paciente.getExpedienteList();
            List<Agendavisitas> agendavisitasListOld = persistentPaciente.getAgendavisitasList();
            List<Agendavisitas> agendavisitasListNew = paciente.getAgendavisitasList();
            List<Finanza> finanzaListOld = persistentPaciente.getFinanzaList();
            List<Finanza> finanzaListNew = paciente.getFinanzaList();
            List<Registro> registroListOld = persistentPaciente.getRegistroList();
            List<Registro> registroListNew = paciente.getRegistroList();
            List<String> illegalOrphanMessages = null;
            for (Expediente expedienteListOldExpediente : expedienteListOld) {
                if (!expedienteListNew.contains(expedienteListOldExpediente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Expediente " + expedienteListOldExpediente + " since its pacienteidPaciente field is not nullable.");
                }
            }
            for (Agendavisitas agendavisitasListOldAgendavisitas : agendavisitasListOld) {
                if (!agendavisitasListNew.contains(agendavisitasListOldAgendavisitas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Agendavisitas " + agendavisitasListOldAgendavisitas + " since its pacienteidPaciente field is not nullable.");
                }
            }
            for (Finanza finanzaListOldFinanza : finanzaListOld) {
                if (!finanzaListNew.contains(finanzaListOldFinanza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Finanza " + finanzaListOldFinanza + " since its pacienteidPaciente field is not nullable.");
                }
            }
            for (Registro registroListOldRegistro : registroListOld) {
                if (!registroListNew.contains(registroListOldRegistro)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Registro " + registroListOldRegistro + " since its pacienteidPaciente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Expediente> attachedExpedienteListNew = new ArrayList<Expediente>();
            for (Expediente expedienteListNewExpedienteToAttach : expedienteListNew) {
                expedienteListNewExpedienteToAttach = em.getReference(expedienteListNewExpedienteToAttach.getClass(), expedienteListNewExpedienteToAttach.getIdExpediente());
                attachedExpedienteListNew.add(expedienteListNewExpedienteToAttach);
            }
            expedienteListNew = attachedExpedienteListNew;
            paciente.setExpedienteList(expedienteListNew);
            List<Agendavisitas> attachedAgendavisitasListNew = new ArrayList<Agendavisitas>();
            for (Agendavisitas agendavisitasListNewAgendavisitasToAttach : agendavisitasListNew) {
                agendavisitasListNewAgendavisitasToAttach = em.getReference(agendavisitasListNewAgendavisitasToAttach.getClass(), agendavisitasListNewAgendavisitasToAttach.getIdAgendaVisitas());
                attachedAgendavisitasListNew.add(agendavisitasListNewAgendavisitasToAttach);
            }
            agendavisitasListNew = attachedAgendavisitasListNew;
            paciente.setAgendavisitasList(agendavisitasListNew);
            List<Finanza> attachedFinanzaListNew = new ArrayList<Finanza>();
            for (Finanza finanzaListNewFinanzaToAttach : finanzaListNew) {
                finanzaListNewFinanzaToAttach = em.getReference(finanzaListNewFinanzaToAttach.getClass(), finanzaListNewFinanzaToAttach.getIdadeudo());
                attachedFinanzaListNew.add(finanzaListNewFinanzaToAttach);
            }
            finanzaListNew = attachedFinanzaListNew;
            paciente.setFinanzaList(finanzaListNew);
            List<Registro> attachedRegistroListNew = new ArrayList<Registro>();
            for (Registro registroListNewRegistroToAttach : registroListNew) {
                registroListNewRegistroToAttach = em.getReference(registroListNewRegistroToAttach.getClass(), registroListNewRegistroToAttach.getIdregistros());
                attachedRegistroListNew.add(registroListNewRegistroToAttach);
            }
            registroListNew = attachedRegistroListNew;
            paciente.setRegistroList(registroListNew);
            paciente = em.merge(paciente);
            for (Expediente expedienteListNewExpediente : expedienteListNew) {
                if (!expedienteListOld.contains(expedienteListNewExpediente)) {
                    Paciente oldPacienteidPacienteOfExpedienteListNewExpediente = expedienteListNewExpediente.getPacienteidPaciente();
                    expedienteListNewExpediente.setPacienteidPaciente(paciente);
                    expedienteListNewExpediente = em.merge(expedienteListNewExpediente);
                    if (oldPacienteidPacienteOfExpedienteListNewExpediente != null && !oldPacienteidPacienteOfExpedienteListNewExpediente.equals(paciente)) {
                        oldPacienteidPacienteOfExpedienteListNewExpediente.getExpedienteList().remove(expedienteListNewExpediente);
                        oldPacienteidPacienteOfExpedienteListNewExpediente = em.merge(oldPacienteidPacienteOfExpedienteListNewExpediente);
                    }
                }
            }
            for (Agendavisitas agendavisitasListNewAgendavisitas : agendavisitasListNew) {
                if (!agendavisitasListOld.contains(agendavisitasListNewAgendavisitas)) {
                    Paciente oldPacienteidPacienteOfAgendavisitasListNewAgendavisitas = agendavisitasListNewAgendavisitas.getPacienteidPaciente();
                    agendavisitasListNewAgendavisitas.setPacienteidPaciente(paciente);
                    agendavisitasListNewAgendavisitas = em.merge(agendavisitasListNewAgendavisitas);
                    if (oldPacienteidPacienteOfAgendavisitasListNewAgendavisitas != null && !oldPacienteidPacienteOfAgendavisitasListNewAgendavisitas.equals(paciente)) {
                        oldPacienteidPacienteOfAgendavisitasListNewAgendavisitas.getAgendavisitasList().remove(agendavisitasListNewAgendavisitas);
                        oldPacienteidPacienteOfAgendavisitasListNewAgendavisitas = em.merge(oldPacienteidPacienteOfAgendavisitasListNewAgendavisitas);
                    }
                }
            }
            for (Finanza finanzaListNewFinanza : finanzaListNew) {
                if (!finanzaListOld.contains(finanzaListNewFinanza)) {
                    Paciente oldPacienteidPacienteOfFinanzaListNewFinanza = finanzaListNewFinanza.getPacienteidPaciente();
                    finanzaListNewFinanza.setPacienteidPaciente(paciente);
                    finanzaListNewFinanza = em.merge(finanzaListNewFinanza);
                    if (oldPacienteidPacienteOfFinanzaListNewFinanza != null && !oldPacienteidPacienteOfFinanzaListNewFinanza.equals(paciente)) {
                        oldPacienteidPacienteOfFinanzaListNewFinanza.getFinanzaList().remove(finanzaListNewFinanza);
                        oldPacienteidPacienteOfFinanzaListNewFinanza = em.merge(oldPacienteidPacienteOfFinanzaListNewFinanza);
                    }
                }
            }
            for (Registro registroListNewRegistro : registroListNew) {
                if (!registroListOld.contains(registroListNewRegistro)) {
                    Paciente oldPacienteidPacienteOfRegistroListNewRegistro = registroListNewRegistro.getPacienteidPaciente();
                    registroListNewRegistro.setPacienteidPaciente(paciente);
                    registroListNewRegistro = em.merge(registroListNewRegistro);
                    if (oldPacienteidPacienteOfRegistroListNewRegistro != null && !oldPacienteidPacienteOfRegistroListNewRegistro.equals(paciente)) {
                        oldPacienteidPacienteOfRegistroListNewRegistro.getRegistroList().remove(registroListNewRegistro);
                        oldPacienteidPacienteOfRegistroListNewRegistro = em.merge(oldPacienteidPacienteOfRegistroListNewRegistro);
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
            List<Expediente> expedienteListOrphanCheck = paciente.getExpedienteList();
            for (Expediente expedienteListOrphanCheckExpediente : expedienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Expediente " + expedienteListOrphanCheckExpediente + " in its expedienteList field has a non-nullable pacienteidPaciente field.");
            }
            List<Agendavisitas> agendavisitasListOrphanCheck = paciente.getAgendavisitasList();
            for (Agendavisitas agendavisitasListOrphanCheckAgendavisitas : agendavisitasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Agendavisitas " + agendavisitasListOrphanCheckAgendavisitas + " in its agendavisitasList field has a non-nullable pacienteidPaciente field.");
            }
            List<Finanza> finanzaListOrphanCheck = paciente.getFinanzaList();
            for (Finanza finanzaListOrphanCheckFinanza : finanzaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Finanza " + finanzaListOrphanCheckFinanza + " in its finanzaList field has a non-nullable pacienteidPaciente field.");
            }
            List<Registro> registroListOrphanCheck = paciente.getRegistroList();
            for (Registro registroListOrphanCheckRegistro : registroListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Registro " + registroListOrphanCheckRegistro + " in its registroList field has a non-nullable pacienteidPaciente field.");
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
