package io.github.codenilson.smartpat.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import io.github.codenilson.smartpat.application.usecase.locationunit.CreateLocationUnit;
import io.github.codenilson.smartpat.application.usecase.locationunit.DeleteLocationUnit;
import io.github.codenilson.smartpat.application.usecase.locationunit.GetAllLocationUnits;
import io.github.codenilson.smartpat.application.usecase.locationunit.GetByAdministrativeUnitId;
import io.github.codenilson.smartpat.application.usecase.locationunit.GetLocationUnitById;
import io.github.codenilson.smartpat.application.usecase.locationunit.GetLocationUnitByName;
import io.github.codenilson.smartpat.application.usecase.locationunit.UpdateLocationUnit;
import io.github.codenilson.smartpat.persistence.repositories.LocationUnitRepository;

public class LocationUnitModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LocationUnitRepository.class).in(Scopes.SINGLETON);
        bind(CreateLocationUnit.class).in(Scopes.SINGLETON);
        bind(DeleteLocationUnit.class).in(Scopes.SINGLETON);
        bind(GetLocationUnitById.class).in(Scopes.SINGLETON);
        bind(GetAllLocationUnits.class).in(Scopes.SINGLETON);
        bind(UpdateLocationUnit.class).in(Scopes.SINGLETON);
        bind(GetLocationUnitByName.class).in(Scopes.SINGLETON);
        bind(GetByAdministrativeUnitId.class).in(Scopes.SINGLETON);
    }

}
