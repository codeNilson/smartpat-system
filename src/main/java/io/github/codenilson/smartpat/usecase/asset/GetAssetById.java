package io.github.codenilson.smartpat.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Asset;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class GetAssetById {
    private final AssetRepository assetRepository;

    @Inject
    public GetAssetById(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Asset execute(Integer assetId) {
        return assetRepository.findById(assetId);
    }
}
