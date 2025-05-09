package io.github.codenilson.smartpat.application.usecase.locationunit;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import io.github.codenilson.smartpat.persistence.repositories.LocationUnitRepository;

public class GetAllLocationUnits {
    private final LocationUnitRepository repository;

    @Inject
    public GetAllLocationUnits(LocationUnitRepository locationUnitRepository) {
        this.repository = locationUnitRepository;
    }

    public List<LocationUnit> execute() {
        return repository.findAll();
    }
}
