package io.github.codenilson.smartpat.usecase.asset;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.domain.entities.Asset;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class GetAllAssets {
    private final AssetRepository assetRepository;

    @Inject
    public GetAllAssets(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<Asset> execute() {
        return assetRepository.findAll();
    }
}
