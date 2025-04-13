package io.github.codenilson.smartpat.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Category;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class CreateCategory {
    private final CategoryRepository categoryRepository;

    @Inject
    public CreateCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Category category) {
        categoryRepository.save(category);
    }
}
