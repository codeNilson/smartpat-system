package io.github.codenilson.smartpat.usecase.asset;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.repositories.AssetRepository;

public class GetAllAssets {
    // implementation
    private final AssetRepository assetRepository;

    @Inject
    public GetAllAssets(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<Asset> execute() {
        return assetRepository.findAll();
    }
}
