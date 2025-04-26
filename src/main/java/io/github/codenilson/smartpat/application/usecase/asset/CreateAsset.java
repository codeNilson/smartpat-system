package io.github.codenilson.smartpat.application.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.repositories.AssetRepository;

public class CreateAsset {
    // implementation
    private final AssetRepository assetRepository;

    @Inject
    public CreateAsset(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public void execute(Asset asset) {
        assetRepository.save(asset);
    }
}
