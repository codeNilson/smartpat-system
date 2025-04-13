package io.github.codenilson.smartpat.usecase.categoryschema;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.CategorySchema;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;

public class GetAllCategorySchemas {
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public GetAllCategorySchemas(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public List<CategorySchema> execute() {
        return categorySchemaRepository.findAll();
    }
}