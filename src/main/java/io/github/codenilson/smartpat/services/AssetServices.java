package io.github.codenilson.smartpat.services;

import io.github.codenilson.smartpat.entities.Asset;
import io.github.codenilson.smartpat.persistence.BaseService;
import io.github.codenilson.smartpat.repositories.AssetRepository;
import io.github.codenilson.smartpat.utils.Util;

public class AssetServices extends BaseService<Asset> {

    public AssetServices() {
        super(new AssetRepository());
    }

    @Override
    public void save(Asset asset) {
        sanitizeEntity(asset);
        super.save(asset);
    }

    @Override
    public void update(Asset asset) {
        sanitizeEntity(asset);
        super.update(asset);
    }

    @Override
    protected void sanitizeEntity(Asset asset) {
        asset.setLocationUnit(Util.cleanString(asset.getLocationUnit()));
        asset.setAdministrativeUnit(Util.cleanString(asset.getAdministrativeUnit()));
    }
}
