package io.github.codenilson.smartpat.services;

import io.github.codenilson.smartpat.entities.Category;
import io.github.codenilson.smartpat.persistence.BaseService;
import io.github.codenilson.smartpat.repositories.CategoryRepository;

public class CategoryServices extends BaseService<Category> {

    public CategoryServices() {
        super(new CategoryRepository());
    }
}