package io.github.codenilson.smartpat.repositories;

import io.github.codenilson.smartpat.infra.BaseRepository;
import io.github.codenilson.smartpat.infra.persistence.jpa.AssetJpaEntity;

public class AssetRepository extends BaseRepository<AssetJpaEntity> {

    public AssetRepository() {
        super(AssetJpaEntity.class);
    }

}
