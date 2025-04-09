package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.entities.Asset;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AssetRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mainPU");

    public void save(Asset asset) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(asset);
        em.getTransaction().commit();
        em.close();
    }

    public Asset findById(Integer id) {
        var em = emf.createEntityManager();
        var asset = em.find(Asset.class, id);
        em.close();
        if (asset == null) {
            System.out.println("Asset not found with ID: " + id);
        }
        return asset;
    }

    public void update(Asset asset) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(asset);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Asset asset) {
        var em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(asset) ? asset : em.merge(asset));
        em.getTransaction().commit();
        em.close();
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}
