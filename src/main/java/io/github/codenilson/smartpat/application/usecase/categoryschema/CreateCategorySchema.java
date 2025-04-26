package io.github.codenilson.smartpat.application.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.CategorySchema;
import io.github.codenilson.smartpat.persistence.repositories.CategorySchemaRepository;

public class CreateCategorySchema {
    // implementation
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public CreateCategorySchema(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public void execute(CategorySchema cs) {
        categorySchemaRepository.save(cs);
    }

}
