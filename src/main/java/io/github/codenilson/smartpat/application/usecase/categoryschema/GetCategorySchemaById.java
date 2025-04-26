package io.github.codenilson.smartpat.application.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.CategorySchema;
import io.github.codenilson.smartpat.persistence.repositories.CategorySchemaRepository;

public class GetCategorySchemaById {
    // implementation
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public GetCategorySchemaById(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public CategorySchema execute(Integer id) {
        return categorySchemaRepository.findById(id);
    }
}
