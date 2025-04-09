package io.github.codenilson.smartpat.services;

import io.github.codenilson.smartpat.entities.Asset;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class AssetServices {
    
    private final AssetRepository assetRepository;

    public AssetServices(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public void save(Asset asset) {
        assetRepository.save(asset);
    }

    public Asset findById(Integer id) {
        return assetRepository.findById(id);
    }

    public void update(Asset asset) {
        assetRepository.update(asset);
    }

    public void delete(Asset asset) {
        assetRepository.delete(asset);
    }

    public void close() {
        assetRepository.close();
    }
}
