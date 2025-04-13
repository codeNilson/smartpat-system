package io.github.codenilson.smartpat.usecase.asset;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.AssetJpaEntity;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class GetAssetById {
    private final AssetRepository assetRepository;

    @Inject
    public GetAssetById(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public AssetJpaEntity execute(Integer assetId) {
        return assetRepository.findById(assetId);
    }
}
