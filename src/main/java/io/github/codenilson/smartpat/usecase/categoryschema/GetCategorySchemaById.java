package io.github.codenilson.smartpat.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.CategorySchemaJpaEntity;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;

public class GetCategorySchemaById {
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public GetCategorySchemaById(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public CategorySchemaJpaEntity execute(Integer id) {
        return categorySchemaRepository.findById(id);
    }
}
