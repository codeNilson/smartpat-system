package io.github.codenilson.smartpat.services;

import io.github.codenilson.smartpat.entities.CategorySchema;
import io.github.codenilson.smartpat.persistence.BaseService;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;
import io.github.codenilson.smartpat.utils.Util;

public class CategorySchemaServices extends BaseService<CategorySchema> {

    public CategorySchemaServices() {
        super(new CategorySchemaRepository());
    }

    @Override
    public void save(CategorySchema categorySchema) {
        sanitizeEntity(categorySchema);
        super.save(categorySchema);
    }

    @Override
    public void update(CategorySchema categorySchema) {
        sanitizeEntity(categorySchema);
        super.update(categorySchema);
    }

    @Override
    protected void sanitizeEntity(CategorySchema categorySchema) {
        categorySchema.setFieldName(Util.cleanString(categorySchema.getFieldName()));
        categorySchema.setFieldType(Util.cleanString(categorySchema.getFieldType()));
    }

}
