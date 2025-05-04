package io.github.codenilson.smartpat.application.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.repositories.AssetRepository;

public class GetAssetById {
    // implementation
    private final AssetRepository assetRepository;

    @Inject
    public GetAssetById(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Asset execute(Long assetId) {
        return assetRepository.findById(assetId);
    }
}
