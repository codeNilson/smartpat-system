package io.github.codenilson.smartpat.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Category;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class DeleteCategory {
    private final CategoryRepository categoryRepository;

    @Inject
    public DeleteCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Category category) {
        categoryRepository.delete(category);
    }

}
