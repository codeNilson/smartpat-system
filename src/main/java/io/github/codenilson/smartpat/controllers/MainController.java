package io.github.codenilson.smartpat.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import io.github.codenilson.smartpat.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

    @FXML
    private BorderPane primaryRootPane;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnReport;

    @FXML
    public void onBtnQuitClicked() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        changeScene("gui/scenes/categories");

    }

    private void changeScene(String fxml) {
        try {
            Parent newScene = App.loadFXML(fxml);
            primaryRootPane.setCenter(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
