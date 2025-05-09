package io.github.codenilson.smartpat.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import io.github.codenilson.smartpat.application.usecase.administrativeunit.CreateAdministrativeUnit;
import io.github.codenilson.smartpat.application.usecase.administrativeunit.DeleteAdministrativeUnit;
import io.github.codenilson.smartpat.application.usecase.administrativeunit.GetAdministrativeUnitById;
import io.github.codenilson.smartpat.application.usecase.administrativeunit.GetAdministrativeUnitByName;
import io.github.codenilson.smartpat.application.usecase.administrativeunit.GetAllAdministrativeUnits;
import io.github.codenilson.smartpat.application.usecase.administrativeunit.UpdateAdministrativeUnit;
import io.github.codenilson.smartpat.persistence.repositories.AdministrativeUnitRepository;

public class AdministrativeUnitModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AdministrativeUnitRepository.class).in(Scopes.SINGLETON);
        bind(CreateAdministrativeUnit.class).in(Scopes.SINGLETON);
        bind(DeleteAdministrativeUnit.class).in(Scopes.SINGLETON);
        bind(GetAdministrativeUnitById.class).in(Scopes.SINGLETON);
        bind(GetAllAdministrativeUnits.class).in(Scopes.SINGLETON);
        bind(UpdateAdministrativeUnit.class).in(Scopes.SINGLETON);
        bind(GetAdministrativeUnitByName.class).in(Scopes.SINGLETON);
    }
    
}
