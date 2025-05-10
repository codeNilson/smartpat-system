package io.github.codenilson.smartpat.application.usecase.locationunit;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import io.github.codenilson.smartpat.persistence.repositories.LocationUnitRepository;

public class GetLocationUnitById {
    private final LocationUnitRepository repository;

    @Inject
    public GetLocationUnitById(LocationUnitRepository locationUnitRepository) {
        this.repository = locationUnitRepository;
    }

    public LocationUnit execute(Long id) {
        return repository.findById(id);
    }
}
