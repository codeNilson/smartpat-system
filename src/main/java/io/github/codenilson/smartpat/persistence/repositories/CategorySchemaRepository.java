package io.github.codenilson.smartpat.persistence.repositories;

import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.persistence.entities.Attribute;

public class CategorySchemaRepository extends BaseRepository<Attribute> {

    public CategorySchemaRepository() {
        super(Attribute.class);
    }

}
