package io.github.codenilson.smartpat.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.CategorySchema;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;

public class UpdateCategorySchema {
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public UpdateCategorySchema(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public void execute(CategorySchema cs) {
        categorySchemaRepository.update(cs);
    }
}
