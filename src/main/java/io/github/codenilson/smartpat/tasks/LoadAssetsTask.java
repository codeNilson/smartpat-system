package io.github.codenilson.smartpat.tasks;

import java.util.List;

import io.github.codenilson.smartpat.application.usecase.asset.GetAllAssets;
import io.github.codenilson.smartpat.persistence.entities.Asset;
import javafx.concurrent.Task;

public class LoadAssetsTask extends Task<List<Asset>> {

    private final GetAllAssets getAllAssets;

    public LoadAssetsTask(GetAllAssets getAllAssets) {
        this.getAllAssets = getAllAssets;
    };

    public void getAssets() {
        new Thread(this).start();
    }

    @Override
    protected List<Asset> call() {
        return getAllAssets.execute();
    }
}
