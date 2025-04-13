package io.github.codenilson.smartpat.persistence.repositories;

import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.persistence.entities.Asset;

public class AssetRepository extends BaseRepository<Asset> {

    public AssetRepository() {
        super(Asset.class);
    }

}
