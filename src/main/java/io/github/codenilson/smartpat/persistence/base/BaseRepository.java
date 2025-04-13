package io.github.codenilson.smartpat.persistence.base;

import java.util.List;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class BaseRepository<T> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mainPU");

    private final Class<T> entityClass;

    public BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public T findById(Integer id) {
        var em = emf.createEntityManager();
        var entity = em.find(entityClass, id);
        em.close();
        if (entity == null) {
            System.out.println(entityClass.getSimpleName() + " not found with ID: " + id);
        }
        return entity;
    }

    public void update(T entity) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(T entity) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

    public List<T> findAll() {
        var em = emf.createEntityManager();
        var query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
        var resultList = query.getResultList();
        em.close();
        return resultList;
    }
    

    public static void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}