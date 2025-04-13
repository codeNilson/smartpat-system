package io.github.codenilson.smartpat.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Asset;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class UpdateAsset {
    private final AssetRepository assetRepository;

    @Inject
    public UpdateAsset(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public void execute(Asset asset) {
        assetRepository.update(asset);
    }
}
