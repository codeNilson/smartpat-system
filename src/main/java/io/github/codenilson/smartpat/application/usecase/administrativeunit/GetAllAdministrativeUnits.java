package io.github.codenilson.smartpat.application.usecase.administrativeunit;


import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.AdministrativeUnit;
import io.github.codenilson.smartpat.persistence.repositories.AdministrativeUnitRepository;

public class GetAllAdministrativeUnits {
    private final AdministrativeUnitRepository repository;

    @Inject
    public GetAllAdministrativeUnits(AdministrativeUnitRepository administrativeUnitRepository) {
        this.repository = administrativeUnitRepository;
    }

    public List<AdministrativeUnit> execute() {
        return repository.findAll();
    }
}
