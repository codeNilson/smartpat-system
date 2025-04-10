package io.github.codenilson.smartpat.persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class BaseRepository<T> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mainPU");

    private final Class<T> entityClass;

    public BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected void save(T entity) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    protected T findById(Integer id) {
        var em = emf.createEntityManager();
        var entity = em.find(entityClass, id);
        em.close();
        if (entity == null) {
            System.out.println(entityClass.getSimpleName() + " not found with ID: " + id);
        }
        return entity;
    }

    protected void update(T entity) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    protected void delete(T entity) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

    public static void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}