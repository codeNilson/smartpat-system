package io.github.codenilson.smartpat.usecase.categoryschema;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.CategorySchemaJpaEntity;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;

public class DeleteCategorySchema {
    private final CategorySchemaRepository categorySchemaRepository;

    @Inject
    public DeleteCategorySchema(CategorySchemaRepository categorySchemaRepository) {
        this.categorySchemaRepository = categorySchemaRepository;
    }

    public void execute(CategorySchemaJpaEntity cs) {
        categorySchemaRepository.delete(cs);
    }

}
