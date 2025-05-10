package io.github.codenilson.smartpat.application.usecase.locationunit;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import io.github.codenilson.smartpat.persistence.repositories.LocationUnitRepository;

public class CreateLocationUnit {
    private final LocationUnitRepository repository;

    @Inject
    public CreateLocationUnit(LocationUnitRepository locationUnitRepository) {
        this.repository = locationUnitRepository;
    }

    public void execute(LocationUnit locationUnit) {
        repository.save(locationUnit);
    }
}
