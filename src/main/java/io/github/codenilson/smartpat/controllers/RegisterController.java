package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.usecase.asset.CreateAsset;
import io.github.codenilson.smartpat.usecase.asset.GetAllAssets;
import io.github.codenilson.smartpat.usecase.category.CreateCategory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

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

    @FXML
    private TilePane assetsContainer;

    private final CreateCategory createCategory;
    private final CreateAsset createAsset;
    private final GetAllAssets getAllAssets;

    @Inject
    public RegisterController(CreateCategory createCategory, CreateAsset createAsset, GetAllAssets getAllAssets) {
        this.getAllAssets = getAllAssets;
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

        // Category category = new Category();
        // category.setName("Cadeira");
        // createCategory.execute(category);

        // Asset asset = new Asset();
        // asset.setAssetCode(123456L);
        // asset.setCategory(category);
        // asset.setAdministrativeUnit("COAFI");
        // asset.setLocationUnit("CEGEA");
        // asset.setExtraProperties(new HashMap<>());
        // asset.getExtraProperties().put("Propriedade", "Valor da Propriedade");
        // asset.setOwnership(Ownership.LEASED);
        // asset.setImagePath("C:\\Users\\Denilson\\Pictures\\cadeira.jpg");
        // createAsset.execute(asset);

        // Asset asset2 = new Asset();
        // asset2.setAssetCode(654321L);
        // asset2.setCategory(category);
        // asset2.setAdministrativeUnit("CEGEA");
        // asset2.setLocationUnit("Almoxarifado");
        // asset2.setExtraProperties(new HashMap<>());
        // asset2.getExtraProperties().put("Propriedade", "Valor da Propriedade 2");
        // asset2.setOwnership(Ownership.OWNED);
        // asset2.setImagePath("C:\\Users\\Denilson\\Pictures\\backgroundtlou.jpg");
        // createAsset.execute(asset2);

        // Asset asset3 = new Asset();
        // asset3.setAssetCode(789012L);
        // asset3.setCategory(category);
        // asset3.setAdministrativeUnit("COPROJ");
        // asset3.setLocationUnit("Orçamentos");
        // asset3.setExtraProperties(new HashMap<>());
        // asset3.getExtraProperties().put("Propriedade", "Valor da Propriedade 3");
        // asset3.setOwnership(Ownership.OWNED);
        // asset3.setImagePath("C:\\Users\\Denilson\\Pictures\\bleach-background.jpg");
        // createAsset.execute(asset3);

        List<Asset> assets = getAllAssets.execute();

        populateAssetCards(assets);
        populateAssetCards(assets);
    }

    private void populateAssetCards(List<Asset> assets) {
        assets.forEach(asset -> {
            VBox outVBox = new VBox();
            VBox innerVBox = new VBox(5);
            StringBuilder cardDescriptionText = new StringBuilder();

            Image image = new Image("file:/" + asset.getImagePath());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);

            Label cardTitle = new Label();
            cardTitle.setText(asset.getCategory().getName());
            cardTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
            cardTitle.setMaxWidth(Double.MAX_VALUE);
            cardTitle.setAlignment(Pos.CENTER);
            VBox.setVgrow(cardTitle, Priority.ALWAYS);

            Label cardDescription = new Label();
            asset.getExtraProperties().forEach((key, value) -> {
                cardDescriptionText.append(key).append(" ").append(" ").append(value).append(", ");
            });
            cardDescription.setText(cardDescriptionText.toString() + " com gaveta, cor azul, comprimento 1,20m");
            // cardDescription.setPrefWidth(150);
            cardDescription.setWrapText(true);
            cardDescription.setMaxWidth(Double.MAX_VALUE);
            cardDescription.setMaxHeight(Double.MAX_VALUE);
            VBox.setVgrow(cardDescription, Priority.ALWAYS);

            Label cardLocationInfo = new Label();
            cardLocationInfo.setText(asset.getAdministrativeUnit() + " - " + asset.getLocationUnit());
            cardLocationInfo.setMaxWidth(Double.MAX_VALUE);
            cardLocationInfo.setStyle("-fx-font-style: italic; -fx-font-size: 12px;");

            innerVBox.getChildren().addAll(imageView, cardTitle, cardDescription, cardLocationInfo);
            innerVBox.setFillWidth(true);
            innerVBox.setAlignment(Pos.CENTER);
            innerVBox.setPrefHeight(250);
            innerVBox.setPrefWidth(150);
            innerVBox.setStyle("-fx-background-color:  #f5f5f5;");

            outVBox.getChildren().add(innerVBox);
            outVBox.setPadding(new Insets(10));

            assetsContainer.getChildren().add(outVBox);
        });
    }

}