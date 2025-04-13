package io.github.codenilson.smartpat.usecase.category;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Category;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class GetAllCategories {
    private final CategoryRepository categoryRepository;

    @Inject
    public GetAllCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> execute() {
        return categoryRepository.findAll();
    }
}
