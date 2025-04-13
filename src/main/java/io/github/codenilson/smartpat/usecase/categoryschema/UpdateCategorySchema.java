package io.github.codenilson.smartpat.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.CategorySchema;
import io.github.codenilson.smartpat.persistence.repositories.CategorySchemaRepository;

public class UpdateCategorySchema {
    // implementation
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public UpdateCategorySchema(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public void execute(CategorySchema cs) {
        categorySchemaRepository.update(cs);
    }
}
