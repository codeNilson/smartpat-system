package io.github.codenilson.smartpat.usecase.category;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.CategoryJpaEntity;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class GetAllCategories {
    private final CategoryRepository categoryRepository;

    @Inject
    public GetAllCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryJpaEntity> execute() {
        return categoryRepository.findAll();
    }
}
