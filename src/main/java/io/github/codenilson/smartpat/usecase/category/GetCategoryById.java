package io.github.codenilson.smartpat.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.CategoryJpaEntity;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class GetCategoryById {
    private final CategoryRepository categoryRepository;

    @Inject
    public GetCategoryById(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryJpaEntity execute(Integer id) {
        return categoryRepository.findById(id);
    }
}
