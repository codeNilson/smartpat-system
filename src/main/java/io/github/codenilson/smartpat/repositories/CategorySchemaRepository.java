package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.domain.entities.CategorySchema;
import io.github.codenilson.smartpat.infra.BaseRepository;

public class CategorySchemaRepository extends BaseRepository<CategorySchema> {

    public CategorySchemaRepository() {
        super(CategorySchema.class);
    }

}
