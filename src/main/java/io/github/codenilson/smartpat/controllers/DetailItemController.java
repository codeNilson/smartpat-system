package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.utils.Util;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DetailItemController implements Initializable {

    private static Asset asset;

    @FXML
    private Button closeButton;

    @FXML
    private ComboBox<String> categoryList;

    @FXML
    private ComboBox<String> admnistrativeUnitList;

    @FXML
    private ComboBox<String> locationUnitList;

    @FXML
    private Label assetCodeLabel;

    @FXML
    private ComboBox<String> ownershipList;

    @FXML
    private ImageView assetImageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoryList.getItems().addAll("Mesa", "Cadeira", "Computador");
        admnistrativeUnitList.getItems().addAll("COAFI", "COPROJ", "COEDIF");
        locationUnitList.getItems().addAll("Sala de Orçamento", "Depósito", "Financeiro");
        assetCodeLabel.setText("6700004588");
        ownershipList.getItems().addAll("PMF", "Terceiros");

        categoryList.setValue(asset.getCategory().getName());
        admnistrativeUnitList.setValue(asset.getAdministrativeUnit());
        locationUnitList.setValue(asset.getLocationUnit());
        assetCodeLabel.setText(asset.getAssetCode().toString());
        ownershipList.setValue(asset.getOwnership().toString());
        assetImageView.setImage(new Image("file:/" + asset.getImagePath()));
    }

    public void onCloseButtonAction() {
        closeButton.getScene().getWindow().hide();
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

    // public void onAssetCodeLabelClicked(Event event) {
    //     TextField tf = new TextField();
    //     tf.setDisable(false);

    // }
}
