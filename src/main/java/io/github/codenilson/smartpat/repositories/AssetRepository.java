package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.entities.Asset;
import io.github.codenilson.smartpat.persistence.BaseRepository;

public class AssetRepository extends BaseRepository<Asset> {

    public AssetRepository() {
        super(Asset.class);
    }

}
