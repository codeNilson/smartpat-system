package io.github.codenilson.smartpat.application.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.repositories.CategoryRepository;

public class CreateCategory {
    // implementation
    private final CategoryRepository categoryRepository;

    @Inject
    public CreateCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Category category) {
        categoryRepository.save(category);
    }
}
