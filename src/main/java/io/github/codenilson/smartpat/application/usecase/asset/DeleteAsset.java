package io.github.codenilson.smartpat.application.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.repositories.AssetRepository;

public class DeleteAsset {
    // implementation
    private final AssetRepository assetRepository;

    @Inject
    public DeleteAsset(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public void execute(Asset asset) {
        assetRepository.delete(asset);
    }
}
