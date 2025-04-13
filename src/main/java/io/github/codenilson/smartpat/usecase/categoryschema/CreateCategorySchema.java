package io.github.codenilson.smartpat.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.CategorySchema;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;

public class CreateCategorySchema {
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public CreateCategorySchema(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public void execute(CategorySchema cs) {
        categorySchemaRepository.save(cs);
    }

}
