package io.github.codenilson.smartpat.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import io.github.codenilson.smartpat.application.usecase.asset.CreateAsset;
import io.github.codenilson.smartpat.application.usecase.asset.DeleteAsset;
import io.github.codenilson.smartpat.application.usecase.asset.GetAllAssets;
import io.github.codenilson.smartpat.application.usecase.asset.GetAssetById;
import io.github.codenilson.smartpat.application.usecase.asset.UpdateAsset;
import io.github.codenilson.smartpat.persistence.repositories.AssetRepository;

public class AssetModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AssetRepository.class).in(Scopes.SINGLETON);
        bind(CreateAsset.class).in(Scopes.SINGLETON);
        bind(DeleteAsset.class).in(Scopes.SINGLETON);
        bind(GetAssetById.class).in(Scopes.SINGLETON);
        bind(GetAllAssets.class).in(Scopes.SINGLETON);
        bind(UpdateAsset.class).in(Scopes.SINGLETON);
    }

}
