package io.github.codenilson.smartpat.services;

import java.util.List;

import io.github.codenilson.smartpat.entities.CategorySchema;
import io.github.codenilson.smartpat.persistence.Service;
import io.github.codenilson.smartpat.repositories.CategorySchemaRepository;
import io.github.codenilson.smartpat.utils.Util;

public class CategorySchemaService implements Service<CategorySchema> {

    private final CategorySchemaRepository categorySchemaRepository;

    public CategorySchemaService() {
        this.categorySchemaRepository = new CategorySchemaRepository();
    }

    @Override
    public void save(CategorySchema categorySchema) {
        sanitizeEntity(categorySchema);
        categorySchemaRepository.save(categorySchema);
    }

    @Override
    public CategorySchema findById(Integer id) {
        return categorySchemaRepository.findById(id);
    }

    @Override
    public List<CategorySchema> findAll() {
        return categorySchemaRepository.findAll();
    }

    @Override
    public void update(CategorySchema categorySchema) {
        sanitizeEntity(categorySchema);
        categorySchemaRepository.update(categorySchema);
    }

    @Override
    public void delete(CategorySchema entity) {
        categorySchemaRepository.delete(entity);
    }

    private void sanitizeEntity(CategorySchema categorySchema) {
        categorySchema.setFieldName(Util.cleanString(categorySchema.getFieldName()));
        categorySchema.setFieldType(Util.cleanString(categorySchema.getFieldType()));
    }

}
