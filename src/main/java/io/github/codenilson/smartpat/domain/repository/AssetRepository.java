package io.github.codenilson.smartpat.domain.repository;

import java.util.List;

import io.github.codenilson.smartpat.domain.entities.Asset;

public interface AssetRepository {

    public void save(Asset asset);
    public Asset findById(int id);
    public List<Asset> findAll();
    public void update(Asset asset);
    public void delete(Asset asset);
}
