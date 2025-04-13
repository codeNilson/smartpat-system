package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.infra.persistence.jpa.AssetJpaEntity;
import io.github.codenilson.smartpat.infra.persistence.jpa.CategoryJpaEntity;
import io.github.codenilson.smartpat.usecase.category.CreateCategory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RegisterController implements Initializable {

    @FXML
    private TableView<AssetJpaEntity> tableView;

    @FXML
    private TableColumn<AssetJpaEntity, String> tombamentoColumn;

    @FXML
    private TableColumn<AssetJpaEntity, String> categoryColumn;

    @FXML
    private TableColumn<AssetJpaEntity, String> unidadeAdministrativaColumn;

    @FXML
    private TableColumn<AssetJpaEntity, String> unidadeDeLocalizacaoColumn;

    @FXML
    private TableColumn<AssetJpaEntity, String> propertyColumn;

    private final CreateCategory createCategory;

    @Inject
    public RegisterController(CreateCategory createCategory) {
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

        CategoryJpaEntity category = new CategoryJpaEntity();
        category.setName("Cadeira");

        createCategory.execute(category);

    }

}
