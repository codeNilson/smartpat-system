package io.github.codenilson.smartpat.persistence.repositories;

import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.persistence.entities.Category;

public class CategoryRepository extends BaseRepository<Category> {

    public CategoryRepository() {
        super(Category.class);
    }
}
