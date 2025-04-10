package io.github.codenilson.smartpat.services;

import io.github.codenilson.smartpat.entities.Category;
import io.github.codenilson.smartpat.persistence.BaseService;
import io.github.codenilson.smartpat.repositories.CategoryRepository;
import io.github.codenilson.smartpat.utils.Util;

public class CategoryServices extends BaseService<Category> {

    public CategoryServices() {
        super(new CategoryRepository());
    }

    @Override
    public void save(Category category) {
        sanitizeEntity(category);
        super.save(category);
    }

    @Override
    public void update(Category category) {
        sanitizeEntity(category);
        super.update(category);
    }

    @Override
    protected void sanitizeEntity(Category category) {
        category.setName(Util.cleanString(category.getName()));
    }
}