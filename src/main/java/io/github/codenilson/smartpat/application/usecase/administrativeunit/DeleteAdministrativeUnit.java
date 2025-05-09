package io.github.codenilson.smartpat.application.usecase.administrativeunit;


import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.AdministrativeUnit;
import io.github.codenilson.smartpat.persistence.repositories.AdministrativeUnitRepository;

public class DeleteAdministrativeUnit {
    private final AdministrativeUnitRepository repository;

    @Inject
    public DeleteAdministrativeUnit(AdministrativeUnitRepository administrativeUnitRepository) {
        this.repository = administrativeUnitRepository;
    }

    public void execute(AdministrativeUnit administrativeUnit) {
        repository.delete(administrativeUnit);
    }
}
