package io.github.codenilson.smartpat.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.CategoryJpaEntity;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class UpdateCategory {
    private final CategoryRepository categoryRepository;

    @Inject
    public UpdateCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(CategoryJpaEntity category) {
        categoryRepository.update(category);
    }
}
