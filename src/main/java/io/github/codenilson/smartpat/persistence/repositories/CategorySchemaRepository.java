package io.github.codenilson.smartpat.persistence.repositories;

import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.persistence.entities.CategorySchema;

public class CategorySchemaRepository extends BaseRepository<CategorySchema> {

    public CategorySchemaRepository() {
        super(CategorySchema.class);
    }

}
