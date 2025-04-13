package io.github.codenilson.smartpat.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Asset;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class DeleteAsset {
    private final AssetRepository assetRepository;

    @Inject
    public DeleteAsset(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public void execute(Asset asset) {
        assetRepository.delete(asset);
    }
}
