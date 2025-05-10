package io.github.codenilson.smartpat.persistence.repositories;

import java.util.List;

import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import jakarta.persistence.EntityManager;

public class LocationUnitRepository extends BaseRepository<LocationUnit> {

    public LocationUnitRepository() {
        super(LocationUnit.class);
    }

    public LocationUnit findByName(String name) {
        EntityManager em = emf.createEntityManager();
        LocationUnit lu = em.find(LocationUnit.class, name);
        em.close();
        if (lu == null) {
            System.out.println("LocationUnit not found with name: " + name);
        }
        return lu;
    }

    public List<LocationUnit> findByAdministrativeUnitId(Long administrativeUnitId) {
        EntityManager em = emf.createEntityManager();
        List<LocationUnit> locationUnits = em.createQuery("SELECT lu FROM LocationUnit lu WHERE lu.administrativeUnit.id = :administrativeUnitId", LocationUnit.class)
                .setParameter("administrativeUnitId", administrativeUnitId)
                .getResultList();
        em.close();
        return locationUnits;
    }

}
