package io.github.codenilson.smartpat.domain.repository;

import java.util.List;

import io.github.codenilson.smartpat.infra.persistence.jpa.AssetJpaEntity;

public interface AssetRepository {

    public void save(AssetJpaEntity asset);
    public AssetJpaEntity findById(int id);
    public List<AssetJpaEntity> findAll();
    public void update(AssetJpaEntity asset);
    public void delete(AssetJpaEntity asset);
}
