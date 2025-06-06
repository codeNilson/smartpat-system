package io.github.codenilson.smartpat.controllers.scenes;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.application.usecase.administrativeunit.CreateAdministrativeUnit;
import io.github.codenilson.smartpat.application.usecase.asset.CreateAsset;
import io.github.codenilson.smartpat.application.usecase.asset.GetAllAssets;
import io.github.codenilson.smartpat.application.usecase.category.CreateCategory;
import io.github.codenilson.smartpat.application.usecase.locationunit.CreateLocationUnit;
import io.github.codenilson.smartpat.controllers.components.AssetCardController;
import io.github.codenilson.smartpat.persistence.entities.AdministrativeUnit;
import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import io.github.codenilson.smartpat.persistence.valueobjects.Ownership;
import io.github.codenilson.smartpat.tasks.LoadAssetsTask;
import io.github.codenilson.smartpat.utils.Util;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ListAssetsController implements Initializable {

    @FXML
    private TilePane assetsContainer;

    @FXML
    ProgressIndicator loadingSpinner;

    private List<Asset> assets = new ArrayList<>();

    private final CreateCategory createCategory;
    private final CreateAsset createAsset;
    private final GetAllAssets getAllAssets;
    private final CreateAdministrativeUnit createAdministrativeUnit;
    private final CreateLocationUnit createLocationUnit;

    @Inject
    public ListAssetsController(CreateCategory createCategory,
            CreateAsset createAsset,
            GetAllAssets getAllAssets,
            CreateAdministrativeUnit createAdministrativeUnit,
            CreateLocationUnit createLocationUnit) {
        this.getAllAssets = getAllAssets;
        this.createAsset = createAsset;
        this.createCategory = createCategory;
        this.createAdministrativeUnit = createAdministrativeUnit;
        this.createLocationUnit = createLocationUnit;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // createInitialAssets();
        loadDataBaseData();

    }

    public void loadDataBaseData() {

        loadingSpinner.setVisible(true);
        LoadAssetsTask loadAssetsTask = new LoadAssetsTask(getAllAssets);

        loadAssetsTask.setOnSucceeded(e -> {
            loadingSpinner.setVisible(false);
            assets = loadAssetsTask.getValue();
            populateAssetCards(assets);
        });

        loadAssetsTask.setOnFailed(e -> {
            loadingSpinner.setVisible(false);
            assetsContainer.getChildren().clear();
            assetsContainer.getChildren().add(new Label("Erro ao carregar os itens."));
        });

        loadAssetsTask.getAssets();
    }

    private void createInitialAssets() {

        Category category1 = new Category("Cadeira");
        Category category2 = new Category("Mesa");
        Category category3 = new Category("Computador");
        Category category4 = new Category("Monitor");
        Category category5 = new Category("Impressora");

        createCategory.execute(category1);
        createCategory.execute(category2);
        createCategory.execute(category3);
        createCategory.execute(category4);
        createCategory.execute(category5);

        AdministrativeUnit administrativeUnit1 = new AdministrativeUnit("COAFI");
        AdministrativeUnit administrativeUnit2 = new AdministrativeUnit("CEGEA");
        AdministrativeUnit administrativeUnit3 = new AdministrativeUnit("COPROJ");

        createAdministrativeUnit.execute(administrativeUnit1);
        createAdministrativeUnit.execute(administrativeUnit2);
        createAdministrativeUnit.execute(administrativeUnit3);

        LocationUnit locationUnit1 = new LocationUnit("Almoxarifado", administrativeUnit1);
        LocationUnit locationUnit2 = new LocationUnit("Orçamentos", administrativeUnit2);
        LocationUnit locationUnit3 = new LocationUnit("Copa", administrativeUnit3);
        LocationUnit locationUnit4 = new LocationUnit("Sala de Reunião", administrativeUnit1);
        LocationUnit locationUnit5 = new LocationUnit("Desapropriação", administrativeUnit2);
        LocationUnit locationUnit6 = new LocationUnit("Qualifor", administrativeUnit3);

        createLocationUnit.execute(locationUnit1);
        createLocationUnit.execute(locationUnit2);
        createLocationUnit.execute(locationUnit3);
        createLocationUnit.execute(locationUnit4);
        createLocationUnit.execute(locationUnit5);
        createLocationUnit.execute(locationUnit6);

        Asset asset = new Asset();
        asset.setAssetCode(123456L);
        asset.setCategory(category1);
        asset.setLocationUnit(locationUnit2);
        asset.setExtraProperties(new HashMap<>());
        asset.getExtraProperties().put("Propriedade", "Valor da Propriedade");
        asset.setOwnership(Ownership.LEASED);
        asset.setImagePath("C:\\Users\\Denilson\\Pictures\\cadeira.jpg");
        createAsset.execute(asset);

        Asset asset2 = new Asset();
        asset2.setAssetCode(654321L);
        asset2.setCategory(category2);
        asset2.setLocationUnit(locationUnit1);
        asset2.setExtraProperties(new HashMap<>());
        asset2.getExtraProperties().put("Propriedade", "Valor da Propriedade 2");
        asset2.setOwnership(Ownership.OWNED);
        asset2.setImagePath("C:\\Users\\Denilson\\Pictures\\backgroundtlou.jpg");
        createAsset.execute(asset2);

        Asset asset3 = new Asset();
        asset3.setAssetCode(789012L);
        asset3.setCategory(category3);
        asset3.setLocationUnit(locationUnit6);
        asset3.setExtraProperties(new HashMap<>());
        asset3.getExtraProperties().put("Com portas", "sim");
        asset3.setOwnership(Ownership.OWNED);
        asset3.setImagePath("C:\\Users\\Denilson\\Pictures\\bleach-background.jpg");
        createAsset.execute(asset3);
    }

    private void populateAssetCards(List<Asset> assets) {
        assets.forEach(asset -> {
            FXMLLoader loader = Util.loadFXML("/gui/components/asset-card.fxml");
            try {
                VBox cardRoot = loader.load();
                AssetCardController assetCardController = loader.getController();
                assetCardController.setData(asset);
                assetsContainer.getChildren().add(cardRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void addShadowEffect(Node node) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(1);
        dropShadow.setOffsetY(1);
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.GRAY);
        node.setEffect(dropShadow);
    }

}