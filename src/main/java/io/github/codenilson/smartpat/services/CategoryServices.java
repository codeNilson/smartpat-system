package io.github.codenilson.smartpat.services;

import io.github.codenilson.smartpat.entities.Category;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class CategoryServices {
    
    private final CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public void update(Category category) {
        categoryRepository.update(category);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    public void close() {
        categoryRepository.close();
    }
}
