package io.github.codenilson.smartpat.application.usecase.administrativeunit;


import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.AdministrativeUnit;
import io.github.codenilson.smartpat.persistence.repositories.AdministrativeUnitRepository;

public class GetAdministrativeUnitByName {
    private final AdministrativeUnitRepository repository;

    @Inject
    public GetAdministrativeUnitByName(AdministrativeUnitRepository administrativeUnitRepository) {
        this.repository = administrativeUnitRepository;
    }

    public AdministrativeUnit execute(String name) {
        return repository.findByName(name);
    }
}
