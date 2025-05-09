package io.github.codenilson.smartpat.persistence.repositories;

import java.util.List;

import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.persistence.entities.Asset;
import jakarta.persistence.EntityManager;

public class AssetRepository extends BaseRepository<Asset> {

    public AssetRepository() {
        super(Asset.class);
    }

    public List<Asset> findByLocationUnitId(Long locationUnitId) {
        EntityManager em = emf.createEntityManager();
        List<Asset> assets = em
                .createQuery("SELECT a FROM Asset a WHERE a.locationUnit.id = :locationUnitId", Asset.class)
                .setParameter("locationUnitId", locationUnitId)
                .getResultList();
        em.close();
        return assets;
    }

}
