package io.github.codenilson.smartpat.domain.repository;

import java.util.List;

import io.github.codenilson.smartpat.infra.persistence.jpa.CategoryJpaEntity;

public interface CategoryRepository {
    public void save(CategoryJpaEntity category);

    public void update(CategoryJpaEntity category);

    public CategoryJpaEntity findById(Integer id);

    public List<CategoryJpaEntity> findAll();

    public void delete(CategoryJpaEntity entity);
}
