package io.github.codenilson.smartpat.usecase.asset;

import java.util.List;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.AssetJpaEntity;
import io.github.codenilson.smartpat.repositories.AssetRepository;

public class GetAllAssets {
    private final AssetRepository assetRepository;

    @Inject
    public GetAllAssets(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetJpaEntity> execute() {
        return assetRepository.findAll();
    }
}
