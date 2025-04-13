package io.github.codenilson.smartpat.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.AssetJpaEntity;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class UpdateAsset {
    private final AssetRepository assetRepository;

    @Inject
    public UpdateAsset(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public void execute(AssetJpaEntity asset) {
        assetRepository.update(asset);
    }
}
