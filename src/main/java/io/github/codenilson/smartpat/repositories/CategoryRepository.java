package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.infra.BaseRepository;
import io.github.codenilson.smartpat.infra.persistence.jpa.CategoryJpaEntity;

public class CategoryRepository extends BaseRepository<CategoryJpaEntity> {

    public CategoryRepository() {
        super(CategoryJpaEntity.class);
    }
}
