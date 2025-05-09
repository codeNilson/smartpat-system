package io.github.codenilson.smartpat.application.usecase.locationunit;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import io.github.codenilson.smartpat.persistence.repositories.LocationUnitRepository;

public class UpdateLocationUnit {
    private final LocationUnitRepository locationUnitRepository;

    @Inject
    public UpdateLocationUnit(LocationUnitRepository locationUnitRepository) {
        this.locationUnitRepository = locationUnitRepository;
    }

    public void execute(LocationUnit locationUnit) {
        locationUnitRepository.update(locationUnit);
    }
}
