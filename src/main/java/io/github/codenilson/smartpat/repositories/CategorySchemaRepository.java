package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.infra.BaseRepository;
import io.github.codenilson.smartpat.infra.persistence.jpa.CategorySchemaJpaEntity;

public class CategorySchemaRepository extends BaseRepository<CategorySchemaJpaEntity> {

    public CategorySchemaRepository() {
        super(CategorySchemaJpaEntity.class);
    }

}
