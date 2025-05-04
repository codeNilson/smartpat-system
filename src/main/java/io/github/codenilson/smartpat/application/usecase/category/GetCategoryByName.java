package io.github.codenilson.smartpat.application.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.repositories.CategoryRepository;

public class GetCategoryByName {
    private final CategoryRepository categoryRepository;

    @Inject
    public GetCategoryByName(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(String name) {
        return categoryRepository.findByName(name);
    }
}
