package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.entities.Category;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mainPU");

    public void save(Category Category) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(Category);
        em.getTransaction().commit();
        em.close();
    }

    public Category findById(Integer id) {
        var em = emf.createEntityManager();
        var category = em.find(Category.class, id);
        em.close();
        if (category == null) {
            System.out.println("Category not found with ID: " + id);
        }
        return category;
    }

    public void update(Category Category) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(Category);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Category category) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(category) ? category : em.merge(category));
        em.getTransaction().commit();
        em.close();
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}
