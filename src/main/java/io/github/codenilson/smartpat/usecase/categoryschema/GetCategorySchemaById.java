package io.github.codenilson.smartpat.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.CategorySchema;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;

public class GetCategorySchemaById {
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public GetCategorySchemaById(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public CategorySchema execute(Integer id) {
        return categorySchemaRepository.findById(id);
    }
}
