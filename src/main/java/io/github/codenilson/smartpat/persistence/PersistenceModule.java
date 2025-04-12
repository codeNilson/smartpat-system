package io.github.codenilson.smartpat.persistence;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import io.github.codenilson.smartpat.repositories.AssetRepository;
import io.github.codenilson.smartpat.repositories.CategoryRepository;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;
import io.github.codenilson.smartpat.services.AssetService;
import io.github.codenilson.smartpat.services.CategorySchemaService;
import io.github.codenilson.smartpat.services.CategoryService;

public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AssetRepository.class).in(Scopes.SINGLETON);
        bind(AssetService.class).in(Scopes.SINGLETON);

        bind(CategoryRepository.class).in(Scopes.SINGLETON);
        bind(CategoryService.class).in(Scopes.SINGLETON);

        bind(CategorySchemaRepository.class).in(Scopes.SINGLETON);
        bind(CategorySchemaService.class).in(Scopes.SINGLETON);
    }

}
