package io.github.codenilson.smartpat.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import io.github.codenilson.smartpat.application.usecase.category.CreateCategory;
import io.github.codenilson.smartpat.application.usecase.category.DeleteCategory;
import io.github.codenilson.smartpat.application.usecase.category.GetAllCategories;
import io.github.codenilson.smartpat.application.usecase.category.GetCategoryById;
import io.github.codenilson.smartpat.application.usecase.category.UpdateCategory;
import io.github.codenilson.smartpat.persistence.repositories.CategoryRepository;

public class CategoryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CategoryRepository.class).in(Scopes.SINGLETON);
        bind(CreateCategory.class).in(Scopes.SINGLETON);
        bind(DeleteCategory.class).in(Scopes.SINGLETON);
        bind(GetCategoryById.class).in(Scopes.SINGLETON);
        bind(GetAllCategories.class).in(Scopes.SINGLETON);
        bind(UpdateCategory.class).in(Scopes.SINGLETON);

    }
}