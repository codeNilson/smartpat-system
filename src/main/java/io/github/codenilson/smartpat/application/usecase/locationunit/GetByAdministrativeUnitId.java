package io.github.codenilson.smartpat.application.usecase.locationunit;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import io.github.codenilson.smartpat.persistence.repositories.LocationUnitRepository;

public class GetByAdministrativeUnitId {
    private final LocationUnitRepository locationUnitRepository;

    @Inject
    public GetByAdministrativeUnitId(LocationUnitRepository locationUnitRepository) {
        this.locationUnitRepository = locationUnitRepository;
    }

    public List<LocationUnit> execute(Long administrativeUnitId) {
        return locationUnitRepository.findByAdministrativeUnitId(administrativeUnitId);
    }
}
