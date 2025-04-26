package io.github.codenilson.smartpat.application.usecase.category;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.repositories.CategoryRepository;

public class GetAllCategories {
    // implementation
    private final CategoryRepository categoryRepository;

    @Inject
    public GetAllCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> execute() {
        return categoryRepository.findAll();
    }
}
