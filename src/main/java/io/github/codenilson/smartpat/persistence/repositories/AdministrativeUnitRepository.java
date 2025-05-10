package io.github.codenilson.smartpat.persistence.repositories;

import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.persistence.entities.AdministrativeUnit;
import jakarta.persistence.EntityManager;

public class AdministrativeUnitRepository extends BaseRepository<AdministrativeUnit> {

    public AdministrativeUnitRepository() {
        super(AdministrativeUnit.class);
    }

    public AdministrativeUnit findByName(String name) {
        EntityManager em = emf.createEntityManager();
        AdministrativeUnit au = em.find(AdministrativeUnit.class, name);
        em.close();
        if (au == null) {
            System.out.println("AdministrativeUnit not found with name: " + name);
        }
        return au;
    }

}
