package io.github.codenilson.smartpat.usecase.category;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Category;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class GetCategoryById {
    private final CategoryRepository categoryRepository;

    @Inject
    public GetCategoryById(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(Integer id) {
        return categoryRepository.findById(id);
    }
}
