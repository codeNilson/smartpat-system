package io.github.codenilson.smartpat.services;

import java.util.List;

import io.github.codenilson.smartpat.entities.Asset;
import io.github.codenilson.smartpat.persistence.Service;
import io.github.codenilson.smartpat.repositories.AssetRepository;
import io.github.codenilson.smartpat.utils.Util;

public class AssetService implements Service<Asset> {

    private final AssetRepository assetRepository;

    public AssetService() {
        this.assetRepository = new AssetRepository();
    }

    @Override
    public void save(Asset asset) {
        sanitizeEntity(asset);
        assetRepository.save(asset);
    }

    @Override
    public Asset findById(Integer id) {
        return assetRepository.findById(id);
    }

    @Override
    public List<Asset> findAll() {
        return assetRepository.findAll();
    }

    @Override
    public void update(Asset asset) {
        sanitizeEntity(asset);
        assetRepository.update(asset);
    }

    @Override
    public void delete(Asset asset) {
        assetRepository.delete(asset);
    }

    private void sanitizeEntity(Asset asset) {
        asset.setLocationUnit(Util.cleanString(asset.getLocationUnit()));
        asset.setAdministrativeUnit(Util.cleanString(asset.getAdministrativeUnit()));
    }
}
