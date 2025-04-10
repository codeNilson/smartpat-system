package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.entities.CategorySchema;
import io.github.codenilson.smartpat.persistence.BaseRepository;

public class CategorySchemaRepository extends BaseRepository<CategorySchema> {

    public CategorySchemaRepository() {
        super(CategorySchema.class);
    }

}
