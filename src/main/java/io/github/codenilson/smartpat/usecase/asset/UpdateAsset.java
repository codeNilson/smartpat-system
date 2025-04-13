package io.github.codenilson.smartpat.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.repositories.AssetRepository;

public class UpdateAsset {
    // implementation
    private final AssetRepository assetRepository;

    @Inject
    public UpdateAsset(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public void execute(Asset asset) {
        assetRepository.update(asset);
    }
}
