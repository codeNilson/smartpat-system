package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.entities.Asset;
import io.github.codenilson.smartpat.entities.Category;
import io.github.codenilson.smartpat.services.AssetService;
import io.github.codenilson.smartpat.services.CategorySchemaService;
import io.github.codenilson.smartpat.services.CategoryService;
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

    private final AssetService assetService;
    private final CategoryService categoryService;
    private final CategorySchemaService categorySchemaService;

    @Inject
    public RegisterController(AssetService assetService, CategoryService categoryService,
            CategorySchemaService categorySchemaService) {
        this.assetService = assetService;
        this.categoryService = categoryService;
        this.categorySchemaService = categorySchemaService;
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

        categoryService.save(category);

        Asset asset = new Asset();
        asset.setAssetCode(6700004588L);
        asset.setAdministrativeUnit("COAFI");
        asset.setLocationUnit("CEGEA");
        asset.setCategory(category);

        assetService.save(asset);

    }

}
