package io.github.codenilson.smartpat.services;

import io.github.codenilson.smartpat.entities.Asset;
import io.github.codenilson.smartpat.persistence.BaseService;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class AssetServices extends BaseService<Asset> {

    public AssetServices() {
        super(new AssetRepository());
    }
}
