package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.domain.entities.Category;
import io.github.codenilson.smartpat.infra.BaseRepository;

public class CategoryRepository extends BaseRepository<Category> {

    public CategoryRepository() {
        super(Category.class);
    }
}
