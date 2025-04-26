package io.github.codenilson.smartpat.controllers;

import io.github.codenilson.smartpat.utils.Util;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DetailItemController {
    @FXML
    private Button closeButton;

    public void onCloseButtonAction() {
        closeButton.getScene().getWindow().hide();
    }

    public void setupDetailView(Stage primaryStage) {
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
}
