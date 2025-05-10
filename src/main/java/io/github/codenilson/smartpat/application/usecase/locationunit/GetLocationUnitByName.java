package io.github.codenilson.smartpat.application.usecase.locationunit;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import io.github.codenilson.smartpat.persistence.repositories.LocationUnitRepository;

public class GetLocationUnitByName {
    private final LocationUnitRepository repository;

    @Inject
    public GetLocationUnitByName(LocationUnitRepository locationUnitRepository) {
        this.repository = locationUnitRepository;
    }

    public LocationUnit execute(String name) {
        return repository.findByName(name);
    }
}
