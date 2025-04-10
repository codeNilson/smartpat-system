package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.entities.Category;
import io.github.codenilson.smartpat.persistence.BaseRepository;

public class CategoryRepository extends BaseRepository<Category> {

    public CategoryRepository() {
        super(Category.class);
    }
}
