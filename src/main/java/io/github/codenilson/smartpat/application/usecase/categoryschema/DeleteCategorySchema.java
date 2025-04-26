package io.github.codenilson.smartpat.application.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.CategorySchema;
import io.github.codenilson.smartpat.persistence.repositories.CategorySchemaRepository;

public class DeleteCategorySchema {
    // implementation
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public DeleteCategorySchema(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public void execute(CategorySchema cs) {
        categorySchemaRepository.delete(cs);
    }

}
