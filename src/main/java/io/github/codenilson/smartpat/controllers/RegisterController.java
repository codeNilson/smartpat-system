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
        populateAssetCards(assets);
        populateAssetCards(assets);
        populateAssetCards(assets);
    }

    private void populateAssetCards(List<Asset> assets) {
        assets.forEach(asset -> {
            createAssetCardView(asset);
        });
    }

    private void createAssetCardView(Asset asset) {
        VBox outVBox = new VBox();
        StringBuilder cardDescriptionText = new StringBuilder();
        
        Image image = new Image("file:/" + asset.getImagePath());
        ImageView imageView = new ImageView(image);
        imageView.setCache(true);
        
        Label cardTitle = new Label();
        cardTitle.getStyleClass().add("category-title");
        cardTitle.setText(asset.getCategory().getName());
        
        Label cardDescription = new Label();
        cardDescription.getStyleClass().add("category-description");
        asset.getExtraProperties().forEach((key, value) -> {
            cardDescriptionText.append(key).append(" ").append(" ").append(value).append(", ");
        });
        cardDescription.setText(cardDescriptionText.toString() + " com gaveta, cor azul, comprimento 1,20m");
        cardDescription.setWrapText(true);
        VBox.setVgrow(cardDescription, Priority.ALWAYS);
        
        Label cardLocationInfo = new Label();
        cardLocationInfo.getStyleClass().add("category-location-info");
        Image locationImage = new Image("https://img.icons8.com/color/48/marker--v1.png");
        ImageView locationImageView = new ImageView(locationImage);
        locationImageView.setPreserveRatio(true);
        locationImageView.setCache(true);
        cardLocationInfo.setGraphic(locationImageView);
        cardLocationInfo.setText(asset.getAdministrativeUnit() + " - " + asset.getLocationUnit());
        
        VBox innerVBox = new VBox();
        innerVBox.getStyleClass().add("category-card");
        innerVBox.getChildren().addAll(imageView, cardTitle, cardDescription, cardLocationInfo);
        innerVBox.setFillWidth(true);
        VBox.setVgrow(innerVBox, Priority.ALWAYS);

        outVBox.getChildren().add(innerVBox);
        CategoriesController.applyScaleAnimation(outVBox);
        assetsContainer.getChildren().add(outVBox);
    }

}