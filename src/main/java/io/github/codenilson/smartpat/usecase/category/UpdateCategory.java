package io.github.codenilson.smartpat.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Category;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class UpdateCategory {
    private final CategoryRepository categoryRepository;

    @Inject
    public UpdateCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Category category) {
        categoryRepository.update(category);
    }
}
