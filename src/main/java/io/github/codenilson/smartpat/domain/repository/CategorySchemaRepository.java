package io.github.codenilson.smartpat.domain.repository;

import java.util.List;

public interface CategorySchemaRepository {
    public void save(CategorySchemaRepository categorySchema);

    public CategorySchemaRepository findById(Integer id);

    public List<CategorySchemaRepository> findAll();

    public void update(CategorySchemaRepository categorySchema);

    public void delete(CategorySchemaRepository entity);
}
