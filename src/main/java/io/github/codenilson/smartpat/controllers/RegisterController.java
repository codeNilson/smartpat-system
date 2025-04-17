package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.valueobjects.Ownership;
import io.github.codenilson.smartpat.usecase.asset.CreateAsset;
import io.github.codenilson.smartpat.usecase.category.CreateCategory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RegisterController implements Initializable {

    @FXML
    private TableView<Asset> tableView;

    @FXML
    private TableColumn<Asset, String> tombamentoColumn;

    @FXML
    private TableColumn<Asset, String> categoryColumn;

    @FXML
    private TableColumn<Asset, String> unidadeAdministrativaColumn;

    @FXML
    private TableColumn<Asset, String> unidadeDeLocalizacaoColumn;

    @FXML
    private TableColumn<Asset, String> propertyColumn;

    private final CreateCategory createCategory;
    private final CreateAsset createAsset;

    @Inject
    public RegisterController(CreateCategory createCategory, CreateAsset createAsset) {
        this.createAsset = createAsset;
        this.createCategory = createCategory;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeTableColumns();

        loadDataBaseData();

    }

    private void initializeTableColumns() {
    }

    public void loadDataBaseData() {

        Category category = new Category();
        category.setName("Cadeira");

        Asset asset = new Asset();
        asset.setAssetCode(123456L);
        asset.setCategory(category);
        asset.setAdministrativeUnit("Unidade Administrativa");
        asset.setLocationUnit("Unidade de Localização");
        asset.setExtraProperties(new HashMap<>());
        asset.getExtraProperties().put("Propriedade", "Valor da Propriedade");
        asset.setOwnership(Ownership.LEASED);

        createCategory.execute(category);
        createAsset.execute(asset);
    }

}
