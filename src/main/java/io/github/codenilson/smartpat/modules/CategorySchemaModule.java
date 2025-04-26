package io.github.codenilson.smartpat.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import io.github.codenilson.smartpat.application.usecase.categoryschema.CreateCategorySchema;
import io.github.codenilson.smartpat.application.usecase.categoryschema.DeleteCategorySchema;
import io.github.codenilson.smartpat.application.usecase.categoryschema.GetAllCategorySchemas;
import io.github.codenilson.smartpat.application.usecase.categoryschema.GetCategorySchemaById;
import io.github.codenilson.smartpat.application.usecase.categoryschema.UpdateCategorySchema;
import io.github.codenilson.smartpat.persistence.repositories.CategorySchemaRepository;

public class CategorySchemaModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CategorySchemaRepository.class).in(Scopes.SINGLETON);
        bind(CreateCategorySchema.class).in(Scopes.SINGLETON);
        bind(DeleteCategorySchema.class).in(Scopes.SINGLETON);
        bind(GetCategorySchemaById.class).in(Scopes.SINGLETON);
        bind(GetAllCategorySchemas.class).in(Scopes.SINGLETON);
        bind(UpdateCategorySchema.class).in(Scopes.SINGLETON);

    }
}