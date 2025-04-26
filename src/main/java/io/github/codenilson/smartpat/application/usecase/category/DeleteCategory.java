package io.github.codenilson.smartpat.application.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.repositories.CategoryRepository;

public class DeleteCategory {
    // implementation
    private final CategoryRepository categoryRepository;

    @Inject
    public DeleteCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Category category) {
        categoryRepository.delete(category);
    }

}
