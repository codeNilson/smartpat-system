package io.github.codenilson.smartpat.domain.repository;

import java.util.List;

import io.github.codenilson.smartpat.domain.entities.Category;

public interface CategoryRepository {
    public void save(Category category);

    public void update(Category category);

    public Category findById(Integer id);

    public List<Category> findAll();

    public void delete(Category entity);
}
