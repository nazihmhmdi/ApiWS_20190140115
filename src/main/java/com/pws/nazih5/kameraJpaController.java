/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.nazih5;

import com.pws.nazih5.exceptions.NonexistentEntityException;
import com.pws.nazih5.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author nazih
 */
public class kameraJpaController implements Serializable {

    public kameraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.pws_nazih.115_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public kameraJpaController() {
    }
                    
    public void create(kamera kamera) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(kamera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findkamera(kamera.getNoseri()) != null) {
                throw new PreexistingEntityException("kamera " + kamera + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(kamera kamera) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            kamera = em.merge(kamera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = kamera.getNoseri();
                if (findkamera(id) == null) {
                    throw new NonexistentEntityException("The kamera with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            kamera kamera;
            try {
                kamera = em.getReference(kamera.class, id);
                kamera.getNoseri();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kamera with id " + id + " no longer exists.", enfe);
            }
            em.remove(kamera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<kamera> findkameraEntities() {
        return findkameraEntities(true, -1, -1);
    }

    public List<kamera> findkameraEntities(int maxResults, int firstResult) {
        return findkameraEntities(false, maxResults, firstResult);
    }

    private List<kamera> findkameraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(kamera.class));
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

    public kamera findkamera(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(kamera.class, id);
        } finally {
            em.close();
        }
    }

    public int getkameraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<kamera> rt = cq.from(kamera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
