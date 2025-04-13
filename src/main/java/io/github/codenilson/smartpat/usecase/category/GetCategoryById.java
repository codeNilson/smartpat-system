package io.github.codenilson.smartpat.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.repositories.CategoryRepository;

public class GetCategoryById {
    // implementation
    private final CategoryRepository categoryRepository;

    @Inject
    public GetCategoryById(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(Integer id) {
        return categoryRepository.findById(id);
    }
}
