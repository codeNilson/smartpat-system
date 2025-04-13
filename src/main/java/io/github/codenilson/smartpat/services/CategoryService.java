package io.github.codenilson.smartpat.services;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.entities.Category;
import io.github.codenilson.smartpat.persistence.Service;
import io.github.codenilson.smartpat.repositories.CategoryRepository;
import io.github.codenilson.smartpat.utils.Util;

public class CategoryService implements Service<Category> {

    private final CategoryRepository categoryRepository;

    @Inject
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        sanitizeEntity(category);
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        sanitizeEntity(category);
        categoryRepository.update(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

    protected void sanitizeEntity(Category category) {
        category.setName(Util.cleanString(category.getName()));
    }
}