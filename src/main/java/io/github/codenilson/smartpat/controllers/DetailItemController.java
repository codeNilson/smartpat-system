package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.google.inject.Inject;

import io.github.codenilson.smartpat.application.usecase.asset.UpdateAsset;
import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.persistence.entities.Category;
import io.github.codenilson.smartpat.persistence.valueobjects.Ownership;
import io.github.codenilson.smartpat.utils.Util;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DetailItemController implements Initializable {

    private static Asset asset;

    @FXML
    private Button saveButton;

    @FXML
    private Button closeButton;

    @FXML
    private ComboBox<String> categoryList;

    @FXML
    private ComboBox<String> admnistrativeUnitList;

    @FXML
    private ComboBox<String> locationUnitList;

    @FXML
    private TextField assetCodeTextField;

    @FXML
    private ComboBox<String> ownershipList;

    @FXML
    private ImageView assetImageView;

    private final UpdateAsset updateAsset;

    private BooleanProperty valueHasChanged = new SimpleBooleanProperty(false);

    @Inject
    public DetailItemController(UpdateAsset updateAsset) {
        this.updateAsset = updateAsset;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setupAsseCodeText();

        loadAssetOptions();

        setAssetInformation();

        setupSaveButton();
        saveButton.disableProperty().bind(valueHasChanged.not());
    }

    private void setAssetInformation() {
        categoryList.setValue(asset.getCategory().getName());
        admnistrativeUnitList.setValue(asset.getAdministrativeUnit());
        locationUnitList.setValue(asset.getLocationUnit());
        assetCodeTextField.setText(asset.getAssetCode().toString());
        ownershipList.setValue(asset.getOwnership().toString());
        assetImageView.setImage(new Image("file:/" + asset.getImagePath()));
    }

    private void loadAssetOptions() {
        categoryList.getItems().addAll("Mesa", "Cadeira", "Computador");
        admnistrativeUnitList.getItems().addAll("COAFI", "COPROJ", "COEDIF", "CEGEA");
        locationUnitList.getItems().addAll("Sala de Orçamento", "Depósito", "Financeiro", "Almoxarifado");
        ownershipList.getItems().addAll("PMF", "Terceiros", "Leased");
    }

    private void setupAsseCodeText() {
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

    public void onCloseButtonAction() {

        if (!valueHasChanged.get()) {
            closeButton.getScene().getWindow().hide();
            return;
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getButtonTypes().setAll(ButtonType.CANCEL, ButtonType.OK);
        alert.setTitle("Alerta!");
        alert.setHeaderText("Tem certeza que deseja sair?");
        alert.setContentText("As alterações não salvas serão perdidas.");

        DialogPane dialogPane = alert.getDialogPane();
        Util.loadStyleSheet(dialogPane, "/styles/main.css");

        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        okButton.setText("SAIR");
        okButton.getStyleClass().add("button-ok");

        Button cancelButton = (Button) dialogPane.lookupButton(ButtonType.CANCEL);
        cancelButton.setText("FICAR");
        cancelButton.getStyleClass().add("button-cancel");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                closeButton.getScene().getWindow().hide();
            } else if (response == ButtonType.CANCEL) {
                alert.close();
            }
        });

    }

    public void setupDetailView(Stage primaryStage, Asset asset) {

        DetailItemController.asset = asset;

        Parent primaryRoot = primaryStage.getScene().getRoot();
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        primaryRoot.setEffect(colorAdjust);

        Parent parent = Util.loadFXML("/gui/scenes/detail-asset.fxml");
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

        saveButton.setOnAction(event -> {
            asset.setCategory(new Category(categoryList.getValue()));
            asset.setAdministrativeUnit(admnistrativeUnitList.getValue());
            asset.setLocationUnit(locationUnitList.getValue());
            asset.setOwnership(Ownership.valueOf(ownershipList.getValue()));
            asset.setAssetCode(Long.valueOf(assetCodeTextField.getText()));
            asset.setImagePath(assetImageView.getImage().getUrl());

        });
    }

    private void verifyChanges() {

        boolean isCategoryChanged = !categoryList.getValue().equals(asset.getCategory().getName());
        boolean isAdmnistrativeUnitChanged = !admnistrativeUnitList.getValue().equals(asset.getAdministrativeUnit());
        boolean isLocationUnitChanged = !locationUnitList.getValue().equals(asset.getLocationUnit());
        boolean isOwnershipChanged = !ownershipList.getValue().equals(asset.getOwnership().toString());
        boolean isAssetCodeChanged = !assetCodeTextField.getText().equals(asset.getAssetCode().toString());

        valueHasChanged
                .set(isCategoryChanged || isAdmnistrativeUnitChanged || isLocationUnitChanged || isOwnershipChanged
                        || isAssetCodeChanged);
    }

}
