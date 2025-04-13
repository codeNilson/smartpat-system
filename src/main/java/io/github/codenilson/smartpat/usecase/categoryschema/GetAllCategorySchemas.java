package io.github.codenilson.smartpat.usecase.categoryschema;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.CategorySchemaJpaEntity;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;

public class GetAllCategorySchemas {
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public GetAllCategorySchemas(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public List<CategorySchemaJpaEntity> execute() {
        return categorySchemaRepository.findAll();
    }
}