package io.github.codenilson.smartpat.modules;

import com.google.inject.AbstractModule;

public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new AssetModule());
        install(new CategoryModule());
        install(new CategorySchemaModule());
        install(new AdministrativeUnitModule());
        install(new LocationUnitModule());
    }

}
