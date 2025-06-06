package io.github.codenilson.smartpat.controllers.scenes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.application.usecase.administrativeunit.GetAllAdministrativeUnits;
import io.github.codenilson.smartpat.application.usecase.asset.UpdateAsset;
import io.github.codenilson.smartpat.application.usecase.category.GetAllCategories;
import io.github.codenilson.smartpat.application.usecase.category.GetCategoryByName;
import io.github.codenilson.smartpat.application.usecase.locationunit.GetAllLocationUnits;
import io.github.codenilson.smartpat.application.usecase.locationunit.GetLocationUnitByName;
import io.github.codenilson.smartpat.persistence.entities.AdministrativeUnit;
import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.entities.LocationUnit;
import io.github.codenilson.smartpat.persistence.valueobjects.Ownership;
import io.github.codenilson.smartpat.utils.AlertConfirmation;
import io.github.codenilson.smartpat.utils.Util;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DetailItemController implements Initializable {

    private static Asset asset = new Asset();

    @FXML
    private Button saveButton;

    @FXML
    private Button closeButton;

    @FXML
    private ComboBox<Category> categoryList;

    @FXML
    private ComboBox<AdministrativeUnit> admnistrativeUnitList;

    @FXML
    private ComboBox<LocationUnit> locationUnitList;

    @FXML
    private TextField assetCodeTextField;

    @FXML
    private ComboBox<Ownership> ownershipList;

    @FXML
    private ImageView assetImageView;

    private final UpdateAsset updateAsset;
    private final GetCategoryByName getCategoryByName;
    private final GetAllCategories getAllCategories;
    private final GetLocationUnitByName getLocationUnitByName;
    private final GetAllAdministrativeUnits getAllAdministrativeUnits;
    private final GetAllLocationUnits getAllLocationUnits;

    private BooleanProperty valueHasChanged = new SimpleBooleanProperty(false);

    @Inject
    public DetailItemController(UpdateAsset updateAsset,
            GetCategoryByName getCategoryByName,
            GetAllCategories getAllCategories,
            GetLocationUnitByName getLocationUnitByName,
            GetAllAdministrativeUnits getAllAdministrativeUnits,
            GetAllLocationUnits getAllLocationUnits) {
        this.updateAsset = updateAsset;
        this.getCategoryByName = getCategoryByName;
        this.getAllCategories = getAllCategories;
        this.getLocationUnitByName = getLocationUnitByName;
        this.getAllAdministrativeUnits = getAllAdministrativeUnits;
        this.getAllLocationUnits = getAllLocationUnits;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setupAssetCodeText();

        loadAssetOptions();

    }

    private void setupAssetCodeText() {
        assetCodeTextField.setDisable(true);

        assetCodeTextField.focusedProperty().addListener((observable, oldValue,
                newValue) -> {

            if (!newValue) {
                assetCodeTextField.setDisable(true);
            }
        });

        assetCodeTextField.setOnAction(event -> {
            assetCodeTextField.setDisable(true);
        });
    }

    private void loadAssetOptions() {

        categoryList.getItems().addAll(getAllCategories.execute());
        admnistrativeUnitList.getItems().addAll(getAllAdministrativeUnits.execute());
        locationUnitList.getItems().addAll(getAllLocationUnits.execute());
        ownershipList.getItems().addAll(Ownership.values());
    }

    private void setAssetInformation() {

        categoryList.setValue(asset.getCategory());
        admnistrativeUnitList.setValue(asset.getLocationUnit().getAdministrativeUnit());
        locationUnitList.setValue(asset.getLocationUnit());
        assetCodeTextField.setText(asset.getAssetCode().toString());
        ownershipList.setValue(asset.getOwnership());
        assetImageView.setImage(new Image("file:/" + asset.getImagePath()));
    }

    @FXML
    public void onSaveButtonAction(Event event) {

        Category category = getCategoryByName.execute(categoryList.getValue().toString());

        Asset currentAsset = asset;

        currentAsset.setCategory(category);

        LocationUnit locationUnit = getLocationUnitByName.execute(locationUnitList.getValue().getName());

        currentAsset.setLocationUnit(locationUnit);

        currentAsset.setOwnership(ownershipList.getValue());

        currentAsset.setAssetCode(Long.valueOf(assetCodeTextField.getText()));

        Image assetImage = assetImageView.getImage();
        if (assetImage != null) {
            String fullUrl = assetImage.getUrl();
            if (fullUrl.startsWith("file:/")) {
                fullUrl = fullUrl.replace("file:/", "");
            }
            currentAsset.setImagePath(fullUrl);
        }

        updateAsset.execute(currentAsset);

        closeCurrentWindow(event);
    }

    public void onCloseButtonAction(Event event) {

        if (!valueHasChanged.get()) {
            closeCurrentWindow(event);
            return;
        }

        AlertConfirmation alertConfirmation = new AlertConfirmation("As alteração não foram salvas.");
        alertConfirmation.getAlert().setOnHidden(e -> {
            if (alertConfirmation.getAlert().getResult() == ButtonType.OK) {
                closeCurrentWindow(event);
            }
        });
        alertConfirmation.execute();

    }

    private void closeCurrentWindow(Event event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    public void setupDetailView(Stage primaryStage, Asset asset) throws IOException {

        DetailItemController.asset = asset;

        Parent primaryRoot = primaryStage.getScene().getRoot();
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        primaryRoot.setEffect(colorAdjust);

        FXMLLoader loader = Util.loadFXML("/gui/scenes/detail-asset.fxml");
        Parent parent = loader.load();
        DetailItemController controller = loader.getController();
        controller.setAssetInformation();
        controller.setupSaveButton();
        Scene scene = new Scene(parent);
        Util.loadStyleSheet(scene, "/styles/main.css");

        Stage stage = new Stage();
        stage.setTitle("Detalhes do item");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.setOnHidden(e -> primaryRoot.setEffect(null));
        stage.sizeToScene();
        stage.showAndWait();
    }

    public void setupDetailView(Stage primaryStage) throws IOException {

        Parent primaryRoot = primaryStage.getScene().getRoot();
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        primaryRoot.setEffect(colorAdjust);

        FXMLLoader loader = Util.loadFXML("/gui/scenes/detail-asset.fxml");
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Util.loadStyleSheet(scene, "/styles/main.css");

        Stage stage = new Stage();
        stage.setTitle("Detalhes do item");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.setOnHidden(e -> primaryRoot.setEffect(null));
        stage.sizeToScene();
        stage.showAndWait();
    }

    public void onAssetCodeLabelClicked() {

        if (assetCodeTextField.isDisabled()) {
            assetCodeTextField.setDisable(false);
            assetCodeTextField.requestFocus();
        }
    }

    private void setupSaveButton() {

        saveButton.disableProperty().bind(valueHasChanged.not());

        categoryList.valueProperty().addListener((observable, oldValue, newValue) -> {
            verifyChanges();
        });

        admnistrativeUnitList.valueProperty().addListener((observable, oldValue, newValue) -> {
            verifyChanges();
        });

        locationUnitList.valueProperty().addListener((observable, oldValue, newValue) -> {
            verifyChanges();
        });

        ownershipList.valueProperty().addListener((observable, oldValue, newValue) -> {
            verifyChanges();
        });

        assetCodeTextField.textProperty().addListener((observable, oldValue,
                newValue) -> {
            verifyChanges();
        });
    }

    private void verifyChanges() {

        boolean isCategoryChanged = !categoryList.getValue().equals(asset.getCategory());
        boolean isAdmnistrativeUnitChanged = !admnistrativeUnitList.getValue()
                .equals(asset.getLocationUnit().getAdministrativeUnit());
        boolean isLocationUnitChanged = !locationUnitList.getValue().equals(asset.getLocationUnit());
        boolean isOwnershipChanged = !ownershipList.getValue().equals(asset.getOwnership());
        boolean isAssetCodeChanged = !assetCodeTextField.getText().equals(asset.getAssetCode().toString());

        valueHasChanged
                .set(isCategoryChanged || isAdmnistrativeUnitChanged || isLocationUnitChanged || isOwnershipChanged
                        || isAssetCodeChanged);
    }

}
