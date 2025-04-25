package io.github.codenilson.smartpat.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.valueobjects.Ownership;
import io.github.codenilson.smartpat.usecase.asset.CreateAsset;
import io.github.codenilson.smartpat.usecase.asset.GetAllAssets;
import io.github.codenilson.smartpat.usecase.category.CreateCategory;
import io.github.codenilson.smartpat.utils.Util;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RegisterController implements Initializable {

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

    @FXML
    ProgressIndicator loadingSpinner;

    private List<Asset> assets = new ArrayList<>();

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

        // createInitialAssets();
        loadDataBaseData();

    }

    public void loadDataBaseData() {

        loadingSpinner.setVisible(true);
        Task<List<Asset>> loadAssetsTask = new Task<>() {
            @Override
            protected List<Asset> call() {
                return getAllAssets.execute();
            }
        };

        loadAssetsTask.setOnSucceeded(e -> {
            loadingSpinner.setVisible(false);
            assets = loadAssetsTask.getValue();
            populateAssetCards(assets);
        });

        new Thread(loadAssetsTask).start();
    }

    private void createInitialAssets() {
        Category category = new Category();
        category.setName("Cadeira");
        createCategory.execute(category);

        Asset asset = new Asset();
        asset.setAssetCode(123456L);
        asset.setCategory(category);
        asset.setAdministrativeUnit("COAFI");
        asset.setLocationUnit("CEGEA");
        asset.setExtraProperties(new HashMap<>());
        asset.getExtraProperties().put("Propriedade", "Valor da Propriedade");
        asset.setOwnership(Ownership.LEASED);
        asset.setImagePath("C:\\Users\\Denilson\\Pictures\\cadeira.jpg");
        createAsset.execute(asset);

        Asset asset2 = new Asset();
        asset2.setAssetCode(654321L);
        asset2.setCategory(category);
        asset2.setAdministrativeUnit("CEGEA");
        asset2.setLocationUnit("Almoxarifado");
        asset2.setExtraProperties(new HashMap<>());
        asset2.getExtraProperties().put("Propriedade", "Valor da Propriedade 2");
        asset2.setOwnership(Ownership.OWNED);
        asset2.setImagePath("C:\\Users\\Denilson\\Pictures\\backgroundtlou.jpg");
        createAsset.execute(asset2);

        Asset asset3 = new Asset();
        asset3.setAssetCode(789012L);
        asset3.setCategory(category);
        asset3.setAdministrativeUnit("COPROJ");
        asset3.setLocationUnit("Orçamentos");
        asset3.setExtraProperties(new HashMap<>());
        asset3.getExtraProperties().put("Propriedade", "Valor da Propriedade 3");
        asset3.setOwnership(Ownership.OWNED);
        asset3.setImagePath("C:\\Users\\Denilson\\Pictures\\bleach-background.jpg");
        createAsset.execute(asset3);
    }

    private void populateAssetCards(List<Asset> assets) {
        assets.forEach(asset -> {
            createAssetCardView(asset);
        });
    }

    private void createAssetCardView(Asset asset) {
        VBox outVBox = new VBox();
        outVBox.setOnMouseClicked(event -> {
            Stage stage = getStageFromEvent(event);
            openSecondaryWindow(stage);
        });
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
        addShadowEffect(innerVBox);
        innerVBox.getChildren().addAll(imageView, cardTitle, cardDescription, cardLocationInfo);
        innerVBox.setFillWidth(true);
        VBox.setVgrow(innerVBox, Priority.ALWAYS);

        outVBox.getChildren().add(innerVBox);
        outVBox.getStyleClass().add("category-card-container");
        Util.applyScaleAnimation(outVBox);

        assetsContainer.getChildren().add(outVBox);
    }

    private Stage getStageFromEvent(Event event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    private void openSecondaryWindow(Stage primaryStage) {

        Parent primaryRoot = primaryStage.getScene().getRoot();
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        primaryRoot.setEffect(colorAdjust);

        Stage stage = new Stage();
        stage.setTitle("Detalhes do item");
        stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);
        // stage.setResizable(false);

        // 
        Parent parent = Util.loadFXML("/gui/scenes/detail-item.fxml");
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(RegisterController.class.getResource("/styles/main.css").toExternalForm());
        stage.setScene(scene);

        stage.setOnHidden(e -> primaryRoot.setEffect(null));
        stage.showAndWait();
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