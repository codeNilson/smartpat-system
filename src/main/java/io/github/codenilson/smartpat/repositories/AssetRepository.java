package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.domain.entities.Asset;
import io.github.codenilson.smartpat.infra.BaseRepository;

public class AssetRepository extends BaseRepository<Asset> {

    public AssetRepository() {
        super(Asset.class);
    }

}
